package com.meritamerica.assignment2;

import java.util.Date;

public class CDAccount {
	private double currentBalance;
	private double interestRate;
	private int term;
	private long accountNumber;
	private Date startDate;

	public CDAccount(CDOffering offering, double openingBalance) {
		this.currentBalance = openingBalance;
		this.interestRate = offering.getInterestRate();
		this.term = term;

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
		return startDate;

	}
	
	public long getAccountNumber() {
		return accountNumber;
	}
	
	public double futureValue() {
		return MeritBank.futureValue(presentValue, interestRate, term);
		
		
	}

}
