package blackjack.application;

public class Bet {
	
	private int amount;
	
	public Bet(int amount) {
		this.amount = amount;
	}
	
	public int getBet() {
		return amount;
	}
	
	public String toString() {
		return "You have bet amount: $" + amount;
	}

}
