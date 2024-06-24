package com.example.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.equals("/login")) {
            showFormLogin(req, resp);
        }
    }

    private void showFormLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();

        if (url.equals("/login")) {
            checkLogin(req, resp);
        }

    }

    private void checkLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username.equals("admin") && password.equals("123abc")) {
            String currentTime = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy").format(new Date());
            req.setAttribute("message", "Admin đăng nhập thành công vào lúc " + currentTime);
            req.getRequestDispatcher("/success.jsp").forward(req, resp);
        } else {
            req.setAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu không đúng.");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
