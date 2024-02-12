package other;

import java.util.*;

import Uno.Array;

import md_array.MDArray;

public class Magic_Trick {

	public static Scanner myInput = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Initialize the mother card deck
		ArrayList<String> cards = new ArrayList<String>(Arrays.asList( "2♠", "3♠", "4♠", "5♠", "6♠", "7♠", "8♠", "9♠", "10♠", "J♠", "Q♠", "K♠", "A♠",
				"2♡", "3♡", "4♡", "5♡", "6♡", "7♡", "8♡", "9♡", "10♡", "J♡", "Q♡", "K♡", "A♡",
				"2♢", "3♢", "4♢", "5♢", "6♢", "7♢", "8♢", "9♢", "10♢", "J♢", "Q♢", "K♢", "A♢",
				"2♣", "3♣", "4♣", "5♣", "6♣", "7♣", "8♣", "9♣", "10♣", "J♣", "Q♣", "K♣", "A♣"));

		//Initialize the deck used for the magic trick
		String[] CurrentDeck = new String[21];

		//Choose the cards that will be used for the magic trick
		for (int a = 0; a < CurrentDeck.length;a++)
		{
			int randCard = (int) (Math.random( )*(cards.size()-1)) + 0;
			CurrentDeck[a] = cards.get(randCard);
			cards.remove(randCard);
		}//end for

		//Ask the user to pick a card
		System.out.println("Pick a card! Any Card! (Press enter when you've chosen)");
		
		//Print the 21 cards
		Array.print(CurrentDeck);
		
		//enter line
		myInput.nextLine();

		String chosenCard = trickLoop(CurrentDeck);

		System.out.println("Your card is " + chosenCard);		

	}//end main

	/**
	 * This method deals the cards into 3 columns of 7
	 * @param cards the deck of cards to sort
	 * @return pilesOfCards the sorted array of cards
	 */
	public static String[][] dealIntoArray(String[] cards)
	{
		//initialize the array
		String pilesOfCards[][] = new String[3][7];

		int i = 20;

		//set the elements in the multi-dimensional array
		for(int row = 0; row < 7; row++)
		{
			for(int column = 0; column < 3; column++)
			{
				pilesOfCards[column][row] = cards[i];
				i--;
			}
		}//end loop

		//return the md array
		return pilesOfCards;

	}//end dealntoArray

	/**
	 * This method has the user locate their card within the 3 columns of cards and put the cards together 3 times
	 * @param CurrentDeck the deck of 21 cards that is being used
	 * @return chosenCard the card that the user chose
	 */
	public static String trickLoop(String[] CurrentDeck)
	{

		//Debug variable to test debugging
		boolean showDebug = false;

		//String for the chosen card
		String chosenCard = "";

		//The sorted cards array
		String[][] SortedCards = null;

		//Loop to repeat 3 times
		for (int a = 0; a < 3; a++)
		{
			//Create the sorted card array
			SortedCards = dealIntoArray(CurrentDeck);

			//Print out the cards in columns
			for(int row = 0; row < 7; row++)
			{
				for(int column = 0; column< 3; column++)
				{
					System.out.print(SortedCards[column][row] + "\t");
				}
				System.out.println("");

			}//end print loop

			//ask the user which column their card is in
			System.out.println("What column is your card in?");

			//Loop while the user hasn't selected a column
			do
			{

				//user inputs a column
				String selectColumn = myInput.next();

				//if the user has selected the column, the cards all come into one deck, and the chosen column is put in the middle, collect the cards backwards
				if(selectColumn.equalsIgnoreCase("1"))
				{
					for(int j = 6; j >= 0; j--)
					{
						CurrentDeck[j] = SortedCards[1][j];
					}
					for(int j = 6; j >= 0; j--)
					{
						CurrentDeck[j+7] = SortedCards[0][j];
					}
					for(int j = 6; j >= 0; j--)
					{
						CurrentDeck[j+14] = SortedCards[2][j];
					}
					break;
				}
				else if(selectColumn.equalsIgnoreCase("2"))
				{

					for(int j = 6; j >= 0; j--)
					{
						CurrentDeck[j] = SortedCards[0][j];
					}
					for(int j = 6; j >= 0; j--)
					{
						CurrentDeck[j+7] = SortedCards[1][j];
					}
					for(int j = 6; j >= 0; j--)
					{
						CurrentDeck[j+14] = SortedCards[2][j];
					}
					break;
				}

				else if(selectColumn.equalsIgnoreCase("3"))
				{

					for(int j = 6; j >= 0; j--)
					{
						CurrentDeck[j] = SortedCards[0][j];
					}
					for(int j = 6; j >= 0; j--)
					{
						CurrentDeck[j+7] = SortedCards[2][j];
					}
					for(int j = 6; j >= 0; j--)
					{
						CurrentDeck[j+14] = SortedCards[1][j];
					}
					break;
				}
				//if the user has entered an invalid input
				else
				{
					System.out.println("Invalid Input.");
				}

			} while (true);//end loop

			//for debugging purposes, check what the whole deck looks like
			if (showDebug) 
			{
				System.out.println("//--DEBUG START--//"); 
				Array.print(CurrentDeck);
				System.out.println("//--DEBUG END--//\n"); 
			}

		}//end loop

		//set the chosen card to be the 11th card
		chosenCard = CurrentDeck[10];

		//return the chosenCard
		return chosenCard;

	}//end trickLoop

}//end class
