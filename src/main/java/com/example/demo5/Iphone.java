package com.example.demo5;

public class Iphone extends Android {

   private String nation;
    public Iphone(String brand, String model, String color, int price, int quality,String nation ) {
        super(brand, model, color, price, quality);
        this.nation = nation;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Override
    public String toString() {
        return "Iphone{" + super.toString() +
                "nation='" + nation + '\'' +
                '}';
    }
}

