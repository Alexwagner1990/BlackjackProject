package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Rank;

public abstract class HandOfCards {

	List<Card> hand = new ArrayList<>();

	public void addCardToHand(Card card) {
		hand.add(card);
	}

	public void displayHand() {
		System.out.println();
		System.out.println("++ Here's the updated hand ++");
		System.out.println("********************************");
		for (int i = 0; i < hand.size(); i++) {
			System.out.println(hand.get(i).toString());
		}
		System.out.println("********************************");
	}

	public int getValueOfHand() {
		int totalCardValue = 0;
		for(int i = 0; i < hand.size(); i++) {
			Card oneCard = hand.get(i);
			int cardValue = oneCard.getValue();
			totalCardValue = cardValue + totalCardValue;
		}
		return totalCardValue;
	}

	public boolean areYouBusted(int value) {
		if(value > 21) {
			return true;
		}
		return false;
	}

	public boolean doYouHaveTwentyOne(int value) {
		if(value == 21) {
			return true;
		}
		return false;
	}

	public void playerHasBetterHand(String playerName, int pValue, int dValue) {
		if(pValue > dValue) {
			System.out.println("\"You've got " + pValue + " to my " + dValue + ", I owe ya some dough.\"");
			//give back double bet
		}
		else if(pValue < dValue) {
			System.out.println("\"Too bad, " + playerName + ", but " + pValue + " can't beat my " + dValue + ", betta luck next hand.\"");
			//lose bet
		}
		else {
			System.out.println("\"We both got " + dValue + ", eh? Ah well, thatsa push.\"");
			//give back bet
		}
	}
	


	@Override
	public String toString() { //check player and dealers toString method if not working
		return "HandOfCards [hand=" + hand + "]";
	}

}
