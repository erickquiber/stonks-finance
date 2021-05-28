package com.acme.stonks.resource;

import java.util.Date;

public class AccountTermDepositResource {

    private Long id;
    private double capital;
    private double tea;
    private float minTea;
    private Date dateStart;
    private Date dateEnd;
    private boolean interestPaymentType;
    private boolean withdrawalInterest;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public double getCapital() {
        return capital;
    }
    public void setCapital(double capital) {
        this.capital = capital;
    }
    public double getTea() {
        return tea;
    }
    public void setTea(double tea) {
        this.tea = tea;
    }
    public float getMinTea() {
        return minTea;
    }
    public void setMinTea(float minTea) {
        this.minTea = minTea;
    }
    public Date getDateStart() {
        return dateStart;
    }
    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }
    public Date getDateEnd() {
        return dateEnd;
    }
    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }
    public boolean isInterestPaymentType() {
        return interestPaymentType;
    }
    public void setInterestPaymentType(boolean interestPaymentType) {
        this.interestPaymentType = interestPaymentType;
    }
    public boolean isWithdrawalInterest() {
        return withdrawalInterest;
    }
    public void setWithdrawalInterest(boolean withdrawalInterest) {
        this.withdrawalInterest = withdrawalInterest;
    }

    
}
