package com.example.max_market.service;

import com.example.max_market.model.User;

import java.util.List;

public interface UserService {
    User findUserById(Long userId);
    List<User> findAllUsers();
    boolean saveUser(User user);
    boolean deleteUser(Long userId);
    List<User> usergtList(Long idMin);
}
