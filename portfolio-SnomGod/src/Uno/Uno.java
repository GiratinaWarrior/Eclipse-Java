/** 
 * Simer Aim
 * Course: ICS 3U
 * Teacher: Mrs. McCaffery
 * Date: 2022/12/21
 * Description: This program is UNO with a certain number of Computers, that number being chosen by the sole player.
 */
package Uno;

import java.util.*;

public class Uno {
	
	public static void main(String[] args) {

		//Displays the opening message
		System.out.println("Welcome to Uno! \nI am your host The Puppet, and you, \nmy lucky fellow, are a guest to our \nUNO! CHAMPIONSHIP TOURNAMENT! \nOpen to professionals, and since you are the first one here, \nyou get to decide how you want your game to be played. Let’s begin shall we?\n");
		
		//Loop that repeats while the program is running
		do {
		
			//Requests the menu choice, calls Menu()
			String MenuChoice = Menu();
			//System.out.println("Menu choice entered:" + MenuChoice);
			
			//if the user entered 'p', Begin setting up and starting the game
			if (MenuChoice.equalsIgnoreCase("p")) {
				//System.out.println("in case P");
				StartGame();
				//break; //Temporary break, will not stay when the game is finished
			}
			//if the user entered 'r', display the rules
			else if (MenuChoice.equalsIgnoreCase("r")) {
				rules();
			}
			//if the user entered 'c', displays the controls
			else if (MenuChoice.equalsIgnoreCase("c")) {
				controls();
			}
			//if the user entered 'q', display a disdainful message and exit the program
			else if (MenuChoice.equalsIgnoreCase("q")) {
				System.out.println("The Puppet: Tch! Fine then, see you never...");
				System.exit(0);
			}
			//if the user entered something else, display the error message
			else {
				System.out.println("The Puppet: That option doesn't exist my guest, try again.");
			}
			
		} while (true); //end of while loop
		
	}//end main

	/* Method Name: rules()
	 * Description: Displays the rules of Uno!
	 * Parameters: N/A
	 * Returns: N/A
	 */
	public static void rules() {
		
		//Initializes scanner
		Scanner myInput = new Scanner(System.in);
		
		//The Puppet giving a message suggesting that the rules are read carefully
		System.out.println("\nHere are the rules of we will be playing with my lucky guest! Make sure you understand them, because I’m not helping you.");
		
		//The rules are printed out
		System.out.println(
				"\n\tIn the game Uno! The objective is to be the first player to get rid of all of your cards.\n" +
				"\n\tThese cards come in 5 colors, the main 4 of red, blue, yellow and green, with the 5th color black.\r\n" + 
				"\n\tThe cards of each color are labelled with either numbers or special symbols. \n\tThe numbers being from 0-9, and the 3 special types of cards being skip, Draw 2, and Reverse. \n\tThe black cards come in either Wild or Wild Draw 4. \r\n" + 
				"\n\tThe number of cards that each player starts with can vary, ideally, it is at least 5 or greater. \n\tThe rest of the cards are to be placed in a pile in the center.\n" +
				"\n\tA single card is placed in the center of the players, \n\ton this pile is where players will place their cards. \n\tA players card may be placed in the center should it match \n\teither the color or the symbol of the card in the center. \n\tIf none of the players cards can be played, they have to draw a card from the pile. \n\tThis card may not be placed even if it’s valid. \n\tWild Cards and Wild Draw 4 are exceptions that can be placed no matter what color the top card is.\n" + 
				"\n\tThe cards labelled with the numbers 0-9 will act normally and will not greatly affect play, \n\tbut the other types of cards have special effects that change the games continuation.\n" + 
				"\n\tSkip will cause the next player to lose their turn, \n\tmaking the player after them have their turn.\n" + 
				"\n\tDraw 2 will force the next player to draw 2 cards from the deck, and their turn will be lost.\n" + 
				"\n\tReverse will switch the turn order in the opposite direction. \n\tIn a 1v1 situation, this card functions as a regular card.\n" + 
				"\n\tWild card will change the color of the center card in the pile, for example, \n\tIf the center card is a green 8\n\t, and a player uses a wild card to switch to green\n\t, then only green cards and other wild cards and wild draw 4’s can be placed.\n" + 
				"\n\tWild Draw 4 forces the next player in line to draw 4 cards from the deck along with losing their turn\n\t, the player that used this card can change the color of the top card, \n\tin other words, what cards can be considered valid.\r\n" + 
				"\n\tIf a Player has 2 cards left, and is about to place 1 card down, they must call uno, \n\tif they neglect to do so before placing down their second last card, they will be forced to draw 6 cards.\r\n"
				);
				
	}//end rules()
	
	/* Method Name: controls()
	 * Description: Displays the controls of this program
	 * Parameters: N/A
	 * Returns: N/A
	 */
	public static void controls() {
		
		//The Puppet explains that this program has very strict regulations and controls
		System.out.println("\nThis tournament is very strict in how the game is played, so you will have to do the followings exactly as they are, or you’ll suffer the consequences.");
		
		//Displays the controls
		System.out.println(
				"\n\tWhen asked what card to play, type in the format ‘red9’ and not ‘red 9’ nor ‘9 red’\n" + 
				"\n\tIf you want to draw a card, type 'draw'\n" +
				"\n\tWhen you have two cards left and you place one card down, in the next line, nothing will happen, here you must type ‘uno’\n" +
				"\n\tWhen it is a computer players turn, a message akin to “Stew placed a blue0!” will be displayed, \n\twhen this is shown, to continue the game, press the enter key, until it is your turn, though you may want to pay attention to what cards they play.\n" +
				"\n\tWhen you play a wild card and are given the option to choose a color, type in lower-case only, ex. ‘Red’ is invalid, while ‘red’ is valid\n"
				);
		
	}
	
	/* Method Name: String Menu()
	 * Description: Prints the menu options and requests a choice
	 * Parameters: N/A
	 * Returns: String MenuChoice
	 */
	public static String Menu() {
		
		//Initializes Scanner
		Scanner myInput = new Scanner(System.in);
		
		//Displays the message asking for an option to be selected
		System.out.println("Select one of the following options");
		
		//Displays the options
		System.out.println("\tP - Start the game" + "\n\tR - Rules " + "\n\tC - Controls" + "\n\tQ - Quit");
		
		//Asks for the option
		System.out.print("Which option do you choose my lucky guest? ");
		
		//Input the Menu Option
		String MenuChoice = myInput.next();
		//System.out.println("Menu option in Menu Method:" + MenuChoice);
				
		//returns the MenuChoice
		return MenuChoice;
		
		
	}//end Menu
	
	/* Method Name: StartGame()
	 * Description: Sets up the game a plays the game
	 * Parameters: N/A
	 * Returns: N/A
	 */
	public static void StartGame() {
		
		//Initialize scanner
		Scanner myInput = new Scanner(System.in);
		
		//Variables for the number of players and the number of cards respectively
		int numOfPlayers = 0;
		int numOfCards = 0;
		
		//Variable for the number of times the user is annoying
		int AnnoyCounter = 0;
		
		//Choosing the number of players
		do 
		{
			//Prints the message asking how many  players are desired
			System.out.print("\nThe Puppet: How many people do you want to play with in total? ");

			//Input the number of players desired
			try {
				numOfPlayers = myInput.nextInt();
				//myInput.nextLine();
			}

			//If an error is detected
			catch (InputMismatchException e) {
				//System.out.println("In error detection");
				myInput.nextLine();
			}

			int minPlayer = 2;
			
			//If the number of players is less than 2, display a scornful message
			if (numOfPlayers < minPlayer || numOfPlayers > 10) {
				
				if (AnnoyCounter == 0) {
					System.out.println("The Puppet: You can't play like that!");
					AnnoyCounter++;
				}
				
				else if (AnnoyCounter == 1) {
					System.out.println("The Puppet: Pick a number greater than " + (minPlayer - 1) + " and less than 11");
					AnnoyCounter++;
				}
				
				else {
					System.out.println("The Puppet: You’re getting annoying, do this properly, we don’t have all day.");
				}
			}

			//If the number of players is greater than or equal to 2, exit the loop
			if (numOfPlayers >= minPlayer && numOfPlayers <= 10) {
				break;
			}

		} while (true); //end while loop

		//Choosing the number of cards
		do 
		{
			//Prints the message asking how many cards to start with
			System.out.print("\nThe Puppet: How many cards would you like to start with? (A number greater than 2 and less than 20 is recommended)");
			
			boolean detectError = false;
			
			//Input the number of players desired
			try {
				numOfCards = myInput.nextInt();
				}
					
			
			//If an error is detected
			catch (InputMismatchException e) {
				System.out.println("The Puppet: Hahaha Mr. Funny Man, it's time to remind you that this isn't the circus you work at, so stop messing around.");
				detectError = true;
				AnnoyCounter++;
				myInput.nextLine();
			}
					
			//If the number of cards is less than 2, display a scornful message
			if (numOfCards > 0 && numOfCards < 3 && detectError == false) {
				System.out.println("The Puppet: You wanna 3 second game? 'Cuz I ain't hosting one. Do this right.");
				AnnoyCounter++;
			}
			
			if (numOfCards <= 0 && detectError == false) {
				System.out.println("The Puppet: leave");
				AnnoyCounter++;
			}
			
			if (numOfCards > 20) {
				System.out.println("The Puppet: Look, I have a life outside of this even if you don't. " + numOfCards + " cards? Ditch the nonsense.");
				AnnoyCounter++;
			}
					
			//If the number of cards is greater than or equal to 2, exit the loop
			if (numOfCards >= 3 && numOfCards <= 20) {
				break;
			}
					
		} while (true); //end while loop		
		
		//Array that holds the computer players names
		String CompNames[] = new String[numOfPlayers];
		
		//Array that holds the randomly generated player names
		String RandomCompNames[] = {"Alika", "Berimoon", "Caroluna", "Dextasia", "Eonol", "Farjeridge", "Gappen", "Hapally", "Izu'ha", "Jantirm", "Kawelna", "Luminess", "Murara", "Nixiana", "Olimba", "Pacrid", "Quintess", "Ryagan", "Salminyko", "Tvyulia", "Uyi", "Valorance", "Wombei", "Xoly", "Yindiana", "Zakyarvy", "Alifarnia", "Brindot", "Calificy", "Dalam", "Erimaia", "Gorfinder", "Hilsun", "Intuwin", "Jogin-Jo", "Klamifax", "Lingeezis", "Mothena", "Njevoura", "o7", "Pjorn", "Qwelamy", "Raensomore", "Solaris", "Taka", "Uratalinol", "Vwagon", "Wvonage", "X-Sirsize", "Yinmora", "Zimporvorette", "Ayspesce", "Bindocklick", "Citapola", "Drathma", "Etuje", "Forworm", "Galamin", "Hyorjus", "Irora", "Jraquor", "Ktarma", "Lelomy", "Mintsee", "Nwekeor", "Orrowrist", "Pemokow", "Qezana", "Roedrola", "Storroado", "Tempora", "Umber", "Vramptonne", "Wisymph", "Xhalxhia", "Yggbrazil", "Zawaruud"};
		
		//Array that holds the names for if the player is Cardinal
		String CardinalCompNames[] = {"Fela", "Osana", "Tundour", "Desour", "Empyrea", "Celesta", "Etherae", "Seraph", "Aster", "Nebulai", "Novatia", "Voizatia", "M-Ankolaja", "C-Bunjenos", "H-Rzitar", "E-5131620252251919512", "Ziovirna", "Vizether", "Limborav", "Nocremja", "Warlock Jest", "Soul God Jest", "Hellzone Helix", "Xenezeatherisix", "Ancient Evil"};
		
		//Prints the message asking what the users name is
		System.out.print("\nThe Puppet: What might your name be? ");
		
		//Input the users names
		String PlayerName = myInput.next();
	
		boolean CardinalPlayer = false;
		
		if (PlayerName.equals("Cardinal")) {
			System.out.println("\nThe Puppet: yooo Cardinal, what's good? You look so different that I didn't recognize you \nIt's good that you're alright, don't worry, I've got the perfect set of opponents for you...huhuhuhuhu...");
			
			CardinalPlayer = true;
			
			//Start a loop that chooses the names of Cardinal's opponents
			for (int c = 0; c < numOfPlayers; c++) {
				
				int Rnd = (int) (Math.random() * CardinalCompNames.length);
				
				CompNames[c] = CardinalCompNames[Rnd];
				
				CardinalCompNames = Array.deleteElement(CardinalCompNames, Rnd);
				
			}//end loop
			
		}//end if Player is Cardinal
		
		//If the players is not Warlock Jest, proceed as normal
		else if (PlayerName.equals("Cardinal") == false) {

			//Loop that repeats while the user has not chosen who they wanna play against
			do
			{
				//Display the message asking if you want to play against certain people
				System.out.print("\nThe Puppet: Would you like to choose who you play against? ('y' or 'n')");

				//Input your decision
				String FoeChoice = myInput.next();

				//If the user wants to choose who they play against
				if (FoeChoice.equalsIgnoreCase("y")) {
					System.out.println("The Puppet: Tell me, who are the other " + (numOfPlayers - 1) + " you would like to play with? ");

					//The user inputs the names of those they would like to play against
					for (int e = 0; e < numOfPlayers - 1; e++) {
						CompNames[e] = myInput.next();
					}
					break; //exit the original loop
				}//end if FoeChoice = 'y'

				//If the user does not have specific people in mind
				if (FoeChoice.equalsIgnoreCase("n")) {
					//The names of the computer players are randomly generated
					for (int a = 0; a < numOfPlayers; a++) {

						int RndName = (int) (Math.random() * RandomCompNames.length);
						CompNames[a] = RandomCompNames[RndName];

						RandomCompNames = Array.deleteElement(RandomCompNames, RndName);

					}//end for loop
					break;
				}//end if FoeChoice == 'n'

				//If the user input something else
				else {

					switch(AnnoyCounter) {

					case 0: 
						System.out.println("The Puppet: It seems you've misunderstood, just type the letter 'y' for yes or the letter 'n' for no (without the apostraphes)");
						AnnoyCounter++;
						break;

					case 1:
						System.out.println("The Puppet: Please try again " + PlayerName + ".");
						AnnoyCounter++;
						break;

					default:
						System.out.println("The Puppet: I gave you two options, do this right.");
						AnnoyCounter++;
					}

				}//end else

			} while(true);

		}
		
		//2D array that holds the players decks is created
		Card Decks[][] = new Card[numOfPlayers + 0][numOfCards + 100];
		
		//Double for loop that deals the cards to each player
		for (int c = 0; c < numOfPlayers + 0; c++) {
			for (int d = 0; d < numOfCards; d++) {
				Decks[c][d] = new Card();
			}
		}
		
		//A cheat code: If the user says a certain word as their name, it will active 'god mode', and give the player all wilddraw4 cards
		if (PlayerName.equals("GodMode")) {
			
			for (int p = 0; p < numOfCards; p++) {
				Decks[0][p].setColor("");
				Decks[0][p].setType("wilddraw4");
			}
			
		//	System.out.println("\nThe Puppet: YOOOOOOOOOOOO it's Warlock Jest *whisper* here's some cheat codes for you my old friend *whisper*");
			
		}
		
		myInput.nextLine();
		
		if (CardinalPlayer == true) {
			myInput.nextLine();
		}
		
		System.out.println("\nThe Puppet: Alright " + PlayerName + ", without further ado, let's start the UNO! CHAMPIONSHIP TOURNAMENT!");
		
		//The Top Card that is placed in the center and starts the game
		Card TopCard = new Card();
		
		//The players card choice
		Card PlayerCard = new Card();
		
		//the computers card choice
		Card CompCard = new Card();
		
		//Variables that holds the value for who's turn it is
		int PlayerTurn = 0;
		
		//The direction of play order
		int PlayerDirection = 1;
		
		//counter that changes the players turn
		int TurnChanger = 0;
		
		//The next player in line
		int NextPlayer = PlayerTurn + PlayerDirection;
		
		//the previous player
		int PrePlayer = numOfPlayers + 1;
		
		boolean SpecialPlaced = false;
		
		boolean GameOver = false;
		
//		TopCard.setColor("red");
//		TopCard.setType("0");
//		
//		Decks[0][0].setColor("red");
//		Decks[0][0].setType("3");
//		
//		Decks[0][1].setColor("red");
//		Decks[0][1].setType("skip");
//		
//		Decks[1][1].setColor("green");
//		Decks[1][1].setType("skip");
//		
//		Decks[1][2].setColor("blue");
//		Decks[1][2].setType("skip");
//		
//		Decks[1][3].setColor("green");
//		Decks[1][3].setType("skip");
		
		/**
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 *
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * Loop that repeats while the game is ongoing
		 *
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		do
		{			

			PlayerTurn = Math.abs(TurnChanger % numOfPlayers + 1);
			
			if (TurnChanger < 1) {
				TurnChanger = numOfPlayers;
			}
					
			if (PlayerTurn < 1) {
				TurnChanger = 1;
				PlayerTurn = Math.abs(TurnChanger % numOfPlayers + 1);
			}
			
			//System.out.println(PlayerTurn);
			
			//If a special card that makes the next player have their turn skipped is placed
			if (SpecialPlaced == true) {
				
				//If a skip was placed
				if (TopCard.getType().equals("skip")) {
					
					switch(PlayerTurn) 
					{
					case 1:
						System.out.println("HA! " + PlayerName + " has lost their turn!");
						TurnChanger+=PlayerDirection;
						break;
					
					default:
						//System.out.println(PlayerTurn);
						System.out.println("Oh no! " + CompNames[PlayerTurn - 2] + " has lost their turn!");
						TurnChanger += PlayerDirection;
						break;
					}//end switch NextPlayer
					
						
				}//end if skip is placed
				
				//If a draw2 was placed
				else if (TopCard.getType().equals("draw2")) {
					
					switch(PlayerTurn) 
					{
					case 1:
						System.out.println("HA! " + PlayerName + " must pick up 2 cards and has lost their turn!");
						Decks[0] = DrawCard(Decks[0], 2);
						TurnChanger+=PlayerDirection;
						break;
						
					default:
						System.out.println("Oh no! " + CompNames[PlayerTurn - 2] + " must pick up 2 cards and has lost their turn!");
						TurnChanger+=PlayerDirection;
						Decks[PlayerTurn - 1] = DrawCard(Decks[PlayerTurn - 1], 2);
						break;
					}//end switch NextPlayer
					
						
				}//end if draw2 is placed
				
				//If a wilddraw4 was placed
				else if (TopCard.getType().equals("") && TopCard.getColor().equals("") == false) {
					
					switch(PlayerTurn) 
					{
					case 1:
						System.out.println("HA! " + PlayerName + " must pick up 4 cards and has lost their turn!");
						Decks[0] = DrawCard(Decks[0], 4);
						TurnChanger+=PlayerDirection;
						break;
						
					default:
						System.out.println("Oh no! " + CompNames[PlayerTurn - 2] + " must pick up 4 cards and has lost their turn!");
						TurnChanger+=PlayerDirection;
						Decks[PlayerTurn - 1] = DrawCard(Decks[PlayerTurn - 1], 4);
						break;
					}//end switch NextPlayer
					
						
				}//end if wilddraw4 is placed
				
				myInput.nextLine();
			}//end if special placed
			
			PlayerTurn = Math.abs(TurnChanger % numOfPlayers + 1);
			
			if (TurnChanger < 0) {
				TurnChanger = numOfPlayers - 1;
			}
			
			//System.out.print("\n" + PlayerTurn + ": ");
			
			/**
			 * 
			 * 
			 * 
			 * 
			 * If its the users turn
			 * 
			 * 
			 * 
			 * 
			 * */
			if (PlayerTurn == 1) {
				
				//Display the top card
				System.out.println("\nTopCard: " + TopCard.getColor() + TopCard.getType() + "\n");
				
				//Displays the players name and their cards
				System.out.print(PlayerName + ": ");
				DisplayPlayerDeck(Decks[0]);
				System.out.println("");
				
				
				//Displays the number of cards the other players have left
				for (int d = 0; d < numOfPlayers - 1; d++) {
					System.out.println(CompNames[d] + ": " + (DeckCardNum(Decks[d + 1])) + " cards");
				}
				
				//System.out.print("\n" + CompNames[d] + ": ");
				//DisplayPlayerDeck(Decks[d + 1]);
				//System.out.println("");
				
				System.out.println("");
				
				//Player chooses a card
				PlayerCard = ChoosePlayerCard(Decks[0], TopCard, numOfCards, CardinalPlayer);
				//System.out.print(" " + PlayerTurn + " ");
				
				//If the user played a card
				if (PlayerCard.getType() != "" && PlayerCard.getType() != " ") {
					//Remove the card from the players deck
					Decks[0] = RemoveCard(Decks[0], PlayerCard);
					
					//If the card is a wild variant
					if (PlayerCard.getColor() == "") {
						
						//Pick a color	
						TopCard.setColor(PlayerChooseColor());
						
						TopCard.setType("");
									
					}//end if wild
					
					//if the card is a colored card
					else {

						SpecialPlaced = false;
						
						//Set the top card to be equal to the player card
						TopCard.setColor(PlayerCard.getColor());
						TopCard.setType(PlayerCard.getType());
						
						if ((PlayerCard.getType()).equals("reverse")) {
							System.out.println(PlayerName + " changed the turn order!");
							PlayerDirection *= -1;
						}
						
					}//end if colored card
					
					//SpecialPlaced
					
				}//end if card played
				
				//if the user drew a card
				else {
					//Draw a card from the deck
					Decks[0] = DrawCard(Decks[0], 1);
					SpecialPlaced = false;
				}//end draw
				
				//variable that detects for uno, irrelevant unless the user has one card left
				String CallUno = myInput.nextLine();
				
				int PlayerNumOfCards = DeckCardNum(Decks[0]);
				
				if (PlayerNumOfCards == 1 && PlayerCard.getType() != "") {	
					//If the user placed their second last card down
					if ((PlayerCard.getType()).equals("") == false) {
						
						//If they failed to call uno
						if (CallUno.equals("uno") == false) {
							
							//The number of cards the user must pick up after failing to call uno, 6 by default
							int UnoPickUp = 6;
							
							if (CardinalPlayer == false) {
							
								//Response depends on how many times the Player annoyed The Puppet
								switch(AnnoyCounter) 
								{
								case 0:
									System.out.println("The Puppet: Oh no! " + PlayerName + " forgot to call uno! Looks like they'll have to pick up 6 cards!");
									break;
								case 1:	
									System.out.println("The Puppet: H- Oh DEAR! " + PlayerName + " has to pick up 6 cards because he's an id- forgot to call uno!");
									break;
								case 2:	
									System.out.println("The Puppet: Heh! It seems that annoying little " + PlayerName + " forgot to read the rules, 6 cards to you!" );
									break;
								case 4:
									System.out.println("The Puppet: LET'S GO! " + PlayerName + " didn't call uno do he has to pick 6 cards" );
									break;

								default:
									System.out.println("The Puppet: HYAAAAJAJAJAJAJAJA HYAAAAAJAJAJAJAJAJA! \nThePuppet: IT SUCKS TO SUCK DOESN'T IT USELESS " + PlayerName.toUpperCase() + "!\nThePuppet: AND SINCE YOU WERE SO ANNOYING, PICK UP 10 CARDS!");
									UnoPickUp = 10;
									break;
								}//end switch case
							
							}//end if Player isn't Cardinal
							
							//if the player is Cardinal
							else {
								System.out.println("The Puppet: Oh dear, it seems you've forgotten to call uno, sorry my friend, but rules are rules");
							}//end if Player is Cardinal
							
							//The user will be forced to pick up cards
							Decks[0] = DrawCard(Decks[0], UnoPickUp);
							
						}//end if uno not called
						
					}//end if last card placed
					
				}//if card placed and now on last card
					
				if ((PlayerCard.getType()).equals("skip") || (PlayerCard.getType()).equals("draw2")|| (PlayerCard.getType()).equals("wilddraw4")) {
					SpecialPlaced = true;
				}
				
				else {
					SpecialPlaced = false;
				}
				
			}//end if player 1 turn
			
			System.out.print("");
			
			/**
			 * 
			 * 
			 * 
			 * 
			 * 
			 * If its a computers turn
			 * 
			 * 
			 * 
			 * 
			 * 
			 */
			if (PlayerTurn != 1) {
				
				if (PlayerTurn != 1) {
					CompCard = ChooseComputerCard(Decks[PlayerTurn - 1], TopCard, numOfCards);
				}
					
				/**The events themselves*/
				
				//if the computer placed a colored card
				if ((CompCard.getColor()).equals("")  == false) {
					TopCard.setColor(CompCard.getColor());
					TopCard.setType(CompCard.getType());
					Decks[PlayerTurn - 1] = RemoveCard(Decks[PlayerTurn - 1], CompCard);
					//SpecialPlaced = false;
				}//end colored card placed
				
				//if the computer did not place a colored card
				if ((CompCard.getColor()).equals("")) {
					
					//if the computer chose to draw a card
					if ((CompCard.getType()).equals("")) {
						Decks[PlayerTurn - 1] = DrawCard(Decks[PlayerTurn - 1], 1);
						SpecialPlaced = false; 
					}//end computer draw card
					
					
					//if the user placed a wild variant
					else 
					{
						TopCard.setColor(ComputerChooseColor(Decks[PlayerTurn - 1], numOfCards));
						TopCard.setType("");
						Decks[PlayerTurn - 1] = RemoveCard(Decks[PlayerTurn - 1], CompCard);
					}
					
				}//end uncolored card placed
				
				int ImNotSure = 0;
				
				//If skipping card placed
				if ((CompCard.getType()).equals("draw2") || (CompCard.getType()).equals("skip") || (CompCard.getType()).equals("wilddraw4")) {
					SpecialPlaced = true;
				}//end skipping placed
				
				//else skipping not placed
				else {
					SpecialPlaced = false;
				}
				
				/**Display the events*/
				
				//myInput.nextLine();
					
				int dif = 2;
				
				String nextLine = "";
				
				//System.out.println("\n" + PlayerTurn + "\n");
				
				//if the computer placed a card
				if ((CompCard.getType()).equals("") == false) {
					
					
					System.out.print(nextLine + CompNames[PlayerTurn - dif] + " placed a " + CompCard.getColor() + CompCard.getType() + "! ");
					
					//if the computer placed a wild variant
					if ((CompCard.getColor()).equals("")) {
						System.out.print(nextLine + CompNames[PlayerTurn - dif] + " changed the color to " + TopCard.getColor() + "! ");
					}//end wild variant
					
				
				}//end computer placed card
				
				//if the computer chose to draw a card
				if ((CompCard.getType()).equals("")) {
					System.out.print(nextLine + CompNames[PlayerTurn - dif] + " drew a card from the deck! ");
				}
				
				//if the computer played a reverse
				if ((CompCard.getType()).equals("reverse")) {
					System.out.print(CompNames[PlayerTurn - dif] + " changed the turn order! ");
					PlayerDirection *= -1;
				}
				
				//counts the number of cards in a computer players deck
				int CompNumOfCards = DeckCardNum(Decks[PlayerTurn - 1]);
				
				//if the has placed a card and has one card left
				if (CompNumOfCards == 1 && (CompCard.getType()).equals("") == false) {
				
					//decides if the comp remembers to call uno
					boolean CompUnoCalled = CompCallUno();
					
					//if they fail to call uno
					if (CompUnoCalled == false) {
						System.out.println("Oh no! " + CompNames[PlayerTurn - dif] + " forgot to call uno! PICK UP SIX CARDS");
						Decks[PlayerTurn - 1] = DrawCard(Decks[PlayerTurn - 1], 6);
					}//end fail uno call
					
				}//end call uno conditions
				
			    myInput.nextLine();
				
			}//end computer turn
			
			int EmptyDeckPos = 0;
			
			do
			{
				try {
					if (Decks[PlayerTurn - 1][EmptyDeckPos] != null) {
						GameOver = false;
						break;
					}
					
				}
				
				catch (ArrayIndexOutOfBoundsException e) {
					GameOver = true;
					break;
				}
				
				if (EmptyDeckPos > Decks[PlayerTurn - 1].length) {
					GameOver = true;
					break;
				}
				
				EmptyDeckPos++;
			} while (true);
			
			if (GameOver == true) {
				break;
			}
			
			else {
				//System.out.print("NEXT: ");
				TurnChanger+=PlayerDirection;
			}
			
		} while (true); //end of the game
		
		/**
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * After the game is finished
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		String WinnerName = "";
		int PlayerCheers = 5;
		
		//System.out.println("");
		//myInput.nextLine();
		
		//switch case depending on who the winner is
		switch (PlayerTurn) 
		{
		//if the player is the winner
		case 1:
			WinnerName = PlayerName;
			
			if (CardinalPlayer == true) {
				AnnoyCounter = -1;
			}
			
			//Output depends on how annoying the player was in the beginning
			switch (AnnoyCounter) 
			{
			case 0:
				PlayerCheers = 4;
				System.out.println("The Puppet: WOW! WHAT A SPECTACULAR SERIES OF EVENTS\nAND IT LED US TO OUR WINNER\nLET'S ALL CONGRATULATE OUR CHAMPIUNO " + WinnerName.toUpperCase() + " WITH " + PlayerCheers + " LOUD CHEERS");
				System.out.print("Crowd: WOOOOOOOOOOOOOOOOOOOOOH! ");
				for (int a = 0; a < PlayerCheers; a++) {
					System.out.print(WinnerName.toUpperCase() + "! ");
				}
				break;
				
			case 1:
				PlayerCheers = 3;
				System.out.println("The Puppet: WOW! It APPEARS that " + WinnerName + " is our winner and the new Champiuno SIMER");
				System.out.print("Crowd: YEEEEEEEEAAAAAAAH! ");
				for (int a = 0; a < PlayerCheers; a++) {
					System.out.print(WinnerName.toUpperCase() + "! ");
				}
				break;
				
			case 2:
				PlayerCheers = 2;
				System.out.println("The Puppet: Ah! So " + WinnerName + " is our new champiuno huh\n, folks, do your " + PlayerCheers + " things for 'em will ya?");
				System.out.print("Crowd: LETS Goooooo.... ");
				for (int a = 0; a < PlayerCheers; a++) {
					System.out.print(WinnerName.toUpperCase() + "! ");
				}
				break;
				
			case 3:
				PlayerCheers = 1;
				System.out.println("The Puppet: ...Fine, " + WinnerName + ", you win\n, everyone please give " + PlayerCheers + " mediocre cheers." );
				System.out.print("Crowd: woohoo " + WinnerName);
				break;
				
			case 4:
				System.out.println("The Puppet: Ugh, why you, oh nevermind!\n LADIES AND GENTLEMEN, " + WinnerName + " is annoying, give him the applause they deserve!");
				System.out.println("Crowd:.........");
				System.out.println("The Puppet: Pfft, yeah that's right...");
				break;
				
				
			case -1:
				PlayerCheers = 5;
				System.out.println("The Puppet: LETS GOO Cardinal, it's been such a while, but your skill hasn't deteriorate at all.");
				System.out.println("The Puppet: LADIES AND GENTLEMEN! LET'S GIVE MY BEST FRIEND HERE 5 LOUD CHEERS! ");
				myInput.nextLine();
				for (int c = 3; c > 0; c--) {
					System.out.print(c + "! ");
					myInput.nextLine();
				}
				System.out.println("\nCARDINAL OF THE VOID! \nCARDINAL OF THE STARS! \nCARDINAL OF SPACE! \nCARDINAL OF DEATH! \nCARDINAL OF THE SOUL! ");
				break;
				
			default:
				System.out.println("The Puppet: Eeeeeewwwwwwwwwww, screw you " + WinnerName + ". \nLADIES AND GENTLEMEN! GIVE THIS WASTE OF SPACE THE BOOS HE DESERVES!");
				System.out.println("The Crowd: BOOOOOOOOOOOOOOOOOOOOOOOOO");
			}
				break;
			
		//If a computer player won
		default:
			
			WinnerName = CompNames[PlayerTurn - 2];
			int NPCheers = 4;
			
			//if the player is Cardinal
			if (CardinalPlayer == false) {
		
				System.out.println("The Puppet: LADIES AND GENTLEMEN, WE HAVE A WINNER, \nLET'S GIVE " + NPCheers + " GREAT CHEERS FOR THE NEW CHAMPIUNO " + WinnerName.toUpperCase() + "!");
				System.out.print("Crowd: WOOOOOOOOOOOOH! ");
				for (int a = 0; a < NPCheers; a++) {
					System.out.print(WinnerName.toUpperCase() + "! ");
				}
			
			}//end if player is not cardinal

			else {
				
				System.out.println("The Puppet: Good try my friend, but it seems our winner takes on a different name! \nNonetheless, " + NPCheers + " WONDERFUL CHEERS FOR THE CHAMPIUNO " + WinnerName.toUpperCase() + "!");
				System.out.print("Crowd: WOOHOOOOOOO! ");
				for (int a = 0; a < NPCheers; a++) {
					System.out.print(WinnerName.toUpperCase() + "! ");
				}
			}
			
			break;
		}//end switch case
		
		myInput.nextLine();
		
		System.out.println("\nThe Puppet: Now then ladies and gentlemen, \nthe UNO CHAMPIONSHIP TOURNAMENT is over today, but not forever, \nmaybe one of you lucky ones will be chosen to participate, \nand until next time, \nSee UNOxt Time!");
		System.out.println("The Crowd: SEE UNOXT TIME!");
		
		myInput.nextLine();
		
	}//end StartGame
		
	/* Method Name: DisplayPlayerDeck()
	 * Description: Displays the human players cards
	 * Parameters: Card [] PlayerDeck
	 * Returns: N/A
	 */
	public static void DisplayPlayerDeck(Card [] PlayerDeck) {
		
		//loop that prints out the cards
		for (int p = 0; p < PlayerDeck.length; p++) {

			try {
				System.out.print(PlayerDeck[p].getColor() + PlayerDeck[p].getType() + " ");
			}
			
			catch (NullPointerException e) {
			//	System.out.print("");
			}
				
		}//end loop
		
		
	}//end DisplayPlayerDeck
		
	/* Method Name: DisplayCard()
	 * Description: Displays the card given in the parameter
	 * Parameters: Card Play
	 * Returns: N/A
	 */
	public static void DisplayCard(Card Play) {
		
		//Prints the cards color and type together with a space at the end
		System.out.print(Play.getColor() + Play.getType() + " ");
		
	}
	
	/* Method Name: ChoosePlayerCard()
	 * Description: Where the user can choose what card to play
	 * Parameters: Card [] PlayerDeck, Card TopCard, int numOfCards
	 * Returns: Card CardPlay
	 */
	public static Card ChoosePlayerCard(Card [] PlayerDeck, Card TopCard, int numOfCards, boolean CardinalPlayer) {
		
		Scanner myInput = new Scanner(System.in);
		
		//System.out.println(CardinalPlayer);
		
		Card CardPlay = new Card();
		CardPlay.setColor("");
		CardPlay.setType("");
		
		Card DrawCard = new Card();
		DrawCard.setColor("");
		DrawCard.setType("");
		
		boolean CardFound = false;
		
		int AnnoyCounter = 0;
		
		do
		{
			
			System.out.print("\nWhat card would you like to play? ");
			
			//input the users card choice
			String CardChoice = myInput.next();
			
			//if the user chooses to draw
			if (CardChoice.equals("draw")) {
				CardPlay = DrawCard;
				break;
			}//end draw
			
			//if the user intends to play a card
			else 
			{
				
				int Pos = 0;
				
				//Finding the chosen card
				for (int a = 0; a < PlayerDeck.length; a++) {
					
					try {
						if ((PlayerDeck[a].getColor() + PlayerDeck[a].getType()).equals(CardChoice)) {
							CardFound = true;
							Pos = a;
							CardPlay = PlayerDeck[Pos];
							break;
						}//end card located
					}//end try
					
					catch (NullPointerException e) {
						
					}//end catch
					
				}//end loop
								
				//If the card was found
					if (CardFound == true) {
						
						CardPlay = PlayerDeck[Pos];
						
						//If is matches the top card
						if ((CardPlay.getColor().equals(TopCard.getColor()) || CardPlay.getType().equals(TopCard.getType())) || TopCard.getColor() == "") {
							break;
						}
						
						//if it doesn't match the top card
						else {
							
							//If the user wants to play a wild card
							if (CardChoice.equals("wild")) {
								CardPlay.setColor("");
								CardPlay.setType("wild");
								break;
							}//end if wild
						
							//If the user wants to play a wild draw 4
							else if (CardChoice.equals("wilddraw4")) {
								CardPlay.setColor("");
								CardPlay.setType("wilddraw4");
								break;
							}//end if wild draw 4
							
							else {
								
								if (CardinalPlayer == false) {	

									//check how many times the user placed an invalid card
									switch(AnnoyCounter) 
									{


									case 0:
										System.out.println("That card can't be placed! It has to be either the same color or type as the top card!");
										break;

									case 1:
										System.out.println("Same Color. Same Type");
										break;

									case 2:
										System.out.println("Please place a valid card.");
										break;

									case 3:
										System.out.println("Place a valid card.");
										break;

									case 4:
										System.out.println("You read the rules right?");
										break;

									default:
										System.out.println("Take this seriously.");
										break;


									}//end switch

								}//end if Cardinal is the user
								
								else {
									
									System.out.println("The Puppet: Wrong card my friend");
									
								}
								
							}//end else not wild
								
						}//end else not match
						
					}//end CardFound true
				
					//If the card wasn't found
					else {
					
						//If the player is just some random person
						if (CardinalPlayer == false) {
						
							switch(AnnoyCounter) 
							{

							case 5:
								//System.out.println("The Puppet: Oh you think you're funny don't ya, ya think you deserve a medal? Well here's a medal! You can pick up a card and lose a turn, and think about the consequences of your actions next time!");
								break;

							default:
								System.out.println("You dont have a card like that. Try Again.");
								break;
							}//end switch AnnoyCounter
						
						}//end if player != cardinal
						
						//if the player is Cardinal
						else {
							
							System.out.println("The Puppet: I believe you don't have a card like that my friend");
							
						}//end if player = cardinal
					
				}//end CardFound is false
				
			}//end chooses card
			
			//increases the annoy counter
			AnnoyCounter++;
			
		} while (true);
		
//		DisplayCard(CardPlay); 
//		
//		System.out.print("|");
		
		return CardPlay;
		
	}//end ChoosePlayerCard

	/* Method Name: RemoveCard()
	 * Description: The played card is removed from a deck
	 * Parameters: Card [] PlayerDeck, Card PlayerCard
	 * Returns: Card [] newArray
	 */
	public static Card [] RemoveCard(Card [] PlayerDeck, Card PlayerCard) {
		
		//declare the new card array
		Card[] NewArray = new Card[PlayerDeck.length - 1];
		
		//the position of PlayerCard in PlayerDeck[]
		int Pos = 0;
		
		//find PlayerCard in PlayerDeck[]
		for (int a = 0; a < PlayerDeck.length; a++) {
			try {
				if ((PlayerDeck[a].getColor() == PlayerCard.getColor() && PlayerDeck[a].getType() == PlayerCard.getType())) {
					Pos = a;
					break;
				}//end card
			}
			
			catch (NullPointerException e) {
				
			}
			
		}//end for
		
		//copy all the cards before the played card
		for (int b = 0; b < Pos; b++) {
			NewArray[b] = PlayerDeck[b];
		}
		
		//copy all the cards after the played card
		for (int b = Pos; b < NewArray.length; b++) {
			NewArray[b] = PlayerDeck[b + 1];
		}
		
		//returns the new Array
		return NewArray;
	
	 }//end RemoveCard
		
	/* Method Name: DrawCard()
	 * Description: Draws cards from the deck and adds them to a deck
	 * Parameters: Card [] Deck, int NumDraw
	 * Returns: Card newArray[]
	 */
	public static Card [] DrawCard(Card [] Deck, int NumDraw) {
		
		//Declare a new array that is greater than the original array by NumDraw Card's
		Card [] newArray = new Card[Deck.length + NumDraw];
		
		//fill the new array with all of the elements of the original array
		for (int a = 0; a < Deck.length; a++) {
			newArray[a] = Deck[a];
		}//end loop
		
		//add new cards to the new array
		for (int e = 0; e < NumDraw; e++) {
			newArray[Deck.length + e] = new Card();
		}
		
		//returns the new array
		return newArray;
		
	}//end DrawCard
		
	/* Method Name: PlayerChooseColor()
	 * Description: The player chooses a color after placing a form of wild card
	 * Parameters: N/A
	 * Returns: String PlayerColorChoice
	 */
	public static String PlayerChooseColor() {
		
		//Initializes scanner
		Scanner myInput = new Scanner(System.in);
		
		//Declares variable that represents the players choice of color
		String PlayerColorChoice = "";
		
		//Loop that repeats while the user is still choosing a color
		do
		{
			
			//Displays a message asking the user what color
			System.out.print("What color? ");
			
			//Player inputs their choice of color
			PlayerColorChoice = myInput.nextLine();
			
			//if the players enters a valid color (CASE SENSITIVE), break out of the do while loop
			if (PlayerColorChoice.equals("red") || PlayerColorChoice.equals("green") || PlayerColorChoice.equals("blue") || PlayerColorChoice.equals("yellow")) {
				break;
			}//end if valid
			
			//Message that points out an invalid color choice that will display if an invalid color choice is entered
			
			System.out.println("Invalid color choice.");
			
		} while(true);
		
		return PlayerColorChoice;
		
	}//end PlayerChooseColor
		
	/* Method Name: ChooseComputerCard()
	 * Description: Decides what the computer will do, and what card they will play
	 * Parameters: Card [] CompDeck, Card TopCard, int numOfCards
	 * Returns: Card CompPlay
	 */
	public static Card ChooseComputerCard(Card [] CompDeck, Card TopCard, int numOfCards) {
		
		//System.out.println("Some like it hot");
		
		//Declare the computers card of choice as draw by default
		Card CompPlay = new Card();
		CompPlay.setType("");
		CompPlay.setColor("");
		
		//The index of the card being checked
		int DeckPos = 0;
		
		//variable that represents if a regular card was found
		boolean RegularFound = false;
		
		//variable that represents if a wild card was found
		boolean WildFound = false;
		
	//	System.out.println(CompDeck.length);
		
		//loop that repeats while the computer is searching for a valid card
		do
		{
			try {
				//If a card is a valid play 
				if ((CompDeck[DeckPos].getColor()).equals(TopCard.getColor()) || (CompDeck[DeckPos].getType()).equals(TopCard.getType()) && CompDeck[DeckPos].getColor() != "") {
					CompPlay.setColor(CompDeck[DeckPos].getColor());
					CompPlay.setType(CompDeck[DeckPos].getType());
					RegularFound = true;
					break;
				}//end if valid found
			
			}
			
			catch (NullPointerException e) {
				//RegularFound = false;
				//break;
			}
			
			catch (ArrayIndexOutOfBoundsException e) {
				RegularFound = false;
				break;
			}
			
			//if the entire deck was searched
//			if (DeckPos >= CompDeck.length) {
//				RegularFound = false;
//				break;
//			}//end deck searched
			
			//Change the card that is being checked in the deck
			DeckPos++;
			
		} while (true);
		
		//If a regular card was not found
		if (RegularFound == false) {
			
			//reset the deck search index
			DeckPos = 0;
			
			//loop that repeats while the computer is searching for a wild card
			do 
			{
				
				try {
					if ((CompDeck[DeckPos].getColor()).equals("")) {
						CompPlay.setColor(CompDeck[DeckPos].getColor());
						CompPlay.setType(CompDeck[DeckPos].getType());
						WildFound = true;
						break;
					}//end if wild found
				}
				
				catch (NullPointerException e) {
					WildFound = false;
					break;
				}
					
				//if the entire deck was searched
//				if (DeckPos >= (CompDeck.length - 1) - 100) {
//					WildFound = false;
//					break;
//				}//end deck searched
				
				//check the next card in the deck
				DeckPos++;
				
			} while (true); 
			
		}//end if regular not found
		
		//If neither a regular nor a wild card are found, opt to draw a card
		if (RegularFound == false && WildFound == false) {
			CompPlay.setType("");
			CompPlay.setColor("");
		}
		
		return CompPlay;
	}//end ChooseComputerCard
		
	/* Method Name: ComputerChooseColor()
	 * Description: Decides what color the computer will choose after placing a wild variant
	 * Parameters: Card [] CompDeck, int numOfCards
	 * Returns: String ColorChoice
	 */
	public static String ComputerChooseColor(Card [] CompDeck, int numOfCards) {
		
		//declare the ColorChoice variable
		String ColorChoice = "";
		
		//count how many of each color of cards appears in the deck
		int RedTotal = Array.countElements("red", CompDeck, numOfCards);
		int BlueTotal = Array.countElements("blue", CompDeck, numOfCards);
		int GreenTotal = Array.countElements("green", CompDeck, numOfCards);
		int YellowTotal = Array.countElements("yellow", CompDeck, numOfCards);
		
		//Put the numbers into a single array
		int [] ColorTotal = {RedTotal, BlueTotal, GreenTotal, YellowTotal};
		
		//Array.print(ColorTotal);
		
		//sort the array from highest to lowest
		ColorTotal = Array.sortHighToLow(ColorTotal);
		
		//Array.print(ColorTotal);
		
		//the computers choice of color will be whatever color is dominant within its deck

		if (ColorTotal[0] == RedTotal) {
			ColorChoice = "red";
		}
		if (ColorTotal[0] == BlueTotal) {
			ColorChoice = "blue";
		}
		if (ColorTotal[0] == GreenTotal) {
			ColorChoice = "green";
		}
		if (ColorTotal[0] == YellowTotal) {
			ColorChoice = "yellow";
		}
		
		return ColorChoice;
		
	}//end ComputerChooseColor

	/* Method Name: DeckCardNum()
	 * Description: Counts the number of cards in a deck
	 * Parameters: Card [] Deck
	 * Returns: int numOfCard
	 */
	public static int DeckCardNum(Card [] Deck) {
		
		//the number of cards the deck has in it
		int numOfCard = 0;
		
		//loop that repeats as many times as the length of the deck
		for (int a = 0; a < Deck.length; a++) {
			
			//If the card at the index is not a null, the counter goes up
			if (Deck[a] != null && Deck[a].getType().equals("") == false) {
				numOfCard++;
			}//end counter increases
			
		}//end loop
		
		//returns the number of cards in the deck
		return numOfCard;
	}//end DeckCardNum
	
	/* Method Name: CompCallUno()
	 * Description: Determines whether a computer player will call uno or not
	 * Parameters: N/A
	 * Returns: boolean UnoCalled
	 */
	public static boolean CompCallUno() {
		
		//boolean for whether or not the computer called uno
		boolean UnoCalled = true;
		
		//roll a random number between 1 and 9
		int UnoRoll = (int) (Math.random() * 9) + 1;
		
		//if the number rolled is one, then the computer will fail to call uno
		if (UnoRoll == 1) {
			UnoCalled = false;
		}//end uno failure
		
		//if any other number is rolled, the computer will call uno
		else {
			UnoCalled = true;
		}//end uno success
		
		//return whether or not uno has been called
		return UnoCalled;
		
	}//end CompCallUno
	
}//end class


