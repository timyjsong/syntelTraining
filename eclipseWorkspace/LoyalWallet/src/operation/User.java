package operation;

public abstract class User {
	
	private int userId;
	
	private String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private String password;
	
	public void storeUserData(int userId, String username, String password) {
		
		this.userId = userId;
		this.username = username;
		this.password = password;
		
	}
	
	
}
