package bank;

public class SavingAccount extends Account{
	
	public SavingAccount(int accId, double accBalance, String accType, float interestRate) {
		super(accId, accBalance, accType);
		this.interestRate = interestRate;
	}

	private float interestRate;
	
	public void storeAccountDetails(int accId, double accBalance, float interestRate) {
		super.storeAccountDetails(accId, accBalance);
		this.interestRate = interestRate;
	}
	
	public void displayAccountDetails() {
		super.displayAccountDetails();
		System.out.println(interestRate);
	}
	
}
