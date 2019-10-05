import java.lang.Math;
import java.util.ArrayList;
import java.util.Collections; 

/*
 * Deck object:
 * Representation of a standard deck with 52 playing cards.  
 * Deck can be shuffled and dealt.
 * 
 * */


public class Deck {

	private ArrayList<Card> deck;
    private int cardsDealt; 
    
    public Deck() {
    	cardsDealt = 0;
    	deck = new ArrayList<Card>();
    	int count = 0; 
    	for(int suit = 0; suit < 4; suit++) { 
    		for(int value = 1; value < 14; value++) {
    			deck.add(new Card(value,suit));
    			count++;
    		}
    	}
    }
    
    public void shuffle() {
    	Collections.shuffle(deck);
        cardsDealt = 0;
    }
    
    // Returns remaining cards in deck
    public int cardsLeft() {
        return 52 - cardsDealt;
    }
    
    // Deals one card from the deck 
    public Card dealCard() {
        cardsDealt++;
        return deck.get(cardsDealt - 1);
    }

} 