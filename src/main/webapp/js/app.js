(function(window){
    function getCars(callback) {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {

                callback(JSON.parse(this.responseText));
            }
        };
        xhttp.open("GET", "services/car_record/cars", true);
        xhttp.setRequestHeader("Content-type", "application/json");
        xhttp.send();
    }

    function saveCar(car, callback) {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                callback(JSON.parse(this.responseText));
            }
        };
        xhttp.open("POST", "services/car_record/cars", true);
        xhttp.setRequestHeader("Content-type", "application/json");
        xhttp.send(JSON.stringify(car));
    }

    function addTDFor(car, property, row) {
        let htmlTableDataCellElement = document.createElement("td");
        htmlTableDataCellElement.innerHTML = car[property]
        row.appendChild(htmlTableDataCellElement);
    }

    function carRowFor(car){
        var row =  document.createElement("tr");
        addTDFor(car, "id", row);
        addTDFor(car, "plate", row);
        addTDFor(car, "brand", row);
        addTDFor(car, "model", row);
        addTDFor(car, "year", row);
        return row;
    }

    function populate(element){
        element.innerHTML = "";
        function callback(cars){
            var len = cars.length;
            let i = 0;
            for (i=0;i<len;i++) {
                var car = cars[i];
                console.log(car);
                var rowElement = carRowFor(car);
                element.appendChild(rowElement);
            }
        }
        getCars(callback);
    }
    var cars_app_table = document.getElementById("cars-app-body");
    populate(cars_app_table);
    var cars_app_add_car_button = document.getElementById("cars-app-add-car");

    function add_property_from_input(new_car, property) {
        var property_value = document.getElementById("cars-app-input-" + property).value;
        new_car[property] = property_value;
    }

    cars_app_add_car_button.onclick = function (event){
        var new_car = {};
        add_property_from_input(new_car, "plate");
        add_property_from_input(new_car, "brand");
        add_property_from_input(new_car, "model");
        add_property_from_input(new_car, "year");
        console.log(new_car);
        saveCar(new_car, function (data){
            console.log("New car added!");
            console.log(data);
            populate(cars_app_table);
        })
    }

})(window);