package exceptions;

public class WithdrawAmountNegativeException extends Exception{
	public String getMessage() {
		return "Withdraw amount is invalid - Negative amount";
	}
}
