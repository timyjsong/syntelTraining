package exceptions;

public class WithdrawAmountMoreThanBalanceException extends Exception{
	public String getMessage() {
		return "Withdraw amount entered is more than exisiting balance";
	}
}
