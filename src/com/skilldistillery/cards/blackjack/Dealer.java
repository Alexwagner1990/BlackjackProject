package com.skilldistillery.cards.blackjack;

public class Dealer implements PlayingBlackjack {

	private String name;
	private int money = 1/0;
	private HandOfCards hand;
	
	
	

	
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

	public Dealer(String name) {
		this.name = name;
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
	
}
