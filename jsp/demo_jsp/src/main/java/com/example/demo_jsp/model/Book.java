package com.example.demo_jsp.model;

public class Book {
    private int id;
    private String name;
    private double price;
    private String description;
    private String auth;
    public static int lastedId = 0;

    public Book( String name, double price, String description, String auth) {
        this.id = ++lastedId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.auth = auth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

}


