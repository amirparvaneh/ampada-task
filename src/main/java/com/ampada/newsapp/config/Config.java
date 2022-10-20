package com.ampada.newsapp.config;

import com.ampada.newsapp.controller.BoardController;
import com.ampada.newsapp.model.Board;
import com.ampada.newsapp.model.User;
import com.ampada.newsapp.repository.BoardRepository;
import com.ampada.newsapp.repository.UserRepository;
import com.ampada.newsapp.service.boardService.BoardService;
import com.ampada.newsapp.service.boardService.BoardServiceImpl;
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
    private BoardRepository boardRepository;
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
    @Bean
    public BoardService boardService(){
        return new BoardService() {
            @Override
            public Board createBoard(Board board) {
                return null;
            }
        };
    }
}
