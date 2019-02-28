package blackjack.application;

import java.util.ArrayList;

import blackjack.application.Card.Rank;
import blackjack.application.Card.Suit;

public class Deck {
	
	private ArrayList<Card> deck;
	
	
	public Deck() {
		deck = new ArrayList<>();
		
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.add(new Card(r, s));
			}
		}	
	}
	
	public ArrayList<Card> getCards() {
		return deck;
	}

}
