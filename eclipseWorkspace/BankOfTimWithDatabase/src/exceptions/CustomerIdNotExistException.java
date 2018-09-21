package exceptions;

public class CustomerIdNotExistException extends Exception{
	public String getMessage() {
		return "Customer ID does not exist";
	}
}
