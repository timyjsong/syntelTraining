package rms.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import rms.mapper.InvitationMapper;
import rms.model.InvitationModel;

import java.util.List;

public class InvitationDAO {
    private JdbcTemplate temp;

    public InvitationDAO(){
        temp = Connection.getConnection();
    }
    
    // Return the next available ID for insert
    public int getNextAvailableKey() {
    	Integer keyInc = (Integer)temp.queryForObject("select MAX(invid) from Invitation",Integer.class);
    	if(keyInc == null) 
    		return 1;
    	else
    		return keyInc+1;
    }
    
    // Return InvitationModel with specified invitationID
    public InvitationModel getInvitation(int invId) {
    	return (InvitationModel)temp.queryForObject("Select * from Invitation where invId = ?", new InvitationMapper(), invId);
    }
    
    // Inserts specified invitation into Invitation table
    public int insertInvitation(InvitationModel inv) {
    	return temp.update("insert into Invitation values(?,?,?,?,?,?,1)",
    			new InvitationDAO().getNextAvailableKey(), inv.getUserID(), inv.getBookingID(), inv.getStatus(), inv.getVisitorID(), inv.getDescription());
    }
	
    // Updates isActive column entry to 0 to the specified invitation from Invitation table
    public int deleteInvitation(InvitationModel inv) {
    	return temp.update("update Invitation set isActive = 0 where invId = ?", inv.getID());
    }
	
    // Updates specified invitation from Invitation table
    public int updateInvitation(InvitationModel inv) {
    	return temp.update("update Invitation set userId = ?, bookingId = ?, status =?, visId = ?, description = ? where invId = ?)",
    			inv.getUserID(), inv.getBookingID(), inv.getStatus(), inv.getVisitorID(), inv.getDescription(), inv.getID());
    }
    
    // Returns a list of InvitationModel from Invitation table
    public List<InvitationModel> getAllInvitations() {
    	return temp.query("select * from Invitation", new InvitationMapper());
    }
    
    /*
    public static void main(String args[]) {
    	System.out.println(new InvitationDAO().getNextAvailableKey());
    }
    */

}
