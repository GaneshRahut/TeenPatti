package com.cards;
/* 
 * This Class Analyzes the had of all the players and rank them according to the hand
 * For example Set of Three (Trial is 1) and Straight Flush is 2 and So on.
 * 
 * @Grahut
 */
public class AnalyzeCards {
	Card[] hand;
	int handSet;
	int[] ranks = new int[3];

	public AnalyzeCards(Card[] hand) {

		this.ranks[0] = hand[0].getRank();
		this.ranks[1] = hand[1].getRank();
		this.ranks[2] = hand[2].getRank();
		
		this.sort();
		//If hand is trial

		if(hand[0].getRank() == hand[1].getRank() && hand[0].getRank() == hand[2].getRank()) {
			this.hand = hand;
			this.handSet = 1;

			//Check for Straight flush or Flush
		}else if(hand[0].getSuits().contentEquals(hand[1].getSuits()) 
				&& hand[0].getSuits().contentEquals(hand[2].getSuits())) {
		
			if(checkRun() == true) {
				this.hand = hand;
				this.handSet = 2;
			}else {
				this.hand = hand;
				this.handSet = 4;
			}

			//Check For Pair
		}else if(hand[0].getRank() == hand[1].getRank() || 
				hand[0].getRank() == hand[2].getRank() ||
				hand[1].getRank() == hand[2].getRank()) {
			this.hand = hand;
			this.handSet = 5;
		}else {
			if(checkRun() == true) {
				this.hand = hand;
				this.handSet = 3;
			}else {
				this.hand = hand;
				this.handSet = 6;
			}
		}

	}

	public boolean checkRun() {

		boolean run = false;

		if(this.ranks[2] < 14) {
			if(this.ranks[0] == this.ranks[1] - 1 
					&& this.ranks[1] == this.ranks[2] -1) {
				run = true; 
			}
		}else {
			if((this.ranks[0] == 2 && this.ranks[1] == 3) || 
					(this.ranks[0] == 12 && this.ranks[1] == 13)){
				run = true;
			}
		}


		return run;
	}

	/*
	 * Sorts the the rank to check Straight ( Run)
	 */
	public void sort() {
		for(int i = 0; i < this.ranks.length; i++) {
			for(int j = 0; j < this.ranks.length; j++) {
				if(this.ranks[i] < this.ranks[j]) {
					int temp = this.ranks[i];
					this.ranks[i] = this.ranks[j];
					this.ranks[j] = temp;
				}
			}
		}

	}

}
