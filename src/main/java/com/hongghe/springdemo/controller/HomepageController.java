package com.hongghe.springdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/homepage")
public class HomepageController {
    private static final Logger logger = LoggerFactory.getLogger(HomepageController.class);

    @RequestMapping("hello")
    public String hello() {
        return "hello";
    }
}
