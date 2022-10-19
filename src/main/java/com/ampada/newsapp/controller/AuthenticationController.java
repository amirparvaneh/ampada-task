package com.ampada.newsapp.controller;

import com.ampada.newsapp.dto.AuthResponse;
import com.ampada.newsapp.dto.LoginRequest;
import com.ampada.newsapp.model.User;
import com.ampada.newsapp.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthService authService;

    @PostMapping("/signUp")
    public ResponseEntity register(@RequestBody User user) {
        return authService.register(user);
    }


    @PostMapping("/login")
    public AuthResponse authResponse(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }
}
