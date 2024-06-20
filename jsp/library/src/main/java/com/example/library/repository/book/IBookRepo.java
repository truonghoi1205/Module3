package com.example.library.repository.book;

import com.example.library.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface IBookRepo {
    List<Book> selectAllBook()throws SQLException;

}
