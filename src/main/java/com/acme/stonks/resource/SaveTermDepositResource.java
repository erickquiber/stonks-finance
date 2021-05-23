package com.acme.stonks.resource;

import javax.validation.constraints.NotNull;

public class SaveTermDepositResource {

	@NotNull
	private float tea;

	@NotNull
	private String name;
	
	@NotNull
	private Integer maxDay;
	
	@NotNull
	private Integer minDay;
	
	@NotNull
	private float minAmount;
	
	public float getTea() {
		return tea;
	}
	public SaveTermDepositResource setTea(float tea) {
		this.tea = tea;
		return this;
	}
	public String getName() {
		return name;
	}
	public SaveTermDepositResource setName(String name) {
		this.name = name;
		return this;
	}
	public Integer getMaxDay() {
		return maxDay;
	}
	public SaveTermDepositResource setMaxDay(Integer maxDay) {
		this.maxDay = maxDay;
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
