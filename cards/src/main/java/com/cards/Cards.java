package com.cards;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;
/* This Class works as an deck of cards. It will do few functions that 
 * can be performed with using deck of cards while playing TeenPatti.
 * 
 * @Grahut
 */
@Component
public class Cards {

	private static Card[] deck;


	public Cards() {
		
		Card[] deck = new Card[52];
		String[] suits = {"Clubs    ", "Diamonds", "Hearts  ", "Spades  "};

		int deckIndex = 0;
		for(int i = 0; i < suits.length; i++) {
			for(int j = 2; j <= 14;  j++) {
				deck[deckIndex] = new Card(suits[i], j);
				deckIndex++;
			}
		}
		Cards.deck = deck;
	}

	/*Returns the deck of cards
	 * 
	 */
	public Card[] getDeck() {
		return Cards.deck;
	}
	
	


	/* Prints cards from each players by calling printCards method.
	 * 
	 */
	public void print(Card[][] playersCards) {
		for(int i = 0; i < playersCards.length; i++) {
			printCards(playersCards[i], i);
		}
	}

	/* Prints the card on hand of each player 
	 * @position = position of player
	 * @Cards = cards on Hand
	 * */
	private static void printCards(Card[] cards, int position) {
		System.out.println("Player Position= " + position);

		for(int i = 0; i < cards.length; i++) {
			System.out.println(cards[i].getSuits() + " , " + cards[i].getRank());
		}
		System.out.println("-------------*----------------");

	}

	/* Deals Cards to given Number of Players 
	 * 
	 */
	public Card[][] DealCards(int numberOfPlayers) {
		
		Card[][] dealtCards = new Card[numberOfPlayers][];

		for(int player = 0; player < numberOfPlayers; player++) {
			int playerPosition = player;
			Card[] cards = new Card[3];
			cards[0] = deck[playerPosition];
			cards[1] = deck[playerPosition + numberOfPlayers];
			cards[2] = deck[playerPosition + (2* numberOfPlayers)];

			dealtCards[player] = cards;

		}
		return dealtCards;
	}



	/* Shuffles the deck randomly
	 * 
	 */
	public void shuffleDeck()
	{
		// If running on Java 6 or older, use `new Random()` on RHS here
		Random rnd = ThreadLocalRandom.current();
		for (int i = deck.length - 1; i > 0; i--)
		{
			int index = rnd.nextInt(i + 1);
			// Simple swap
			Card a = deck[index];
			deck[index] = deck[i];
			deck[i] = a;
		}
	}

}
