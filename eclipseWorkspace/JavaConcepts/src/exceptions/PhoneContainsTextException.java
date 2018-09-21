package exceptions;

public class PhoneContainsTextException extends Exception{
	public String getMessage() {
		return "Phone number contains text";
	}
}
