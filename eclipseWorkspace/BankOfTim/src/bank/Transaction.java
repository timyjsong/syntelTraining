package bank;

public class Transaction {

	private double amount;
	private String tranType;
	
	public Transaction(double amount, String tranType) {
		super();
		this.amount = amount;
		this.tranType = tranType;
	}
	
	public void displayTransactionDetails() {
		System.out.println(tranType + " : " + amount);
	}
	
}
