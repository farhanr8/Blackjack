# Blackjack
This is a simple terminal based blackjack game, completed as part of an application. Current implementation does not have allow placing bets. Basic blackjack rules apply.

## Running the code

Prerequisites:
- Java
- Git

Downloading the code:
```bash
git clone https://github.com/farhanr8/Blackjack.git
cd Blackjack
```

Compile and run:
```bash
javac Blackjack.java
java Blackjack
```

## Design Choices

Card games are very pervasive when it comes to object oriented programming and that is why I took the approach of creating objects to ressemble the real world. Cards simply have a suit and value, and I added the helper functions so that the card can be read properly once printed. A deck and a hand of cards is simply a collection of cards, so I made an arraylist in the Deck and Hand objects. For the deck, the arraylist allowed me to call the java shuffle function to mix up the elements, rather than me having to do it myself.

I chose Java since that was the language I am most comfortable with when it comes to OOP. As for testing my code, I did not write any test runner. Rather, I sent in dummy values during the development to make sure the appropriate calculations and messages where being printed. Other than that, I just played a lot to make sure all scenarios are covered.
