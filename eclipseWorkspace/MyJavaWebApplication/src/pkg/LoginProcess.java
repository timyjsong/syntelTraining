package pkg;

public class LoginProcess {

	public static boolean isValidLogin(String username, String password) {
		if(username.length()>6 && password.equals("syntel123$")) {
			return true;
		}
		else
			return false;
	}
}
