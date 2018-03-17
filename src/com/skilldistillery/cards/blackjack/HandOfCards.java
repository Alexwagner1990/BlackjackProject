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
		for (int i = 0; i < hand.size(); i++) {
			System.out.println(hand.get(i).toString());
		}
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

	public boolean playerHasBetterHand(int pValue, int dValue) {
		if(pValue > dValue) {
			return true;
		}
		else if (pValue == dValue) {
			return false; //NOT SURE WHAT HAPPENS IF BOTH PLAYER AND DEALER TIE, REVISIT THIS
		}
		
		return false;
	}
	


	@Override
	public String toString() {
		return "HandOfCards [hand=" + hand + "]";
	}

}
