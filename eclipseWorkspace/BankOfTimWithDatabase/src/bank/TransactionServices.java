package bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import exceptions.DepositAmountNegativeException;
import exceptions.DepositGreaterThanLimitException;
import exceptions.WithdrawAmountMoreThanBalanceException;
import exceptions.WithdrawAmountNegativeException;

public class TransactionServices {
	
	public void cashWithdraw(Connection connection, int fromId) {

		System.out.println("----------Withdrawl Process----------");
		
		while(true) {
			try {
				Scanner sc = new Scanner(System.in);
				
				// Retrieve balance from Account table
				PreparedStatement balanceState = connection.prepareStatement("Select account.balance from Account where custId = ?");
				balanceState.setInt(1, fromId);
				ResultSet balanceResult = balanceState.executeQuery();

				float balance;
				if(balanceResult.next())
					balance = balanceResult.getFloat(1);
				else
					return;
				
				System.out.println("Please enter the amount you would like to withdraw : ");
				float amount = sc.nextFloat();
				
				if(amount < 0)
					throw new WithdrawAmountNegativeException();
				
				if(balance < amount)
					throw new WithdrawAmountMoreThanBalanceException();
								
				// Retrieve accId from Account table
				PreparedStatement accIdState = connection.prepareStatement("Select account.accId from Account where custId = ?");
				accIdState.setInt(1, fromId);
				ResultSet accIdResult = accIdState.executeQuery();

				int accId;
				if(accIdResult.next())
					accId = accIdResult.getInt(1);
				else
					return;

				// Update balance from Account table
				PreparedStatement updateBalanceState = connection.prepareStatement("update account set balance = ? where custId = ?");
				updateBalanceState.setFloat(1, balance - amount);
				updateBalanceState.setInt(2, fromId);
				updateBalanceState.executeUpdate();
				
				// Insert data into Transaction table
				PreparedStatement insertTranState = connection.prepareStatement("insert into Transaction values(?,?,?)");
				insertTranState.setInt(1, accId);
				insertTranState.setFloat(2, amount);
				insertTranState.setString(3, "Withdraw");
				insertTranState.executeUpdate();
				
				System.out.println("-----$" +amount+ " has been withdrawn from Customer ID " + fromId + "-----");
			}
			catch(WithdrawAmountMoreThanBalanceException e) {
				System.out.println("ERROR : " + e.getMessage());
			}
			catch(WithdrawAmountNegativeException e) {
				System.out.println("ERROR : " + e.getMessage());
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("ERROR : " + e.getMessage());
				continue;
			}
			break;
		}
		
	}

	public void cashDeposit(Connection connection, int fromId) {
		
		System.out.println("----------Deposit Process----------");
		
		while(true) {
			try {
				Scanner sc = new Scanner(System.in);
				
				// Retrieve balance from Account table
				PreparedStatement balanceState = connection.prepareStatement("Select account.balance from Account where custId = ?");
				balanceState.setInt(1, fromId);
				ResultSet balanceResult = balanceState.executeQuery();

				float balance;
				if(balanceResult.next())
					balance = balanceResult.getFloat(1);
				else
					return;
				
				System.out.println("Please enter the amount you would like to deposit : ");
				float amount = sc.nextFloat();
				
				if(amount < 0)
					throw new DepositAmountNegativeException();
				
				if(5000 < amount)
					throw new DepositGreaterThanLimitException();
								
				// Retrieve accId from Account table
				PreparedStatement accIdState = connection.prepareStatement("Select account.accId from Account where custId = ?");
				accIdState.setInt(1, fromId);
				ResultSet accIdResult = accIdState.executeQuery();

				int accId;
				if(accIdResult.next())
					accId = accIdResult.getInt(1);
				else
					return;

				// Update balance from Account table
				PreparedStatement updateBalanceState = connection.prepareStatement("update account set balance = ? where custId = ?");
				updateBalanceState.setFloat(1, balance + amount);
				updateBalanceState.setInt(2, fromId);
				updateBalanceState.executeUpdate();
				
				// Insert data into Transaction table
				PreparedStatement insertTranState = connection.prepareStatement("insert into Transaction values(?,?,?)");
				insertTranState.setInt(1, accId);
				insertTranState.setFloat(2, amount);
				insertTranState.setString(3, "Deposit");
				insertTranState.executeUpdate();
				
				System.out.println("-----$" +amount+ " has been deposited to Customer ID " + fromId + "-----");
			}
			catch(DepositGreaterThanLimitException e) {
				System.out.println("ERROR : " + e.getMessage());
			}
			catch(DepositAmountNegativeException e) {
				System.out.println("ERROR : " + e.getMessage());
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("ERROR : " + e.getMessage());
				continue;
			}
			break;
		}
	}

	public void cashTransfer(Connection connection, int fromId, int toId) {
		System.out.println("----------Transfer Process----------");
		while(true) {
			try {
				Scanner sc = new Scanner(System.in);
				
				// Retrieve balance from Account table
				PreparedStatement balanceFrom = connection.prepareStatement("Select account.balance from Account where custId = ?");
				balanceFrom.setInt(1, fromId);
				ResultSet fromResult = balanceFrom.executeQuery();

				float balanceF;
				if(fromResult.next())
					balanceF = fromResult.getFloat(1);
				else
					return;
				
				// Retrieve balance from Account table
				PreparedStatement balanceTo = connection.prepareStatement("Select account.balance from Account where custId = ?");
				balanceTo.setInt(1, toId);
				ResultSet toResult = balanceTo.executeQuery();

				float balanceT;
				if(toResult.next())
					balanceT = toResult.getFloat(1);
				else
					return;
				
				// Amount
				System.out.println("Please enter the amount you would like to transfer to customer "+toId+" : ");
				float amount = sc.nextFloat();
				
				if(amount < 0)
					throw new WithdrawAmountNegativeException();
				
				if(5000 < amount)
					throw new DepositGreaterThanLimitException();
								
				if(balanceF < amount)
					throw new WithdrawAmountMoreThanBalanceException();
				
				// Retrieve accId from Account table
				PreparedStatement accIdFrom = connection.prepareStatement("Select account.accId from Account where custId = ?");
				accIdFrom.setInt(1, fromId);
				ResultSet accIdResultF = accIdFrom.executeQuery();

				int accIdF;
				if(accIdResultF.next())
					accIdF = accIdResultF.getInt(1);
				else
					return;
				
				// Retrieve accId from Account table
				PreparedStatement accIdTo = connection.prepareStatement("Select account.accId from Account where custId = ?");
				accIdTo.setInt(1, toId);
				ResultSet accIdResultT = accIdTo.executeQuery();

				int accIdT;
				if(accIdResultT.next())
					accIdT = accIdResultT.getInt(1);
				else
					return;
				
				// Withdraw balance from Account table
				PreparedStatement updateBalanceStateFrom = connection.prepareStatement("update account set balance = ? where custId = ?");
				updateBalanceStateFrom.setFloat(1, balanceF - amount);
				updateBalanceStateFrom.setInt(2, fromId);
				updateBalanceStateFrom.executeUpdate();

				// Deposit balance to Account table
				PreparedStatement updateBalanceStateTo = connection.prepareStatement("update account set balance = ? where custId = ?");
				updateBalanceStateTo.setFloat(1, balanceT + amount);
				updateBalanceStateTo.setInt(2, toId);
				updateBalanceStateTo.executeUpdate();
				
				// Insert data into Transaction table
				PreparedStatement insertTranStateF = connection.prepareStatement("insert into Transaction values(?,?,?)");
				insertTranStateF.setInt(1, accIdF);
				insertTranStateF.setFloat(2, amount);
				insertTranStateF.setString(3, "Withdraw");
				insertTranStateF.executeUpdate();
				
				// Insert data into Transaction table
				PreparedStatement insertTranStateT = connection.prepareStatement("insert into Transaction values(?,?,?)");
				insertTranStateT.setInt(1, accIdT);
				insertTranStateT.setFloat(2, amount);
				insertTranStateT.setString(3, "Deposit");
				insertTranStateT.executeUpdate();
				
				System.out.println("-----$" +amount+ " has been transfered to Customer ID " + fromId + " from Customer ID " + toId + "-----");
			}
			catch(DepositGreaterThanLimitException e) {
				System.out.println("ERROR : " + e.getMessage());
			}
			catch(WithdrawAmountMoreThanBalanceException e) {
				System.out.println("ERROR : " + e.getMessage());
			}
			catch(WithdrawAmountNegativeException e) {
				System.out.println("ERROR : " + e.getMessage());
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("ERROR : " + e.getMessage());
				continue;
			}
			break;
		}
		
	}
		
	
}
