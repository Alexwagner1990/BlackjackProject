package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;

public interface PlayingBlackjack {

	public boolean hitMe(); //DEALER USES THIS

	boolean hitMe(int handValue); //NOT SURE IF I NEED THIS YET

	boolean hitMe(String input); //PLAYER USES THIS

}
