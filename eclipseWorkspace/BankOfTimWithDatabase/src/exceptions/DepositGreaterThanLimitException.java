package exceptions;

public class DepositGreaterThanLimitException extends Exception{
	public String getMessage() {
		return "Deposit amount is greater than the limit of $5000";
	}
}
