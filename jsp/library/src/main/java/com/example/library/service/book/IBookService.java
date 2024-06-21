package com.example.library.service.book;

import com.example.library.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> selectAllBook();
    void deleteBook(int id);
    void insertBook(Book book);
    void update(Book book);

    Book selectBook(int id);
}
