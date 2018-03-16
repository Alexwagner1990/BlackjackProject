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
		this.deck = new Deck();
	}
	
	public Deck getDeck() {
		return deck;
	}
	
	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
	
	public Card dealACard() {
		Card card = deck.dealCard();
		return card;
	}
	@Override
	public boolean hitMe() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean stay() {
		// TODO Auto-generated method stub
		return false;
	}
	//*******************************AUTO-GENERATED STUFF*********************************************** 	
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


	
}
