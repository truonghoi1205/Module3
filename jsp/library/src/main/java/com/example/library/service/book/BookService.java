package com.example.library.service.book;

import com.example.library.model.Book;
import com.example.library.repository.book.BookRepo;
import com.example.library.repository.book.IBookRepo;

import java.sql.SQLException;
import java.util.List;

public class BookService implements IBookService{
    IBookRepo bookRepo = new BookRepo();


    @Override
    public List<Book> selectAllBook() {
        try {
            return bookRepo.selectAllBook();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteBook(int id) {
        try {
            bookRepo.deleteBook(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertBook(Book book) {
        try {
            bookRepo.insertBook(book);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Book book) {
        try {
            bookRepo.updateBook(book);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book selectBook(int id) {
        try {
            return bookRepo.selectBook(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
