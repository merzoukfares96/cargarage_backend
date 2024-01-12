package tech.getarrays.garageApp.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String model;
    private String brand;
    private int year;
    private String imageUrl;

    public Car() {}

    public Car(String model, String brand, int year, String imageUrl) {
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Car{"
                + "id=" + id +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", year='" + year + '\'' +
                ", imageURL='" + imageUrl + '\'' +
                '}';
    }
}
