package com.example.demo_jsp.controller;

import com.example.demo_jsp.model.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "BooksController", urlPatterns = {"/books/*"})
public class BooksController extends HttpServlet {
    private final List<Book> books = new ArrayList<>();
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Override
    public void init(ServletConfig config) throws ServletException {
        Book book1 = new Book("Doraemon", 15.00, "Truyện thiếu nhi", "Fujiko Fujio");
        Book book2 = new Book("Đắc nhân tâm", 17.00, "Sách tự lực", "Dale Carnegie");
        Book book3 = new Book("Thần đồng đất việt", 10.00, "Truyện thiếu nhi", "Kim Đồng");
        books.add(book1);
        books.add(book2);
        books.add(book3);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        request = req;
        response = resp;
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = request.getRequestURI();
        switch (url) {
            case "/books":
                showList();
                break;
            case "/books/new":
                showFormCreate();
                break;
            case "/books/delete":
                deleteBook();
                break;
            case "/books/update":
                updateBook();
                break;
        }
    }

    private void showList() throws ServletException, IOException {
        request.setAttribute("books", books);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/books/index.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showFormCreate() throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/books/new.jsp");
        requestDispatcher.forward(request, response);
    }

    private void deleteBook() throws ServletException, IOException {
        String id = request.getParameter("id");
        Book deleteBook = findBook(Integer.parseInt(id));
        books.remove(deleteBook);
        response.sendRedirect("/books");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.equals("/books/new")) {
            String name = req.getParameter("name");
            double price;
            try {
                price = Double.parseDouble(req.getParameter("price"));
            } catch (Exception e) {
                price = 0.0;
            }
            String description = req.getParameter("description");
            String auth = req.getParameter("auth");
            Book book = new Book(name, price, description, auth);
            books.add(book);
            resp.sendRedirect("/books");

        } else if (url.equals("/books/update")) {

            String id = request.getParameter("id");
            Book bookUpdate = findBook(Integer.parseInt(id));
            // get du lieu
            double price;
            try {
                price = Double.parseDouble(req.getParameter("price"));
            } catch (Exception e) {
                price = 0.0;
            }
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            String auth = req.getParameter("auth");
            bookUpdate.setName(name);
            bookUpdate.setPrice(price);
            bookUpdate.setDescription(description);
            bookUpdate.setAuth(auth);
            response.sendRedirect("/books");
        }
    }

    private void updateBook() throws ServletException, IOException {
        String id = request.getParameter("id");
        Book bookUpdate = findBook(Integer.parseInt(id));
        request.setAttribute("books", bookUpdate);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/books/edit.jsp");
        requestDispatcher.forward(request, response);

    }

    public Book findBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

}
