package com.authorization.jwt.service;

import com.authorization.jwt.entities.User;

import java.util.List;

public interface UserService {
    User registerUser(User user);
    List<User> getAllUsers();
    User getByUsername(String username);
    User findById(Long id);
    void deleteUser(Long id);
}
