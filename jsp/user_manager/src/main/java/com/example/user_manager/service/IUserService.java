package com.example.user_manager.service;

import com.example.user_manager.models.User;

import java.awt.print.Book;
import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    public void insertUser(User user);
    public User selectUser(int id);
    public List<User> selectAllUser();
    public boolean deleteUser(int id) ;
    public boolean updateUser(User user);
    public List<User> searchUserCountry(String keyword);
    List<User> sortUserByName();
}
