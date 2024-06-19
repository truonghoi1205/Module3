package com.example.bt_mvc.sevices;

import com.example.bt_mvc.models.Book;
import com.example.bt_mvc.repositories.BookRepo;
import com.example.bt_mvc.repositories.IBookRepo;

import java.sql.SQLException;
import java.util.List;

public class BookService implements IBookService {
    IBookRepo bookRepo = new BookRepo();

    @Override
    public void insertBook(Book book) {
        validate(book);
        if (book.getErrors().isEmpty()) {
            try {
                bookRepo.insertBook(book);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
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
    public void updateBook(Book book) {
        validate(book);
        if (book.getErrors().isEmpty()) {
            try {
                bookRepo.updateBook(book);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<Book> searchBookByTitle(String keyword) {
        try {
            return bookRepo.searchBookByTitle(keyword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void validate(Book book) {
        if (book.getTitle().isEmpty()) {
            book.setError("title", "Tên không được để trống");
        }
        if (book.getPageSize() <= 0) {
            book.setError("page_size", "Vui lòng nhập đúng số trang");
        }
//        book findProductBySku = findProductBySku(book.getId());
//        if (findProductBySku != null && findProductBySku.getId() != product.getId()) {
//            product.setError("sku", "Mã sản phẩm đã tồn tại");

    }
}
