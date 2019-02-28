package blackjack.application;

import java.util.ArrayList;

public class Table {
	
	private ArrayList<Bet> playerBets;
	private ArrayList<Player> players;
	private Dealer dealer;
	private Shoe shoe;
	
	public Table(int numDecks, int numPlayers) {
		players = new ArrayList<Player>();
		playerBets = new ArrayList<Bet>();
		Dealer dealer = new Dealer(this);
		shoe = new Shoe(5, 2);
	
		players.add(dealer);
		players.add(new HumanPlayer(this, "Ashton", 1000));
		
	}
	
	public void start() {
		shoe.shuffleShoe();
		if (shoe.shoeIsValid()) {
			
			for (int i = 0; i < 2; i++) {
				for (Player p: players) {
					p.getHand().addCard(deal());
				}
			}
			for (Player p: players) {
				if (p instanceof HumanPlayer) {
					if (p.getHand().getHard() == p.getHand().getSoft()) {
						System.out.println(((HumanPlayer) p).getName() + " cards: " + p.getHand().toString() + " -> " + p.getHand().getHard());
					} else {
						System.out.println(((HumanPlayer) p).getName() + " cards: " + p.getHand().toString() + " -> " + p.getHand().getSoft() + " or " + p.getHand().getHard());
					}
				}
				if (p instanceof Dealer) {
					System.out.println("Dealers card: " + ((Dealer) p).getUpCard());
				}
			}
			for (Player p: players) {
				if (p instanceof HumanPlayer) {
					p.decide();
				}
			}
			for (Player p: players) {
				if (p instanceof Dealer) {
					p.decide();
				}
			}
		}
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public Card deal() {
		return shoe.deal();
	}
	
	public void restart() {
		this.shoe = new Shoe(6,2);
		this.dealer = new Dealer(this);
		this.players = new ArrayList<Player>();
		this.playerBets = new ArrayList<Bet>();
	}

	public static void main(String[] args) {
		Table t = new Table(5, 2);
		t.start();
	}


}
