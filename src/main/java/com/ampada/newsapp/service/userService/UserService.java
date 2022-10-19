package com.ampada.newsapp.service.userService;

import com.ampada.newsapp.model.User;
import org.springframework.stereotype.Component;


import java.util.List;


@Component
public interface UserService {
    List<User> findAll();
}
