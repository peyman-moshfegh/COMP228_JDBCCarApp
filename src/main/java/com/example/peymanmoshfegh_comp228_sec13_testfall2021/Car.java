package com.example.peymanmoshfegh_comp228_sec13_testfall2021;

public class Car {
    private Integer carID;
    private String make;
    private String model;
    private Integer b_year;
    private Integer price;

    public Car() {
    }

    public Car(Integer carID, String make, String model, Integer b_year, Integer price) {
        this.carID = carID;
        this.make = make;
        this.model = model;
        this.b_year = b_year;
        this.price = price;
    }

    public Integer getCarID() {
        return carID;
    }

    public void setCarID(Integer carID) {
        this.carID = carID;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getB_year() {
        return b_year;
    }

    public void setB_year(Integer b_year) {
        this.b_year = b_year;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}