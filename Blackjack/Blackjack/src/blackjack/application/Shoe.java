package blackjack.application;

import java.util.ArrayList;
import java.util.Collections;

public class Shoe {
	
	private ArrayList<Card> cards = new ArrayList<>();
	private int cardsToDeal;
	
	public Shoe(int decks, int stopDeal) {
		if (decks >= 2 && decks > stopDeal && stopDeal >= 0) {
			for (int i=0; i < decks; i++) {
				Deck deck = new Deck();
				cards.addAll(deck.getCards());
			}
			cardsToDeal = decks * 52 - stopDeal * 52;
		} else {
			System.out.println("Error: Invalid number of decks.");
		}
		System.out.println("Creating a new shoe with " + decks + "  decks\n");
	}
	
	public void shuffleShoe() {
		System.out.println("Shuffling Shoe...\n");
		Collections.shuffle(cards);
	}
	
	public Card deal() {
		Card card = cards.get(0);
		cards.remove(0);
		return card;
	}
	
	public boolean shoeIsValid() {
		if (cards.size() >= cardsToDeal) {
			return true;
		}
		return false;
	}
	
	public int getCardsRemaining() {
		return cards.size();
	}

}
