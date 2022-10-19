package com.ampada.newsapp.repository;

import com.ampada.newsapp.model.Board;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BoardRepository extends MongoRepository<Board,String> {
}
