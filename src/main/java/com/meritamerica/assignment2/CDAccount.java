package com.meritamerica.assignment2;

import java.util.Date;

public class CDAccount {
	private double balance;
	private double interestRate;
	private int term;
	private long accountNumber;
	private Date startDate;

	public CDAccount(double balance, double interestRate, int term) {
		this.balance = balance;
		this.interestRate = interestRate;
		this.term = term;
	}
	public CDAccount(CDOffering offering, double balance) {
		this.balance = balance;
		this.interestRate = offering.getInterestRate();
		this.term = offering.getTerm();

	}

//getters
	public double getBalance() {
		return this.balance;
	}

	public double getInterestRate() {
		return this.interestRate;
	}

	public int getTerm() {
		return this.term;

	}
	
	public long getAccountNumber() {
		return this.accountNumber;
	}

	public Date getStartDate() {
		return this.startDate;

	}
	
	public double futureValue() {
		double futureValue = (Math.pow(1 + this.interestRate, this.term));
		futureValue *= this.balance;
		return futureValue;
		
	}

}
