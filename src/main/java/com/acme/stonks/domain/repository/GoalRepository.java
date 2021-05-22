package com.acme.stonks.domain.repository;

import com.acme.stonks.domain.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<Goal,Long> {
}
