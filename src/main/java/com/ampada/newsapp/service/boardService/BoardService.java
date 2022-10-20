package com.ampada.newsapp.service.boardService;

import com.ampada.newsapp.model.Board;
import org.springframework.stereotype.Service;

@Service
public interface BoardService {
    Board createBoard(Board board);
}
