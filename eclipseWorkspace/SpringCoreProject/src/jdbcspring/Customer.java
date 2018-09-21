package jdbcspring;

public class Customer {

	int custId;
	String custName;
	String custPhone;
	String custCity;

	
	public void display() {
		System.out.println("Customer [custId=" + custId + ", custName=" + custName + ", custPhone=" + custPhone + ", custCity="
				+ custCity + ", isActive=" + isActive + "]");
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
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
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	String isActive;
	
}
