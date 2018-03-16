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
	//	toString(hand); put this in later, some toString method that either displays the whole current list of cards, or one that iterates through a list of cards.
	}
	
	public int getValueOfHand() {
		
		//here I'll need to iterate through each card in the hand array, get its value with the getValue method, then add all of them together.
		return 0;
	}
	
	public boolean areYouBusted() {
		//will need to get the value of the hand with getValueOfHand() and check if it is more than 21
		return false;
	}
	
	public boolean doYouHaveTwentyOne() {
		//this will check if each player has exactly twenty one - check after dealer deals first two cards and again after each turn.
		return false;
	}
	
	public void clearHand() {
		//This method will empty the hand array after each round is completed, so that a new round can begin. Perhaps a new hand object can just be created?
	}
}
