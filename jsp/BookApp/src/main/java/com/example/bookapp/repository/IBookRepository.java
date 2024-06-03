package com.example.bookapp.repository;

import com.example.bookapp.models.Book;

import java.sql.SQLException;
import java.util.List;

public interface IBookRepository {
    public void insertBook(Book book) throws SQLException;

    public Book selectBook(int id);

    List<Book> selectAllBook();

    boolean delete(int id) throws SQLException;

    boolean update( Book book) ;

}
