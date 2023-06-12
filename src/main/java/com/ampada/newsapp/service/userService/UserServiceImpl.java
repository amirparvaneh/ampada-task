package com.ampada.newsapp.service.userService;

import com.ampada.newsapp.model.User;
import com.ampada.newsapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        userList = userRepository.findAll();
        return userList;
    }
}
