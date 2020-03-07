package com.meritamerica.assignment2;

/**
 * This program creates software for Merit Bank. Allows for the creation of an
 * Account Holder with multiple checking, savings and CD accounts with verification 
 * of balance status of all not exceeding 250000.
 * 
 * 
 * Date: 3/3/2020 Version 1.1
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

	public AccountHolder() {
	}

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
		if (getCheckingBalance() + getSavingsBalance() + checkingAccount.getBalance() > 250000) {
			System.out.println("Unable to create a new account, balance is too high.");
			return;
		}

		int currentArrayLimit = this.checkingAccountIndex;
		CheckingAccount[] temp = new CheckingAccount[currentArrayLimit + 1];

		for (int i = 0; i < currentArrayLimit; i++) {
			temp[i] = this.checkingAccounts[i];
		}

		temp[currentArrayLimit] = checkingAccount;
		this.checkingAccountIndex++;
		this.checkingAccounts = temp;
	}

	public void addSavingsAccount(double openingBalance) {
		double amountRemainingBeforeMaxBalance = -1;
		SavingsAccount newSavingsAccount;

		if (getCheckingBalance() + getSavingsBalance()   > 250000) {
			System.out.println("Unable to create account. Balance too high.");
			return;
		} else if (getCheckingBalance() + getSavingsBalance() + openingBalance > 250000) {
			 amountRemainingBeforeMaxBalance = 250000 - getCheckingBalance() - getSavingsBalance();
			double refundAmountOverBalanceMax = openingBalance - amountRemainingBeforeMaxBalance;
			newSavingsAccount = new SavingsAccount(amountRemainingBeforeMaxBalance);
			System.out.println("Opening Balance exceeds allowable amount. Account created with: " + 
											amountRemainingBeforeMaxBalance + ". \nYour refund is: " + refundAmountOverBalanceMax);
		}else { newSavingsAccount = new SavingsAccount(openingBalance);}
		int currentArrayLimit = this.savingsAccountIndex;
		SavingsAccount[] temp = new SavingsAccount[currentArrayLimit + 1];

		for (int i = 0; i < currentArrayLimit; i++) {
			temp[i] = this.savingsAccounts[i];
		}
		temp[currentArrayLimit] = newSavingsAccount;
		this.savingsAccountIndex++;
		this.savingsAccounts = temp;
		
	}

	public void addSavingsAccount(SavingsAccount savingsAccount) {
		double amountRemainingBeforeMaxBalance = -1;
		if (getCheckingBalance() + getSavingsBalance()   > 250000) {
			System.out.println("Unable to create account. Balance too high.");
			return;
		} else if (getCheckingBalance() + getSavingsBalance() + savingsAccount.getBalance() > 250000) {
			 amountRemainingBeforeMaxBalance = 250000 - getCheckingBalance() + getSavingsBalance();
			
			System.out.println();

		}
		int currentArrayLimit = this.savingsAccountIndex;
		SavingsAccount[] temp = new SavingsAccount[currentArrayLimit + 1];

		for (int i = 0; i < currentArrayLimit; i++) {
			temp[i] = this.savingsAccounts[i];
		}
		if (amountRemainingBeforeMaxBalance != -1) {
			
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
		if (cdAccount == null) {
			System.out.println("Unable to find account.");
		}

		int currentArrayLimit = this.cdAccountIndex;
		CDAccount[] temp = new CDAccount[currentArrayLimit + 1];

		for (int i = 0; i < currentArrayLimit; i++) {
			temp[i] = this.cdAccounts[i];
		}

		temp[currentArrayLimit] = cdAccount;
		this.cdAccountIndex++;
		this.cdAccounts = temp;
	}

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

	public double getCheckingBalance() { // iterate over array of checking accounts to find the total sum of the
											// accounts
		double chkAccSums = 0;

		for (int i = 0; i < this.checkingAccountIndex; i++) {
			chkAccSums += this.checkingAccounts[i].getBalance();
		}
		return chkAccSums;
	}

	public double getSavingsBalance() {
		double savAccSums = 0;

		for (int i = 0; i < this.savingsAccountIndex; i++) {
			savAccSums += this.savingsAccounts[i].getBalance();
		}

		return savAccSums;

	}

	public double getCDAccountsBalance() {
		if (this.cdAccounts[0] == null) {
			return 0;
		}
		double cdAccSums = 0;

		for (int i = 0; i < this.cdAccounts.length; i++) {
			cdAccSums += this.cdAccounts[i].getBalance();
		}
		
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
