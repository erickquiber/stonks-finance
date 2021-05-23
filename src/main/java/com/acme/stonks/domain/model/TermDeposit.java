package com.acme.stonks.domain.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="termdeposit")
public class TermDeposit {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotNull
	private String name;
	
	
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bank_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
	private Bank bank;
    

	@NotNull
	private float tea;

	@NotNull
	private Integer maxDay;
	
	@NotNull
	private Integer minDay;

	@NotNull
	private float minAmount;
	
	public float getMinAmount() {
		return minAmount;
	}

	public TermDeposit setMinAmount(float minAmount) {
		this.minAmount = minAmount;
		return this;
	}

	public Long getId() {
		return id;
	}

	public TermDeposit setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public TermDeposit setName(String name) {
		this.name = name;
		return this;
	}

	public Bank getBank() {
		return bank;
	}

	public TermDeposit setBank(Bank bank) {
		this.bank = bank;
		return this;
	}

	public float getTea() {
		return tea;
	}

	public TermDeposit setTea(float tea) {
		this.tea = tea;
		return this;
	}

	public Integer getMaxDay() {
		return maxDay;
	}

	public TermDeposit setMaxDay(Integer maxDay) {
		this.maxDay = maxDay;
		return this;
	}

	public Integer getMinDay() {
		return minDay;
	}

	public TermDeposit setMinDay(Integer minDay) {
		this.minDay = minDay;
		return this;
	}
	
	
}
