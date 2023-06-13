package com.ampada.newsapp.controller;

import com.ampada.newsapp.model.Board;
import com.ampada.newsapp.service.boardService.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // Existing APIs

    @GetMapping("/search")
    public ResponseEntity<List<Board>> searchBoardsByBoardName(@RequestParam("searchTerm") String searchTerm) {
        List<Board> boards = boardService.searchBoardsByBoardName(searchTerm);
        return ResponseEntity.ok(boards);
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<Board>> getBoardsSortedByModifiedOn() {
        List<Board> boards = boardService.getBoardsSortedByModifiedOn();
        return ResponseEntity.ok(boards);
    }
}

