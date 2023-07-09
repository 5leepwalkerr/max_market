package com.example.max_market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/market")
    public String home(){
        return "home.html";
    }
    @RequestMapping("/registration")
    public String registration(){
        return "registration.html";
    }
}
