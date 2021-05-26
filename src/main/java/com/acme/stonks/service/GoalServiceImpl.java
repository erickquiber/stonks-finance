package com.acme.stonks.service;

import com.acme.stonks.domain.model.Goal;
import com.acme.stonks.domain.repository.ClientRepository;
import com.acme.stonks.domain.repository.GoalRepository;
import com.acme.stonks.domain.service.GoalService;
import com.acme.stonks.exception.ResourceNotFoundException;
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

        return goalRepository.findByClientId(clientId, pageable);
    }

    @Override
    public Goal getGoalByIdAndClientId(Long clientId, Long goalId) {

        return goalRepository.findByIdAndClientId(goalId, clientId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Goal not found with Id " + goalId+
                                " and ClientId " + clientId));
    }

    @Override
    public Goal createGoal(Long clientId, Goal goal) {

        return clientRepository.findById(clientId).map(client->{
            goal.setClient(client);
            return goalRepository.save(goal);
        }).orElseThrow(()->new ResourceNotFoundException("Client","Id",clientId));
    }

    @Override
    public Goal updateGoal(Long clientId, Long goalId, Goal goalDetails) {
        if(!clientRepository.existsById(clientId))
            throw new ResourceNotFoundException("Client", "Id", clientId);

        return goalRepository.findById(goalId).map(goal -> {
            goal.setName(goalDetails.getName());
            goal.setDateGoal(goalDetails.getDateGoal());
            goal.setGoalAmount(goalDetails.getGoalAmount());

            return goalRepository.save(goal);
        }).orElseThrow(() -> new ResourceNotFoundException("Goal", "Id", goalId));
    }

    @Override
    public ResponseEntity<?> deleteGoal(Long clientId, Long goalId) {

        return goalRepository.findByIdAndClientId(goalId, clientId).map(goal -> {
            goalRepository.delete(goal);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Goal not found with Id " + goalId + " and ClientId" + clientId));
    }
}
