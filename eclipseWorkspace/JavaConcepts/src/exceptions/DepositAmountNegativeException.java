package exceptions;

public class DepositAmountNegativeException extends Exception{
	public String getMessage() {
		return "Deposit amount is invalid - Negative amount";
	}
}
