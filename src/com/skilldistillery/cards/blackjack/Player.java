package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

public class Player implements PlayingBlackjack {
	
	private String name;
	private int money;
	private HandOfCards hand;
	Scanner input;
	
	
	
	public Player(String name, int money) {
		
	}
	
	
	public String scannerGetInput() {
		input = new Scanner(System.in);
		return input.nextLine();
	}
	
	public int scannerGetNumber() {
		return input.nextInt();
	}
	
	public int placeWager(int bet) {
		if(bet > money) {
			System.out.println("You can't bet that much.");
			return 0;
		}
		setMoney(money-bet);
		return bet;
	}
	
	public void doubleDown() {
		
	}
	
	public void split() {
		
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
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public HandOfCards getHand() {
		return hand;
	}
	public void setHand(HandOfCards hand) {
		this.hand = hand;
	}

}
