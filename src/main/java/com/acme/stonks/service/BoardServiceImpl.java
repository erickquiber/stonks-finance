package com.acme.stonks.service;

import com.acme.stonks.domain.model.Board;
import com.acme.stonks.domain.repository.BoardRepository;
import com.acme.stonks.domain.repository.ClientRepository;
import com.acme.stonks.domain.service.BoardService;
import com.acme.stonks.exception.ResourceNotFoundException;
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


        return boardRepository.findByClientId(clientId,pageable);
    }

    @Override
    public Board getBoardIdAndByClientId(Long clientId, Long boardId) {

        return boardRepository.findByIdAndClientId(boardId,clientId)
                .orElseThrow(()->new ResourceNotFoundException(
                        "Board not found whit Id "+boardId+
                                "and ClientId "+ clientId));
    }

    @Override
    public Board createBoard(Long clientId, Board board) {

        return clientRepository.findById(clientId).map(client -> {
            board.setClient(client);
            return boardRepository.save(board);
        }).orElseThrow(()->new ResourceNotFoundException(
                "Client","Id", clientId
        ));
    }

    @Override
    public Board updateBoard(Long clientId, Long boardId, Board boardDetails) {
        if(!clientRepository.existsById(clientId))
            throw new ResourceNotFoundException("Client", "Id", clientId);

        return boardRepository.findById(boardId).map(board -> {
            board.setName(boardDetails.getName());
            return boardRepository.save(board);
        }).orElseThrow(() -> new ResourceNotFoundException("Board", "Id", boardId));
    }

    @Override
    public ResponseEntity<?> deleteBoard(Long clientId, Long boardId) {

        return boardRepository.findByIdAndClientId(boardId, clientId).map(board -> {
            boardRepository.delete(board);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Board not found with Id " + boardId+ " and ClientTd " + clientId));
    }
}
