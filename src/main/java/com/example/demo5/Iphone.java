package com.example.demo5;

public class Iphone {
    private int id;
    private int brandId;
    private String model;
    private String color;
    private double price;
    private int quality;

    public Iphone(int id, int brandId, String model, String color, double price, int quality) {
        this.id = id;
        this.brandId = brandId;
        this.model = model;
        this.color = color;
        this.price = price;
        this.quality = quality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}


