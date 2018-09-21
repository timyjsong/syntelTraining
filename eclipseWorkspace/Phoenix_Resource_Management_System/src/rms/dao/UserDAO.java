package rms.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import rms.mapper.UserMapper;
import rms.model.UsersModel;

import java.util.List;

public class UserDAO {
    private JdbcTemplate temp;

    public UserDAO(){
        temp = Connection.getConnection();
    }
    
    // Return the next available ID for insert
    public int getNextAvailableKey() {
    	Integer keyInc = (Integer)temp.queryForObject("select MAX(userId) from Users",Integer.class);
    	if(keyInc == null) 
    		return 1;
    	else
    		return keyInc+1;
    }
    
    public UsersModel getUser(int userId) {
    	return (UsersModel)temp.queryForObject("select * from Users where userId = ?", new UserMapper(), userId);
    }
    
    // Return correct password for specified user
    public String getPasswordForUser(UsersModel user) {
    	UsersModel userRet = (UsersModel)temp.queryForObject("Select * from Users where userId = ?", new UserMapper(), user.getUserId());
    	return userRet.getUserPassword();
    }
    
    // Inserts specified user into Users table
    public int insertUser(UsersModel user) {
    	return temp.update("insert into Users values(?,?,?,?,?,?,?,?,1)",
    			new UserDAO().getNextAvailableKey(), user.getUserName(), user.getUserEmail(), user.getUserPassword(),
    			user.getUserType(), user.getUserPhone(), user.getLocId(),user.getName());
    }
	
    // Updates isActive column entry to 0 to the specified user from Users table
    public int deleteUser(UsersModel user) {
    	return temp.update("update Users set isActive = 0 where userId = ?)", user.getUserId());
    }
	
    // Updates specified user from Users table
    public int updateUser(UsersModel user) {
    	return temp.update("update Users set userPassword = ?, locId = ?, userType =? where userId = ?)",
    			user.getUserPassword(), user.getLocId(), user.getUserType(), user.getUserId());
    }
    
    public List<UsersModel> getAllUsers() {
    	return temp.query("select * from Users", new UserMapper());
    }

    /*
    public UsersModel get(int ID)
    {
        return new UsersModel();
    }
    */

}
