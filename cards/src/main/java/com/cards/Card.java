/**
 * 
 */
package com.cards;



/**
 * @author Grahut
 *
 */

public class Card {
	
	private String suits;
	private int rank;

	/**
	 * 
	 */
	public Card(String suit, int rank) {
		this.suits = suit;
		this.rank = rank;
	}

	public String getSuits() {
		return suits;
	}

	public void setSuits(String suits) {
		this.suits = suits;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Card [suits=" + suits + ", rank=" + rank + "]";
	}

}
