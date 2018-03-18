package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;

public class DealerHand extends HandOfCards {
	
	public void addCardToHand(Card card) {
		super.addCardToHand(card);
	}
	
	public HandOfCards clearHandAtEndOfRound() {
		HandOfCards newHand = new DealerHand(); //CAREFUL ABOUT MAKING A NEW OBJECT HERE
		return newHand;	
	}

	@Override //to only show one card instead of both, just delete if not working
	public String toString() {
		return "++ Here's what the dealer is showing ++\n\n***************************" + "\n\n" + hand.get(1) + "\n\n***************************\n";
	}
	
	
}
