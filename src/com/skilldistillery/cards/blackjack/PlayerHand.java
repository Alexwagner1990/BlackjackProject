package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Card;

public class PlayerHand extends HandOfCards {

	public void addCardToHand(Card card) {
		super.addCardToHand(card);
	}

	public HandOfCards clearHandAtEndOfRound() {
		HandOfCards newHand = new PlayerHand(); //CAREFUL ABOUT MAKING A NEW OBJECT HERE
		return newHand;	
	}
}
