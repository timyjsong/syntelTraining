package bank;

public class CheckingAccount extends Account{
	
	private float interestRate;
	private final float dailyWithdrawlLimit = 5000;
	
	public void storeAccountDetails(int accId, double accBalance, float interestRate) {
		super.storeAccountDetails(accId, accBalance);
		this.interestRate = interestRate;
	}
	
	public void displayAccountDetails() {
		super.displayAccountDetails();
		System.out.println(interestRate + "   " + dailyWithdrawlLimit);
	}
	
}
