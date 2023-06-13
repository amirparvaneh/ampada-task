package com.ampada.newsapp.service.boardService;
import com.ampada.newsapp.model.Board;
import com.ampada.newsapp.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Board createBoard(Board board) {
        board.setCreatedOn(LocalDateTime.now());
        board.setModifiedOn(LocalDateTime.now());
        return boardRepository.save(board);
    }

    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    public Board getBoardById(String boardId) {
        return boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("Board not found."));
    }

    public void updateBoard(String boardId, Board updatedBoard) {
        Board board = getBoardById(boardId);
        board.setBoardName(updatedBoard.getBoardName());
        board.setModifiedOn(LocalDateTime.now());
        boardRepository.save(board);
    }

    public void deleteBoard(String boardId) {
        boardRepository.deleteById(boardId);
    }

    public List<Board> searchBoardsByBoardName(String searchTerm) {
        return boardRepository.findByBoardNameContainingIgnoreCase(searchTerm);
    }

    public List<Board> getBoardsSortedByModifiedOn() {
        return boardRepository.findAllByOrderByModifiedOnDesc();
    }
}

