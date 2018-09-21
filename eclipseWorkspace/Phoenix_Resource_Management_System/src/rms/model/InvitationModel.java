package rms.model;

public class InvitationModel
{
    private int ID;
    private int bookingID;
    private int userID;
    private int visitorID;
    private String status;
    private String description;
    private int isActive;
    
    public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getBookingID() {
        return this.bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getUserID() {
        return this.userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getVisitorID() {
        return this.visitorID;
    }

    public void setVisitorID(int visitorID) {
        this.visitorID = visitorID;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	@Override
	public String toString() {
		return "InvitationModel [ID=" + ID + ", bookingID=" + bookingID + ", userID=" + userID + ", visitorID="
				+ visitorID + ", status=" + status + ", description=" + description + ", isActive=" + isActive + "]";
	}
}