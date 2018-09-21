package exceptions;

public class AccountTypeInvalidException extends Exception{
	public String getMessage() {
		return "Invalid account type -- Please enter either 1 or 2";
	}
}
