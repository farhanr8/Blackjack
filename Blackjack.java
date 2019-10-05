import java.util.Scanner;

public class Blackjack {

	public static void main(String[] args) {
		boolean userWins;
		String userReady;
		Scanner console = new Scanner(System.in);
      
		System.out.println("Let's play BlackJack!\n");
   
		while (true) {
			System.out.println("Are you ready? (Y or N)");
			do {
				userReady = console.next().toUpperCase(); 
				if(!userReady.equals("Y") && !userReady.equals("N")) {
    			  System.out.print("Please enter Y or N:  ");
      		  	}    
			} while(!userReady.equals("Y") && !userReady.equals("N"));
    	  
			if(userReady.equals("N")) {
				System.out.println("Thanks for playing with me! Goodbye...");
				break;
			}
    	  
			System.out.println("****** Game Starting ******\n");
			userWins = playBlackjack();
          
			if (userWins) {
				System.out.println("\nYay you WON! Let's play again!\n");
				System.out.println("------------------------------------");
			}
			else {
				System.out.println("\nAww you lost. Let's try again!\n");
				System.out.println("------------------------------------");
			}

		}
      
	} 
   
   
	static boolean playBlackjack() {
		Scanner console = new Scanner(System.in);

		Deck deck;                 
		Hand dealerHand; 
		Hand userHand;     
      
		deck = new Deck();
		dealerHand = new Hand();
		userHand = new Hand();
	   
		//  Shuffle the deck, then deal two cards to each player.
		deck.shuffle();
		dealerHand.addCard(deck.dealCard());
		dealerHand.addCard(deck.dealCard());
		userHand.addCard(deck.dealCard());
		userHand.addCard(deck.dealCard());

      
		/* 
		 * Case 1:
		 * - Either dealer or user gets 21 after dealing
		 * - Dealer wins ties.
		 */
      
		if(dealerHand.getHandSum() == 21) {
			System.out.println("Your cards are:");
			for(int i = 0; i < userHand.getCardCount(); i++) {
              System.out.println(">> " + userHand.getCard(i));
			}
			System.out.println(">> Total = " + userHand.getHandSum());
           	System.out.println();
           	
           	System.out.println("Dealer's cards are:");
			for(int i = 0; i < dealerHand.getCardCount(); i++) {
              System.out.println(">> " + dealerHand.getCard(i));
			}
			System.out.println(">> Total = " + dealerHand.getHandSum());
           	System.out.println();

           	System.out.println("Dealer has Blackjack.  Dealer wins.");
       		return false;
		}
      
		if (userHand.getHandSum() == 21) {
			System.out.println("Your cards are:");
			for(int i = 0; i < userHand.getCardCount(); i++) {
              System.out.println(">> " + userHand.getCard(i));
			}
			System.out.println(">> Total = " + userHand.getHandSum());
           	System.out.println();
           	
           	System.out.println("Dealer's cards are:");
			for(int i = 0; i < dealerHand.getCardCount(); i++) {
              System.out.println(">> " + dealerHand.getCard(i));
			}
			System.out.println(">> Total = " + dealerHand.getHandSum());
           	System.out.println();
           	
       		System.out.println("You have Blackjack.  You win.");
           	return true;
		}
		
		/* 
		 * Case 2:
		 * - User chooses the "Hit" option
		 * - Loop until user busts or "Stands"
		 */
      
		while (true) {
			System.out.println("Your cards are:");
			for(int i = 0; i < userHand.getCardCount(); i++) {
				System.out.println(">> " + userHand.getCard(i));
			}
			System.out.println(">> Total = " + userHand.getHandSum());
			System.out.println();
           
			if (userHand.getHandSum() > 21) {
				System.out.println("BUSTED! You went over 21.");
				System.out.println("Dealer's other card was: " + dealerHand.getCard(1));
				return false;  
			}
           
			System.out.println("Dealer is showing: " );
			System.out.println(">> " + dealerHand.getCard(0));
			System.out.println();
           
			System.out.println("Hit (H) or Stand (S)? ");
           
			String userAction;  
			do {
				userAction = console.next().toUpperCase(); 
				if (!userAction.equals("H") && !userAction.equals("S")) {
					System.out.print("Please enter H or S:  ");
       		  	}    
			} while(!userAction.equals("H") && !userAction.equals("S"));

			// User Stands
			if (userAction.equals("S")) {
				break;
			}	
			// User Hits
			else {  
				Card newCard = deck.dealCard();
				userHand.addCard(newCard);
				System.out.println();
				System.out.println("User hits.");
				System.out.println("New card: " + newCard);    
			}
           
		} 
		
		/* 
		 * Case 3:
		 * - User chooses the "Stand" option
		 * - Dealer draws until their sum is greater than 16
		 * - If dealer goes over 21, they lose.
		 */

		System.out.println("\nUser stands.\n");
		System.out.println("Dealer's cards are");
		System.out.println(">> " + dealerHand.getCard(0));
		System.out.println(">> " + dealerHand.getCard(1));
		while (dealerHand.getHandSum() <= 16) {
			Card newCard = deck.dealCard();
			System.out.println("\nDealer hits.");
			System.out.println("New card: " + newCard);
			System.out.println("New total = " + userHand.getHandSum());
			dealerHand.addCard(newCard);
			if (dealerHand.getHandSum() > 21) {
				System.out.println();
				System.out.println("Dealer BUSTED!");
				return true;
			}
		}
		
		/* 
		 * Case 4:
		 * - Both players now stand
		 * - Determine winner by looking at max value
		 */
		
		System.out.println("\nDealer stands.\n");
		System.out.println("Dealer's cards are:");
		for(int i = 0; i < dealerHand.getCardCount(); i++) {
          System.out.println(">> " + dealerHand.getCard(i));
		}
		System.out.println(">> Total = " + dealerHand.getHandSum());
       	System.out.println();

		if(dealerHand.getHandSum() == userHand.getHandSum()) {
			System.out.println("Tie game! Dealer wins, You lose.");
			return false;
		}
		else if(dealerHand.getHandSum() > userHand.getHandSum()) {
			System.out.println("Dealer wins! " + dealerHand.getHandSum() 
                          	   + " points to " + userHand.getHandSum() + ".");
			return false;
		}
		else {
			System.out.println("You win! " + userHand.getHandSum() 
                           + " points to " + dealerHand.getHandSum() + ".");
			return true;
		}

	} 

} 