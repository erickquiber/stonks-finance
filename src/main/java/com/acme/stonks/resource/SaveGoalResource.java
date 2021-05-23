package com.acme.stonks.resource;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
public class SaveGoalResource {
    @NotNull
    private String name;
    @NotNull
    private Double goalAmount;
    @NotNull
    private Date dateGoal;
}
