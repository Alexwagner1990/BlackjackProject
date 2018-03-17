package com.skilldistillery.cards.blackjack;

import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class Dealer implements PlayingBlackjack {

	private String name;
	private int money = Integer.MAX_VALUE;
	private HandOfCards hand;
	private Deck deck;

	public Dealer(String name) {
		this.name = name;
		deck = new Deck();
	}

	public Card startAHand() {
		Card card = deck.dealCard();
		return card;
	}
	public Card drawACard() {
		Card card = deck.dealCard();
		return card;
	}

	public Deck getDeck() {
		return this.deck;
	}

	@Override
	public boolean hitMe(int handValue) { //MAY NOT USE THIS
		if(handValue < 17) {
			return true;
		}
		return false;
	}

	@Override
	public boolean hitMe() {

		return false;
	}
	// *******************************AUTO-GENERATED
	// ***********************************************
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HandOfCards getHand() {
		return hand;
	}

	public void setHand(HandOfCards hand) {
		this.hand = hand;
	}


	@Override
	public boolean hitMe(String input) { //DEALER WONT USE THIS
		// TODO Auto-generated method stub
		return false;
	}

}
