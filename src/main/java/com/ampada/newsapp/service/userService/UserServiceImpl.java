package com.ampada.newsapp.service.userService;

import com.ampada.newsapp.dto.LoginDto;
import com.ampada.newsapp.dto.UserDto;
import com.ampada.newsapp.filters.JwtTokenUtil;
import com.ampada.newsapp.model.User;
import com.ampada.newsapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, JwtTokenUtil jwtTokenUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = bCryptPasswordEncoder;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    public User register(UserDto userDto) {
        String encryptedPassword = passwordEncoder.encode(userDto.getPassword());
        User user = new User();
        user.setUsername(userDto.getUserName());
        user.setPassword(encryptedPassword);
        return userRepository.save(user);
    }

    public User getUserByUserName(String userName){
        return userRepository.findByUsername(userName);
    }

    public String login(LoginDto loginDto) throws Exception {
        User user = userRepository.findByUsername(loginDto.getUsername());
        if (user == null) {
            throw new Exception("Invalid username or password");
        }
        boolean passwordMatch = passwordEncoder.matches(loginDto.getPassword(), user.getPassword());
        if (!passwordMatch) {
            throw new Exception("Invalid username or password");
        }
        return jwtTokenUtil.generateToken(user.getUsername());
    }

    public boolean validateToken(String token) {
        return jwtTokenUtil.validateToken(token);
    }

    public String getUsernameFromToken(String token) {
        return jwtTokenUtil.getUsernameFromToken(token);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }
}
