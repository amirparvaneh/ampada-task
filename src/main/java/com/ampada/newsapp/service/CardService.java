package com.ampada.newsapp.service;

import com.ampada.newsapp.model.Card;
import com.ampada.newsapp.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CardService {
    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Card createCard(Card card) {
        card.setCreatedOn(LocalDateTime.now());
        card.setModifiedOn(LocalDateTime.now());
        return cardRepository.save(card);
    }

    public List<Card> getCardsByBoardId(String boardId) {
        return cardRepository.findByBoardId(boardId);
    }

    public Card getCardById(String cardId) {
        return cardRepository.findById(cardId)
                .orElseThrow(() -> new IllegalArgumentException("Card not found."));
    }

    public void updateCard(String cardId, Card updatedCard) {
        Card card = getCardById(cardId);
        card.setCardTitle(updatedCard.getCardTitle());
        card.setModifiedOn(LocalDateTime.now());
        cardRepository.save(card);
    }

    public void deleteCard(String cardId) {
        cardRepository.deleteById(cardId);
    }

    public List<Card> searchCardsByCardTitle(String searchTerm) {
        return cardRepository.findByCardTitleContainingIgnoreCase(searchTerm);
    }

    public List<Card> searchCardsByMembers(String memberId) {
        return cardRepository.findByMembersContaining(memberId);
    }

    public List<Card> getCardsSortedByModifiedOn() {
        return cardRepository.findAllByOrderByModifiedOnDesc();
    }
}
