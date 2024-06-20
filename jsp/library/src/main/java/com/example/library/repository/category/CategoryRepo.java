package com.example.library.repository.category;

import com.example.library.database.ConnectDB;
import com.example.library.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepo implements ICategoryRepo{
    public List<Category> selectAllCategory() throws SQLException {
        List<Category> categories = new ArrayList<>();
        Connection connection = new ConnectDB().getConnection();
        String sql = "select * from category";
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
