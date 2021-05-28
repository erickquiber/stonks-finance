package com.acme.stonks.resource;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Setter
@Getter
public class GoalResource {
    private Long id;
    private String name;
    private Double goalAmount;
    private Date dateGoal;
}
