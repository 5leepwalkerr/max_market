package com.example.max_market.controller;

import com.example.max_market.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

}
