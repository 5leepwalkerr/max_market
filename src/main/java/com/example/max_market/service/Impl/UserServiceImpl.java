package com.example.max_market.service.Impl;

import com.example.max_market.model.Role;
import com.example.max_market.model.User;
import com.example.max_market.repository.UserRepository;
import com.example.max_market.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private  PasswordEncoder passwordEncoder;
    @Override
    public boolean createUser(User user) {
        String username = user.getUsername();
        if (userRepository.findByUsername(username).isPresent()){
            log.error("This username already exist, try another!");
            return false;
        }
        user.setActive(true);
        user.getRoles().add(Role.ROLE_USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        log.info("Saving new User with name {}",username);
        return true;
    }
}
