package com.ampada.newsapp.controller;

import com.ampada.newsapp.model.Card;
import com.ampada.newsapp.service.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board/{boardId}/cards")
public class CardController {
    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }


    @GetMapping("/search")
    public ResponseEntity<List<Card>> searchCardsByCardTitle(@RequestParam("searchTerm") String searchTerm) {
        List<Card> cards = cardService.searchCardsByCardTitle(searchTerm);
        return ResponseEntity.ok(cards);
    }

    @GetMapping("/search/members")
    public ResponseEntity<List<Card>> searchCardsByMembers(@RequestParam("memberId") String memberId) {
        List<Card> cards = cardService.searchCardsByMembers(memberId);
        return ResponseEntity.ok(cards);
    }
}

