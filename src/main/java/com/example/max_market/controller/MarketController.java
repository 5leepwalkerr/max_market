package com.example.max_market.controller;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/market")
@Slf4j
public class MarketController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MarketController.class);

}
