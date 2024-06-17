package com.example.student_manager.repository.student;

import com.example.student_manager.models.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentRepository {
    List<Student> selectAllStudent() throws SQLException;
    void save(Student student) throws SQLException;
}
