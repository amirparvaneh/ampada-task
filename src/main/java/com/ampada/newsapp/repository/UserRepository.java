package com.ampada.newsapp.repository;

import com.ampada.newsapp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User,String> {
    User findByUsername(String username);
}
