package com.example.library.service.category;

import com.example.library.model.Category;
import com.example.library.repository.category.CategoryRepo;
import com.example.library.repository.category.ICategoryRepo;

import java.sql.SQLException;
import java.util.List;

public class CategoryService implements ICategoryService{
    ICategoryRepo categoryRepo = new CategoryRepo();
    @Override
    public List<Category> selectAllCategory() {
        try {
            return categoryRepo.selectAllCategory();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
