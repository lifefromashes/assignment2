package com.meritamerica.assignment2;

public class MeritAmericaBankApp {
	public static void main(String[] args) {
		System.out.println("Hello Merit America!");
		
		CDOffering[] offering = new CDOffering[5];
		offering[0] = new CDOffering(1, .018);
		offering[1] = new CDOffering(2, .019);
		offering[2] = new CDOffering(3, .020);
		offering[3] = new CDOffering(5, .025);
		offering[4] = new CDOffering(10, .022);
		MeritBank.setCDOfferings(offering);
		
		AccountHolder ah1 = new AccountHolder("Jim", "T", "Halpert", "5874512397");
		ah1.addCheckingAccount(1000);
		ah1.addSavingsAccount(10000);
		ah1.addCheckingAccount(5000);
		ah1.addSavingsAccount(50000);
		ah1.addCheckingAccount(50000);
		ah1.addSavingsAccount(500000);
		ah1.addCheckingAccount(5000);
		ah1.addSavingsAccount(50000);
		//verify last two not created
		
		ah1.addCDAccount((MeritBank.getBestCDOffering(100)), 100);
		MeritBank.addAccountHolder(ah1);
		
		String s = MeritBank.getAccountHolders()[0].toString();
		System.out.println(s);
		
		
		AccountHolder ah2 = new AccountHolder("Michael", "Gary", "Scott", "9841203600");
		ah2.addCDAccount(MeritBank.getSecondBestCDOffering(100), 100);
		MeritBank.addAccountHolder(ah2);
		
		MeritBank.clearCDOfferings();
		
		AccountHolder ah3 = new AccountHolder("Dwight", "K", "Schrute", "1248520199");
		ah3.addCDAccount(MeritBank.getSecondBestCDOffering(100), 100); //will be rejected
		MeritBank.addAccountHolder(ah3);
		
		double total = ah1.getCombinedBalance();
		System.out.println(total);
		
		
		
		
		
		
		
	}
}