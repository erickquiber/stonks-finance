package com.acme.stonks.domain.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Account_term_deposits")
public class AccountTermDeposit {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private float capital;

    @NotNull
    private float tea;

    @Column(name = "min_tea")
    private float minTea;
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_start")
    private Date dateStart;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_end")
    private Date dateEnd;

    @NotNull
    @Column(name = "interest_payment_type")
    private boolean interestPaymentType;

    @NotNull
    @Column(name = "withdrawal_interest")
    private boolean withdrawalInterest;

    @OneToMany(mappedBy = "accountTermDeposit")
    private List<Transaction> transactions;

    /*
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bank_id", nullable = false)
    @JsonIgnore
    private Bank bank;
    */
    /*
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "board_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Board board;
    */


    public Long getId() {
        return id;
    }

    public AccountTermDeposit setId(Long id) {
        this.id = id;
        return this;
    }

    public float getCapital() {
        return capital;
    }

    public AccountTermDeposit setCapital(float capital) {
        this.capital = capital;
        return this;
    }

    public float getTea() {
        return tea;
    }

    public AccountTermDeposit setTea(float tea) {
        this.tea = tea;
        return this;
    }

    public float getMinTea() {
        return minTea;
    }

    public AccountTermDeposit setMinTea(float minTea) {
        this.minTea = minTea;
        return this;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public AccountTermDeposit setDateStart(Date dateStart) {
        this.dateStart = dateStart;
        return this;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public AccountTermDeposit setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
        return this;
    }

    public boolean isInterestPaymentType() {
        return interestPaymentType;
    }

    public AccountTermDeposit setInterestPaymentType(boolean interestPaymentType) {
        this.interestPaymentType = interestPaymentType;
        return this;
    }

    public boolean isWithdrawalInterest() {
        return withdrawalInterest;
    }

    public AccountTermDeposit setWithdrawalInterest(boolean withdrawalInterest) {
        this.withdrawalInterest = withdrawalInterest;
        return this;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public AccountTermDeposit setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
        return this;
    }
    
    /*
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bank_id", nullable = false)
    @JsonIgnore
    private Bank bank;
    */

    /*
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "board_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Board board;
    */
    
}
