package com.acme.stonks.resource;

public class TermDepositResource {

	private Long id;
	private String name;
	private float tea;
	private Integer maxDay;
	private Integer minDay;
	private float minAmount;
	
	public Long getId() {
		return id;
	}
	public TermDepositResource setId(Long id) {
		this.id = id;
		return this;
	}
	
	public String getName() {
		return name;
	}
	public TermDepositResource setName(String name) {
		this.name = name;
		return this;
	}
	public float getTea() {
		return tea;
	}
	public TermDepositResource setTea(float tea) {
		this.tea = tea;
		return this;
	}
	public Integer getMaxDay() {
		return maxDay;
	}
	public TermDepositResource setMaxDay(Integer maxDay) {
		this.maxDay = maxDay;
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
