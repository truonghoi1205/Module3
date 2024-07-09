package com.example.thuchanhm3.models;

import java.sql.Date;

public class ProductDTO {
    private  int id;
    private String sku;
    private String name;
    private String unit;
    private double price;
    private String categoryName;
    private int categoryId;
    private Date day_th;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Date getDay_th() {
        return day_th;
    }

    public void setDay_th(Date day_th) {
        this.day_th = day_th;
    }
}
