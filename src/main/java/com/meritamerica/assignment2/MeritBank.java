package com.meritamerica.assignment2;

import java.util.Arrays;
import java.util.Random;

public class MeritBank {
	private static AccountHolder[] accountHolders; //scope/type/name //static operates before the object layer
	private static int accountHolderIndex = 0;
	private static CDOffering[] cdOfferings;
	private static int cdOfferingIndex;
	private static long nextAccountNumber;
	
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
		
		
	}
	
	public static CDOffering getSecondBestCDOffering(double depositAmount) {
		
	}
	
	public static void clearCDOfferings() {
		cdOfferings = null; //to clear CDOfferings
		
	}
	
	public static long getNextAccountNumber() {
		nextAccountNumber++;
		return nextAccountNumber;
		
	}
	
	public static double totalBalances() {
		double sum;
		
		for(AccountHolder acctHolder : accountHolders) {
			if(acctHolder == null) {
				break;
			
			
			for(CheckingAccount chkAccountBalance : acctHolder.getCheckingAccounts()) {
				sum += chkAccountBalance.getBalance();
			}
			
			for(SavingsAccount savAccountBalance : acctHolder.getSavingsAccount()) {
				sum += savAccountBalance.getBalance();
			}
			
			for(CDAccount cdAccount : acctHolder.getCDAccounts()) {
			sum+= cdAccount.getBalance();
			}
			
		}
	}
		return sum;
}
	
	public static double futureValue(double presentValue, double interestRate, int term) {
		double futureValue = presentValue * (Math.pow(1 + presentValue, term));
		return futureValue;
		
	}
}
