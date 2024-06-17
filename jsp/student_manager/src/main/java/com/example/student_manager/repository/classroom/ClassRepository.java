package com.example.student_manager.repository.classroom;


import com.example.student_manager.models.Classroom;
import com.example.student_manager.models.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.example.student_manager.databases.DBConnect.getConnection;

public class ClassRepository implements IClassRepository {
    private static final String SELECT_ALL_CLASSROOM = "SELECT * FROM students.class;";
    private static final String FIND_BY_ID = "SELECT * FROM students.class WHERE id = ?";
    Connection connection = getConnection();

    @Override
    public List<Classroom> selectAllClassroom() throws SQLException {
        List<Classroom> classrooms = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(SELECT_ALL_CLASSROOM);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int idClass = rs.getInt("id");
            String nameClass = rs.getString("nameClass");
            Classroom classroom = new Classroom(idClass,nameClass);
            classrooms.add(classroom);
        }
        return classrooms;
    }
    public Classroom findById(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        Classroom classroom = null;
        while (resultSet.next()) {
            int idClass = resultSet.getInt("id");
            String name = resultSet.getString("name");
            classroom = new Classroom(idClass, name);
        }
        return classroom;
    }
}
