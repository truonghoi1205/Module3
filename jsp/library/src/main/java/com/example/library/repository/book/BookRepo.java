package com.example.library.repository.book;

import com.example.library.database.ConnectDB;
import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepo implements IBookRepo {
    @Override
    public List<Book> selectAllBook() throws SQLException {
        List<Book> books = new ArrayList<>();
        Connection connection = new ConnectDB().getConnection();
        String sql = "select b.* ,a.name as \"author_name\" ,c.name as \"category_name\" from books b join category c on b.categoryId = c.id join authors a on a.id = b.authorId;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setTitle(rs.getString("title"));
            book.setPageSize(rs.getInt("page_size"));
            Category category = new Category();
            category.setName(rs.getString("category_name"));
            Author author = new Author();
            author.setName(rs.getString("author_name"));
            book.setAuthor(author);
            book.setCategory(category);
            books.add(book);
        }
            return books;
    }
}
