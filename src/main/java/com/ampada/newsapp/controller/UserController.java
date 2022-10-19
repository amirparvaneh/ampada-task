package com.ampada.newsapp.controller;


import com.ampada.newsapp.model.User;
import com.ampada.newsapp.service.userService.UserService;
import com.ampada.newsapp.service.userService.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody()
    public List<User> getAllUser(){
        List<User> userList = userService.findAll();
        return userList;
    }
}
