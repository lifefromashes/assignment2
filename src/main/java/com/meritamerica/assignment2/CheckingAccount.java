package com.meritamerica.assignment2;

	import java.text.DecimalFormat;


	public class CheckingAccount  {
		
		private double checkingBalanceThreeYears;
		private double currentBalance;
		private  double interestRate = .0001;
		private long accountNumber;

		//Constructor to initialize the objects
		public CheckingAccount( double openingBalance) {
			this.currentBalance = openingBalance;
			this.accountNumber = MeritBank.getNextAccountNumber();
		}
		
		public long getAccountNumber() {
			return this.accountNumber;
		}
		
		public double getBalance() {
			return this.currentBalance;
		}
		
		
		public double getInterestRate() {
			return interestRate;
		}
		
		public void setInterestRate(double interestRate, int years) {
			this.interestRate = interestRate;
			
		}
		//Method and conditions for withdrawing money 
		public boolean withdraw(double amount) {
			if (this.currentBalance <= 0) {
				System.out.println("Unable to make withdrawal. Not enough funds.");
				return false;
			}
			if (amount > this.currentBalance) {
				System.out.println("Unable to make withdrawal. Not enough funds.");
				return false;
				
			} 
			 if (amount < 0) {
				System.out.println("Unable to make withdrawal.");
				return false;
			}
			else {
				this.currentBalance =  this.currentBalance - amount;
				System.out.println("Withdrawing: " + amount + " from checking. Your balance is now: " + currentBalance);
				
			}
			return true;
			
			
		}
		//methods and conditions for depositing money
		public boolean deposit(double amount) {
			if (amount <= 0) {
				System.out.println("You have to deposit a positive amount.");
				return false;
			} 
			else {
				this.currentBalance = this.currentBalance +  amount;
				System.out.println("Depositing: " + amount + " to checking. Your balance is now: " + this.currentBalance);
			}
				return true;
		}
		
		
		//method to calculate future value of current balance in the checking account
		public double futureValue(int years) {
			//Formula: FV = PV(1 + interestRate) ^ years;
			checkingBalanceThreeYears = this.currentBalance * Math.pow((this.interestRate + 1), years);
			return checkingBalanceThreeYears;

			
		}
		//method to return the string representation of our object
		@Override
		public String toString() {
			DecimalFormat df = new DecimalFormat("0.00"); //format the currency
			DecimalFormat iformat = new DecimalFormat(".0000"); //format the interest rate
			return (
						"Checking Account Balance: " + df.format(this.currentBalance) + 
					   "\nChecking Account Interest Rate: " + iformat.format(this.interestRate) +
						"\nChecking Account Balance in 3 Years: " + df.format(futureValue(3))
					   );
		}
	}

		
		
		

