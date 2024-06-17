package com.example.student_manager.repository.student;

import com.example.student_manager.models.Classroom;
import com.example.student_manager.models.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.example.student_manager.databases.DBConnect.getConnection;


public class StudentRepository implements IStudentRepository {
    private static final String SELECT_ALL_STUDENTS = "select s.*, c.name as className from student s join class c on s.class_id = c.id;";
    private static final  String INSERT_STUDENT = "INSERT INTO student(name, email, class_id) VALUE (?, ?, ?)";
    Connection connection;
    public StudentRepository() {
        connection = getConnection();
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Student> selectAllStudent() throws SQLException {
        List<Student> students = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement(SELECT_ALL_STUDENTS);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int idStudent = rs.getInt("id");
            String nameStudent = rs.getString("name");
            String emailStudent = rs.getString("email");
            int idClass = rs.getInt("id");
            String nameClass = rs.getString("className");
            Classroom classroom = new Classroom(idClass,nameClass);
            Student student = new Student(idStudent, nameStudent, emailStudent, classroom);
            students.add(student);
        }
        return students;
    }

    public void save(Student student) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT);
        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getEmail());
        preparedStatement.setInt(3, student.getClassroom().getId());
        preparedStatement.execute();
    }
}
