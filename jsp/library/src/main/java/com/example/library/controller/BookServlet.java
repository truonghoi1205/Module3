package com.example.library.controller;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.model.Category;
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
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String url = req.getPathInfo();
        switch (url) {
            case "/list":
                showListBook(req, resp);
                break;
            case "/delete":
                deleteBook(req, resp);
                break;
            case "/create":
                showFormCreateBook(req, resp);
                break;
            case "/update":
                showFormEditBook(req, resp);
                break;
        }
    }

    private void showFormEditBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Book book = bookService.selectBook(id);
        req.setAttribute("book", book);
        getAllCategories(req, resp);
        getAllAuthors(req, resp);
        req.getRequestDispatcher("/views/edit.jsp").forward(req, resp);
    }

    private void showFormCreateBook(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Book book = new Book();
        req.setAttribute("book", book);
        getAllAuthors(req, resp);
        getAllCategories(req, resp);
        req.getRequestDispatcher("/views/create.jsp").forward(req, resp);
    }

    private void deleteBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        bookService.deleteBook(id);
        List<Book> books = bookService.selectAllBook();
        req.setAttribute("books", books);
        Book book = new Book();
        if (book.getErrors().isEmpty()) {
            req.setAttribute("noti", "Xóa thành công!");
            showListBook(req, resp);
        } else {
            getAllCategories(req, resp);
            req.setAttribute("book", book);
            req.getRequestDispatcher("/views/list.jsp").forward(req, resp);
        }
    }

    private void showListBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
                updateBook(req, resp);
                break;
        }
    }

    private void updateBook(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        int page_size = Integer.parseInt(req.getParameter("page_size"));
        int category_id = Integer.parseInt(req.getParameter("category_id"));
        int author_id = Integer.parseInt(req.getParameter("author_id"));
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setPageSize(page_size);
        book.setAuthorId(author_id);
        book.setCategoryId(category_id);
        bookService.update(book);
        if (book.getErrors().isEmpty()) {
            req.setAttribute("noti", "Cập nhật thành công!");
            showListBook(req, resp);
        } else {
            getAllAuthors(req,resp);
            getAllCategories(req, resp);
            req.setAttribute("book", book);
            req.getRequestDispatcher("/views/edit.jsp").forward(req, resp);
        }
    }

    private void insertBook(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String title = req.getParameter("title");
        String pageSizeStr = req.getParameter("page_size");
        String errorMessage = validateProduct(title, pageSizeStr);

        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        int authorId = Integer.parseInt(req.getParameter("authorId"));
        int page_size = 0;
        try {
            page_size = Integer.parseInt(pageSizeStr);
        } catch (NumberFormatException e) {
            errorMessage = "Vui lòng nhập đúng trang sách.";
        }
        Book book = new Book();
        book.setTitle(title);
        book.setPageSize(page_size);
        book.setCategoryId(categoryId);
        book.setAuthorId(authorId);
        if (errorMessage != null) {
            List<Category> categories = categoryService.selectAllCategory();
            List<Author> authors = authorService.selectAllAuthor();
            req.setAttribute("categories", categories);
            req.setAttribute("authors", authors);
            req.setAttribute("errorMessage", errorMessage);
            req.setAttribute("book", book);
            req.getRequestDispatcher("/views/create.jsp").forward(req, resp);
            return;
        }
        bookService.insertBook(book);
        if (book.getErrors().isEmpty()) {
            req.setAttribute("noti", "Thêm thành công!");
            showListBook(req, resp);
        } else {
            getAllAuthors(req, resp);
            getAllCategories(req, resp);
            req.setAttribute("book", book);
            resp.sendRedirect("/books/list");
        }
    }

    private void getAllCategories(HttpServletRequest req, HttpServletResponse resp) {
        List<Category> categories = categoryService.selectAllCategory();
        req.setAttribute("categories", categories);
    }

    private void getAllAuthors(HttpServletRequest req, HttpServletResponse resp) {
        List<Author> authors = authorService.selectAllAuthor();
        req.setAttribute("authors", authors);
    }

    // validate
    private String validateProduct(String title, String pageSizeStr) {
        if (title == null || title.isEmpty()) {
            return "Không được để trống tên sách";
        }
        try {
            if (pageSizeStr == null || pageSizeStr.isEmpty()) {
                return "Không được để trống số trang";
            }
            int pageSize = Integer.parseInt(pageSizeStr);
            if (pageSize < 0) {
                return "Vui lòng nhập đúng trang sách";
            }
            if (pageSize == 0) {
                return "Vui lòng nhập trang sách";
            }
        } catch (NumberFormatException e) {
            return "Vui lòng nhập đúng trang sách";
        }
        return null;
    }
}
