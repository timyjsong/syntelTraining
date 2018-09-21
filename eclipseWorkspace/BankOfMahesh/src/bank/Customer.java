package bank;

public class Customer {
	
	public Customer(int custId, String custName, String custPhone, String custCity, Account custAccount) {
		this.custId = custId;
		this.custName = custName;
		this.custPhone = custPhone;
		this.custCity = custCity;
		this.custAccount = custAccount;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public String getCustCity() {
		return custCity;
	}

	public void setCustCity(String custCity) {
		this.custCity = custCity;
	}

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
		System.out.println("Customer ID: " + custId + "               Customer Name: " + custName +
				"\nCustomer Phone: " + custPhone + "      Customer City: " + custCity +
				"\nCUSTOMER ACCOUNT DETAILS: "); 
		custAccount.displayAccountDetails();
	}
	
	
	
}
