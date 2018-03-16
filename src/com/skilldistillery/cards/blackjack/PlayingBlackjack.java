package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;

public interface PlayingBlackjack {

	public boolean hitMe();
	//the return value of boolean will matter for the dealer, but not for the player - player will use user input.
	
	public boolean stay();
	//this will matter more for dealer, will "pass priority" to either dealer or player. For dealer, decision is made automatically - for player, decision based on input.
	
}
