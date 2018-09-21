package bank;

import java.util.ArrayList;

public abstract class Account {
	
	private int accId;
	private double accBalance;
	private String accType;
	private ArrayList<Transaction> tranList = new ArrayList<Transaction>();
	
	public ArrayList<Transaction> getTranList() {
		return tranList;
	}

	public void setTranList(ArrayList<Transaction> tranList) {
		this.tranList = tranList;
	}

	public String getAccType() {
		return accType;
	}

	public Account(int accId, double accBalance, String accType) {
		this.accId = accId;
		this.accBalance = accBalance;
		this.accType = accType;
	}
	
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
		System.out.println("Account ID : " + accId + "         Balance : " + accBalance);
	}

	
}
