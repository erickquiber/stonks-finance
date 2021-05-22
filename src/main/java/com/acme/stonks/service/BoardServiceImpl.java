package com.acme.stonks.service;

import com.acme.stonks.domain.model.Board;
import com.acme.stonks.domain.repository.BoardRepository;
import com.acme.stonks.domain.repository.ClientRepository;
import com.acme.stonks.domain.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public Page<Board> getAllBoardsByClientId(Long clientId, Pageable pageable) {
        return null;
    }

    @Override
    public Board getBoardByClientId(Long clientId, Long boardId) {
        return null;
    }

    @Override
    public Board createBoard(Long clientId, Board board) {
        return null;
    }

    @Override
    public Board updateBoard(Long clientId, Long boardId, Board boardDetails) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteBoard(Long clientId, Long boardId) {
        return null;
    }
}
