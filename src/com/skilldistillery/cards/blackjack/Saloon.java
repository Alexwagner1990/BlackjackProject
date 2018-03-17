package com.skilldistillery.cards.blackjack;

import java.util.Collections;
import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class Saloon {
	Scanner input = new Scanner(System.in);
	Player player = new Player("default", 0);
	Dealer dealer = new Dealer("default");
	PlayerHand phand = new PlayerHand();
	DealerHand dhand = new DealerHand();

	public static void main(String[] args) {
		Saloon theGustyGultch = new Saloon();
		theGustyGultch.theSaloon();
	}

	public void theSaloon() {
		opener();
		boolean playAnotherHand = true;
		while (playAnotherHand) {
			// need something here to check deck array, get deck back to 52 cards if less than a certain
			// number. Maybe the check can just be done before each drawACard method?
			for (int i = 0; i < 2; i++) {
				Card playerCard = dealer.startAHand();
				phand.addCardToHand(playerCard);
				Card dealerCard = dealer.startAHand();
				dhand.addCardToHand(dealerCard);
			}
			System.out.println(phand); // test
			System.out.println(dhand); // test
			if (dhand.doYouHaveTwentyOne(dhand.getValueOfHand())) {
				if (phand.doYouHaveTwentyOne(phand.getValueOfHand())) {
					System.out.println("Both players got blackjack, that's a push");
					//return the bet amount to wallet
					continue;
				}
				System.out.println("Dealer has blackjack, house wins");
				continue;
			}
			if (dhand.areYouBusted(dhand.getValueOfHand())) {
				System.out.println("Dealer is over 21, busts");
				//return twice the amount bet
				continue;
			}

			if (phand.doYouHaveTwentyOne(dhand.getValueOfHand())) {
				System.out.println("Player has blackjack, player wins!");
				//return twice wagered amount to money field.
				continue;
			}
			if (phand.areYouBusted(dhand.getValueOfHand())) {
				System.out.println("Player has more than 21, player loses");
				continue;
			}
			System.out.println(phand.getValueOfHand()); // test
			System.out.println(dhand.getValueOfHand()); // test
			while (true) { // this loop is the player's turn - the loop is sustained for as long as the
							// player continues to hit, gets 21, or gets over 21.
				System.out.print("Would you like to hit or stay? (hit/stay)");
				if (player.hitMe(input.next())) {
					phand.addCardToHand(dealer.drawACard());
					phand.displayHand();
					System.out.println(phand.getValueOfHand()); // test
					phand.displayHand(); // test
					if (phand.doYouHaveTwentyOne(phand.getValueOfHand())) {
						System.out.println("That's 21!");
						break;
					}
					if (phand.areYouBusted(phand.getValueOfHand())) {
						System.out.println("You're over 21! That's bad!");
						break;
					}
				} else {
					break;
				}
			} // end player while loop

			while (true) { // this loop is the dealer's turn. the system stays in the loop for as long as
							// the dealer has a score of over 17 - different outcomes for if the dealer has
							// 21 or over 21
				System.out.println("Now the dealer is taking his turn");
				if (dealer.hitMe(dhand.getValueOfHand())) {
					dhand.addCardToHand(dealer.drawACard());
					System.out.println(dhand.getValueOfHand()); // test
					dhand.displayHand(); // test
					if (dhand.doYouHaveTwentyOne(dhand.getValueOfHand())) {
						System.out.println("That's 21!");
						break;
					}
					if (dhand.areYouBusted(dhand.getValueOfHand())) {
						System.out.println("You're over 21! That's bad!");
						break;
					}
				} else {
					break;
				}
			} // end dealer while loop
			if(dhand.getValueOfHand()<21 && phand.getValueOfHand()<21) {
				System.out.println("THIS IS A TEST OF THE EMERGENCY BROADCAST SYSTEM"); //test
				//Need to add something here about comparing the values of player and dealer.
			}
			phand = (PlayerHand) phand.clearHandAtEndOfRound(); //CAREFUL WITH THIS - MAKES A NEW OBJECT
			dhand = (DealerHand) dhand.clearHandAtEndOfRound(); //CAREFUL WITH THIS - MAKES A NEW OBJECT
			//flush out hands here, probably using loops. Need to look closer at why this isn't working
		} // end round loop
	}

	public void opener() {
		System.out.println(
				"The year is 1884. \nThe plains of Texas are harsh and unforgiving, and the small spit of town appearing in a haze on the horizon is a welcome sight. \nYou roll into town with nothing but the money you stole and your trusty steed.");
		System.out.println(
				"The law is hot on your heels - you need to triple your money to get a train ticket and head back east, and you need it fast.");
		System.out.println(
				"You spot a rough-looking saloon, The Gusty Gultch - the sort of place where fortunes can be won or lost over the course of a blackjack hand.");
		System.out.println("Right about now, you need to make a fortune.");
		System.out.println(
				"You sit down across a gruff looking ruffian with a deck of cards. \n\"Blackjack?\" he grunts. \n You tip your hat. \n\"Name?\"");
		System.out.print("You reply: ");
		player.setName("NEW PLAYER"); // TEST CODE DELETE WHEN DONE
		// String name = input.nextLine(); -UNCOMMENT THIS WHEN TEST DONE
		System.out.println("\"Hmm. " + player.getName() + "\" he grumbles back.");
		System.out.println("How much you got?");
		System.out.print("You reply $: ");
		int cash = 10; // TEST CODE DELETE WHEN DONE
		// int cash = input.nextInt(); -UNCOMMENT THIS WHEN TEST DONE
		System.out.println(
				"\"Hmm. Got it. No funny business. No tricks. Just blackjack\"\nThe ruffian flashes a pistol in his waistband before standing up. \nYou assumed the ruffian would be your dealer, but he motions over another wiry, trickster-looking fellow to take his place.");
		System.out.println(
				"The wiry fellow fires off a sly grin and fires off a rural Texas drawl - \n\"Hey fella, I'm shufflin' up tha cawds, see, ready for some blackjack?");

		(dealer.getDeck()).shuffle(); // shuffle deck here
	}
	
	public void getADrink() {
		
	}
	
	public void startABarFight() {
		
	}
}
