package pkg;

public class LoginCheck {

	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isValidLoginNew() {
		if(username.length()>6 && password.equals("syntel123$")) 
			return true;
		else
			return false;
	}
	
	
	public static boolean isValidLogin(String username, String password) {
		if(username.length()>6 && password.equals("syntel123$")) 
			return true;
		else
			return false;
	}
}
