package com.acme.stonks.domain.service;

import com.acme.stonks.domain.model.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface BoardService {
    Page<Board> getAllBoardsByClientId(Long clientId, Pageable pageable);
    Board getBoardByClientId(Long clientId, Long boardId);
    Board createBoard(Long clientId, Board board);
    Board updateBoard(Long clientId, Long boardId, Board boardDetails);
    ResponseEntity<?> deleteBoard(Long clientId, Long boardId);
}
