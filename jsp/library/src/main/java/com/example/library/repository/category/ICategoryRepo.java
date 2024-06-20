package com.example.library.repository.category;

import com.example.library.model.Category;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryRepo {
    List<Category> selectAllCategory() throws SQLException;
}
