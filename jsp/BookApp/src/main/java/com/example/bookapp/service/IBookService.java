package com.example.bookapp.service;

import com.example.bookapp.models.Book;

import java.sql.SQLException;
import java.util.List;

public interface IBookService {
    List<Book> selectAllBook();

    void insertBook(Book book);

    Book selectBook(int id);

    boolean delete(int id) throws SQLException;

    boolean update( Book book) ;

}
