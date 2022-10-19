package com.ampada.newsapp.repository;

import com.ampada.newsapp.model.Card;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CardRepository extends MongoRepository<Card,String> {
}
