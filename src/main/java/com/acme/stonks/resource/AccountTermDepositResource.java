package com.acme.stonks.resource;

import java.util.Date;

public class AccountTermDepositResource {

    private Long id;
    private float capital;
    private float tea;
    private float minTea;
    private Date dateStart;
    private Date dateEnd;
    private boolean monthlyPayment;
    private boolean withdrawalInterest;
    private float interest;

    public float getInterest() {
		return interest;
	}
	public void setInterest(float interest) {
		this.interest = interest;
	}
	public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
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
