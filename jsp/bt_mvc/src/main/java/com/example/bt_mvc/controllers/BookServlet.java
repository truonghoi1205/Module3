package com.example.bt_mvc.controllers;

import com.example.bt_mvc.models.Book;
import com.example.bt_mvc.sevices.BookService;
import com.example.bt_mvc.sevices.IBookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BookServlet", urlPatterns = "/books/*")
public class BookServlet extends HttpServlet {
    IBookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("UTF-8");
       resp.setCharacterEncoding("UTF-8");
        String url = req.getPathInfo();
        switch (url) {
            case "/list":
                showAll(req, resp);
            case "/create":
                showFormCreateBook(req, resp);
                break;
            case "/delete":
                deleteBook(req,resp);
                break;
            case "/update":
                showFormUpdateBook(req,resp);
                break;
            case "/search":
                searchBook(req,resp);
                break;
        }
    }

    private void searchBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        List<Book> books = bookService.searchBookByTitle(keyword);
        req.setAttribute("books", books);
        req.setAttribute("keyword", keyword);
        req.getRequestDispatcher("/views/list.jsp").forward(req, resp);
    }

    private void showFormUpdateBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Book book = bookService.selectBook(id);
        req.setAttribute("book", book);
        req.getRequestDispatcher("/views/update.jsp").forward(req, resp);
    }

    private void deleteBook(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        bookService.deleteBook(id);
        List<Book> books = bookService.selectAllBook();
        req.setAttribute("books", books);
        resp.sendRedirect("/books/list");
    }

    private void showFormCreateBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/create.jsp").forward(req, resp);
    }

    private void showAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.selectAllBook();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/views/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String url = req.getPathInfo();
        switch (url) {
            case "/create":
                insertBook(req, resp);
                break;
            case "/update":
                updateBook(req,resp);
                break;
        }
    }

    private void insertBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = new Book();
        String title = req.getParameter("title");
        int page_size = Integer.parseInt(req.getParameter("page_size"));
        String author = req.getParameter("author");
        String category = req.getParameter("category");
        book.setTitle(title);
        book.setPageSize(page_size);
        book.setAuthor(author);
        book.setCategory(category);
        bookService.insertBook(book);
        if (book.getErrors().isEmpty()) {
            req.setAttribute("noti", "Thêm sản phẩm thành công!");
            showAll(req, resp);
        } else {
            req.setAttribute("book", book);
            req.getRequestDispatcher("/views/create.jsp").forward(req, resp);
        }
    }

    private void updateBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        int page_size = Integer.parseInt(req.getParameter("page_size"));
        String author = req.getParameter("author");
        String category = req.getParameter("category");
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setPageSize(page_size);
        book.setAuthor(author);
        book.setCategory(category);
        bookService.updateBook(book);
        if (book.getErrors().isEmpty()) {
            req.setAttribute("noti", "Cập nhật sản phẩm thành công!");
            showAll(req, resp);
        } else {
            req.setAttribute("book", book);
            req.getRequestDispatcher("/views/update.jsp").forward(req, resp);
        }
    }

}
