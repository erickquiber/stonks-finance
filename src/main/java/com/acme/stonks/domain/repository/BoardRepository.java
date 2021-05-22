package com.acme.stonks.domain.repository;

import com.acme.stonks.domain.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  BoardRepository extends JpaRepository<Board, Long> {
}
