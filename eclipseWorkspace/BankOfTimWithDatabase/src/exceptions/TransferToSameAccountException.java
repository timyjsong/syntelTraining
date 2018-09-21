package exceptions;

public class TransferToSameAccountException extends Exception{
	public String getMessage() {
		return "Cannot transfer to own account";
	}
}
