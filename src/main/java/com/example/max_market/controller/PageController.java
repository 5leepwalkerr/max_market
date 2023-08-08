package com.example.max_market.controller;

import com.example.max_market.model.User;
import com.example.max_market.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/market")
public class PageController {
    @Autowired
    private UserService userService;

    @GetMapping("/marketplace")
    public String home(){
        return "marketplace.html";
    }
    @GetMapping("/registration")
    public String registration(){
        return "registration.html";
    }

    @GetMapping("/login")
    public String login(){ return "login.html"; }

    @PostMapping("/registration")
    public String createUser(@RequestBody User user) {
        userService.createUser(user);
        log.info("Create new user: {}",user.getCreationDate());
        return "redirect:/market/login";
    }
    @PostMapping("/login")
    public String authUser(@RequestBody User user){
        if(userService.authUser(user)) {
            log.info("User {} authorize",user.getUsername());
            return "redirect:/market/marketplace";
        }
        else{
            throw new UsernameNotFoundException("User with that attributes not found");
        }
    }
}
