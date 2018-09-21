package bank;

public class TransactionServices {
	
	public Customer cashWithdraw(Customer custObj, double amount) {
		
		if(isValidWithdrawAmount(amount)) {
			double afterWithdraw = custObj.getCustAccount().getAccBalance() - amount;
			custObj.getCustAccount().setAccBalance(afterWithdraw);
			return custObj;
		}
		else {
			return null;
		}
		
	}
	public Customer cashDeposit(Customer custObj, double amount) {
		
		if(isValidWithdrawAmount(amount)) {
			double afterDeposit = custObj.getCustAccount().getAccBalance() + amount;
			custObj.getCustAccount().setAccBalance(afterDeposit);
			return custObj;
		}
		else {
			return null;
		}
	}
	public boolean isValidWithdrawAmount(double amount) {
		if(amount<=0)
			return false;
		else
			return true;
	}
	
	
}
