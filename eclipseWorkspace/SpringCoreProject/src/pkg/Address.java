package pkg;

public class Address {

	private String street;
	private String state;
	private String pinCode;
	
	public Address() {
		
	}
	public Address(String street, String state, String pinCode) {
		this.street = street;
		this.state = state;
		this.pinCode = pinCode;
	}
	
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String i) {
		this.pinCode = i;
	}
	public void displayAddress() {
		System.out.println(street + " " + state + " " + pinCode);
	}
}
