package com.acme.stonks.resource;

import javax.validation.constraints.NotNull;

public class SaveTermDepositResource {

	@NotNull
	private float tea;

	@NotNull
	private Integer minDay;
	
	@NotNull
	private float minAmount;

	@NotNull
	private String currency;
	
	public String getCurrency() {
		return currency;
	}
	public SaveTermDepositResource setCurrency(String currency) {
		this.currency = currency;
		return this;
	}
	public float getTea() {
		return tea;
	}
	public SaveTermDepositResource setTea(float tea) {
		this.tea = tea;
		return this;
	}
	public Integer getMinDay() {
		return minDay;
	}
	public SaveTermDepositResource setMinDay(Integer minDay) {
		this.minDay = minDay;
		return this;
	}
	public float getMinAmount() {
		return minAmount;
	}

	public SaveTermDepositResource setMinAmount(float minAmount) {
		this.minAmount = minAmount;
		return this;
	}
	
}
