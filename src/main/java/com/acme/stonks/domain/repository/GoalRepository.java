package com.acme.stonks.domain.repository;

import com.acme.stonks.domain.model.Goal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GoalRepository extends JpaRepository<Goal,Long> {
    Page<Goal> findByClientId(Long clientId, Pageable pageable);
    Optional<Goal> findByIdAndClientId(Long id, Long ClientId);
}
