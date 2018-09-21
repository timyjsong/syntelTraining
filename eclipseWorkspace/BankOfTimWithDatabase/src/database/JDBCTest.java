package database;

import java.sql.*;
import java.util.*;

public class JDBCTest {

	static Connection connection;
	
	public static void giveConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "syntel123$");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insertEmployee(int eid, String ename, String ecity, int esalary) {
		
		try {
			
			PreparedStatement pstate = connection.prepareStatement("insert into employee_data values(?,?,?,?)");
			pstate.setInt(1, eid);
			pstate.setString(2, ename);
			pstate.setString(3, ecity);
			pstate.setInt(4, esalary);
			
			// returns the amount of updates (same method for insertion, deletion, and update) made
			int result = pstate.executeUpdate();
			
			if(result > 0)
				System.out.println("Insert successful");
			else
				System.out.println("Update failed");
			
			System.out.println("-------ok");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updateEmployee(int eid, String ecity, int esalary) {
		
		try {
			
			PreparedStatement pstate = connection.prepareStatement("update employee_data set ecity = ?, esalary = ? where eid = ?");
			pstate.setString(1, ecity);
			pstate.setInt(2, esalary);
			pstate.setInt(3, eid);
			
			// returns the amount of updates (same method for insertion, deletion, and update) made
			int result = pstate.executeUpdate();
			
			if(result > 0)
				System.out.println("Update successful");
			else
				System.out.println("Update failed");
			
			System.out.println("-------ok");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void deleteEmployee(int eid) {
		
		try {
			
			PreparedStatement pstate = connection.prepareStatement("delete from employee_data where eid = ?");
			pstate.setInt(1, eid);
			
			// returns the amount of updates (same method for insertion, deletion, and update) made
			int result = pstate.executeUpdate();
			
			if(result > 0)
				System.out.println("Delete successful");
			else
				System.out.println("Delete failed");
			
			System.out.println("-------ok");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void searchEmployee(String empCity) {
		
		try {
			PreparedStatement pstate = connection.prepareStatement("Select * from employee_data where ecity = ?");
			pstate.setString(1, empCity);
			ResultSet result = pstate.executeQuery();
			
			while(result.next()) {
				System.out.println(result.getString(1) + result.getString(2) + result.getString(3) + result.getString(4));
			}
			
			System.out.println("-------ok");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getAllEmployees() {
		try {

			Statement state = connection.createStatement();
			ResultSet result = state.executeQuery("Select * from employee_data");
			
			ResultSetMetaData rsmd = result.getMetaData();
			
			for(int i = 1; i <= rsmd.getColumnCount(); i++) {
				System.out.print(rsmd.getColumnName(i) + " ");
			}
			System.out.println();
			while(result.next()) {
				System.out.println(result.getString(1) + result.getString(2) + result.getString(3) + result.getString(4));
			}
			System.out.println("-------ok");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String s[]) {
		
		giveConnection();
		getAllEmployees();
		//searchEmployee("Boston");
		
		Scanner sc = new Scanner(System.in);
		
		//System.out.println("Enter EID : ");
		int deleteEID = sc.nextInt();
		
		deleteEmployee(deleteEID);
		
		getAllEmployees();
		
	}
	
}
