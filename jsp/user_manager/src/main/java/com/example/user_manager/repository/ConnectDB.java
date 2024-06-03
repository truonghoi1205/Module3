package com.example.user_manager.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/user_manager?useSSL=false";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "120599";
    protected static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("-----------------Kết nối thành công-----------------");
        } catch (SQLException e) {
            System.out.println("-----------------Lỗi kết nối-----------------");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("-----------------Lỗi kết nối-----------------");
            e.printStackTrace();
        }
        return connection;
    }

}
