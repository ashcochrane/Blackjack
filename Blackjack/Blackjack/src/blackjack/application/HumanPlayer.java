package blackjack.application;

import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer implements Player {

	private int stake;
	private Table table;
	private String name;
	private ArrayList<Hand> hands;
	private ArrayList<Bet> bets;

	public HumanPlayer(Table table, String name, int stake) {
		this.table = table;
		this.name = name;
		this.stake = stake;
		this.hands = new ArrayList<Hand>();
		this.bets = new ArrayList<Bet>();
		this.hands.add(new Hand());
	}

	@Override
	public void decide() {
		for (int i = 0; i < hands.size(); i++) {
			Hand hand = hands.get(0);
			Decision decision = null;
			while (hand.getSoft() <= 21 && decision != Decision.STAND) {
				System.out.println("\nSelect: h=hit | s=stand | sp=split | d=double");
				Scanner scan = new Scanner(System.in);
				String input = scan.next();
				switch(input) {
				case("h"):
					System.out.println("Hit");
					decision = Decision.HIT;
					executeDecision(hand, decision);
					break;
				case("s"):
					System.out.println("Stand");
					decision = Decision.STAND;
					executeDecision(hand, decision);
					break;
				case("d"):
					System.out.println("Double");
					decision = Decision.DOUBLE;
					executeDecision(hand, decision);
					break;
				case("sp"):
					System.out.println("Split");
					decision = Decision.SPLIT;
					executeDecision(hand, decision);
					break;
				default:
					System.out.println("Invalid entry, please try again");
					break;
				}
				if (hand.getHard() <= 21 && hand.getHard() != hand.getSoft()) {
					System.out.println("Hand totals: " + hand.getSoft() + " or " + hand.getHard());
				} else {
					System.out.println("Hand totals: " + hand.getSoft());
				}
			}
		}
	}

	private void executeDecision(Hand hand, Decision decision) {
		switch(decision) {
		case HIT:
			Card card = table.deal();
			hand.addCard(card);
			System.out.println("Card dealt: " + card);
			break;
		case DOUBLE:
			hand.addCard(table.deal());
			//Double bet
			break;
		case SPLIT:
			Hand splitHand = new Hand();
			splitHand.addCard(hand.Split());
			hand.addCard(table.deal());
			splitHand.addCard(table.deal());
			hands.add(splitHand);
			break;
		default:
			break;
		}
	}

	@Override
	public void endRound() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Hand getHand() {
		return hands.get(0);
	}
	
	public String getName() {
		return name;
	}
	
	public Hand getSplitHand() {
		if (hands.size() == 2) {
			return hands.get(1);
		}
		return null;
	}
	
	public int getNumberOfHands() {
		return hands.size();
	}
	
	public int getStake() {
		return stake;
	}
	
	public boolean allHandsBust() {
		for (Hand h : hands) {
			if (h.getSoft() > 21 && h.getHard() > 21) {
				return true;
			}
		}
		return false;
	}
	

}
