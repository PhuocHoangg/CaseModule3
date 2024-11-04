package com.example.demo5;

public class Android {
    private String brand;
    private String model;
    private String color;
    private int price;
    private int quality;
    public Android(String brand, String model, String color, int price, int quality) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.price = price;
        this.quality = quality;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return "Android{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", quality=" + quality +
                '}';
    }
}
