package com.example.library.repository.book;

import com.example.library.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface IBookRepo {
    List<Book> selectAllBook()throws SQLException;
    void deleteBook(int id) throws  SQLException;
    void insertBook(Book book) throws  SQLException;
    void updateBook(Book book) throws  SQLException;
    Book selectBook(int id) throws SQLException;

}
