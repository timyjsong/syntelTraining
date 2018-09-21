package security;

public class SecurityAPI {

	public static boolean isUserValid(String username, String password) {
		if(username.length()>5 && password.equals("syntel123$"))
			return true;
		else
			return false;
	}
}
