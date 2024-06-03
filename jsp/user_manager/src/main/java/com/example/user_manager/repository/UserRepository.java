package com.example.user_manager.repository;

import com.example.user_manager.models.User;
import com.sun.scenario.effect.impl.prism.ps.PPSBlend_ADDPeer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.example.user_manager.repository.ConnectDB.getConnection;

public class UserRepository implements IUserRepository {
    private static final String INSERT_USERS_SQL = "insert into users (name, email, country) values (?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
    private static final String SEARCH_USER_COUNTRY_SQL = "select * from users where country like ?;";
    private static final String SORT_BY_NAME = "select * from users order by name;";

    public UserRepository() {
    }

    @Override
    public void insertUser(User user) {

        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCountry());
            ps.executeUpdate();
        } catch (SQLException exception) {
            printSQLException(exception);
        }

    }

    @Override
    public User selectUser(int id) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_USER_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException exception) {
            printSQLException(exception);
        }


        return user;
    }

    @Override
    public List<User> selectAllUser() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_ALL_USERS)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                User user = new User(id, name, email, country);
                userList.add(user);
            }
        } catch (SQLException exception) {
            printSQLException(exception);
        }
        return userList;
    }


    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);
        statement.setInt(1, id);
        rowDeleted = statement.executeUpdate() > 0;

        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);
        statement.setString(1, user.getName());
        statement.setString(2, user.getEmail());
        statement.setString(3, user.getCountry());
        statement.setInt(4, user.getId());
        rowUpdated = statement.executeUpdate() > 0;

        return rowUpdated;
    }

    @Override
    public List<User> searchUserCountry(String keyword) {
        List<User> users = new ArrayList<>();
        Connection connection = getConnection();
        System.out.println(keyword);
        try {
            PreparedStatement ps = connection.prepareStatement(SEARCH_USER_COUNTRY_SQL);
            ps.setString(1, "%"+keyword+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                User user = new User(id, name, email, country);
                System.out.println(user);
                users.add(user);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    public List<User> sortUserByName() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(SORT_BY_NAME)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                User user = new User(id, name, email, country);
                userList.add(user);
            }
        } catch (SQLException exception) {
            printSQLException(exception);
        }
        return userList;
    }


    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
