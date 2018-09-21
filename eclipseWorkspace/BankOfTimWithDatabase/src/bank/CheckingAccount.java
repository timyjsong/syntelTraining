package bank;

public class CheckingAccount extends Account{
	
	public CheckingAccount(int accId, double accBalance, String accType, float interestRate) {
		super(accId, accBalance, accType);
		this.interestRate = interestRate;
	}

	private float interestRate;
	private final float dailyWithdrawlLimit = 5000;
	
	public void storeAccountDetails(int accId, double accBalance, float interestRate) {
		super.storeAccountDetails(accId, accBalance);
		this.interestRate = interestRate;
	}
	
	public void displayAccountDetails() {
		super.displayAccountDetails();
		System.out.println("Interest Rate : " + interestRate + "    Daily Withdraw Limit : " + dailyWithdrawlLimit);
	}
	
}
