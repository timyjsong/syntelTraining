package exceptions;

public class PhoneNotTenDigitException extends Exception{
	public String getMessage() {
		return "Phone number is not 10-digits";
	}
}
