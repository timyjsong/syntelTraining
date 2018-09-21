package aop;

import java.util.List;

//entity class
//POJO class -- Plain Old Java Object
public class Employee {
	
	private Address address;
	private int eid;
	private String ename;
	private String ecity;
	private double esalary;
	private List<String> hobbies;
	
	class PassportDetail{
		
	}
	
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEcity() {
		return ecity;
	}
	public void setEcity(String ecity) {
		this.ecity = ecity;
	}
	public double getEsalary() {
		return esalary;
	}
	public void setEsalary(double esalary) {
		this.esalary = esalary;
	}
	public void displayEmployee() {
		System.out.println(eid + " " + ename + " " + ecity + " " + esalary);
		address.displayAddress();
		for(String i : hobbies) {
			System.out.println(i);
		}
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	
	
	
}
