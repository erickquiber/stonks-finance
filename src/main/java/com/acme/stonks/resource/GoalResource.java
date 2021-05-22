package com.acme.stonks.resource;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Setter
@Getter
public class GoalResource {
    private Long id;
    private String name;
    private String goalAmount;
    private Date dateGoal;
}
