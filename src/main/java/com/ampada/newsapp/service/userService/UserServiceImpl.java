package com.ampada.newsapp.service.userService;

import com.ampada.newsapp.filters.JwtTokenUtil;
import com.ampada.newsapp.model.User;
import com.ampada.newsapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;

    public UserServiceImpl(UserRepository userRepository,BCryptPasswordEncoder bCryptPasswordEncoder, JwtTokenUtil jwtTokenUtil){
        this.userRepository = userRepository;
        this.passwordEncoder = bCryptPasswordEncoder;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        userList = userRepository.findAll();
        return userList;
    }
}
