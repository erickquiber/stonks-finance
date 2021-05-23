package com.acme.stonks.resource;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class SaveTransactionResource {
    @NotNull
    @NotBlank
    @Size(max = 20)
    private String type;

    @NotNull
    private Date date;

    @NotNull
    @Positive
    private float currentCapital; 

    @NotNull
    private float amount;

    //getters and setters

    public String getType() {
        return type;
    }

    public SaveTransactionResource setType(String type) {
        this.type = type;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public SaveTransactionResource setDate(Date date) {
        this.date = date;
        return this;
    }

    public float getCurrentCapital() {
        return currentCapital;
    }

    public SaveTransactionResource setCurrentCapital(float currentCapital) {
        this.currentCapital = currentCapital;
        return this;
    }

    public float getAmount() {
        return amount;
    }

    public SaveTransactionResource setAmount(float amount) {
        this.amount = amount;
        return this;
    }

    
}
