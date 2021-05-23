package com.acme.stonks.controller;

import com.acme.stonks.domain.model.Board;
import com.acme.stonks.domain.service.BoardService;
import com.acme.stonks.resource.BoardResource;
import com.acme.stonks.resource.SaveBoardResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
@Tag(name="Boards",description = "Board API")
@RestController
@RequestMapping("/api")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/clients/{clientId}/boards")
    public Page<BoardResource> getAllBoardsByClientId(
            @PathVariable(value = "clientId") Long clientId,
            Pageable pageable) {
        Page<Board> boardPage = boardService.getAllBoardsByClientId(clientId, pageable);
        List<BoardResource> resources = boardPage.getContent().stream()
                .map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/clients/{clientId}/boards/{boardId}")
    public BoardResource getBoardByIdAndClientId(
            @PathVariable(name = "clientId") Long clientId,
            @PathVariable(name = "boardId") Long boardId) {
        return convertToResource(boardService.getBoardIdAndByClientId(clientId, boardId));
    }

    @PostMapping("/clients/{clientId}/boards")
    public BoardResource createBoard(
            @PathVariable(value = "clientId") Long clientId,
            @Valid @RequestBody SaveBoardResource resource) {
        return convertToResource(boardService.createBoard(clientId,
                convertToEntity(resource)));
    }

    @PutMapping("/clients/{clientId}/boards/{boardId}")
    public BoardResource updateBoard(
            @PathVariable (value = "clientId") Long clientId,
            @PathVariable (value = "boardId") Long boardId,
            @Valid @RequestBody SaveBoardResource resource) {
        return convertToResource(boardService.updateBoard(clientId, boardId,
                convertToEntity(resource)));
    }

    @DeleteMapping("/clients/{clientId}/boards/{boardId}")
    public ResponseEntity<?> deleteBoard(
            @PathVariable (value = "clientId") Long clientId,
            @PathVariable (value = "boardId") Long boardId) {
        return boardService.deleteBoard(clientId, boardId);
    }

    private Board convertToEntity(SaveBoardResource resource) {
        return mapper.map(resource, Board.class);
    }

    private BoardResource convertToResource(Board entity) {
        return mapper.map(entity, BoardResource.class);
    }
}
