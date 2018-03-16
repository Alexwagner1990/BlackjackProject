package com.skilldistillery.cards.common;

public enum Suit {
	CLUBS("Clubs"),
	SPADES("Spades"),
	HEARTS("Hearts"),
	DIAMONDS("Diamonds");
	
	final private String name;
	
	
	Suit(String n){
		name = n;
	}
	
	public String toString() {
		return name;
	}
	
	
	
	
	
	
	
	
}
