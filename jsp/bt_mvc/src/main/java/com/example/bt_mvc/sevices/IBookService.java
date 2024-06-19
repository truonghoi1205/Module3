package com.example.bt_mvc.sevices;

import com.example.bt_mvc.models.Book;

import java.sql.SQLException;
import java.util.List;

public interface IBookService {
    void insertBook(Book book) ;
    Book selectBook(int id) ;
    List<Book> selectAllBook() ;
    void deleteBook(int id) ;
    void updateBook(Book book);
    List<Book> searchBookByTitle(String keyword);

}
