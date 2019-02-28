package blackjack.application;

public class Dealer implements Player {
	
	private Hand hand;
	private Table table;
	
	public Dealer(Table table) {
		this.table = table;
		hand = new Hand();
	}
	
	public Card getUpCard() {
		return hand.upCard();
	}

	@Override
	public void decide() {
		if (hand.getHard() == hand.getSoft()) {
			System.out.println("Dealer's cards: " + hand.getHard());
		} else {
			System.out.println("Ace");
		}
		while (hand.getHard() < 17) {
			Card card = table.deal();
			hand.addCard(card);
			System.out.println("Card dealt: " + card.toString());
			System.out.println("Dealer's cards: " + hand.getHard());
		}
		
		if (hand.getHard() > 21 && hand.getHard() != hand.getSoft()) {
			while (hand.getSoft() < 17) {
				Card card = table.deal();
				hand.addCard(card);
				System.out.println("Card dealt: " + card.toString());
				System.out.println("Dealer's cards: " + hand.getSoft());
			}
		}
		
		if (hand.getHard() > 21 && hand.getSoft() > 21) {
			System.out.println("Dealer bust!");
		}
		
	}

	@Override
	public void endRound() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Hand getHand() {
		return hand;
	}

}
