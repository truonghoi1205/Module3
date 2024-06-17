package com.example.student_manager.services.classroom;

import com.example.student_manager.models.Classroom;
import com.example.student_manager.repository.classroom.ClassRepository;
import com.example.student_manager.repository.classroom.IClassRepository;

import java.sql.SQLException;
import java.util.List;

public class ClassService implements IClassService{
    private IClassRepository classRepository = new ClassRepository();
    @Override
    public List<Classroom> selectAllClassroom() {
        try {
            return classRepository.selectAllClassroom();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Classroom findById(int id) throws SQLException {
        return classRepository.findById(id);
    }
}
