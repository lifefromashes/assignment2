package com.meritamerica.assignment2;

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
	
	private CheckingAccount[] checkingAccounts;
	private int checkingAccountIndex;
	private SavingsAccount[] savingsAccounts;
	private int savingsAccountIndex;
	private CDAccount[] cdAccounts;
	private int cdAccountIndex;
	
	public AccountHolder() {}

	public AccountHolder(String firstName, String middleName, String lastName, String ssn) {
		// setting the attributes to the value from the constructor parameters
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.ssn = ssn;
		
		this.checkingAccountIndex = 0;
		this.checkingAccounts = new CheckingAccount[1];
		this.savingsAccountIndex = 0;
		this.savingsAccounts = new SavingsAccount[1];
		this.cdAccountIndex = 0;
		this.cdAccounts = new CDAccount[1];
	}
	
	public void addCheckingAccount(double openingBalance) {
		CheckingAccount tempAccount = new CheckingAccount(openingBalance);
		addCheckingAccount(tempAccount);
	}
	
	public void addCheckingAccount(CheckingAccount checkingAccount) {
		if(getCheckingBalance() + getSavingsBalance() + checkingAccount.getBalance() >= 250000) {
			System.out.println("Unable to create a new account, balance is too high.");
			return;
		}
		
		int currentArrayLimit = this.checkingAccountIndex;
		CheckingAccount[] temp = new CheckingAccount[currentArrayLimit + 1];
		
		for(int i=0; i<currentArrayLimit; i++) {
			temp[i] = this.checkingAccounts[i];
		}
		
		temp[currentArrayLimit] = checkingAccount;
		this.checkingAccountIndex ++;
		this.checkingAccounts = temp;
	}
	
	public void addSavingsAccount(double openingBalance) {
		SavingsAccount tempAccount = new SavingsAccount(openingBalance);
		addSavingsAccount(tempAccount);
	}
	
	public void addSavingsAccount(SavingsAccount savingsAccount) {
		if(getCheckingBalance() + getSavingsBalance() + savingsAccount.getBalance() >= 250000 ) {
			System.out.println("Unable to create account. Balance too high.");
			return;
			
		}
		 int currentArrayLimit = this.savingsAccountIndex;
		 SavingsAccount[] temp = new SavingsAccount[currentArrayLimit + 1];
		 
		 for(int i = 0; i < currentArrayLimit; i++) {
			 temp[i] = this.savingsAccounts[i];
		 }
		 
		 temp[currentArrayLimit] = savingsAccount;
		 this.savingsAccountIndex++;
		 this.savingsAccounts = temp;
	}

	public void addCDAccount(CDOffering offering, double openingBalance) {
		CDAccount tempAccount = new CDAccount(offering, openingBalance);
		addCDAccount(tempAccount);
		
	}
		
		public void addCDAccount(CDAccount cdAccount) {
			if(cdAccount == null) {
				System.out.println("Unable to find account.");
			}
		
		int currentArrayLimit = this.cdAccountIndex;
		CDAccount [] temp = new CDAccount[currentArrayLimit + 1];
		
		for (int i = 0; i < currentArrayLimit; i++) {
			temp[i] = this.cdAccounts[i];
		}
		
		temp[currentArrayLimit] = cdAccount;
		this.cdAccountIndex++;
		this.cdAccounts = temp;
	}

//	public CDAccount addCDAccount(CDAccount cdAccount) {
//		numOfCDAccounts++;
//		CDAccount[] newCDAccountArray = new CDAccount[numOfCDAccounts];
//
//		if (cdAccount == null) {
//			newCDAccountArray = new CDAccount[1];
//			newCDAccountArray[0] = cdAccount;
//			return cdAccount;
//		}
//
//		for (int i = 0; i < cdAccountArray.length; i++) {
//			newCDAccountArray[i] = cdAccountArray[i];
//
//		}
//
//		newCDAccountArray[newCDAccountArray.length - 1] = cdAccount;
//		cdAccountArray = newCDAccountArray;
//		return cdAccount;
//	}
	
	// create getters and setters for retrieving and updating the value of the
	// variables
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

	public CheckingAccount[] getCheckingAccounts() {
		return this.checkingAccounts;
	}
	
	public SavingsAccount[] getSavingsAccounts() {
		return this.savingsAccounts;
	}
	
	public CDAccount[] getCDAccounts() {
		return this.cdAccounts;
	}

	public int getNumberOfCheckingAccounts() {
		return this.checkingAccountIndex;
	}
	
	public int getNumberOfSavingsAccounts() {
		return this.savingsAccountIndex;

	}
	
	public int getNumberOfCDAccounts() {
		return this.cdAccountIndex;

	}
	
	public double getCheckingBalance() { // iterate over array of checking accounts to find the total sum of the accounts
		double chkAccSums = 0;
		
		for (int i = 0; i < this.checkingAccountIndex; i++) {
			chkAccSums += this.checkingAccounts[i].getBalance();
		}
		return chkAccSums;
	}
	
	public double getSavingsBalance() {
		double savAccSums = 0;
		
		for (int i = 0; i  < this.savingsAccountIndex; i++) {
			savAccSums += this.savingsAccounts[i].getBalance();
		}
		
		return savAccSums;
				
	}
	
	public double getCDAccountsBalance() {
		if(this.cdAccounts[0] == null) {
			return 0;
		}
		double cdAccSums = 0;
		
		for (int i = 0; i < this.cdAccounts.length; i++) {
			cdAccSums += this.cdAccounts[i].getBalance();
		}
		
//		for(int i = 0; i < this.cdAccounts[i].getBalance(); i++) {
//			cdAccSums += this.cdAccounts[i].getBalance();
//			
//		}
		return cdAccSums;
		
	}
	
	public double getCDBalance() {
	return getCDAccountsBalance();
}
	
	public double getCombinedBalance() {
		double accountSums = getCheckingBalance();
		accountSums += getCDAccountsBalance();
		accountSums += getSavingsBalance();
		return accountSums;
	}

	@Override
	public String toString() {
		return ("Name: " + this.firstName + " " + this.middleName + " " + this.lastName + "\nSSN: " + this.ssn + "\n"
				+ checkingAccounts[0].toString() + "\n" + savingsAccounts[0].toString());

	}
}
