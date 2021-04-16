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
        function callback(cars){
            var len = cars.length;
            var i = 0;
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

})(window);