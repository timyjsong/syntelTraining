package bank;

import java.util.*;
import exceptions.*;

public class MyApp {
	
	static int custIdIteration = 1025;
	static int accIdIteration = 125;
	
	// Method to create sample customer data for testing
	public static Map<Integer,Customer> makeSampleCustMap(){
		Map<Integer,Customer> custMap = new HashMap<Integer,Customer>();
		
		Customer s01 = new Customer(1001,"Tim","9302933939","Boston",new SavingAccount(101, 5000, "saving", 4));
		Customer s02 = new Customer(1002,"John","9302933959","Boston",new SavingAccount(102, 4000, "saving", 3));
		Customer s03 = new Customer(1003,"Mike","9302933639","Boston",new SavingAccount(103, 7000, "saving", 4));
		Customer s04 = new Customer(1004,"Timoty","9302933339","Boston",new SavingAccount(104, 2000, "saving", 2));
		Customer s05 = new Customer(1005,"Tim2","9302936439","Boston",new SavingAccount(105, 5500, "saving", 4));
		Customer s06 = new Customer(1006,"Tim3","9302937439","Boston",new SavingAccount(106, 3000, "saving", 4));
		Customer s07 = new Customer(1007,"Tim4","9302933999","Boston",new SavingAccount(107, 19000, "saving", 5));
		Customer s08 = new Customer(1008,"Tim5","9302933859","Boston",new SavingAccount(108, 20000, "saving", 4));
		Customer s09 = new Customer(1009,"Tim6","9302932349","Boston",new SavingAccount(109, 34000, "saving", 1));
		Customer s10 = new Customer(1010,"Tim7","9303453939","Boston",new SavingAccount(110, 1000, "saving", 3));
		Customer s11 = new Customer(1011,"Tim8","9332933939","Boston",new SavingAccount(111, 500, "saving", 2));
		Customer s12 = new Customer(1012,"Tim9","9354933939","Boston",new SavingAccount(112, 6300, "saving", 4));
		
		Customer c01 = new Customer(1013,"Tim11","9302933939","Boston",new CheckingAccount(113, 5000, "checking", 4));
		Customer c02 = new Customer(1014,"Tim22","9302933939","Boston",new CheckingAccount(114, 4000, "checking", 3));
		Customer c03 = new Customer(1015,"Tim33","9302933939","Boston",new CheckingAccount(115, 7000, "checking", 4));
		Customer c04 = new Customer(1016,"Tim44","9302933939","Boston",new CheckingAccount(116, 2000, "checking", 2));
		Customer c05 = new Customer(1017,"Tim55","9302933939","Boston",new CheckingAccount(117, 5500, "checking", 4));
		Customer c06 = new Customer(1018,"Tim66","9302933939","Boston",new CheckingAccount(118, 3000, "checking", 4));
		Customer c07 = new Customer(1019,"Tim77","9302933939","Boston",new CheckingAccount(119, 19000, "checking", 5));
		Customer c08 = new Customer(1020,"Tim88","9302933939","Boston",new CheckingAccount(120, 20000, "checking", 4));
		Customer c09 = new Customer(1021,"Tim99","9302933939","Boston",new CheckingAccount(121, 34000, "checking", 1));
		Customer c10 = new Customer(1022,"Tim12","9302933939","Boston",new CheckingAccount(122, 1000, "checking", 3));
		Customer c11 = new Customer(1023,"Tim13","9302933939","Boston",new CheckingAccount(123, 500, "checking", 2));
		Customer c12 = new Customer(1024,"Tim52","9302933939","Boston",new CheckingAccount(124, 6300, "checking", 4));

		Customer custArray[] = new Customer[24];
		custArray[0] = s01;
		custArray[1] = s02;
		custArray[2] = s03;
		custArray[3] = s04;
		custArray[4] = s05;
		custArray[5] = s06;
		custArray[6] = s07;
		custArray[7] = s08;
		custArray[8] = s09;
		custArray[9] = s10;
		custArray[10] = s11;
		custArray[11] = s12;
		custArray[12] = c01;
		custArray[13] = c02;
		custArray[14] = c03;
		custArray[15] = c04;
		custArray[16] = c05;
		custArray[17] = c06;
		custArray[18] = c07;
		custArray[19] = c08;
		custArray[20] = c09;
		custArray[21] = c10;
		custArray[22] = c11;
		custArray[23] = c12;

		for(Customer c : custArray) {
			custMap.put(c.getCustId(), c);
		}
		
		return custMap;
	}
	
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
	
	// Exception check method for customer ID existence 
	public static void checkCustomerIdExistException(Map<Integer,Customer> map, Integer key) 
			throws 
				CustomerIdNotExistException 
		{
			if(!map.containsKey(key)) 
				throw new CustomerIdNotExistException();
			return;
		}
		
	private static void checkDepositGreaterThanLimitException(int amount) throws DepositGreaterThanLimitException {
		if(amount > 5000) 
			throw new DepositGreaterThanLimitException();
	}

	private static void checkDepositAmountNegativeException(int amount) throws DepositAmountNegativeException {
		if(amount < 0)
			throw new DepositAmountNegativeException();
	}

	private static void checkWithdrawAmountNegativeException(int amount) throws WithdrawAmountNegativeException {
		if(amount < 0)
			throw new WithdrawAmountNegativeException();
	}

	private static void checkWithdrawAmountMoreThanBalanceException(Customer cust, int amount) throws WithdrawAmountMoreThanBalanceException {
		if(amount > cust.getCustAccount().getAccBalance())
			throw new WithdrawAmountMoreThanBalanceException();
	}

	// Method to add new customer
	public static void addNewCustomer(Map<Integer,Customer> map){
		
		Customer newCust;
		
		System.out.println("--------------------Add New Customer--------------------");

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
		
		if(savingOrChecking == 1) 
			newCust = new Customer(custIdIteration,custName,custPhone,custCity,new SavingAccount(accIdIteration, accBalance, "saving", intRate));
		else
			newCust = new Customer(custIdIteration,custName,custPhone,custCity,new CheckingAccount(accIdIteration, accBalance, "checking", intRate));

		map.put(newCust.getCustId(), newCust);
		
		System.out.println("-----Customer ID " + custIdIteration + " has been added-----");
		
		custIdIteration++;
		accIdIteration++;
	}
	
	// Method to display all Customers -- 1 ordering issue: Displays from the map, the last customer, then first, second, third...
	public static void displayAllCustomers(Map<Integer,Customer> map) {
		Iterator<Integer> custKeySet = map.keySet().iterator();
		Customer cust;
		while(custKeySet.hasNext()) {
			cust = map.get(custKeySet.next());
			System.out.println("-------------------------------------");
			cust.displayCustomerDetails();
			System.out.println("-------------------------------------");
			if(!cust.getCustAccount().getTranList().isEmpty()) {
				for(int i = 0; i < cust.getCustAccount().getTranList().size(); i++) {
					cust.getCustAccount().getTranList().get(i).displayTransactionDetails();
				}
			}
		}
	}
	
	// Method to update existing customer (only phone number and city)
	public static void updateCustomer(Map<Integer,Customer> map){
		
		int key;
		
		System.out.println("----------Updating Existing Customer----------");
		while(true) {
			try {
				Scanner sc = new Scanner(System.in);
				
				System.out.println("Please enter the Customer ID which you would like to update (or enter 0 to exit to menu) : ");
				key = sc.nextInt();
				
				if(key == 0)
					return;
				
				checkCustomerIdExistException(map, key);
			}
			catch(CustomerIdNotExistException e) {
				System.out.println("ERROR : " + e.getMessage());
				System.out.println("Please enter an valid Customer ID . . .");
				continue;
			}
			catch(Exception e) {
				System.out.println("ERROR : " + e.getMessage());
				System.out.println("Please enter an valid Customer ID . . .");
				continue;
			}
			break;
		}
		
		String custPhone;
		String custCity;
		
		System.out.println("Updating Customer Details for " + map.get(key).getCustName() + " . . .");
		
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Please enter the new phone number : ");
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
		
		while(true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Please enter the new City : ");
				custCity = sc.next();
			}
			catch(Exception e) {
				System.out.println("ERROR : " + e.getMessage());
				System.out.println("Please enter a Valid City . . .");
				continue;
			}
			break;	
		}
		
		map.get(key).setCustPhone(custPhone);
		map.get(key).setCustCity(custCity);
	
		System.out.println("-----Customer ID " + key +" has been updated-----");
	}
	
	// Method to delete existing customer
	public static void deleteCustomer(Map<Integer,Customer> map){
		
		int key;
		
		System.out.println("----------Deleting Existing Customer----------");
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter the Customer ID which you would like to delete (Enter 0 to exit to menu) : ");
			key = sc.nextInt();
			
			if(key == 0)
				return;
			
			try {
				checkCustomerIdExistException(map, key);
			}
			catch(CustomerIdNotExistException e) {
				System.out.println("ERROR : " + e.getMessage());
				System.out.println("Please enter an valid Customer ID . . .");
				continue;
			}
			catch(Exception e) {
				System.out.println("ERROR : " + e.getMessage());
				System.out.println("Please enter an valid Customer ID . . .");
				continue;
			}
			break;
		}
		
		map.remove(key);
		
		System.out.println("-----Customer has been deleted-----");
	}
	
	public static void initiateTransaction(Map<Integer,Customer> map){
		
		//withdraw deposit transfer
		System.out.println("----------Transaction Initiated----------");
		
		int fromKey;
		
		while(true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Please enter the Customer ID which you would like to complete a transaction (Enter 0 to exit to menu) : ");
				fromKey = sc.nextInt();
				if(fromKey == 0)
					return;
				checkCustomerIdExistException(map, fromKey);
			}
			catch(CustomerIdNotExistException e) {
				System.out.println("ERROR : " + e.getMessage());
				System.out.println("Please enter an valid Customer ID . . .");
				continue;
			}
			catch(Exception e) {
				System.out.println("ERROR : " + e.getMessage());
				System.out.println("Please enter an valid Customer ID . . .");
				continue;
			}
			break;
		}
		
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
		
		int toKey;
		int amount;
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Please enter the amount . . . ");
				amount = sc.nextInt();

				switch(tranType){
				// Withdraw
				case 1:
					checkWithdrawAmountMoreThanBalanceException(map.get(fromKey), amount);
					checkWithdrawAmountNegativeException(amount);
					map.get(fromKey).getCustAccount().setAccBalance(map.get(fromKey).getCustAccount().getAccBalance() - amount);
					System.out.println("$" + amount + " has been withdrawn from account ID " + fromKey);
					map.get(fromKey).getCustAccount().getTranList().add(new Transaction(amount, "Withdraw"));
					break;
					
				case 2:
					checkDepositAmountNegativeException(amount);
					checkDepositGreaterThanLimitException(amount);
					map.get(fromKey).getCustAccount().setAccBalance(map.get(fromKey).getCustAccount().getAccBalance() + amount);
					System.out.println("$" + amount + " has been deposited to account ID " + fromKey);
					map.get(fromKey).getCustAccount().getTranList().add(new Transaction(amount, "Deposit"));
					break;
					
				case 3:
					while(true) {
						try {
							System.out.println("Please enter the account ID which you would like to transfer to . . .");
							toKey = sc.nextInt();
							checkCustomerIdExistException(map, toKey);
							
							checkWithdrawAmountMoreThanBalanceException(map.get(fromKey), amount);
							checkWithdrawAmountNegativeException(amount);
							checkDepositAmountNegativeException(amount);
							checkDepositGreaterThanLimitException(amount);
							
							map.get(fromKey).getCustAccount().setAccBalance(map.get(fromKey).getCustAccount().getAccBalance() - amount);
							map.get(toKey).getCustAccount().setAccBalance(map.get(toKey).getCustAccount().getAccBalance() + amount);
							
							map.get(fromKey).getCustAccount().getTranList().add(new Transaction(amount, "Withdraw"));
							map.get(toKey).getCustAccount().getTranList().add(new Transaction(amount, "Deposit"));

							System.out.println("$" + amount + " has been transferred from account ID " + fromKey + " to account ID " + toKey);
							
						}
						catch (CustomerIdNotExistException e){
							System.out.println("ERROR : " + e.getMessage());
						}
						catch (WithdrawAmountMoreThanBalanceException e){
							System.out.println("ERROR : " + e.getMessage());
						}
						catch (WithdrawAmountNegativeException e){
							System.out.println("ERROR : " + e.getMessage());
						}
						catch (DepositAmountNegativeException e){
							System.out.println("ERROR : " + e.getMessage());
						}
						catch (Exception e) {
							System.out.println("ERROR : " + e.getMessage());						
						}
						break;
					}
				}
				
			}
			catch (WithdrawAmountMoreThanBalanceException e){
				System.out.println("ERROR : " + e.getMessage());
			}
			catch (WithdrawAmountNegativeException e){
				System.out.println("ERROR : " + e.getMessage());
			}
			catch (DepositAmountNegativeException e){
				System.out.println("ERROR : " + e.getMessage());
			}
			catch (DepositGreaterThanLimitException e){
				System.out.println("ERROR : " + e.getMessage());
			}
			catch (Exception e) {
				System.out.println("ERROR : " + e.getMessage());						
			}
			break;	
		}
		
	}
	
	public static void main(String s[]) {
		
		// Creation of Mock Customer Data for testing . . .
		Map<Integer,Customer> custMap = new HashMap<Integer,Customer>();
		custMap = makeSampleCustMap();
		
		
		while (true) {
			try {
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("\n1. Add New Customer            2. Show All Customers            3. Delete Customer ");
			System.out.println("\n4. Update Customer Details     5. Perform Transactions          6. Exit");
			System.out.println("\n------------------------------------------------------------------------------------");
			Scanner sc = new Scanner(System.in);
			int mSelection = sc.nextInt();

			switch(mSelection) {
				case 1:
					addNewCustomer(custMap);
					continue;
				case 2:
					displayAllCustomers(custMap);
					continue;
				case 3:
					deleteCustomer(custMap);
					continue;
				case 4:
					updateCustomer(custMap);
					continue;
				case 5:
					initiateTransaction(custMap);
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
		
		
		
	public static Customer[] startTransaction(Customer[] custArray) 
		throws
			CustomerIdNotExistException,
			DepositAmountNegativeException,
			DepositGreaterThanLimitException,
			WithdrawAmountMoreThanBalanceException,
			WithdrawAmountNegativeException,
			TransactionTypeInvalidException
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("------------TRANSACTION------------");
		System.out.println("Please enter type of Transaction (depo/with) : ");
		String tranType = sc.next();
		System.out.println("Please enter amount : ");
		int tranAmount = sc.nextInt();
		System.out.println("Please enter the Customer ID : ");
		int custId = sc.nextInt();
		
		
		for(Customer c : custArray) {
			if(c.getCustId() == custId) {
				if(tranType.equals("depo")) {
					if(tranAmount > 5000)
						throw new DepositGreaterThanLimitException();
					else if (tranAmount < 0)
						throw new DepositAmountNegativeException();
					else {
						System.out.println("Depositing " + tranAmount + " from Customer ID " + c.getCustId());
						TransactionServices tranServices = new TransactionServices();
						c = tranServices.cashDeposit(c, tranAmount);
						return custArray;
					}
				}
				else if(tranType.equals("with")) {
					if(tranAmount < 0)
						throw new WithdrawAmountNegativeException();
					else if(tranAmount > c.getCustAccount().getAccBalance())
						throw new WithdrawAmountMoreThanBalanceException();
					else {
						System.out.println("Withdrawing " + tranAmount + " from Customer ID " + c.getCustId());
						TransactionServices tranServices = new TransactionServices();
						c = tranServices.cashWithdraw(c, tranAmount);
						return custArray;
					}
				}
				else {
					throw new TransactionTypeInvalidException();
				}
			}
		}
		throw new CustomerIdNotExistException();

		
	}
}
