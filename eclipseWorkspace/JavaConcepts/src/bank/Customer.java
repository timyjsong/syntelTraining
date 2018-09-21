package bank;

public class Customer {
	
	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	private int custId;
	private String custName;
	private String custPhone;
	private String custCity;
	
	private Account custAccount;
	
	public Account getCustAccount() {
		return custAccount;
	}

	public void setCustAccount(Account custAccount) {
		this.custAccount = custAccount;
	}

	
	public void storeCustomerDetails(int custId, String custName, String custPhone, String custCity, Account custAccount) {
		
		this.custId = custId;
		this.custName = custName;
		this.custPhone = custPhone;
		this.custCity = custCity;
		this.custAccount = custAccount;
		
	}
	
	public void displayCustomerDetails() {
		System.out.println("Customer ID: " + custId +
				"\nCustomer Name: " + custName +
				"\nCustomer Phone: " + custPhone +
				"\nCustomer City: " + custCity +
				"\nCustomer Account: "); 
		custAccount.displayAccountDetails();
	}
	
	
	
}
