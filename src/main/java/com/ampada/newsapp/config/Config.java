package com.ampada.newsapp.config;

import com.ampada.newsapp.model.User;
import com.ampada.newsapp.repository.UserRepository;
import com.ampada.newsapp.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan
public class Config{

    private UserRepository userRepository;


    @Autowired
    public Config(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Bean
    public UserService userService(){
        return new UserService() {
            @Override
            public List<User> findAll() {
                List<User> list= userRepository.findAll();
                return list;
            }
        };
    }
}
