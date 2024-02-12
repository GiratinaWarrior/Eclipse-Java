package Uno;

import java.util.*;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner myInput = new Scanner(System.in);
		
		int counter = 0;
		
		int dir = -1;
		
		int numOfPlayers = 5;
		
		String[] Names = {"Q", "W", "E", "R", "T"};
		
		for (int a = 0; a < 10; a++) {
			
			int PlayerTurn = Math.abs(counter % numOfPlayers + 1);
		
			System.out.println("Turn: " + PlayerTurn);
			
			if (counter < 1) {
				counter = numOfPlayers - 0;
			}
			
			counter+=dir;		
			
		}
		
	}

}