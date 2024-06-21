package com.example.library.model;

import java.util.HashMap;

public class Book {
    private int id;
    private String title;
    private int pageSize;
    private int authorId;
    private Author author;
    private int categoryId;
    private HashMap<String, String> errors = new HashMap<>();

    private Category category;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void setError(String key, String message) {
        errors.put(key, message);
    }

}
