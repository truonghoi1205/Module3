package com.example.user_manager.repository;

import com.example.user_manager.models.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
    public void insertUser(User user) throws SQLException;
    public User selectUser(int id) ;
    public List<User> selectAllUser() ;
    public boolean deleteUser(int id) throws SQLException;
    public boolean updateUser(User user) throws SQLException;
    public List<User> searchUserCountry(String keyword) throws SQLException;

    List<User> sortUserByName();
}
