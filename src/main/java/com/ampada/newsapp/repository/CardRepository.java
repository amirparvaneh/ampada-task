package com.ampada.newsapp.repository;

import com.ampada.newsapp.model.Card;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CardRepository extends MongoRepository<Card,String> {
    List<Card> findByBoardId(String boardId);
    List<Card> findByCardTitleContainingIgnoreCase(String search);
    List<Card> findByMembersContaining(String memberId);
    List<Card> findAllByOrderByModifiedOnDesc();
}
