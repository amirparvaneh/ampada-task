package com.ampada.newsapp.service.userService;

import com.ampada.newsapp.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> findAll();
}
