package com.example.max_market.service.Impl;

import com.example.max_market.model.User;
import com.example.max_market.repository.UserRepository;
import com.example.max_market.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.max_market.model.Role.ROLE_USER;

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
        user.getRoles().add(ROLE_USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        log.info("Saving new User with name {}",username);
        return true;
    }

    @Override
    public boolean authUser(User userAuth) {
        Optional<User> user = userRepository.findByUsername(userAuth.getUsername());
        if (user.isPresent() && user.get().getUsername().equals(userAuth.getUsername())){
            return true;
        }
        return false;
    }
}
