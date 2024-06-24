package com.example.codegym_student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="StudentServlet", urlPatterns = "/list")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Nguyen Van A", "Nam", 95));
        students.add(new Student(2, "Tran Thi B", "Nữ", 85));
        students.add(new Student(3, "Le Van C", "Nam", 70));
        students.add(new Student(4, "Pham Thi D", "Nữ", 55));

        req.setAttribute("students", students);
        req.getRequestDispatcher("/list.jsp").forward(req, resp);
    }
}
