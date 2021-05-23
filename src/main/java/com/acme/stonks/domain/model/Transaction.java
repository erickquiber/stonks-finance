package com.acme.stonks.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "transactions")
public class Transaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String type;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = false)
    private Date date;

    @NotNull
    @Column(name = "current_capital")
    private float currentCapital; 

    @NotNull
    private float amount;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_term_deposit_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private AccountTermDeposit accountTermDeposit;


    // getters and setters
    
    public Long getId() {
        return id;
    }

    public Transaction setId(Long id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public Transaction setType(String type) {
        this.type = type;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Transaction setDate(Date date) {
        this.date = date;
        return this;
    }

    public float getCurrentCapital() {
        return currentCapital;
    }

    public Transaction setCurrentCapital(float currentCapital) {
        this.currentCapital = currentCapital;
        return this;
    }

    public float getAmount() {
        return amount;
    }

    public Transaction setAmount(float amount) {
        this.amount = amount;
        return this;
    }

    public AccountTermDeposit getAccountTermDeposit() {
        return accountTermDeposit;
    }

    public Transaction setAccountTermDeposit(AccountTermDeposit accountTermDeposit) {
        this.accountTermDeposit = accountTermDeposit;
        return this;
    }
}
