package com.saandeep.contentcalendar.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Value("${message: Welcome message}")
    private String message;

    @GetMapping("/")
    public String getHome() {
        return this.message;
    }
}
