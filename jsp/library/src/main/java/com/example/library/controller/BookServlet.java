package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.service.author.AuthorService;
import com.example.library.service.author.IAuthorService;
import com.example.library.service.book.BookService;
import com.example.library.service.book.IBookService;
import com.example.library.service.category.CategoryService;
import com.example.library.service.category.ICategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet", urlPatterns = "/books/*")
public class BookServlet extends HttpServlet {
    IBookService bookService = new BookService();
    ICategoryService categoryService = new CategoryService();
    IAuthorService authorService = new AuthorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/list":
                showListBook(req,resp);
                break;
        }
    }

    private void showListBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.selectAllBook();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/views/list.jsp").forward(req, resp);
    }


}
