package com.authorization.jwt.service;

import com.authorization.jwt.controllers.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User registerUser(User user);
    List<User> getAllUsers();
    User getByUsername(String username);
    User findById(Long id);
    void deleteUser(Long id);
}
