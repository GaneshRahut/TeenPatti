/**
 * 
 */
package com.cards;

/**
 * @author Grahut
 *
 */
public class Hands {
	
	private Card[][] hands;
	private int numOfPlayers;

	

	/**
	 * 
	 */
	public Hands(int numberOfPlayers) {
		this.numOfPlayers = numberOfPlayers;
		
		hands = new Card[numOfPlayers][];
		Cards decks = new Cards();
		Card[] deck = decks.getDeck();
		decks.shuffleDeck();
		
		for(int player = 0; player < numberOfPlayers; player++) 
		{
			int playerPosition = player;
			Card[] cards = new Card[3];
			cards[0] = deck[playerPosition];
			cards[1] = deck[playerPosition + numberOfPlayers];
			cards[2] = deck[playerPosition + (2* numberOfPlayers)];

			hands[player] = cards;
		}
		
	}

	public int getNumOfPlayers() {
		return numOfPlayers;
	}

	public void setNumOfPlayers(int numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
	}

	public void setHands(Card[][] hands) {
		this.hands = hands;
	}

	public Card[][] getHands() {
		return hands;
	}

	
}
