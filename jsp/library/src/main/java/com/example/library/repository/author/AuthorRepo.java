package com.example.library.repository.author;

import com.example.library.database.ConnectDB;
import com.example.library.model.Author;
import com.example.library.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorRepo implements IAuthorRepo{
    @Override
    public List<Author> selectAllAuthor() throws SQLException {
        List<Author> authors = new ArrayList<>();
        Connection connection = new ConnectDB().getConnection();
        String sql = "select * from author";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Author author = new Author();
            author.setId(rs.getInt("id"));
            author.setName(rs.getString("name"));
            authors.add(author);
        }
        return authors;
    }
}
