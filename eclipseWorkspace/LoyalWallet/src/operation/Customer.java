package operation;

public class Customer extends User{

	private loyaltyCard cardArray[] = new loyaltyCard[5];
	
	public loyaltyCard[] getCardArray() {
		return cardArray;
	}

	public void setCardArray(loyaltyCard[] cardArray) {
		this.cardArray = cardArray;
	}

	public void storeCustomerData(int userId, String username, String password, loyaltyCard[] cardArray) {
		super.storeUserData(userId, username, password);
		this.cardArray = cardArray;
	}
	
	public void displayCustomerData() {
		System.out.println("The following are the details of " + super.getUsername() + " . . .");
		
		try{
			for(loyaltyCard c : cardArray) {
				c.displayCardData();
			}
		}
		catch(NullPointerException e) {
			System.out.println("---Reached the end of Cards!---");
			System.out.println("----Please Come Back Again!----");
		}
		
		
	}
	
	
}
