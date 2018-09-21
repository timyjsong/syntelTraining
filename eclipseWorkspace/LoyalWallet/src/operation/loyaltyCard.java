package operation;

public class loyaltyCard {

	private int cardId;
	private String cardName;
	private int numOfStamps;
	
	public void storeCardData(int cardId, String cardName, int numOfStamps) {
		this.cardId = cardId;
		this.cardName = cardName;
		this.numOfStamps = numOfStamps;
	}
	
	public void displayCardData() {
		System.out.println("Card ID : " + cardId);
		System.out.println("Card Name : " + cardName);
		System.out.println("Card has : " + numOfStamps + " Stamps . . .");
		System.out.println("-------------------------------------");
	}
	
}
