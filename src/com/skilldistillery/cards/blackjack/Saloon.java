package com.skilldistillery.cards.blackjack;

import java.util.Collections;
import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class Saloon {
	Scanner input = new Scanner(System.in);
	Player player;
	Dealer dealer;
	
	public static void main(String[] args) {
		Saloon theGustyGultch = new Saloon();
		theGustyGultch.enterTheSaloon();
	}

	public void enterTheSaloon() {
		opener();
		while(true) {
			Card firstCard = dealer.dealACard();
			System.out.println(firstCard);
			
			
		}
		
	}
	
	public void opener() {
		System.out.println("The year is 1884. \nThe plains of Texas are harsh and unforgiving, and the small spit of town appearing in a haze on the horizon is a welcome sight. \nYou roll into town with nothing but the money you stole and your trusty steed.");
		System.out.println("The law is hot on your heels - you need to triple your money to get a train ticket and head back east, and you need it fast.");
		System.out.println("You spot a rough-looking saloon, The Gusty Gultch - the sort of place where fortunes can be won or lost over the course of a blackjack hand.");
		System.out.println("Right about now, you need to make a fortune.");
		System.out.println("You sit down across a gruff looking ruffian with a deck of cards. \n\"Blackjack?\" he grunts. \n You tip your hat. \n\"Name?\"");
		System.out.print("You reply: ");
		String name = input.nextLine();	
		System.out.println("Hmm. \"" + name + "\" he grumbles back.");
		System.out.println("How much you got?");
		System.out.print("You reply: ");
		int cash = input.nextInt();
		player = new Player(name, cash);
		System.out.println("\"Hmm. Got it. No funny business. No tricks. Just blackjack\"\nThe ruffian flashes a pistol in his waistband before standing up. \nYou assumed the ruffian would be your dealer, but he motions over another wiry, trickster-looking fellow to take his place.");
		System.out.println("The wiry fellow fires off a sly grin and fires off a rural Texas drawl - \n\"Hey fella, I'm shufflin' up tha cawds, see, ready for some blackjack?");
		dealer = new Dealer("Johnny"); 
		Deck deck = dealer.getDeck();
		deck.shuffle();
		dealer.setDeck(deck);
		System.out.println(deck);
	}
	
}
