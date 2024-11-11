package com.example.demo5;

public class Brand {
    int id;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
