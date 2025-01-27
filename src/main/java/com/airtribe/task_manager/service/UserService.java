package com.airtribe.task_manager.service;

import com.airtribe.task_manager.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);
    Optional<User> getUserById(Long id);
    Optional<User> getUserByUsername(String username); // Add this method
    List<User> getAllUsers();
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}
