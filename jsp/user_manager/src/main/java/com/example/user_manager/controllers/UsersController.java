package com.example.user_manager.controllers;

import com.example.user_manager.models.User;
import com.example.user_manager.repository.ConnectDB;
import com.example.user_manager.service.IUserService;
import com.example.user_manager.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UsersController extends HttpServlet {
    private IUserService userService = new UserService();
    private ConnectDB connectDB;

    @Override
    public void init() {
        connectDB = new ConnectDB();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(req, resp);
                break;
            case "edit":
                showFormEdit(req, resp);
                break;
            case "delete":
                deleteUser(req, resp);
                break;
            case "search":
                searchCountry(req, resp);
                break;
            case "sort":
                sort(req,resp);
                break;
            default:
                listUser(req, resp);
                break;
        }
    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("views/create.jsp").forward(req, resp);
        } catch (ServletException | IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private void showFormEdit(HttpServletRequest req, HttpServletResponse resp) {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            User userEdit = userService.selectUser(id);
            req.setAttribute("user", userEdit);
            req.getRequestDispatcher("views/edit.jsp").forward(req, resp);
        } catch (ServletException | IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private void listUser(HttpServletRequest req, HttpServletResponse resp) {
        List<User> listUser = userService.selectAllUser();
        req.setAttribute("listUser", listUser);
        try {
            req.getRequestDispatcher("views/list.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertUser(req, resp);
                break;
            case "edit":
                editUser(req, resp);
                break;
            case "delete":
                deleteUser(req, resp);
                break;
            default:
                listUser(req, resp);
                break;
        }
    }

    private void insertUser(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        User user = new User(name, email, country);
        userService.insertUser(user);
        try {
            resp.sendRedirect("/users");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void editUser(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        User user = new User(id, name, email, country);

        userService.updateUser(user);
        try {
            resp.sendRedirect("/users");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        userService.deleteUser(id);
        List<User> userList = userService.selectAllUser();
        req.setAttribute("user", userList);
        try {
            resp.sendRedirect("/users");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void searchCountry(HttpServletRequest req, HttpServletResponse resp) {
        String keyword = req.getParameter("keyword");
        List<User> users = userService.searchUserCountry(keyword);
        req.setAttribute("listUser", users);
        RequestDispatcher requestDispat = req.getRequestDispatcher("views/list.jsp");
        try {
            requestDispat.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void sort(HttpServletRequest req, HttpServletResponse resp) {
        List<User> listUser = userService.sortUserByName();
        req.setAttribute("listUser", listUser);
        try {
            req.getRequestDispatcher("views/list.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
