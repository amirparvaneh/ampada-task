package com.ampada.newsapp.controller;

import com.ampada.newsapp.dto.LoginDto;
import com.ampada.newsapp.dto.UserDto;
import com.ampada.newsapp.model.User;
import com.ampada.newsapp.service.userService.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService, UserServiceImpl userService1){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto){
        Optional<User> user = Optional.ofNullable(userService.getUserByUserName(userDto.getUserName()));
        if (user.isEmpty()){
            userService.register(userDto);
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) throws Exception {
        String token = userService.login(loginDto);
        return ResponseEntity.ok(token);
    }
}
