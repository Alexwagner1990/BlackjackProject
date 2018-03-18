package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.Rank;
import com.skilldistillery.cards.common.Suit;

public class Dealer implements PlayingBlackjack {

	private String name;
	private int money = Integer.MAX_VALUE;
	private HandOfCards hand;
	private Deck deck;

	public Dealer(String name) {
		this.name = name;
		deck = new Deck();
	}

//	CAREFUL HERE
	public void resetEmptyDeck() { 
			List<Card> newdeck = new ArrayList<>();
			Suit[] suit = Suit.values();
			Rank[] rank = Rank.values();
			for (Suit eachSuit : suit) {
				for (Rank eachRank : rank) {
					newdeck.add(new Card(eachSuit, eachRank));
				}
			}
			deck.setDeck(newdeck);
	}
	
	public Card startAHand() {
		if(deck.checkDeckSize() == 0) {
			System.out.println("\n\"Woah, hold on a tick, lemme shuffle these puppies back up . . .\n");
			resetEmptyDeck();
			deck.shuffle();
		}
		Card card = deck.dealCard();
		return card;
	}
	public Card drawACard() {
		if(deck.checkDeckSize() == 0) {
			resetEmptyDeck();
			deck.shuffle();
		}
		Card card = deck.dealCard();
		return card;
	}

	public Deck getDeck() {
		return this.deck;
	}

	@Override
	public boolean hitMe(int handValue) {
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
