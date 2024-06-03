package com.example.bookapp.repository;

import com.example.bookapp.models.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookRepository {

    private static final String INSERT_BOOKS_SQL = "INSERT INTO book (name, price, description, author) VALUES (?, ?, ?, ?);";
    private static final String SELECT_BOOK_BY_ID = "select id,name,price,description,author from book where id =?";
    private static final String SELECT_ALL_BOOKS = "select * from book";
    private static final String DELETE_BOOKS_SQL = "delete from book where id = ?;";
    private static final String UPDATE_BOOKS_SQL = "update book set name = ?,price= ?, description =?,author =?  where id = ?;";

    public BookRepository() {

    }


    @Override
    public List<Book> selectAllBook() {
        List<Book> books = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnetion();
             PreparedStatement ps = connection.prepareStatement(SELECT_ALL_BOOKS)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String description = rs.getString("description");
                String author = rs.getString("author");
                books.add(new Book(id, name, price, description, author));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return books;
    }

    @Override
    public Book selectBook(int id) {
        Book book = null;
        try (Connection connection = ConnectDB.getConnetion();
             PreparedStatement ps = connection.prepareStatement(SELECT_BOOK_BY_ID);) {
            ps.setInt(1, id);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String description = rs.getString("description");
                String author = rs.getString("author");
                book = new Book(id, name, price, description, author);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return book;
    }

    @Override
    public void insertBook(Book book) {
        try (Connection connection = ConnectDB.getConnetion(); PreparedStatement ps = connection.prepareStatement(INSERT_BOOKS_SQL)) {
            ps.setString(1, book.getName());
            ps.setDouble(2, book.getPrice());
            ps.setString(3, book.getDescription());
            ps.setString(4, book.getAuthor());

            ps.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = ConnectDB.getConnetion(); PreparedStatement statement = connection.prepareStatement(DELETE_BOOKS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean update(Book book)  {
        //update book set name = ?,price= ?, description =?,author =?  where id = ?;
        boolean rowUpdated = false;
        System.out.println("------------------Vào rồi-----------------");
        try (Connection connection = ConnectDB.getConnetion(); PreparedStatement statement = connection.prepareStatement(UPDATE_BOOKS_SQL);) {
            statement.setString(1, book.getName());
            statement.setDouble(2, book.getPrice());
            statement.setString(3, book.getDescription());
            statement.setString(4, book.getAuthor());
            statement.setInt(5,book.getId());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowUpdated;
    }


    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
