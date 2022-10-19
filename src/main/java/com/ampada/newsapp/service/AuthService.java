package com.ampada.newsapp.service;


import com.ampada.newsapp.dto.AuthResponse;
import com.ampada.newsapp.dto.LoginRequest;
import com.ampada.newsapp.model.User;
import com.ampada.newsapp.repository.UserRepository;
import com.ampada.newsapp.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtProvider jwtProvider;



    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
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
        User user = new User().setUserName("amir")
                .setPassword(passwordEncoder.encode("password"));
        userRepository.save(user);
    }


}
