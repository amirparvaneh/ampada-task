package com.ampada.newsapp.controller;

import com.ampada.newsapp.service.userService.UserServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService, UserServiceImpl userService1){
        this.userService = userService;
    }
}
