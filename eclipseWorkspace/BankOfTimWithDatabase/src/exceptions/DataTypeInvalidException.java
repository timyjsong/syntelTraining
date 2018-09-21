package exceptions;

public class DataTypeInvalidException extends Exception {
	public String getMessage() {
		return "Data option is not valid.";
	}
}
