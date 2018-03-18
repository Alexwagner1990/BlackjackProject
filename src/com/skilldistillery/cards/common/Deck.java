package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	List<Card> deck = new ArrayList<>();

	public Deck() {
		Suit[] suit = Suit.values();
		Rank[] rank = Rank.values();
		for (Suit eachSuit : suit) {
			for (Rank eachRank : rank) {
				deck.add(new Card(eachSuit, eachRank));
			}
		}

	}

	public List<Card> getDeck() {
		return deck;
	}

	public int checkDeckSize() {
		return deck.size();
	}

	public Card dealCard() {
		return deck.remove(0);
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}

	
	

}
