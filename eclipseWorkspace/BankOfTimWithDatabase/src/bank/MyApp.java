package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import exceptions.*;

public class MyApp {
	
	static Connection connection;
	static ArrayList<Integer> custIds;
	
	public static void giveConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "syntel123$");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static int custIdIteration = 1025;
	static int accIdIteration = 125;
	
	// Exception check method for customer phone
	public static void checkPhoneException(String inPhone) 
		throws 
			PhoneContainsTextException, 
			PhoneNotTenDigitException 
	{
        for (char c : inPhone.toCharArray()) 
            if (Character.isDigit(c) == false) 
            	throw new PhoneContainsTextException();
		if(inPhone.length() != 10) 
			throw new PhoneNotTenDigitException();
	}
	
	// Exception check method for account type
	public static void checkAccountTypeException(int inType) 
		throws 
			AccountTypeInvalidException 
	{
		if(inType < 0 || inType > 2) 
			throw new AccountTypeInvalidException();
	}
	
	// Exception check method for account type
	public static void checkTransactionTypeException(int tranType) 
		throws 
			TransactionTypeInvalidException 
	{
		if(tranType < 0 || tranType > 3) 
			throw new TransactionTypeInvalidException();
	}
	
	// Exception check method for data type
	public static void checkDataTypeException(int dataType) 
		throws 
			DataTypeInvalidException 
	{
		if(dataType < 0 || dataType > 2) 
			throw new DataTypeInvalidException();
	}
	
	
	private static void checkTransferToSameAccountException(int fromKey, int toKey) throws TransferToSameAccountException {
		if(fromKey == toKey)
			throw new TransferToSameAccountException();
	}
	
	// Done
	public static void deactivateCustomer(){
		int key;
		System.out.println("----------Deactivating Existing Customer----------");
		
		while(true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Please enter the Customer ID which you would like to delete (Enter 0 to exit to menu) : ");
				key = sc.nextInt();
				
				if(key == 0)
					return;
				if(!custIds.contains(key))
					throw new CustomerIdNotExistException();
					
				PreparedStatement pstate1 = connection.prepareStatement("update Customer set isActive = 'no' where custId = ?");
				pstate1.setInt(1, key);
			
				// returns the amount of updates (same method for insertion, deletion, and update) made
				int result1 = pstate1.executeUpdate();
				
				if(result1 > 0)
					System.out.println("-----Customer ID " + key + " has been deactivated-----");
				else
					System.out.println("Account Deactivation Failed");
			}
			catch(CustomerIdNotExistException e) {
				System.out.println("ERROR : " + e.getMessage());
				System.out.println("Please enter an valid Customer ID . . .");
				continue;
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("ERROR : " + e.getMessage());
				System.out.println("Please enter an valid Customer ID . . .");
				continue;
			}
			break;
		}
	}
	
	// Done
	public static void updateCustomer(){
		int key;
		String phone;
		String city;
		
		System.out.println("----------Updating Existing Customer----------");
		
		while(true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Please enter the Customer ID which you would like to update (Enter 0 to exit to menu) : ");
				key = sc.nextInt();
				
				if(key == 0)
					return;
				if(!custIds.contains(key))
					throw new CustomerIdNotExistException();
					
				System.out.println("Please enter the new phone number which you would like to update to : ");
				phone = sc.next();
				
				checkPhoneException(phone);
				
				System.out.println("Please enter the new city which you would like to update to : ");
				city = sc.next();
				
				PreparedStatement pstate1 = connection.prepareStatement("update Customer set custPhone = ?, custCity = ? where custId = ?");
				pstate1.setString(1, phone);
				pstate1.setString(2, city);
				pstate1.setInt(3, key);

				// returns the amount of updates (same method for insertion, deletion, and update) made
				int result1 = pstate1.executeUpdate();
				
				if(result1 > 0)
					System.out.println("-----Customer ID " + key + " has been updated-----");
				else
					System.out.println("Account Update Failed");
			}
			catch(CustomerIdNotExistException e) {
				System.out.println("ERROR : " + e.getMessage());
				System.out.println("Please enter an valid Customer ID . . .");
				continue;
			}
			catch(PhoneNotTenDigitException e) {
				System.out.println("ERROR : " + e.getMessage());
			}
			catch(PhoneContainsTextException e) {
				System.out.println("ERROR : " + e.getMessage());
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("ERROR : " + e.getMessage());
				System.out.println("Please enter an valid Customer ID . . .");
				continue;
			}
			break;
		}
	}

	// Done
	public static void initiateTransaction() throws CustomerIdNotExistException {
		
		//withdraw deposit transfer
		System.out.println("----------Transaction Initiated----------");
		TransactionServices transaction = new TransactionServices();
		
		int tranType;
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Please select the type of transaction . . . ");
				System.out.println("1. Withdraw     2. Deposit     3. Transfer     0. Exit");
				tranType = sc.nextInt();
				if(tranType == 0)
					return;
				checkTransactionTypeException(tranType);
			}
			catch(TransactionTypeInvalidException e) {
				System.out.println("ERROR : " + e.getMessage());
				System.out.println("Please enter a valid Transaction Type . . .");
				continue;
			}
			catch(Exception e) {
				System.out.println("ERROR : " + e.getMessage());
				System.out.println("Please enter a valid Transaction Type . . .");
				continue;
			}
			break;	
		}
		
		int fromId;
		int toId;
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Please enter the customer ID which you would like to complete a transaction from (0 to exit) . . . ");
				fromId = sc.nextInt();
				if(fromId == 0)
					return;
				
				if(!custIds.contains(fromId))
					throw new CustomerIdNotExistException();
			}
			catch(CustomerIdNotExistException e) {
				System.out.println("ERROR : " + e.getMessage());
				System.out.println("Please enter a valid Customer Id . . .");
				continue;
			}
			catch(Exception e) {
				System.out.println("ERROR : " + e.getMessage());
				System.out.println("Please enter a valid Customer Id . . .");
				continue;
			}
			break;	
		}
		
		if(tranType == 3) {
			while (true) {
				try {
					Scanner sc = new Scanner(System.in);
					System.out.println("Please enter the customer ID which you would like to transfer to (0 to exit) . . . ");
					toId = sc.nextInt();
					if(toId == 0)
						return;
					
					if(!custIds.contains(toId))
						throw new CustomerIdNotExistException();
					
					checkTransferToSameAccountException(fromId,toId);
					
					transaction.cashTransfer(connection, fromId, toId);
				}
				catch(CustomerIdNotExistException e) {
					System.out.println("ERROR : " + e.getMessage());
					System.out.println("Please enter a valid Customer Id . . .");
					continue;
				}
				catch(TransferToSameAccountException e) {
					System.out.println("ERROR : " + e.getMessage());
					System.out.println("Please enter a different Customer Id . . .");
					continue;
				}
				catch(Exception e) {
					System.out.println("ERROR : " + e.getMessage());
					System.out.println("Please enter a valid Customer Id . . .");
					continue;
				}
				break;	
			}
		}
				
		if(tranType == 1)
			transaction.cashWithdraw(connection, fromId);
		if(tranType == 2)
			transaction.cashDeposit(connection, fromId);
		System.out.println("----------Transaction Complete----------");
	}
	
	// Done
	public static void addNewCustomer() {
		
		int savingOrChecking;
		//Exception Check for correct account type entry (Neither 1 or 2)
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
			
				System.out.println("Please select the type of account . . . ");
				System.out.println("1. Savings Account     2. Checking Account     0. Exit");
				savingOrChecking = sc.nextInt();
			
				checkAccountTypeException(savingOrChecking);
				
				if(savingOrChecking == 0)
					return;
			}
			catch(AccountTypeInvalidException e) {
				System.out.println("ERROR : " + e.getMessage());
				System.out.println("Please enter a valid Account Type . . .");
				continue;
			}
			catch(Exception e) {
				System.out.println("ERROR : " + e.getMessage());
				System.out.println("Please enter a valid Account Type . . .");
				continue;
			}
			break;	
		}
		String accType;
		if(savingOrChecking == 1)
			accType = "saving";
		else
			accType = "checking";

		System.out.println("---Customer Details Entry---");
		
		String custName;
		while(true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter Customer Name . . .");
				custName = sc.next();
			}
			catch (Exception e) {
				System.out.println("ERROR : " + e.getMessage());
				continue;
			}
			break;
		}
		
		String custPhone;
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter Customer Phone Number . . .");
				custPhone = sc.next();
				
				checkPhoneException(custPhone);
			}
			catch(PhoneNotTenDigitException e) {
				System.out.println("ERROR : " + e.getMessage());
				System.out.println("Please enter a Valid Phone Number . . .");
				continue;
			}
			catch(PhoneContainsTextException e) {
				System.out.println("ERROR : " + e.getMessage());
				System.out.println("Please enter a Valid Phone Number . . .");
				continue;
			}
			catch(Exception e) {
				System.out.println("ERROR : " + e.getMessage());
				System.out.println("Please enter a Valid Phone Number . . .");
				continue;
			}
			break;	
		}
		
		String custCity;
		while(true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter Customer City . . .");
				custCity = sc.next();
			}
			catch(Exception e) {
				System.out.println("ERROR : " + e.getMessage());
				continue;
			}
			break;
		}
		
		try {
			PreparedStatement pstate = connection.prepareStatement("insert into Customer values(?,?,?,?,?)");
			pstate.setInt(1, custIdIteration);
			pstate.setString(2, custName);
			pstate.setString(3, custPhone);
			pstate.setString(4, custCity);
			pstate.setString(5, "yes");
			
			// returns the amount of updates (same method for insertion, deletion, and update) made
			int result = pstate.executeUpdate();
			
			if(result > 0)
				System.out.println("Customer Insertion Successful . . .");
			else
				System.out.println("Customer Insertion Failed . . .");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("---Account Details Entry---");
		
		double accBalance;
		while(true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter Account Balance . . .");
				accBalance = sc.nextDouble();
			}
			catch(Exception e) {
				System.out.println("ERROR : " + e.getMessage());
				System.out.println("Please Enter a valid account balance . . .");
				continue;
			}
			break;
		}

		float intRate;
		while(true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter Account Interest Rate . . .");
				intRate = sc.nextFloat();
			}
			catch(Exception e) {
				System.out.println("ERROR : " + e.getMessage());
				System.out.println("Please Enter a valid interest rate . . .");
				continue;
			}
			break;
		}
		
		try {
			PreparedStatement pstate = connection.prepareStatement("insert into Account values(?,?,?,?,?)");
			pstate.setInt(1, accIdIteration);
			pstate.setInt(2, custIdIteration);
			pstate.setDouble(3, accBalance);
			pstate.setString(4, accType);
			pstate.setDouble(5, intRate);
			
			// returns the amount of updates (same method for insertion, deletion, and update) made
			int result = pstate.executeUpdate();
			
			if(result > 0)
				System.out.println("Account Insertion Successful");
			else
				System.out.println("Account Insertion Failed");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		custIdIteration++;
		accIdIteration++;
	}
	
	// Done
	public static void showAllData() {
		
		int dataType;
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Please select the type of data . . . ");
				System.out.println("1. Customers     2. Transactions     0. Exit");
				dataType = sc.nextInt();
				if(dataType == 0)
					return;
				checkDataTypeException(dataType);
			}
			catch(DataTypeInvalidException e) {
				System.out.println("ERROR : " + e.getMessage());
				System.out.println("Please enter a valid Data Type . . .");
				continue;
			}
			catch(Exception e) {
				System.out.println("ERROR : " + e.getMessage());
				System.out.println("Please enter a valid Data Type . . .");
				continue;
			}
			break;	
		}
		
		if(dataType == 1) {
		try {
			
			ResultSet result = connection.createStatement().executeQuery
					("Select customer.custId, customer.custName, customer.custPhone, customer.custCity, customer.isActive, "
							+ "account.accId, account.balance, account.accType, account.interestRate from customer, account "
							+ "where customer.custId = Account.custId order by custId");
			ResultSetMetaData rsmd = result.getMetaData();
			
			System.out.println("---------------------List of Customers--------------------");

			System.out.print(rsmd.getColumnName(1) + "     ");
			System.out.print(rsmd.getColumnName(2) + "    ");
			System.out.print(rsmd.getColumnName(3) + "     ");
			System.out.print(rsmd.getColumnName(4) + "   ");
			System.out.print(rsmd.getColumnName(5) + "   ");
			System.out.print(rsmd.getColumnName(6) + "   ");
			System.out.print(rsmd.getColumnName(7) + "    ");
			System.out.print(rsmd.getColumnName(8) + "  ");
			System.out.print(rsmd.getColumnName(9));

			System.out.println();
			while(result.next()) {
				if(result.getString(5).equals("yes")) {
					for(int i = result.getString(1).length(); i < 5; i ++) {
						System.out.print(" ");
					}
					System.out.print(result.getString(1) + " | ");
					for(int i = result.getString(2).length(); i < 10; i++) {
						System.out.print(" ");
					}
					System.out.print(result.getString(2) + " | ");
					for(int i = result.getString(3).length(); i < 10; i++) {
						System.out.print(" ");
					}
					System.out.print(result.getString(3) + " | ");
					for(int i = result.getString(4).length(); i < 10; i++) {
						System.out.print(" ");
					}
					System.out.print(result.getString(4) + " | ");
					for(int i = result.getString(5).length(); i < 8; i++) {
						System.out.print(" ");
					}
					System.out.print(result.getString(5) + " | ");
					for(int i = result.getString(6).length(); i < 5; i++) {
						System.out.print(" ");
					}
					System.out.print(result.getString(6) + " | ");
					for(int i = result.getString(7).length(); i < 7; i++) {
						System.out.print(" ");
					}
					System.out.print(result.getString(7) + " | ");
					for(int i = result.getString(8).length(); i < 8; i++) {
						System.out.print(" ");
					}
					System.out.print(result.getString(8) + " | ");
					for(int i = result.getString(9).length(); i < 11; i++) {
						System.out.print(" ");
					}
					System.out.print(result.getString(9) + " | ");
					System.out.println();
				}
			}
			System.out.println("----------------------------------------------------------");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}
		
		if(dataType == 2) {
		try {
			
			ResultSet result = connection.createStatement().executeQuery
					("Select * from Transaction");
			ResultSetMetaData rsmd = result.getMetaData();
			
			System.out.println("---------------------List of Transactions--------------------");
			
			System.out.print(" "+rsmd.getColumnName(1) + "        ");
			System.out.print(rsmd.getColumnName(2) + "     ");
			System.out.print(rsmd.getColumnName(3));

			System.out.println();
			while(result.next()) {
				for(int i = result.getString(1).length(); i < 5; i ++) {
					System.out.print(" ");
				}
				System.out.print(result.getString(1) + " | ");
				for(int i = result.getString(2).length(); i < 10; i++) {
					System.out.print(" ");
				}
				System.out.print("$"+result.getString(2) + " | ");
				for(int i = result.getString(3).length(); i < 10; i++) {
					System.out.print(" ");
				}
				System.out.print(result.getString(3));
				System.out.println();
			}
			System.out.println("----------------------------------------------------------");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}
	}
	
	// To initialize the static ID iterator properly
	public static void setIdIteration() {
		try {
			ResultSet result = connection.createStatement().executeQuery("Select Max(custId) from Customer");
			if(result.next())
				custIdIteration = result.getInt(1) + 1;
			else
				custIdIteration = 1;
			ResultSet result1 = connection.createStatement().executeQuery("Select Max(accId) from Account");
			if(result1.next())
				accIdIteration = result1.getInt(1) + 1;
			else
				accIdIteration = 1;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	// To fill in customer ID data to ArrayList
	public static void fillCustIds() {
		try {
			ResultSet result = connection.createStatement().executeQuery("Select custId from Customer");
			while(result.next()) {
				custIds.add(result.getInt(1));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String s[]) {
		
		// Begin connection to database . . .
		giveConnection();
		setIdIteration();
		
		while (true) {
			try {
				custIds = new ArrayList<Integer>();
				fillCustIds();
				
				System.out.println("--------------------------------WELCOME TO BANK OF TIM--------------------------------");
				System.out.println("\n1. Add New Customer            2. Show All Customers            3. Deactivate Customer ");
				System.out.println("\n4. Update Customer Details     5. Perform Transactions          6. Exit");
				System.out.println("\n------------------------------------------------------------------------------------");
				Scanner sc = new Scanner(System.in);
				int mSelection = sc.nextInt();
	
				switch(mSelection) {
					case 1:
						addNewCustomer();
						continue;
					case 2:
						showAllData();
						continue;
					case 3:
						deactivateCustomer();
						continue;
					case 4:
						updateCustomer();
						continue;
					case 5:
						initiateTransaction();
						continue;
					case 6:
						System.out.println("---- Have a Great Day! ----");
						break;
					default:
						System.out.println("Please enter a valid menu option!!!");
						continue;
				}
			}
			catch(Exception e) {
				System.out.println("ERROR : " + e.getMessage());
				System.out.println("Please enter a digit!");
				continue;
			}
			break;
		}	
	}
}
		