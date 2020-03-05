package com.meritamerica.assignment2;

import java.util.Date;

public class CDAccount {
	private double currentBalance;
	private double interestRate;
	private int term;
	private long accountNumber;
	private Date startDate;
	private double presentValue;

	public CDAccount(CDOffering offering, double openingBalance) {
		this.currentBalance = openingBalance;
		this.interestRate = interestRate;
		this.term = term;
		this.presentValue = presentValue;

	}
	
	public CDAccount(CDOffering offering, double openingBalance, int term) {
		this.currentBalance = openingBalance;
		this.interestRate = offering.getInterestRate();
		this.term = offering.getTerm();
	}

	public double getBalance() {
		return this.currentBalance;
	}

	public double getInterestRate() {
		return this.interestRate;
	}

	public int getTerm() {
		return this.term;

	}

	public Date getStartDate() {
		return this.startDate;

	}
	
	public long getAccountNumber() {
		return this.accountNumber;
	}
	
	public double futureValue() {
		double futureValue = (Math.pow(1 + this.interestRate, this.term));
		futureValue *= currentBalance;
		return futureValue;
		
	}

}
