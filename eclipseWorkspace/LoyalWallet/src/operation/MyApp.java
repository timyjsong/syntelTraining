package operation;

import java.util.Scanner;

public class MyApp {

	public static void main(String args[]) {
		
		loyaltyCard cardArray[] = new loyaltyCard[5];
		loyaltyCard tempCard = new loyaltyCard();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter user ID : ");
		int userId = sc.nextInt();
		System.out.println("Please enter Name : ");
		String username = sc.next();
		System.out.println("Please enter password : ");
		String password = sc.next();
		
		Customer cust = new Customer();
		
		System.out.println("-----------WELCOME " + username + "!!!-----------");
		
		System.out.println("Enter how many cards you would like to store : ");
		int cardCount = sc.nextInt();
		
		for(int i = 0; i < cardCount; i++) {
			System.out.println("Enter card ID : ");
			int cardId = sc.nextInt();
			System.out.println("Enter restaraunt Name : ");
			String cardName = sc.next();
			System.out.println("Enter the amount of stamps for this card : ");
			int numOfStamps = sc.nextInt();
			
			tempCard.storeCardData(cardId, cardName, numOfStamps);
			cardArray[i] = tempCard;
			
			System.out.println();
		}
		
		cust.storeCustomerData(userId, username, password, cardArray);
		
		cust.displayCustomerData();
	
	}
}
