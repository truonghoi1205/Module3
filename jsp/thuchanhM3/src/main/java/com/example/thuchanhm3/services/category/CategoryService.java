package com.example.thuchanhm3.services.category;

import com.example.thuchanhm3.models.Category;
import com.example.thuchanhm3.repositories.category.CategoryRepo;
import com.example.thuchanhm3.repositories.category.ICategoryRepo;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class CategoryService implements ICategoryService {
    private static ICategoryRepo categoryRepo = new CategoryRepo();

    @Override
    public List<Category> selectAllCategory() {
        try {
            return categoryRepo.selectAllCategory();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
