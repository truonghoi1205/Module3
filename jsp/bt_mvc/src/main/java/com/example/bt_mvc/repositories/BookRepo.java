package com.example.bt_mvc.repositories;

import com.example.bt_mvc.database.ConnectDB;
import com.example.bt_mvc.models.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepo implements IBookRepo {
    @Override
    public void insertBook(Book book) throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String sql = "insert into books(title,page_size,author,category) value(?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, book.getTitle());
        ps.setInt(2, book.getPageSize());
        ps.setString(3, book.getAuthor());
        ps.setString(4, book.getCategory());
        ps.executeUpdate();
    }

    @Override
    public Book selectBook(int id) throws SQLException {
        Book book = null;
        Connection connection = new ConnectDB().getConnection();
        String sql = "select * from books where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            book = new Book();
            book.setId(rs.getInt("id"));
            book.setTitle(rs.getString("title"));
            book.setPageSize(rs.getInt("page_size"));
            book.setAuthor(rs.getString("author"));
            book.setCategory(rs.getString("category"));
        }
        return book;
    }

    @Override
    public List<Book> selectAllBook() throws SQLException {
        List<Book> books = new ArrayList<>();
        Connection connection = new ConnectDB().getConnection();
        String sql = "select * from books";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setTitle(rs.getString("title"));
            book.setPageSize(rs.getInt("page_size"));
            book.setAuthor(rs.getString("author"));
            book.setCategory(rs.getString("category"));
            books.add(book);
        }
        return books;
    }

    @Override
    public void deleteBook(int id) throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String sql = "delete from books where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public void updateBook(Book book) throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String sql = "update books set title = ?, page_size = ?, author = ?, category = ? where id =? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, book.getTitle());
        ps.setInt(2, book.getPageSize());
        ps.setString(3, book.getAuthor());
        ps.setString(4, book.getCategory());
        ps.setInt(5, book.getId());
        ps.executeUpdate();
    }

    @Override
    public List<Book> searchBookByTitle(String keyword) throws SQLException {
        List<Book> books = new ArrayList<>();
        Connection connection = new ConnectDB().getConnection();
        String sql = "select * from books where title like ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, "%" + keyword + "%");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setTitle(rs.getString("title"));
            book.setPageSize(rs.getInt("page_size"));
            book.setAuthor(rs.getString("author"));
            book.setCategory(rs.getString("category"));
            books.add(book);
        }
        return books;
    }
}
