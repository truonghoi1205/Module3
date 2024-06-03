package com.example.bookapp.service;
import com.example.bookapp.models.Book;
import com.example.bookapp.repository.BookRepository;
import com.example.bookapp.repository.IBookRepository;
import java.sql.SQLException;
import java.util.List;

public class BookService implements IBookService {
    private IBookRepository bookRepository = new BookRepository();

    @Override
    public List<Book> selectAllBook() {
        return bookRepository.selectAllBook();
    }

    @Override
    public void insertBook(Book book) {
        try {
            bookRepository.insertBook(book);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book selectBook(int id) {
        return bookRepository.selectBook(id);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return bookRepository.delete(id);
    }

    @Override
    public boolean update(Book book){
        return bookRepository.update(book);
    }


}
