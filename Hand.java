import java.util.ArrayList;

/*
 * Hand object:
 * Representation of a hand of cards.
 * Max num of cards is specified in constructor (default is 5)
 * Computes value of the hand
 * 
 * */

public class Hand {

	private ArrayList<Card> hand;
   
	public Hand() {
		hand = new ArrayList<Card>(); 
	}
   
	public void clear() {
		hand.clear();
	}
   
	public void addCard(Card c) {
		if (c != null) {
			hand.add(c);
		}
	}
   
	public int getCardCount() {
		return hand.size();
	}
   
	public Card getCard(int position) {
		return (Card)hand.get(position);
	}
   
	public int getHandSum() {
		int sum;      
		int cards;    
		boolean ace; 

		sum = 0;
		ace = false;
		cards = getCardCount();

		for(int i = 0; i < cards; i++) {
			Card card;     
			int cardVal;  
			card = getCard(i);
			cardVal = card.getValue();
			
			// For a Jack, Queen, or King.
			if (cardVal > 10) {
				cardVal = 10;   
			}
			
			// There is at least one ace.
			if (cardVal == 1) {
				ace = true;     
			}
			
			sum = sum + cardVal;
		}

        // Ace can be either 1 or 11 
		if ( ace == true  &&  sum + 10 <= 21 ) {
			sum = sum + 10;
		}

		return sum;
	} 
  
}