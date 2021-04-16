package persistence;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "car_records")
public class CarRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String plate;
    private String brand;
    private String model;
    private int year;

    @Override
    public String toString() {
        return "CarRecord{" +
                "id=" + id +
                ", plate='" + plate + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarRecord carRecord = (CarRecord) o;
        return id == carRecord.id && year == carRecord.year && Objects.equals(plate, carRecord.plate) && Objects.equals(brand, carRecord.brand) && Objects.equals(model, carRecord.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, plate, brand, model, year);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
