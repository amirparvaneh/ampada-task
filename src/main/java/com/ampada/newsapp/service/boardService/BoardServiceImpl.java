package com.ampada.newsapp.service.boardService;

import com.ampada.newsapp.model.Board;
import com.ampada.newsapp.repository.BoardRepository;

public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }


    @Override
    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }
}
