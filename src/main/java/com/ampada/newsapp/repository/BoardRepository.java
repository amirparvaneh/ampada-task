package com.ampada.newsapp.repository;

import com.ampada.newsapp.model.Board;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BoardRepository extends MongoRepository<Board,String> {
    List<Board> findByBoardNameContainingIgnoreCase(String searchTerm);
    List<Board> findAllBoardByOrderByModifiedOnDesc();
}
