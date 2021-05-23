package com.acme.stonks.resource;

import java.util.Date;

public class TransactionResource {

    private Long id;
    private String type;
    private Date date;
    private Float currentCapital;
    private Float amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getCurrentCapital() {
        return currentCapital;
    }

    public void setCurrentCapital(Float currentCapital) {
        this.currentCapital = currentCapital;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

}
