package com.skilldistillery.cards.common;

public enum Suit {
	CLUBS("\u2663"),
	SPADES("\u2660"),
	HEARTS("\u2665"),
	DIAMONDS("\u2666");
	
	final private String name;
	
	
	Suit(String n){
		name = n;
	}
	
	public String toString() {
		return name;
	}
	
	
	
	
	
	
	
	
}
