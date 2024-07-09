package com.example.thuchanhm3.repositories.category;

import com.example.thuchanhm3.database.ConnectDB;
import com.example.thuchanhm3.models.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepo implements ICategoryRepo {
    @Override
    public List<Category> selectAllCategory() throws SQLException {
        List<Category> categories = new ArrayList<>();
        Connection connection = new ConnectDB().getConnection();
        String sql = "select * from categories";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Category category = new Category();
            category.setId(rs.getInt("id"));
            category.setName(rs.getString("name"));
            categories.add(category);
        }
        return categories;
    }
}
