package bank;

import java.util.*;

import exceptions.*;

public class MyApp {
	
	public static Customer[] inputCustomer() 
		throws 
			PhoneContainsTextException,
			PhoneNotTenDigitException
	{
		Customer custArray[] = new Customer[10];
		
		Scanner sc = new Scanner(System.in);
		
		int custCount = 0;
		
		int custId;
		String custName;
		String custPhone;
		String custCity;
		
		int accId;
		double accBalance;
		float interestRate;
		
		System.out.println("Would you like to enter a new customer? (yes/no)");
		String custCreate = sc.next();

		while(custCreate.equals("yes")) {
			SavingAccount accountObject = new SavingAccount();
			System.out.println("Cust Count: " + custCount);
			System.out.println("Scan Customer Details . . .");
			System.out.println("Scan ID . . .");
			custId = sc.nextInt();
			
			System.out.println("Scan Name . . .");
			custName = sc.next();
			
			System.out.println("Scan Phone . . .");
			custPhone = sc.next();
			
			//Exception Check
	        for (char c : custPhone.toCharArray()) {
	            if (Character.isDigit(c) == false) {
	            	throw new PhoneContainsTextException();
	            }
	        }
			if(custPhone.length() != 10) {
				throw new PhoneNotTenDigitException();
			}
			
			System.out.println("Scan City . . .");
			custCity = sc.next();
			
			System.out.println("Scan Customer Account Details . . .");
			System.out.println("Scan AccID . . .");
			accId = sc.nextInt();
			
			System.out.println("Scan Balance . . .");
			accBalance = sc.nextDouble();
			
			System.out.println("Scan Interest Rate . . .");
			interestRate = sc.nextFloat();
			
			accountObject.storeAccountDetails(accId, accBalance, interestRate);
			Customer newCust = new Customer();
			newCust.storeCustomerDetails(custId, custName, custPhone, custCity, accountObject);
			custArray[custCount] = newCust;
			
			custCount++;
			
			System.out.println("Would you like to enter a new customer? (yes/no)");
			custCreate = sc.next();
		}
		
		return custArray;
		
	}
	
	public static void main(String s[]) {
		
		Customer custArray[] = new Customer[10];
		
		try {
			custArray = inputCustomer();
			
			for(int i = 0; i < custArray.length; i++) {
				custArray[i].displayCustomerDetails();			
			}
		}
		catch(PhoneNotTenDigitException e) {
			System.out.println("ERROR : " + e.getMessage());
		}
		catch(PhoneContainsTextException e) {
			System.out.println("ERROR : " + e.getMessage());
		}
		catch(InputMismatchException e) {
			System.out.println("ERROR : " + e.getMessage());
		}
		catch(NullPointerException e) {
			System.out.println("ERROR : " + e.getMessage());
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println("ERROR : " + e.getMessage());
		}
		catch(Exception e) {
			System.out.println("ERROR : " + e.getMessage());
		}
			
		//-------------------TRANSACTION--------------------
			while(true) {
		try {
			custArray = startTransaction(custArray);
			for(Customer c : custArray) {
				c.displayCustomerDetails();
			}
		}
		catch (CustomerIdNotExistException e) {
			System.out.println("ERROR : " + e.getMessage());
		}
		catch (DepositAmountNegativeException e) {
			System.out.println("ERROR : " + e.getMessage());
		}
		catch (DepositGreaterThanLimitException e) {
			System.out.println("ERROR : " + e.getMessage());
		}
		catch (WithdrawAmountMoreThanBalanceException e) {
			System.out.println("ERROR : " + e.getMessage());
		}
		catch (WithdrawAmountNegativeException e) {
			System.out.println("ERROR : " + e.getMessage());
		}
		catch (TransactionTypeInvalidException e) {
			System.out.println("ERROR : " + e.getMessage());
		}
		catch (NullPointerException e) {
			System.out.println("END OF CUSTOMERS! HAVE A GOOD DAY");
		}
		catch (Exception e) {
			System.out.println("ERROR : " + e.getMessage());
		}
		
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
