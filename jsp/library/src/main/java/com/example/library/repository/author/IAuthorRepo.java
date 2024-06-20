package com.example.library.repository.author;

import com.example.library.model.Author;

import java.sql.SQLException;
import java.util.List;

public interface IAuthorRepo {
    List<Author> selectAllAuthor() throws SQLException;

}
