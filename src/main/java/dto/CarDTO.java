package dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name="car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarDTO {
    @XmlElement(required = false)
    private long id;
    @XmlElement(required = true)
    private String plate;
    @XmlElement(required = true)
    private String brand;
    @XmlElement(required = true)
    private String model;
    @XmlElement(required = true)
    private int year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarDTO carDTO = (CarDTO) o;
        return id == carDTO.id && year == carDTO.year && Objects.equals(plate, carDTO.plate) && Objects.equals(brand, carDTO.brand) && Objects.equals(model, carDTO.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, plate, brand, model, year);
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                "id=" + id +
                ", plate='" + plate + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
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

    public static class Builder{
        private long id;
        private String plate;
        private String brand;
        private String model;
        private int year;
        public CarDTO build(){
            CarDTO carDTO = new CarDTO();
            carDTO.setId(id);
            carDTO.setPlate(plate);
            carDTO.setBrand(brand);
            carDTO.setModel(model);
            carDTO.setYear(year);
            return carDTO;
        }

        public Builder withId(long id){
            this.id = id;
            return this;
        }

        public Builder withPlate(String plate){
            this.plate = plate;
            return this;
        }

        public Builder withBrand(String brand){
            this.brand = brand;
            return this;
        }

        public Builder withModel(String model){
            this.model = model;
            return this;
        }

        public Builder withYear(int year){
            this.year = year;
            return this;
        }
    }
}
