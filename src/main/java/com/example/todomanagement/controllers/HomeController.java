package com.example.todomanagement.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HomeController {

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to the TODO-MANAGEMENT app";
    }
}
