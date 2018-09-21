package bank;

public class SavingAccount extends Account{
	
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
