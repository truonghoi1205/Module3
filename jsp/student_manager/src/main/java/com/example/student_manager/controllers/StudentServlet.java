package com.example.student_manager.controllers;

import com.example.student_manager.databases.DBConnect;
import com.example.student_manager.models.Classroom;
import com.example.student_manager.models.Student;

import com.example.student_manager.services.classroom.ClassService;
import com.example.student_manager.services.classroom.IClassService;
import com.example.student_manager.services.student.IStudentService;
import com.example.student_manager.services.student.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = {"/students/*"})
public class StudentServlet extends HttpServlet {
    private IStudentService studentService = new StudentService();
    private IClassService classService = new ClassService();

    private DBConnect dbConnect;

    @Override
    public void init() {
        this.dbConnect = new DBConnect();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String url = req.getPathInfo();
        if (url == null) {
            url = "";
        }
        switch (url) {
            case "/create":
                renderPageCreateStudent(req, resp);
                break;
            default:
                listStudent(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
    }

    public void listStudent(HttpServletRequest request, HttpServletResponse response) {
        List<Student> students = studentService.selectAllStudent();
        request.setAttribute("students", students);
        try {
            request.getRequestDispatcher("/views/students/list.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void renderPageCreateStudent(HttpServletRequest request, HttpServletResponse response)  {
        List<Classroom> classrooms = classService.selectAllClassroom();
        request.setAttribute("classrooms", classrooms);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/students/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
