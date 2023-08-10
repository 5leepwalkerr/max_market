package com.example.max_market.controller;

import com.example.max_market.model.User;
import com.example.max_market.repository.UserRepository;
import com.example.max_market.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/market")
public class MarketController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/registration")
    public ResponseEntity<?> createUser(@RequestBody User user){
        userService.createUser(user);
        log.info("Created new user with name: {}",user.getUsername());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<?> authUser(@RequestBody User user){
        if(userService.authUser(user)) {
            log.info("User {} authorize",user.getUsername());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            throw new UsernameNotFoundException("User with that attributes not found");
        }
    }
}
