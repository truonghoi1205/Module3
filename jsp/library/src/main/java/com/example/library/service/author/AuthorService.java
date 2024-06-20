package com.example.library.service.author;

import com.example.library.model.Author;
import com.example.library.repository.author.AuthorRepo;
import com.example.library.repository.author.IAuthorRepo;

import java.sql.SQLException;
import java.util.List;

public class AuthorService implements IAuthorService {
    IAuthorRepo authorRepo = new AuthorRepo();

    @Override
    public List<Author> selectAllAuthor() {
        try {
            return authorRepo.selectAllAuthor();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
