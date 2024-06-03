package com.example.bookapp.controllers;

import com.example.bookapp.models.Book;
import com.example.bookapp.repository.ConnectDB;
import com.example.bookapp.service.BookService;
import com.example.bookapp.service.IBookService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "bookServlet", urlPatterns = {"/books", "/sach"})
public class BooksController extends HttpServlet {
    private IBookService bookService = new BookService();
    private ConnectDB connectDB;

    @Override
    public void init()  {
        connectDB = new ConnectDB();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showFormCreate(req, resp);
                    break;
                case "delete":
                    delete(req, resp);
                    break;
                case "update":
                    showFormUpdate(req, resp);
                    break;
                default:
                    showList(req, resp);
                    break;
            }
        } catch (SQLException | IOException ex) {
            throw new ServletException(ex);
        }

    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("views/create.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) {
        List<Book> bookList = bookService.selectAllBook();
        req.setAttribute("bookList", bookList);
        try {
            req.getRequestDispatcher("views/list.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                save(req, resp);
                break;
            case "update":

                    update(req, resp);

                break;
            default:
                showList(req, resp);
                break;
        }
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String description = req.getParameter("description");
        String author = req.getParameter("author");
        Book book = new Book(name, price, description, author);
        bookService.insertBook(book);
        try {
            resp.sendRedirect("/books");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        bookService.delete(id);
        List<Book> bookList = bookService.selectAllBook();
        req.setAttribute("books", bookList);
        try {
            resp.sendRedirect("/books");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void showFormUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Book bookUpdate = bookService.selectBook(id);
        req.setAttribute("book", bookUpdate);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/edit.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp)  {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String description = req.getParameter("description");
        String author = req.getParameter("author");

        Book book = new Book(id, name, price, description, author);
        bookService.update(book);
        try {
            resp.sendRedirect("/books");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
