package com.cards;
/*
 * Simulates the teen patti and stores the data to calculate the probability of 
 * winning with specific cards.
 */
public class Simulate {
	
	private static int[][] playerPosition;
	private static Hands hands;
	
	public static int[][] getPlayerPosition() {
		
		for(int i = 0; i < playerPosition.length; i++) {
			for(int j = 0; j < playerPosition.length; j++) {
				if(playerPosition[i][0] < playerPosition[j][0] ) {
					int[] temp = playerPosition[i];
					playerPosition[i] = playerPosition[j];
					playerPosition[j] = temp;
				}
				
				
			}
		}
		
		return playerPosition;
	}



	public  void setPlayerPosition(int[][] playerPosition) {
		Simulate.playerPosition = playerPosition;
	}



	public Hands getHands() {
		return Simulate.hands;
	}



	public void setHands(Hands hand) {
		Simulate.hands = hand;
	}



	public Simulate(int numberOfPlayers) {
		simulatePlay(numberOfPlayers);
	}
	
	

	private static void simulatePlay(int numberOfPlayers) {
		Cards deckOfCard = new Cards(); 
		deckOfCard.shuffleDeck();
		
		//Card[][] hands = deckOfCard.DealCards(numberOfPlayers);
		//Simulate.hands = hands;
		Simulate.playerPosition = new int[numberOfPlayers][];
		
		Simulate.hands = new Hands(numberOfPlayers);
		
		//deckOfCard.print(hands);
		
		for(int indexOfHands = 0; indexOfHands < hands.getHands().length; indexOfHands++) {
			AnalyzeCards handReport = new AnalyzeCards(hands.getHands()[indexOfHands]);
			int[] rankAndPosition = {handReport.handSet, indexOfHands};
			Simulate.playerPosition[indexOfHands] = rankAndPosition;
			
			System.out.print(handReport.handSet);
		}
	
		
		
	}
	
}
