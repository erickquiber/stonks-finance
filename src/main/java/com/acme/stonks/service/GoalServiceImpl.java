package com.acme.stonks.service;

import com.acme.stonks.domain.model.Goal;
import com.acme.stonks.domain.repository.ClientRepository;
import com.acme.stonks.domain.repository.GoalRepository;
import com.acme.stonks.domain.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GoalServiceImpl implements GoalService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private GoalRepository goalRepository;


    @Override
    public Page<Goal> getAllGoalsByClientId(Long clientId, Pageable pageable) {
        return null;
    }

    @Override
    public Goal getGoalByClientId(Long clientId, Long goalId) {
        return null;
    }

    @Override
    public Goal createGoal(Long clientId, Goal goal) {
        return null;
    }

    @Override
    public Goal updateGoal(Long clientId, Long goalId, Goal goalDetails) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteGoal(Long clientId, Long goalId) {
        return null;
    }
}
