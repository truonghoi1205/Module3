package com.example.library.repository.book;

import com.example.library.database.ConnectDB;
import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepo implements IBookRepo {
    @Override
    public List<Book> selectAllBook() throws SQLException {
        List<Book> books = new ArrayList<>();
        Connection connection = new ConnectDB().getConnection();
        String sql = "select b.* ,a.name as \"author_name\" ,c.name as \"category_name\" from books b join category c on b.categoryId = c.id join authors a on a.id = b.authorId order by b.id desc;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setTitle(rs.getString("title"));
            book.setPageSize(rs.getInt("page_size"));

            Category category = new Category();
            category.setName(rs.getString("category_name"));

            Author author = new Author();
            author.setName(rs.getString("author_name"));
            book.setAuthor(author);
            book.setCategory(category);
            books.add(book);
        }
        return books;
    }

    @Override
    public void deleteBook(int id) throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String sql = "{call deleteBookById(?)}";
        CallableStatement  statement  = connection.prepareCall(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    @Override
    public void insertBook(Book book) throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String sql = "{call AddNewBook(?,?,?,?)}";
        CallableStatement statement  = connection.prepareCall(sql);
        statement.setString(1, book.getTitle());
        statement.setInt(2, book.getPageSize());
        statement.setInt(3, book.getCategoryId());
        statement.setInt(4, book.getAuthorId());
        statement.executeUpdate();
    }

    @Override
    public void updateBook(Book book) throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String sql = "update books set title = ?, page_size = ?, categoryId = ?,authorId = ? where id =? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, book.getTitle());
        ps.setInt(2, book.getPageSize());
        ps.setInt(3, book.getCategoryId());
        ps.setInt(4, book.getAuthorId());
        ps.setInt(5, book.getId());
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public Book selectBook(int id) throws SQLException {
        Book book = null;
        Connection connection = new ConnectDB().getConnection();
        String sql = "select b.*, c.id as category_id , a.id as author_id from books b join category c on c.id = b.categoryId join authors a on a.id = b.authorId where b.id =?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String title = rs.getString("title");
            int pageSize =rs.getInt("page_size");
            int categoryId = rs.getInt("category_id");
            int authorId = rs.getInt("author_id");
            book = new Book();
            book.setId(id);
            book.setTitle(title);
            book.setPageSize(pageSize);
            book.setCategoryId(categoryId);
            book.setAuthorId(authorId);
        }
        return book;
    }

}
