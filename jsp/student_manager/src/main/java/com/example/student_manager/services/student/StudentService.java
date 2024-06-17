package com.example.student_manager.services.student;


import com.example.student_manager.models.Student;
import com.example.student_manager.repository.student.IStudentRepository;
import com.example.student_manager.repository.student.StudentRepository;

import java.sql.SQLException;
import java.util.List;

public class StudentService implements IStudentService {
    private IStudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> selectAllStudent() {
        try {
            return studentRepository.selectAllStudent();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Student student) {
        try {
            studentRepository.save(student);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
