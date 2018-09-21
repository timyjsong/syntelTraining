package pkg;

import java.sql.*;

public class JDBCTest {
	Connection con;
	ResultSet result;
	
	public Connection getConnection() {
		try {
			con = DriverManager.getConnection("", "system", "syntel123$");
		}
		catch (Exception e) {
			e.printStackTrace(s);
		}
		return con;
	}
	Public ResultSet getAllEmployees() {
		
	}
}
