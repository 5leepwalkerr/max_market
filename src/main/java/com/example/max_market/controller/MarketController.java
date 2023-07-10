package com.example.max_market.controller;


import com.example.max_market.model.User;
import com.example.max_market.repository.UserRepository;
import com.example.max_market.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/market")
@Slf4j
public class MarketController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public String createUser(@RequestBody User user){
        userService.createUser(user);
        log.info("Create new user: {}",user.getCreationDate());
        return "redirect:/login";
    }
}
