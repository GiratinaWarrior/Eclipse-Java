package other;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Drop_Dead_Game {

	public static Scanner Input = new Scanner(System.in);

	/**main Starts the game class
	 * @param args
<<<<<<< HEAD
	 * @throws InterruptedException 
	 * @author Daniel
=======
>>>>>>> refs/remotes/origin/CC2_Amir
	 */
	public static void main(String[] args) throws InterruptedException
	{
		//Colours for console
		String red = "\033[0;91m";
		String reset = "\033[0m";

		System.out.println("Welcome to " + red + "Drop Dead" + reset + "!");

		while(true)
		{
			String menuChoice = menu();

			if(menuChoice.equalsIgnoreCase("s"))
			{
				startGame();
			}//end if start game selected
			else if(menuChoice.equalsIgnoreCase("r"))
			{
				rules();
			}//end if rules selected
			else if(menuChoice.equalsIgnoreCase("q"))
			{
				System.out.println("Come again soon!");
				System.exit(0);//exits program
			}//end if quit selected
			else
			{
				String brightRed = "\033[0;31m";
				System.out.println(brightRed + "\nInvalid input" + reset);
			}//end else
		}//end while(true)

	}//end main

	/**menu Prints the menu and returns user input
	 * @return menuInput The input from the user
	 * @author Daniel
	 */
	public static String menu() 
	{
		//Prints menu
		System.out.println("\n"
				+ "█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█\r\n"
				+ "█  S - Start Game  █\r\n"
				+ "█  R - Rules       █\r\n"
				+ "█  Q - Quit        █\r\n"
				+ "█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");

		String menuInput;//Initialize variable

		System.out.print("Type in one of the options above: ");

		//collect input
		menuInput = Input.next();

		//returns input
		return menuInput;

	}//end menu

	/**startGame Starts the main loop for the game
<<<<<<< HEAD
	 * @throws InterruptedException 
	 * @author Daniel
=======
	 * 
>>>>>>> refs/remotes/origin/CC2_Amir
	 */
	public static void startGame() throws InterruptedException
	{

		//Colours for console
		String red = "\033[0;91m";
		String green = "\033[0;32m";
		String cyan = "\033[1;96m";
		String redBoldBright = "\033[1;91m";
		String redBackground = "\033[41m";
		String reset = "\033[0m";


		int numOfPlayers;

		while(true)
		{
			System.out.print("Number of players: ");

			//Collects input as string
			String numOfPlayersString = Input.next();

			try
			{
				//Convert string to integer
				numOfPlayers = Integer.parseInt(numOfPlayersString);
				if(numOfPlayers >= 2)
				{
					break;
				}//end if numOfPlayers is greater or equal to 2
				else
				{
					System.out.println("Number of players must be greater than 1");
				}//end else
			}//end try
			catch(Exception e)
			{
				String brightRed = "\033[0;31m";
				//String reset = "\033[0m";
				System.out.println(brightRed + "Not an integer value" + reset);
			}//end catch
		}//end while true

		//Initialize arrays
		int[] diceLeft = new int[numOfPlayers];
		int[] playerTotal = new int[numOfPlayers];

		String[] playerNames = new String[numOfPlayers];

		//sets all values in both arrays to 5 or 0


		for(int i = 0; i < numOfPlayers; i++)
		{
			diceLeft[i] = 5;
			playerTotal[i] = 0;
		}//end for loop



		///////////////////////
		//                   //
		//  START MAIN GAME  //
		//                   //
		///////////////////////

		for(int i = 0; i < numOfPlayers; i++)
		{

			System.out.print("\nEnter your name: ");
			playerNames[i] = Input.next();
			
			System.out.println("\n\n" + playerNames[i] + "\'s turn!");

			while(diceLeft[i] > 0)
			{

				System.out.print("\nPress a ENTER to roll dice");
				Scanner pressEnter = new Scanner(System.in);
				pressEnter.nextLine();

				int[] currentRoll = rollDice(diceLeft[i]);

				System.out.println("You rolled... ");

				//Prints dice rolled
				for(int n = 0; n < currentRoll.length; n++)
				{
					if(currentRoll[n] == 2 || currentRoll[n] == 5) 
					{
						System.out.print(redBoldBright + currentRoll[n] + reset + " ");
					}
					else
					{;
						System.out.print(cyan + currentRoll[n] + " " + reset);
					}
				}
				Thread.sleep(500);


				int numOfBadNums = checkBadNums(currentRoll);

				if(numOfBadNums > 0)
				{
					diceLeft[i] = diceLeft[i] - numOfBadNums;

					Thread.sleep(500);
					System.out.println("\nOh no! You rolled " + red + numOfBadNums + reset + " bad numbers! NO POINTS FOR YOU!");
					System.out.println("You have: " + green + playerTotal[i] + reset + " points");
					Thread.sleep(500);

				}//end if
				else
				{
					for(int t = 0; t < diceLeft[i]; t++)
					{
						playerTotal[i] += currentRoll[t];
					}//end for loop
					//Prints player score
					System.out.println("\nYou have: " + green + playerTotal[i] + reset + " points");
					Thread.sleep(500);
				}//end else

			}//end while diceLeft[i] > 0
		}//end for loop


		int[] podium = new int[numOfPlayers];

		for(int i = 0; i < numOfPlayers; i++)
		{
			podium[i] = playerTotal[i];
		}
		for(int i = 0; i < numOfPlayers; i++)
		{
			for(int f = 0; f < podium.length; f++)
			{
				if(podium[i] > podium[f])
				{
					int score1 = podium[i];
					int score2 = podium[f];

					String players1 = playerNames[i];
					String players2 = playerNames[f];

					podium[i] = score2;
					podium[f] = score1;
					playerNames[i] = players2;
					playerNames[f] = players1;
				}
			}
		}
		System.out.println(green + "\n-----PODIUM-----" + reset);
		for(int i = 0; i < numOfPlayers; i++)
		{
			System.out.println(i+1 + ". " + playerNames[i] + ": " + podium[i]);
		}



	}//end startGame

	/**checkBadNums Checks if the dice rolled have a 2 or 5
	 * @param currentRoll The array of rolled dice
	 * @return badNums The amount of twos or fives
	 * @author Daniel
	 */
	public static int checkBadNums(int [] currentRoll)
	{
		int badNums = 0;

		//for every value in array
		for(int i = 0; i < currentRoll.length; i++)
		{
			//checks if a 2 or 5 is rolled
			if(currentRoll[i] == 2 || currentRoll[i] == 5)
			{
				badNums ++;
			}
		}

		return badNums;//Returns number of 2's or 5's
	}
	
	public static void rules() {
		
		String greenColorCode = "\u001B[32m";

		String redColorCode = "\u001B[31m";

		String resetColorCode = "\u001B[0m";
        //All the rules written
        String rule1 = "1. Each player in turn rolls the five dice and scores when none of the dice thrown show a 2 or a 5.\r\n";
        String rule2 = "2. If a 2 or a 5 are not thrown, the player scores the total of the numbers rolled.\r\n";
        String rule3 = "3. If a 2 or 5 is thrown, they score nothing and put to one side all the dice showing a 2 or 5.\r\n";
        String rule4 = "4. These dice are dead and the player continues without rolling them, putting to one side any dice showing a 2 or a 5, and scoring when neither are thrown, until all the dice are eliminated.\r\n";
        String rule5 = "5. Once the final die has turned up as a 2 or a 5, the player is said to have dropped dead and it is the next player’s turn.\r\n";
        String rule6 = "6. A running tally of the player’s score is kept and the player with the highest score after every player has had a turn, wins th game\r\n";
        
        //color coded and being printed
        System.out.println(greenColorCode + rule1 + resetColorCode);
        System.out.println(redColorCode + rule2 + resetColorCode);
        System.out.println(greenColorCode + rule3 + resetColorCode);
        System.out.println(redColorCode + rule4 + resetColorCode);
        System.out.println(greenColorCode + rule5 + resetColorCode);
        System.out.println(redColorCode + rule6 + resetColorCode);


	}//end rules


	/**rollDice Randomly generate numbers between 1 and 6
	 * @param numOfDice the number of dice the player has
	 * @return dice The randomly rolled dice
	 * @author Daniel
	 */

	public static int[] rollDice(int numOfDice)
	{
		Random random = new Random();

		int[] dice = new int[numOfDice];

		for(int i = 0; i < numOfDice; i++)
		{
			dice[i] = random.nextInt(6) + 1;
		}

		return dice;
	
	}//end rollDice
	
}//end Drop_Dead_Game