package com.example.max_market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/market")
public class PageController {

    @GetMapping()
    public String home(){
        return "home.html";
    }
    @GetMapping("/registration")
    public String registration(){
        return "registration.html";
    }
}
