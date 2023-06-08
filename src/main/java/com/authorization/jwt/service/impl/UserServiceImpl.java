package com.authorization.jwt.service.impl;

import com.authorization.jwt.controllers.Role;
import com.authorization.jwt.controllers.Status;
import com.authorization.jwt.controllers.User;
import com.authorization.jwt.repo.RoleRepo;
import com.authorization.jwt.repo.UserRepo;
import com.authorization.jwt.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final BCryptPasswordEncoder passwordEncoder;


    @Override
    public User registerUser(User user) {
        Role roleUser = roleRepo.findByName("ROLE_USER");
        List<Role> roles = new ArrayList<>();
        roles.add(roleUser);
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus(Status.ACTIVE);
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public User findById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
        log.info("USER HAS BEEN DELETED SUCCESSFULLY");
    }
}
