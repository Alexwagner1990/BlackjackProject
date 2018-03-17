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
}
