package com.example.bt_mvc.repositories;

import com.example.bt_mvc.models.Book;

import java.sql.SQLException;
import java.util.List;

public interface IBookRepo {
     void insertBook(Book book) throws SQLException;
     Book selectBook(int id) throws SQLException;
     List<Book> selectAllBook() throws SQLException;
     void deleteBook(int id) throws SQLException;
     void updateBook(Book book) throws SQLException;
     List<Book> searchBookByTitle(String keyword) throws SQLException;
}
