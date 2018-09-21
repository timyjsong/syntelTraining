package bank;

public abstract class Account {
	
	private int accId;
	private double accBalance;
	
	public double getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}

	public void storeAccountDetails(int accId, double accBalance) {
		this.accId = accId;
		this.accBalance = accBalance;
	}
	
	public void displayAccountDetails() {
		System.out.println(accId + "   "  + "   " + accBalance);
	}

	
}
