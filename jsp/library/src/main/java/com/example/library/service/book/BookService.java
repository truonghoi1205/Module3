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
}
