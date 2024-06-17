package com.example.student_manager.services.classroom;

import com.example.student_manager.models.Classroom;

import java.sql.SQLException;
import java.util.List;

public interface IClassService {
    List<Classroom> selectAllClassroom();
    Classroom findById(int id) throws SQLException;
}
