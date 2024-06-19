package com.example.bt_mvc.models;

import java.util.HashMap;

public class Book {
    private int id;
    private String title;
    private int pageSize;
    private String author;
    private String category;
    private HashMap<String, String> errors = new HashMap<>();

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void setError(String key, String message) {
        errors.put(key, message);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
