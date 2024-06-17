package com.example.student_manager.repository.classroom;

import com.example.student_manager.models.Classroom;

import java.sql.SQLException;
import java.util.List;

public interface IClassRepository {
    List<Classroom> selectAllClassroom() throws SQLException;

    Classroom findById(int id) throws SQLException;
}
