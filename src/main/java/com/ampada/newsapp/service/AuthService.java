package com.ampada.newsapp.service;


import com.ampada.newsapp.dto.AuthResponse;
import com.ampada.newsapp.dto.LoginRequest;
import com.ampada.newsapp.model.User;
import com.ampada.newsapp.repository.UserRepository;
import com.ampada.newsapp.security.JwtProvider;
import com.ampada.newsapp.service.userService.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService implements CommandLineRunner {

    private final UserRepository userRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtProvider jwtProvider;



    public ResponseEntity register(User user) {
        User userExists = userRepository.findByUsername(user.getUsername());
        if (userExists != null) {
            throw new BadCredentialsException("User with username: " + user.getUsername() + " already exists");
        }
        userRepository.save(user);
        Map<Object, Object> model = new HashMap<>();
        model.put("message", "User registered successfully");
        return ResponseEntity.ok(model);

    }


    public AuthResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(loginRequest.getAuth());
        UserDetails user = userDetailsService
                .loadUserByUsername(loginRequest.getUsername());
        String token = jwtProvider.generateToken(user);
        return new AuthResponse()
                .setUsername(user.getUsername())
                .setToken(token);
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User().setUsername("amir")
                .setPassword(passwordEncoder.encode("password"));
        userRepository.save(user);
    }


}
