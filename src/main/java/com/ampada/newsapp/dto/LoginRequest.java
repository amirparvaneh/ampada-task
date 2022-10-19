package com.ampada.newsapp.dto;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;



public class LoginRequest {
    private String username;
    private String password;


    public UsernamePasswordAuthenticationToken getAuth() {
        return new UsernamePasswordAuthenticationToken(username, password);
    }
}
