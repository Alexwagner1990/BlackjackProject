package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Card;

public class PlayerHand extends HandOfCards {
	
	public void addCardToHand(Card card) {
		super.addCardToHand(card);
	}

	public HandOfCards clearHandAtEndOfRound() {
		HandOfCards newHand = new PlayerHand(); //CAREFUL ABOUT MAKING A NEW OBJECT HERE -> after testing this doesn't seem to be a problem
		return newHand;	
	}
	
	public String toString() {
		return "++ Here's what you are showing ++\n\n***************************" + "\n\n" + hand.get(0) + "\n" + hand.get(1) + "\n\n***************************\n";
		//RETURN TO THIS - FIND SOME WAY TO RUN THE .GET method on player - maybe this toString should take a string (the player name)
	}
}
