package com.skilldistillery.cards.blackjack;

import java.util.Collections;
import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class Saloon {
	Scanner input = new Scanner(System.in);
	Player player = new Player("default", 0);
	Dealer dealer = new Dealer("Johnny");
	PlayerHand phand = new PlayerHand();
	DealerHand dhand = new DealerHand();

	public static void main(String[] args) {
		Saloon theGustyGultch = new Saloon();
		theGustyGultch.theSaloon();
	}

	public void theSaloon() {
		opener();
		boolean playAnotherHand = true; //this will be set to false when player gets enough $$
		while (playAnotherHand) {
			// set a wager here
			boolean dealerGetTurn = true;
			for (int i = 0; i < 2; i++) {
				Card playerCard = dealer.startAHand();
				phand.addCardToHand(playerCard);
				Card dealerCard = dealer.startAHand();
				dhand.addCardToHand(dealerCard);
			}
			System.out.println(phand);
			System.out.println(dhand);
			if (dhand.doYouHaveTwentyOne(dhand.getValueOfHand())) {
				if (phand.doYouHaveTwentyOne(phand.getValueOfHand())) {
					dhand.displayHand();
					System.out.println("Well hot damn, that's double blackjacks! Can't take yer coin this round!");
					// return the bet amount to wallet
					phand = (PlayerHand) phand.clearHandAtEndOfRound(); // CAREFUL WITH THIS - MAKES A NEW HAND OBJECT (BUT ASSIGNS IT TO ORIGINALLY CREATED HAND OBJECT)
					dhand = (DealerHand) dhand.clearHandAtEndOfRound();
					System.out.println("\n\"Alright, forget that last hand cardshark, here comes a new pair!\"\n\n");
					dealerGetTurn = false;
					continue;
				}
				dhand.displayHand();
				System.out.println("\"Sheee-yewt that hand's pretty! I'll be takin ya wager\"");
				phand = (PlayerHand) phand.clearHandAtEndOfRound(); // CAREFUL WITH THIS - MAKES A NEW HAND OBJECT (BUT ASSIGNS IT TO ORIGINALLY CREATED HAND OBJECT)
				dhand = (DealerHand) dhand.clearHandAtEndOfRound();
				System.out.println("\n\"Alright, forget that last hand cardshark, here comes a new pair!\"\n\n");
				dealerGetTurn = false;
				continue;
			}
			if (dhand.areYouBusted(dhand.getValueOfHand())) {
				System.out.println("\"Ooof, this hand's yours " + player.getName() + " but I'll getcha next hand!\"");
				phand = (PlayerHand) phand.clearHandAtEndOfRound(); // CAREFUL WITH THIS - MAKES A NEW HAND OBJECT (BUT ASSIGNS IT TO ORIGINALLY CREATED HAND OBJECT)
				dhand = (DealerHand) dhand.clearHandAtEndOfRound();
				System.out.println("\n\"Alright, forget that last hand cardshark, here comes a new pair!\"\n\n");
				dealerGetTurn = false;
				// return twice the amount bet
				continue;
			}

			if (phand.doYouHaveTwentyOne(phand.getValueOfHand())) {
				System.out.println("\"That's a good one slick, you win this time.\"");
				phand = (PlayerHand) phand.clearHandAtEndOfRound(); // CAREFUL WITH THIS - MAKES A NEW HAND OBJECT (BUT ASSIGNS IT TO ORIGINALLY CREATED HAND OBJECT)
				dhand = (DealerHand) dhand.clearHandAtEndOfRound();
				System.out.println("\n\"Alright, forget that last hand cardshark, here comes a new pair!\"\n\n");
				dealerGetTurn = false;
				// return twice wagered amount to money field.
				continue;
			}
			if (phand.areYouBusted(phand.getValueOfHand())) {
				System.out.println("\"Ya hand's too hot " + player.getName() + ", cool it down a bit next round ya?\"");
				phand = (PlayerHand) phand.clearHandAtEndOfRound(); // CAREFUL WITH THIS - MAKES A NEW HAND OBJECT (BUT ASSIGNS IT TO ORIGINALLY CREATED HAND OBJECT)
				dhand = (DealerHand) dhand.clearHandAtEndOfRound();
				System.out.println("\n\"Alright, forget that last hand cardshark, here comes a new pair!\"\n\n");
				dealerGetTurn = false;
				continue;
			}
			while (true) { // this loop is the player's turn - the loop is sustained for as long as the
							// player continues to hit, gets 21, or goes over 21.
				System.out.print("\"You wanna hit or stay " + player.getName()
						+ ", doesn't maddata me but make a decision quick\" (hit/stay):");
				if (player.hitMe(input.next())) {
					phand.addCardToHand(dealer.drawACard());
					phand.displayHand();
					if (phand.doYouHaveTwentyOne(phand.getValueOfHand())) {
						System.out.println("\"Ah, " + player.getName()
								+ ", that's twenty-one, good show sport, here's ya payout champ.\"");
						// here return double bet
						dealerGetTurn = false;
						break;
					}
					if (phand.areYouBusted(phand.getValueOfHand())) {
						System.out.println(
								"\"Oh tough break pal, that's a bust, I'll be taking that bet. Betta luck next hand friend.\"");
						dealerGetTurn = false;
						break;
					}
				} else {
					break;
				}
			} // end player while loop

			if (dealerGetTurn == true) {
				System.out.println("\"Alright I can beat that, here comes my turn guy!\"\n");
				System.out.println("\"Time for the big reveal par'ner!\"");
				dhand.displayHand();
			}
			while (dealerGetTurn == true) { // this loop is the dealer's turn. the system stays in the loop for as long
											// as
				// the dealer has a score of over 17 - different outcomes for if the dealer has
				// 21 or goes over 21
				if (dealer.hitMe(dhand.getValueOfHand())) {
					System.out.println("\"I'm gonna have to hit, lady luck gimmie a kiss!\"");
					dhand.addCardToHand(dealer.drawACard());
					dhand.displayHand();
					if (dhand.doYouHaveTwentyOne(dhand.getValueOfHand())) {
						System.out.println("\"Owch, tough break " + player.getName()
								+ ", that's twenty-one, I'll be taking that bet thankyaverymuch!\"");
						break;
					}
					if (dhand.areYouBusted(dhand.getValueOfHand())) {
						System.out.println("\"Oh, thats too much, ya got this round " + player.getName() + "!\"");
						// give back double bet
						break;
					}
				} else {
					break;
				}
			} // end dealer while loop
			if ((phand.getValueOfHand() < 21) && (dhand.getValueOfHand() < 21)) {
				phand.playerHasBetterHand(player.getName(), phand.getValueOfHand(), dhand.getValueOfHand());
			}
			phand = (PlayerHand) phand.clearHandAtEndOfRound(); // CAREFUL WITH THIS - MAKES A NEW HAND OBJECT (BUT ASSIGNS IT TO ORIGINALLY CREATED HAND OBJECT)
			dhand = (DealerHand) dhand.clearHandAtEndOfRound();

			System.out.println("\n\"Alright, forget that last hand cardshark, here comes a new pair!\"\n\n");
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
		player.setName(input.nextLine());
		System.out.println("\"Hmm. " + player.getName() + "\" he grumbles back.");
		System.out.println("His expression doesn't change as he asks, \"How much you got?\"");
		System.out.print("You reply $: ");
		player.setMoney(input.nextInt());
		System.out.println(
				"\"Hmm. Got it. No funny business. No tricks. Just blackjack\"\nThe ruffian flashes a pistol in his waistband before standing up. \nYou assumed the ruffian would be your dealer, but he motions over another wiry, trickster-looking fellow to take his place.");
		System.out.println(
				"The wiry fellow fires off a sly grin and greeting that outpaces the speed of this sleepy town - \n\""
						+ player.getName()
						+ ", is it? The name's Johnny, don't forget. I'm shufflin' up tha cawds, see, ready for some blackjack?");
		System.out.print(
				"He peeks up at me from the cards, a knowing glance that seemed to hide a secret. He flicks over a set of cards.");
		String response = "wait"; //to get the program to wait for a response
		while (response.equals("wait")) {
		response = input.nextLine();
		}
		if (response.equalsIgnoreCase("no")) {
			System.out.println(
					"I decide to find more cash some other way - this saloon seems a bit too dangerous for me");
			System.exit(0);
		} //Couldn't actually get the decision to start the game to work, but without it the program is caught up in an infinite loop. will investigate later, but will leave it in for now.
		System.out.println();
		System.out.println(
				"\"Alright, here's ya first hand, slick, and keep those Aces in your pocket!\" the words sprint off his tounge.");
		System.out.println();
		(dealer.getDeck()).shuffle();
	}// end opener

	public void getADrink() {

	}

	public void aceUpMySleeve() {

	}

	public void startABarFight() {

	}
}
