package com.example.max_market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/market")
    public String home(){
        return "home.html";
    }
    @GetMapping("/registration")
    public String registration(){
        return "registration.html";
    }
    @GetMapping("/login")
    public String loginPage(){
        return "login.html";
    }
}
