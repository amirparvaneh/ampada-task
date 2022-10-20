package com.ampada.newsapp.controller;

import com.ampada.newsapp.model.Board;
import com.ampada.newsapp.repository.BoardRepository;
import com.ampada.newsapp.service.boardService.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Board addNewBoard(@RequestBody Board board){
        return boardService.createBoard(board);
    }

}
