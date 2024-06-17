package com.example.student_manager.services.student;

import com.example.student_manager.models.Student;

import java.util.List;

public interface IStudentService {
    List<Student> selectAllStudent();

    void save(Student student);
}
