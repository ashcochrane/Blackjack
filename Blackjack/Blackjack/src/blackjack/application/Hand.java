package blackjack.application;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	
	private List<Card> hand;
	private int size;
	private int hard;
	private int soft;
	private boolean beenSplit;
	
	public Hand() {
		hand = new ArrayList<>();
		size = 0;
		hard = 0;
		soft = 0;
		beenSplit = false;
	}
	
	public List<Card> getHand() {
		return hand;
	}
	
	public int getSize() {
		size = hand.size();
		return size;
	}
	
	public int getHard() {
		hard = 0;
		for (Card card: hand) {
			hard += card.getRank().getHard();
		}
		return hard;
	}
	
	public int getSoft() {
		soft = 0;
		for (Card card: hand) {
			soft += card.getRank().getSoft();
		}
		return soft;
	} 
	
	public boolean getBeenSplit() {
		return beenSplit;
	}
	
	public void setBeenSplit() {
		this.beenSplit = true;
	}
	
	public void addCard(Card card) {
		hand.add(card);
	}
	
	public boolean splittable() {
		if (hand.size() == 2 && hand.get(0).getRank() == hand.get(1).getRank()) {
			return true;
		}
		return false;
	}
	
	public Card upCard() {
		return hand.get(0);
	}
	
	public boolean blackjack() {
		if (soft == 21 || hard == 21) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		String str = "";
		for (Card c: hand) {
			str += c.toString() + " ";
		}
		return str;
	}
	
	public Card Split() {
		if (hand.size() == 2 && hand.get(0) == hand.get(1)) {
			Card splitCard = hand.get(1);
			hand.remove(1);
			return splitCard;
		}
		return null;
	}

}
