package exceptions;

public class TransactionTypeInvalidException extends Exception{
	public String getMessage() {
		return "Transaction type invalid - Neither Deposit, Withdraw, or Transfer";
	}
}
