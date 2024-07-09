package com.example.thuchanhm3.repositories.category;

import com.example.thuchanhm3.models.Category;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryRepo {
    List<Category> selectAllCategory() throws SQLException;
}
