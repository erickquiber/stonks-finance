package com.acme.stonks.controller;

import com.acme.stonks.domain.model.Goal;
import com.acme.stonks.domain.service.GoalService;
import com.acme.stonks.resource.GoalResource;
import com.acme.stonks.resource.SaveGoalResource;
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

@Tag(name="Goals",description = "Goal API")
@RestController
@RequestMapping("/api")
public class GoalController {
    @Autowired
    private GoalService goalService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/clients/{clientId}/goals")
    public Page<GoalResource> getAllGoalsByClientId(
            @PathVariable(value = "clientId") Long clientId,
            Pageable pageable) {
        Page<Goal> goalPage = goalService.getAllGoalsByClientId(clientId, pageable);
        List<GoalResource> resources = goalPage.getContent().stream()
                .map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/clients/{clientId}/goals/{goalId}")
    public GoalResource getGoalByIdAndClientId(
            @PathVariable(name = "clientId") Long clientId,
            @PathVariable(name = "goalId") Long goalId) {
        return convertToResource(goalService.getGoalByIdAndClientId(clientId, goalId));
    }

    @PostMapping("/clients/{clientId}/goals")
    public GoalResource createGoal(
            @PathVariable(value = "clientId") Long clientId,
            @Valid @RequestBody SaveGoalResource resource) {
        return convertToResource(goalService.createGoal(clientId,
                convertToEntity(resource)));
    }

    @PutMapping("/clients/{clientId}/goals/{goalId}")
    public GoalResource updateGoal(
            @PathVariable (value = "clientId") Long clientId,
            @PathVariable (value = "goalId") Long goalId,
            @Valid @RequestBody SaveGoalResource resource) {
        return convertToResource(goalService.updateGoal(clientId, goalId,
                convertToEntity(resource)));
    }

    @DeleteMapping("/clients/{clientId}/goals/{goalId}")
    public ResponseEntity<?> deleteGoal(
            @PathVariable (value = "clientId") Long clientId,
            @PathVariable (value = "goalId") Long goalId) {
        return goalService.deleteGoal(clientId, goalId);
    }

    private Goal convertToEntity(SaveGoalResource resource)  { return mapper.map(resource, Goal.class); }

    private GoalResource convertToResource(Goal entity) {
        return mapper.map(entity, GoalResource.class);
    }
}
