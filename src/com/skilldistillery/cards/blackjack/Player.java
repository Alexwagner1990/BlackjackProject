package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.Scanner;

public class Player implements PlayingBlackjack {
	
	private String name;
	private int money;
	private HandOfCards hand;
	Scanner input;
	
	public Player(String name, int money) {
		this.name = name;
		this.money = money;
	}
	
	public void didYouWinOrLose(int winningMoney) {
		if(this.money >= winningMoney) {
			System.out.println();
			System.out.println("You've got enough money to to skip town! You flip an extra coin to Johnny and he flashes you a wink.\nYou buy a ticket for the next train heading east, the sheriff two steps two slow!\n");
			System.exit(0);
		}
		if(this.money == 0) {
			System.out.println();
			System.out.println("You take a peek in your pocket and, to your horror, you've lost all your cash! \nJohnny gives you a \"them's the breaks!\" look as the town sherrif bursts through the saloon doors.\nYou're busted!");
			System.exit(0);
		}
	}
	public boolean placeWager(int bet) {
		if(bet > money) {
			System.out.println("\"Whoya tryin ta fool bucko? You don't have that much coin!\"");
			return false;
		}
		if(bet == 0) {
			System.out.println("\"Ya gotta bet somethin kid!\"");
			return false;
		}
		setMoney(money-bet);
		return true;
	}
	
	public void doubleDown() {
		
	}
	
	public void split() {
		
	}
	
	@Override
	public boolean hitMe(String input){
		if(input.equalsIgnoreCase("hit")) {
			return true;
		}
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


	@Override
	public boolean hitMe(int handValue) { //PLAYER WONT USE THIS
		return false; //ONLY DEALER USES THIS
	}

	@Override
	public boolean hitMe() {
		return false;
	}

}
