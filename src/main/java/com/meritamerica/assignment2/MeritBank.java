package com.meritamerica.assignment2;

import java.util.Arrays;
import java.util.Random;

public class MeritBank {
	private static AccountHolder[] accountHolders; //scope/type/name //static operates before the object layer
	private static int accountHolderIndex = 0;
	private static CDOffering[] cdOfferings;
	private static int cdOfferingIndex;
	private static long nextAccountNumber = (long)(Math.random() * Math.pow(10, 7));
	private double bestOffering;
	
	public MeritBank() {
	
		
	}
	
	public static void addAccountHolder(AccountHolder accountHolder) {
		accountHolders[accountHolderIndex] = accountHolder;
		accountHolderIndex++;
		
	}
	
	public static AccountHolder[] getAccountHolders() { //returns the array of accountHolders
		return  accountHolders;	
	}
	
	public static CDOffering[] getCDOfferings() {
		return cdOfferings;
	}
	
	public static CDOffering getBestCDOffering(double depositAmount) {
		double bestOffering = 0;
		int bestIndex = 0;
		
		if(cdOfferings == null) {
			return null;
		}
		
		for (int i = 0; i < cdOfferings.length; i++) {
			if(cdOfferings[i].getInterestRate() > bestIndex) {
				bestOffering = cdOfferings[i].getInterestRate();
				bestIndex = i;
			}
		}
		
		return cdOfferings[bestIndex];		
	}
	
	public static CDOffering getSecondBestCDOffering(double depositAmount) {
		double secondBestOffering = 0;
		int secondBestIndex = -1;
		CDOffering bestOffering = getBestCDOffering(depositAmount);
		
		if (cdOfferings == null) {
			return null;
		}
		
		for (int i = 0; i < cdOfferings.length; i ++) {
			if(cdOfferings[i].getInterestRate() > secondBestOffering && !cdOfferings[i] .equals(bestOffering)) {
				secondBestOffering = cdOfferings[i].getInterestRate();
				secondBestIndex = i;
			}
		}
		
		return cdOfferings[secondBestIndex];
		
	}
	
	public static void clearCDOfferings() {
		cdOfferings = null; //to clear CDOfferings
		
	}
	
	public static long getNextAccountNumber() {
		nextAccountNumber++;
		return nextAccountNumber;
		
	}
	
	public static double totalBalances() {
		double sum = 0;
		
		for(AccountHolder acctHolder : accountHolders) {
			if(acctHolder == null) {
				break;
			}
			
			
			for(CheckingAccount chkAccountBalance : acctHolder.getCheckingAccounts()) {
				sum += chkAccountBalance.getBalance();
			}
			
			for(SavingsAccount savAccountBalance : acctHolder.getSavingsAccounts()) {
				sum += savAccountBalance.getBalance();
			}
			
			for(CDAccount account : acctHolder.getCDAccounts()) {
				sum += account.getBalance();
			}
			
		}
	
		return sum;
}
	
	public static double futureValue(double presentValue, double interestRate, int term) {
		double futureValue = presentValue * (Math.pow(1 + presentValue, term));
		return futureValue;
		
	}
}
