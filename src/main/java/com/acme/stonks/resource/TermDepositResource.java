package com.acme.stonks.resource;

public class TermDepositResource {

	private Long id;
	private float tea;
	private String currency;
	private Integer minDay;
	private float minAmount;
	private float profit;
	private float monthlyProfit;

	public float getProfit() {
		return profit;
	}

	public TermDepositResource setProfit(float profit) {
		this.profit = profit;
		return this;
	}

	public float getMonthlyProfit() {
		return monthlyProfit;
	}

	public TermDepositResource setMonthlyProfit(float monthlyProfit) {
		this.monthlyProfit = monthlyProfit;
		return this;
	}
	public Long getId() {
		return id;
	}
	public TermDepositResource setId(Long id) {
		this.id = id;
		return this;
	}
	public String getCurrency() {
		return currency;
	}
	public TermDepositResource setCurrency(String currency) {
		this.currency = currency;
		return this;
	}
	public float getTea() {
		return tea;
	}
	public TermDepositResource setTea(float tea) {
		this.tea = tea;
		return this;
	}
	public Integer getMinDay() {
		return minDay;
	}
	public TermDepositResource setMinDay(Integer minDay) {
		this.minDay = minDay;
		return this;
	}
	public float getMinAmount() {
		return minAmount;
	}

	public TermDepositResource setMinAmount(float minAmount) {
		this.minAmount = minAmount;
		return this;
	}
	
}
