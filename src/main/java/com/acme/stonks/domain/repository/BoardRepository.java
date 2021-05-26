package com.acme.stonks.domain.repository;

import com.acme.stonks.domain.model.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface  BoardRepository extends JpaRepository<Board, Long> {
    Page<Board> findByClientId(Long clientId, Pageable pageable);
    Optional<Board> findByIdAndClientId(Long id, Long ClientId);
}
