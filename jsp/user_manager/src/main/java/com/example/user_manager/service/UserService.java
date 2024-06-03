package com.example.user_manager.service;

import com.example.user_manager.models.User;
import com.example.user_manager.repository.IUserRepository;
import com.example.user_manager.repository.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService {
    private IUserRepository userRepository = new UserRepository();

    @Override
    public void insertUser(User user) {
        try {
            userRepository.insertUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User selectUser(int id) {
        return userRepository.selectUser(id);

    }

    @Override
    public List<User> selectAllUser() {
        return userRepository.selectAllUser();
    }

    @Override
    public boolean deleteUser(int id) {
        try {
            return userRepository.deleteUser(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateUser(User user) {
        try {
            return userRepository.updateUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> sortUserByName() {
       return userRepository.sortUserByName();
    }

    @Override
    public List<User> searchUserCountry(String keyword) {
        try {
            return userRepository.searchUserCountry(keyword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
