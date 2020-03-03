package com.meritamerica.assignment2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This program creates software for Merit Bank. Allows for the creation of an
 * Account Holder and for the creation of checking and savings accounts for the
 * account holder.
 * 
 * Date: 2/29/2020 Version 1.0
 */

public class AccountHolder {

	private String firstName;
	private String middleName;
	private String lastName;
	private String ssn;
	private CheckingAccount checking;
	private SavingsAccount savings;
	private CheckingAccount[] checkingAccountArray;
	private SavingsAccount[] savingsAccountArray; 
	private CDAccount[] cdAccountArray;
	private CDAccount cdAccount;
	private int numOfCheckingAccounts = 0;
	private int numOfSavingsAccounts = 0;
	private int numOfCDAccounts = 0;


	public AccountHolder(String firstName, String middleName, String lastName, String ssn) {
		// setting the attributes to the value from the constructor parameters
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.checkingAccountArray = new CheckingAccount[1];
		this.savingsAccountArray = new SavingsAccount[1];
		this.cdAccountArray = new CDAccount[1];
	}

	
	
	public CheckingAccount addCheckingAccount(double openingBalance) {
		CheckingAccount checkingAcc = new CheckingAccount(openingBalance);
		return checkingAcc;
	}

	public CheckingAccount addCheckingAccout(CheckingAccount checkingAccount) {
		numOfCheckingAccounts++;
		CheckingAccount[] newCheckingAccountArray = new CheckingAccount[numOfCheckingAccounts];
		
		if (checkingAccountArray == null) {
			checkingAccountArray = new CheckingAccount[1];
			checkingAccountArray[0] = checkingAccount;
			return checkingAccount;
		}
			
		for (int i = 0; i < checkingAccountArray.length; i++) {
			newCheckingAccountArray[i] = checkingAccountArray[i];
		}
		
		newCheckingAccountArray[newCheckingAccountArray.length - 1 ] = checkingAccount;
		checkingAccountArray = newCheckingAccountArray;
		return checkingAccount;
	}

	public SavingsAccount addSavingsAccount(double openingBalance) {
		SavingsAccount savingsAcc = new SavingsAccount(openingBalance);
		return savingsAcc;	
	}

	public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount) {
		numOfSavingsAccounts++;
		SavingsAccount[] newSavingsAccountArray = new SavingsAccount[numOfSavingsAccounts];
		
		if (savingsAccountArray == null) {
			savingsAccountArray = new SavingsAccount[1];
			savingsAccountArray[0] = savingsAccount;
			return savingsAccount;
		}
		
		for (int i = 0; i < savingsAccountArray.length; i++) {
			newSavingsAccountArray[i] = savingsAccountArray[i];
		}
		
		newSavingsAccountArray[newSavingsAccountArray.length - 1] = savingsAccount;
		savingsAccountArray = newSavingsAccountArray;
		return savingsAccount;

	}

	public CDAccount addCDAccount(CDOffering offering, double openingBalance) {
		if (offering  == null) {
			System.out.println("Unalbe to find CDOffering. ");
			return cdAccount;
		}
			
			
		}

//	public CDAccount addCDAccount(CDAccount cdAccount) {
//		cdAccount.add(cdAccount);
//
//	}
//
//	public int getNumberOfCDAccounts() {
//
//	}
//
//	public double getCDBalance() {
//		return this.cdAccount;
//	}
//
	public double getCombinedBalance() { 
		return checking.getBalance() + savings.getBalance(); ?????
	}
	
	// create getters and setters for retrieving and updating the value of the variables
		public String getFirstName() {
			return firstName;
		}

		public void setFirstname(String name) {
			this.firstName = name;

		}

		public String getMiddleName() {
			return middleName;
		}

		public void setMiddleName(String midName) {
			this.middleName = midName;
		}

		public String getLastName() {
			return this.lastName;
		}

		public void setLastName(String lstName) {
			this.lastName = lstName;
		}

		public String getSSN() {
			return ssn;
		}

		public void setSSN(String SSN) {
			this.ssn = SSN;

		}

		public CheckingAccount getCheckingAccount() {
			return this.checking;
		}
		
		public CheckingAccount[] getCheckingAccounts() {
			return this.checkingAccountArray;
		}
		
		public int getNumberOfCheckingAccounts() {
			return numOfCheckingAccounts;
		}
		
		public SavingsAccount getSavingsAccount() {
			return this.savings;
		}
		
		public SavingsAccount[] getSavingsAccounts() {
			return this.savingsAccountArray;
		}
		
		public int getNumberOfSavingsAccounts() {
			return numOfSavingsAccounts;
			
		}
		
		public double getCheckingBalance() {
			return checking.getBalance();
		}
		
		public double getSavingsBalance() {
			return savings.getBalance() ;
		}


	@Override
	public String toString() {
		return ("Name: " + this.firstName + " " + this.middleName + " " + this.lastName + "\nSSN: " + this.ssn + "\n"
				+ checking.toString() + "\n" + savings.toString() // new changes
		);

	}

}

