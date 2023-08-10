package com.example.max_market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/market/marketplace")
    public String home(){
        return "marketplace.html";
    }
    @GetMapping("/market/registration")
    public String registration(){
        return "registration.html";
    }

    @GetMapping("/market/login")
    public String login(){ return "login.html"; }

}
