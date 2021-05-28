package com.acme.stonks.resource;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class SaveAccountTermDepositResource {
    
    @NotNull
    @Positive
    private float capital;
    
    @NotNull
    private float tea;
    
    private float minTea;

    @NotNull
    private Date dateStart;
    
    @NotNull
    private Date dateEnd;
    
    @NotNull
    private boolean monthlyPayment;
    
    @NotNull
    private boolean withdrawalInterest;
    
    public float getCapital() {
        return capital;
    }

    public void setCapital(float capital) {
        this.capital = capital;
    }

    public float getTea() {
        return tea;
    }

    public void setTea(float tea) {
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

    public boolean isMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(boolean monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	public boolean isWithdrawalInterest() {
        return withdrawalInterest;
    }

    public void setWithdrawalInterest(boolean withdrawalInterest) {
        this.withdrawalInterest = withdrawalInterest;
    }

    
}
