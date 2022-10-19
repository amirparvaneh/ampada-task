package com.ampada.newsapp.controller;

import com.ampada.newsapp.dto.AuthResponse;
import com.ampada.newsapp.dto.LoginRequest;
import com.ampada.newsapp.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthService authService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authService.register(user);
    }


    @PostMapping("/login")
    public AuthResponse authResponse(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }
}
