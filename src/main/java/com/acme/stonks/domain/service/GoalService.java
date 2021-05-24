package com.acme.stonks.domain.service;

import com.acme.stonks.domain.model.Goal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface GoalService {
    Page<Goal> getAllGoalsByClientId(Long clientId, Pageable pageable);
    Goal getGoalByIdAndClientId(Long clientId, Long goalId);
    Goal createGoal(Long clientId, Goal goal);
    Goal updateGoal(Long clientId, Long goalId, Goal goalDetails);
    ResponseEntity<?> deleteGoal(Long clientId, Long goalId);
}

