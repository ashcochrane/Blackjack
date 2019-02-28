package blackjack.application;

public class Card {
	
	public static enum Suit {
		DIAMONDS(),
		HEARTS(),
		CLUBS(),
		SPADES();
		
	}
	
	public static enum Rank {
		ONE(1,1),
		TWO(2,2),
		THREE(3,3),
		FOUR(4,4),
		FIVE(5,5),
		SIX(6,6),
		SEVEN(7,7),
		EIGHT(8,8),
		NINE(9,9),
		TEN(10,10),
		JACK(10,10),
		QUEEN(10,10),
		KING(10,10),
		ACE(1, 11);
		
		private int hard;
		private int soft;
		
		private Rank(int soft, int hard) {
			this.soft = soft;
			this.hard = hard;
		}
		
		public int getHard() {
			return this.hard;
		}
		
		public int getSoft() {
			return soft;
		}
		
	}
	
	private final Rank rank;
	private final Suit suit;
	
	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public Rank getRank() {
		return rank;
	}
	
	public String toString() {
		return rank.toString() + " " + suit.toString();
	}

}
