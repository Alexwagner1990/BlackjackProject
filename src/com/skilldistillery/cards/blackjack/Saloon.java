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
			//set a wager here
			boolean dealerGetTurn = true;
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
				dealerGetTurn = false;
				continue;
			}
			if (dhand.areYouBusted(dhand.getValueOfHand())) {
				System.out.println("Dealer is over 21, busts");
				dealerGetTurn = false;
				//return twice the amount bet
				continue;
			}

			if (phand.doYouHaveTwentyOne(phand.getValueOfHand())) {
				System.out.println("Player has blackjack, player wins!");
				dealerGetTurn = false;
				//return twice wagered amount to money field.
				continue;
			}
			if (phand.areYouBusted(phand.getValueOfHand())) {
				System.out.println("Player has more than 21, player loses");
				dealerGetTurn = false;
				continue;
			}
			while (true) { // this loop is the player's turn - the loop is sustained for as long as the
							// player continues to hit, gets 21, or gets over 21.
				System.out.print("\"You wanna hit or stay " + player.getName() + ", doesn't mattata me but make a decision quick\" (hit/stay):");
				if (player.hitMe(input.next())) {
					phand.addCardToHand(dealer.drawACard());
					phand.displayHand(); //maybe change this to a sysout?
					if (phand.doYouHaveTwentyOne(phand.getValueOfHand())) {
						System.out.println("\"Ah, " + player.getName() + ", that's twenty-one, good show sport, here's ya payout champ.\"");
						//here return double bet
						dealerGetTurn = false;
						break;
					}
					if (phand.areYouBusted(phand.getValueOfHand())) {
						System.out.println("\"Oh tough break pal, that's a bust, I'll be taking that bet. Betta luck next hand friend.\"");
						dealerGetTurn = false;
						break;
					}
				} else {
					break;
				}
			} // end player while loop

			while (dealerGetTurn = true) { // this loop is the dealer's turn. the system stays in the loop for as long as
							// the dealer has a score of over 17 - different outcomes for if the dealer has
							// 21 or over 21
				System.out.println("\"Alright I can beat that, here comes my turn guy!\"");
				if (dealer.hitMe(dhand.getValueOfHand())) {
					dhand.addCardToHand(dealer.drawACard());
					dhand.displayHand(); // flesh this out - this is how I can get the dealer to display his full hand
					if (dhand.doYouHaveTwentyOne(dhand.getValueOfHand())) {
						System.out.println("\"Owch, tough break " + player.getName() + ", that's twenty-one, I'll be taking that bet thankyaverymuch!\"");
						break;
					}
					if (dhand.areYouBusted(dhand.getValueOfHand())) {
						System.out.println("\"Oh, thats too much, you got this round " + player.getName() + "!\"");
						//give back double bet
						break;
					}
				} else {
					break;
				}
			} // end dealer while loop
			if(dhand.getValueOfHand()<21 && phand.getValueOfHand()<21) {
//				System.out.println("NOBODY GOT 21 NOR BUSTED"); //test
				if(phand.getValueOfHand() > dhand.getValueOfHand()) {
					System.out.println("\"You've got " + phand.getValueOfHand() + " to my " + dhand.getValueOfHand() + ", I owe ya some dough.\"");
					//give back double bet
				}
				else if(phand.getValueOfHand() < dhand.getValueOfHand()) {
					System.out.println("\"Too bad, " + player.getName() + ", but " + phand.getValueOfHand() + " can't beat my " + dhand.getValueOfHand() + ", betta luck next hand.");
				}
				else {
					System.out.println("We both got " + dhand.getValueOfHand() + ", eh? Ah well, that's a push.");
					//give back bet
				}
			}//end non-bust or 21 comparison if statement
			phand = (PlayerHand) phand.clearHandAtEndOfRound(); //CAREFUL WITH THIS - MAKES A NEW OBJECT - I THINK THIS WORKS
			dhand = (DealerHand) dhand.clearHandAtEndOfRound(); 
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
				"The wiry fellow fires off a sly grin and greeting that outpaces the speed of the sleepy town - \n\"" + player.getName() + ", is it? The name's Johnny, don't forget. I'm shufflin' up tha cawds, see, ready for some blackjack?");
		System.out.println("He peeks up at me from the cards, a knowing glance that seemed to hide a secret. I reply: (yes/no):");
		String response = input.nextLine();
		if(response.equalsIgnoreCase("no")) {
			System.out.println("I decide to find more cash some other way - this saloon seems a bit too dangerous for me");
			System.exit(0);
		}
		System.out.println();
		System.out.println("\"Alright, here's ya first hand, slick, and keep those Aces in your pocket!\" the words sprint off his tounge.");
		System.out.println();
		(dealer.getDeck()).shuffle();
	}//end opener
	
	public void getADrink() {
		
	}
	
	public void aceUpMySleeve() {
		
	}
	
	public void startABarFight() {
		
	}
}
