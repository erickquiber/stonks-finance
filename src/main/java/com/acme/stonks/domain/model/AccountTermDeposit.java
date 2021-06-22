package com.acme.stonks.domain.model;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Account_term_deposits")
public class AccountTermDeposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private double capital;

    @NotNull
    private double tea;

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
	@Column(name = "monthly_payment")
	private boolean monthlyPayment;

    @NotNull
    @Column(name = "withdrawal_interest")
    private boolean withdrawalInterest;

    @OneToMany(mappedBy = "accountTermDeposit")
    private List<Transaction> transactions;

    @ManyToOne(optional = false)
    @JoinColumn(name = "bank_id", nullable = false)
    private Bank bank;
    
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "board_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Board board;
    
    	// Prueba
	@Transient
	private double interest;

	@PostLoad
	public void CalculateInterest() {
		Date currentDate = java.util.Calendar.getInstance().getTime();
		long diff = currentDate.getTime() - getDateStart().getTime();
		double tempInterest = 0.0d;
		TimeUnit time;
		time = TimeUnit.DAYS;
		double days = time.convert(diff, TimeUnit.MILLISECONDS);
		double tep;
		if (isMonthlyPayment()) {
			double months;
			double monthlyInterest;
			months = (double) (days / 30);
			months = months - months % 1;
			tep = Math.pow(1 + (double) getTea(), ((double) 30 / 360)) - 1;
			monthlyInterest = tep * getCapital();
			tempInterest = monthlyInterest * months;
		} else {
			tep = Math.pow(1 + (double) getTea(), (days / 360)) - 1;
			tempInterest = tep * getCapital();
		}
		setInterest(tempInterest);
	}

    public Long getId() {
        return id;
    }

    public AccountTermDeposit setId(Long id) {
        this.id = id;
        return this;
    }

    public double getCapital() {
        return capital;
    }

    public AccountTermDeposit setCapital(double capital) {
        this.capital = capital;
        return this;
    }

    public double getTea() {
        return tea;
    }

    public AccountTermDeposit setTea(double tea) {
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
	public Bank getBank() {
		return bank;
	}

	public AccountTermDeposit setBank(Bank bank) {
		this.bank = bank;
		return this;
	}

	public Board getBoard() {
		return board;
	}

	public AccountTermDeposit setBoard(Board board) {
		this.board = board;
		return this;
	}

    public boolean isMonthlyPayment() {
        return monthlyPayment;
    }

    public AccountTermDeposit setMonthlyPayment(boolean monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
        return this;
    }

    public double getInterest() {
        return interest;
    }

    public AccountTermDeposit setInterest(double interest) {
        this.interest = interest;
        return this;
    }
    
}
