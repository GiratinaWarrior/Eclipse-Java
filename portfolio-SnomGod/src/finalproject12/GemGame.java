/** 
 * Simer Aim
 * Course: ICS 4U
 * Teacher: Mrs. McCaffery
 * Date: 2023/01/29
 * Description: This the my final project, Gem Game
 */
package finalproject12;

import java.util.LinkedList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;

public class GemGame extends Application {

	public static String maincolor = new String("-fx-background-color: gold");
	public static String buttoncolor = new String("-fx-border-color: black; -fx-background-color: white;");
	public static String buttoncolorhover = new String("-fx-border-color: white; -fx-background-color: black;");
	public static int screenWidth = 960;
	public static int screenHeight = 540;


	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		mainMenu(stage);
	}//end start

	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {

		launch(args);

	}//end main

	/** The main menu that will be shown at the start of the game
	 * @param stage
	 */
	public static void mainMenu(Stage stage)
	{

		//------------------Title Text----------------------//

		//Create the text object
		Text TitleText = new Text("Gem Game");
		TitleText.setFont(Font.font("Times New Roman", 100));
		TitleText.setFill(Color.BLACK);


		//------------------Button--------------------------//

		//Create the play button
		Button PlayButton = new Button("Play");

		PlayButton.setMinWidth(75); // Minimum width
		PlayButton.setMinHeight(50); // Minimum height
		PlayButton.setMaxWidth(150); // Maximum width
		PlayButton.setMaxHeight(100); // Maximum height
		PlayButton.setStyle(buttoncolor);
		PlayButton.setTextFill(Color.BLACK);
		PlayButton.setFont(Font.font("Times New Roman", 20));
		PlayButton.setAlignment(Pos.CENTER);

		//Set the buttons functions
		PlayButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				//start the game up
				playGame(stage);
			}//end handle

		});//end setOnAction

		//Create the controls button
		Button ControlsButton = new Button("Controls");
		ControlsButton.setMinWidth(50); // Minimum width
		ControlsButton.setMinHeight(25); // Minimum height
		ControlsButton.setMaxWidth(150); // Maximum width
		ControlsButton.setMaxHeight(75); // Maximum height
		ControlsButton.setStyle(buttoncolor);
		ControlsButton.setTextFill(Color.BLACK);
		ControlsButton.setFont(Font.font("Times New Roman", 20));
		ControlsButton.setAlignment(Pos.CENTER);

		//Set the buttons functions
		ControlsButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				//go to the controls screen
				controls(stage);
			}//end handle

		});//end setOnAction

		//Create the Exit Button
		Button ExitButton = new Button("Exit");
		ExitButton.setMinWidth(75); // Minimum width
		ExitButton.setMinHeight(50); // Minimum height
		ExitButton.setMaxWidth(150); // Maximum width
		ExitButton.setMaxHeight(100); // Maximum height
		ExitButton.setStyle(buttoncolor);
		ExitButton.setTextFill(Color.BLACK);
		ExitButton.setFont(Font.font("Times New Roman", 20));
		ExitButton.setAlignment(Pos.CENTER);

		//Set the buttons functions
		ExitButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				//exit the game
				exit(stage);
			}//end handle

		});//end setOnAction

		hovering(PlayButton);
		notHovering(PlayButton);
		hovering(ControlsButton);
		notHovering(ControlsButton);
		hovering(ExitButton);
		notHovering(ExitButton);

		//---------------Aligning the Graphics------------//

		//Align the buttons in a row to the center
		HBox Options = new HBox(PlayButton, ControlsButton, ExitButton);
		Options.setAlignment(Pos.CENTER);

		//Align the title text and the buttons into a column in the center
		VBox AllElements = new VBox(TitleText, Options);
		AllElements.setAlignment(Pos.CENTER);

		//create a group with the vbox of all of the elements in it
		Group group = new Group(AllElements);

		//put the group into a vertical box and align it to the center
		VBox vbox = new VBox(group);
		vbox.setAlignment(Pos.CENTER);
		vbox.setStyle(maincolor);

		//Create the scene with the specified graphics, screen dimensions, and background color
		Scene scene = new Scene(vbox, screenWidth, screenHeight);

		//Set and show the scene
		stage.setScene(scene);
		stage.setTitle("GemGame");
		stage.show();

	}//end stage

	/**Changes the look of the button when a mouse is hovering over it
	 * @param button is the button that can be hovered over
	 * @author 04141upw
	 */
	private static void hovering(Button button) 
	{
		//when hovering over the button
		button.setOnMouseEntered(event -> 
		{		
			button.setStyle(buttoncolorhover);
			button.setTextFill(Color.WHITESMOKE);
		}//end action
				);
	}//end hovering

	/**Changes the look of the button when a mouse is not hovering over it
	 * @param button is the button that can be hovered over
	 * @author coleu
	 */
	private static void notHovering(Button button) 
	{
		//when not hovering over the button
		button.setOnMouseExited(event -> 
		{		
			button.setStyle(buttoncolor);
			button.setTextFill(Color.BLACK);
		}//end action
				);
	}//end notHovering

	/** Exit the game
	 * @param stage
	 */
	public static void exit(Stage stage)
	{
		System.exit(0);
	}//end exit

	/** This is where the controls are shown to the player
	 * @param stage
	 */
	public static void controls(Stage stage)
	{

		//-----------------------------------------------Left Side-------------------------------------//

		//Text to tell you how to move left and right
		Text LRmove = new Text("To move left or right, press...");

		//-------------------------The control boxes---------------//

		//--------Arrow Keys--------//

		//Create the rectangle for the left arrow box
		Rectangle leftArrowRect = new Rectangle(0, 0, 50, 50);
		leftArrowRect.setFill(Color.GREY);

		//create the label on the rectangle
		Label leftArrowRect_Text = new Label("<--");
		leftArrowRect_Text.setTextFill(Color.BLACK);

		//put the box and text together
		StackPane leftArrowBox = new StackPane(leftArrowRect, leftArrowRect_Text);

		//Create the rectangle for the right arrow box
		Rectangle rightArrowRect = new Rectangle(0, 0, 50, 50);
		rightArrowRect.setFill(Color.GREY);

		//create the label on the rectangle
		Label rightArrowRect_Text = new Label("-->");
		rightArrowRect_Text.setTextFill(Color.BLACK);

		//put the box and text together
		StackPane rightArrowBox = new StackPane(rightArrowRect, rightArrowRect_Text);

		//Put the arrow key controls together
		HBox ArrowControls = new HBox(leftArrowBox, rightArrowBox);
		ArrowControls.setAlignment(Pos.CENTER);

		//------Letter Keys---------//

		//Create the rectangle for the left letter box
		Rectangle leftLetterRect = new Rectangle(0, 0, 50, 50);
		leftLetterRect.setFill(Color.GREY);

		//create the label on the rectangle
		Label leftLetterRect_Text = new Label("A");
		leftLetterRect_Text.setTextFill(Color.BLACK);

		//put the box and text together
		StackPane leftLetterBox = new StackPane(leftLetterRect, leftLetterRect_Text);

		//Create the rectangle for the right letter box
		Rectangle rightLetterRect = new Rectangle(0, 0, 50, 50);
		rightLetterRect.setFill(Color.GREY);

		//create the label on the rectangle
		Label rightLetterRect_Text = new Label("D");
		rightLetterRect_Text.setTextFill(Color.BLACK);

		//put the box and text together
		StackPane rightLetterBox = new StackPane(rightLetterRect, rightLetterRect_Text);

		//Put the letter key controls together
		HBox LetterControls = new HBox(leftLetterBox, rightLetterBox);
		LetterControls.setAlignment(Pos.CENTER);

		//--------------------------Button----------------------------//

		Button PlayButton = new Button("Play");
		PlayButton.setMinWidth(75); // Minimum width
		PlayButton.setMinHeight(50); // Minimum height
		PlayButton.setMaxWidth(150); // Maximum width
		PlayButton.setMaxHeight(100); // Maximum height
		PlayButton.setStyle(buttoncolor);
		PlayButton.setTextFill(Color.BLACK);
		PlayButton.setFont(Font.font("Times New Roman", 20));
		PlayButton.setAlignment(Pos.CENTER);

		//Set the buttons functions
		PlayButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				//start the game up
				playGame(stage);
			}//end handle

		});//end setOnAction

		//------------------------Left VBox---------------------------//

		VBox LeftRightVBox = new VBox(20);
		LeftRightVBox.getChildren().addAll(LRmove, ArrowControls, LetterControls, PlayButton);
		LeftRightVBox.setAlignment(Pos.CENTER);

		//-----------------------------------------------Right Side-------------------------------------//

		//Text to tell you how to jump
		Text jumpTxt = new Text("To jump, press...");

		//-------------------------The control boxes---------------//

		//Create the rectangle for the left arrow box
		Rectangle jumpArrowRect = new Rectangle(0, 0, 50, 50);
		jumpArrowRect.setFill(Color.GREY);

		//create the label on the rectangle
		Label jumpArrowRect_Text = new Label("^");
		jumpArrowRect_Text.setTextFill(Color.BLACK);

		//put the box and text together
		StackPane jumpArrowBox = new StackPane(jumpArrowRect, jumpArrowRect_Text);

		//Create the rectangle for the left arrow box
		Rectangle jumpLetterRect = new Rectangle(0, 0, 50, 50);
		jumpLetterRect.setFill(Color.GREY);

		//create the label on the rectangle
		Label jumpLetterRect_Text = new Label("W");
		jumpLetterRect_Text.setTextFill(Color.BLACK);

		//put the box and text together
		StackPane jumpLetterBox = new StackPane(jumpLetterRect, jumpLetterRect_Text);

		//----------------------Button-------------------------//

		//Create the Exit Button
		Button ExitButton = new Button("Exit");
		ExitButton.setMinWidth(75); // Minimum width
		ExitButton.setMinHeight(50); // Minimum height
		ExitButton.setMaxWidth(150); // Maximum width
		ExitButton.setMaxHeight(100); // Maximum height
		ExitButton.setStyle(buttoncolor);
		ExitButton.setTextFill(Color.BLACK);
		ExitButton.setFont(Font.font("Times New Roman", 20));
		ExitButton.setAlignment(Pos.CENTER);

		//Set the buttons functions
		ExitButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				//exit the game
				exit(stage);
			}//end handle

		});//end setOnAction

		//---------------------Right VBox------------------------//

		VBox JumpVBox = new VBox(20);
		JumpVBox.getChildren().addAll(jumpTxt, jumpArrowBox, jumpLetterBox, ExitButton);
		JumpVBox.setAlignment(Pos.CENTER);

		//-----------------------------------------------All Sides-------------------------------------//

		HBox allGraphic = new HBox(100);
		allGraphic.getChildren().addAll(LeftRightVBox, JumpVBox);
		allGraphic.setStyle(maincolor);
		allGraphic.setAlignment(Pos.CENTER);

		hovering(PlayButton);
		notHovering(PlayButton);
		hovering(ExitButton);
		notHovering(ExitButton);

		//Create the scene with the specified graphics, screen dimensions, and background color
		Scene scene = new Scene(allGraphic, screenWidth, screenHeight);

		//Set and show the scene
		stage.setScene(scene);
		stage.setTitle("GemGame");
		stage.show();


	}//end controls

	/** The method where the game is actually played
	 * @param stage
	 */
	public static void playGame(Stage stage)
	{

		//--------------------------------------Walls-----------------------------------//

		int floorWidth = 100;

		//Creating the wall floor
		Wall wallFloor = new Wall(0, screenHeight - floorWidth, screenWidth, floorWidth);

		//Left Wall
		Wall wallLeft = new Wall(0, 0, floorWidth, screenHeight);

		//Right Wall
		Wall wallRight = new Wall(screenWidth - floorWidth, 0, floorWidth, screenHeight);

		Group allWalls = new Group(wallFloor.getWall(), wallLeft.getWall(), wallRight.getWall());

		//------------------------------------Player-------------------------------------//

		//Create the player object
		Player player = new Player(screenWidth/2, screenHeight/2);

		//------------------------------------Timer--------------------------------------//

		//the timer for the game, starting at how long the game will last
		Duration gameDuration = Duration.seconds(40);

		Text timerText = new Text("Timer: " + String.format("%.0f", gameDuration.toSeconds()));
		timerText.setX(0);
		timerText.setY(30);
		timerText.setFill(Color.WHITE);
		timerText.setFont(Font.font(30));

		Timeline gameTimeLine = new Timeline(

				new KeyFrame(gameDuration, e -> {

					///CODE THAT RUNS WHEN TIME IS UP
					finalScore(stage, player.getScore());

				})//end KeyFrame

				);//end Timeline




		displayTimer(gameDuration, gameTimeLine, timerText);

		gameTimeLine.play();


		//------------------------------------Scene--------------------------------------//

		Group allGems = new Group();

		//Group all of the walls and players together with the main background color
		Group allGraphics = new Group(allGems, allWalls, player.getPlayer(), timerText);

		allGraphics.setStyle(maincolor);

		//Create the scene with the objects above
		Scene scene = new Scene(allGraphics, screenWidth, screenHeight, Color.ROSYBROWN);

		//Display the scene
		stage.setScene(scene);
		stage.setTitle("GemGame");
		stage.show();

		//-------------------------------------Create the Gems---------------------------------//

		LinkedList<Gem> GemList = new LinkedList<>();

		Duration gemSpawnRate = Duration.seconds(1);

		Timeline gemSpawnTimeLime = new Timeline(

				new KeyFrame(gemSpawnRate, e -> {

					//Declare the initial gem
					Gem newGem;

					//The range that the gem can spawn across the x-axis of the screen
					int xRange = 300;

					//Set the gems starting position
					int spawnX = 480 + randomRange(-xRange, xRange);
					int spawnY = -100;

					//set the amount the gem is worth
					int[] gemType = {-1, -1, 1, 1, 1, 1, 1, 1, 1};

					int rndGem = gemType[randomRange(0, gemType.length)];

					if (rndGem != -1)
					{
						newGem = new Gem(spawnX, spawnY);
						//	System.out.println("Gem made");
					}
					else
					{
						newGem = new Bomb(spawnX, spawnY);
						//	System.out.println("Bomb made");
					}

					newGem.setGemGroup(allGems);

					Platform.runLater(() -> {

						allGems.getChildren().addAll(newGem.getGem());

						GemList.add(newGem);

					});


				})//end KeyFrame

				);//end Timeline

		int numOfgems = ((int) gameDuration.toSeconds()) / ((int) gemSpawnRate.toSeconds());

		gemSpawnTimeLime.setCycleCount(numOfgems);

		gemSpawnTimeLime.play();

		int numOfFrames = 40;
		
		//Thread to make the gem move
		new Thread(() -> {

			boolean showDebug = false;

			//Repeat this section of code forever
			do
			{

				if (showDebug) System.out.println("Outside for Loop: GemList Size = " + GemList.size());

				//For every gem on screen
				for (int a = 0; a < GemList.size(); a++)
				{
					//Access the gem in the list
					Gem curGem = GemList.get(a);

					//Move the gem itself
					curGem.Move();

					//If this gem is touching the player
					if (curGem.hitPlayer(player))
					{

						player.addScore(curGem.getPoint());

						//System.out.println("Player points: " + player.getScore());

						//Remove the gem from the group
						Platform.runLater(() -> {
							allGems.getChildren().remove(curGem.getGem());
						});

						GemList.remove(a);

					}//end gem touching player


					//check if the gem is offscreen
					if (curGem.getY() + curGem.getSize() > wallFloor.getY())
					{

						//Remove the gem from the group
						Platform.runLater(() -> {
							allGems.getChildren().remove(curGem.getGem());
						});

						GemList.remove(a);
					}//end gem offscreen

					if (showDebug) System.out.println("Inside for Loop: GemList Size = " + GemList.size());


				}//end for loop

				if (showDebug) System.out.println("After for Loop: GemList Size = " + GemList.size());


				//Adjust the delay so that the code runs every several milliseconds
				try {
					Thread.sleep(numOfFrames); // Adjust the delay as needed
				} catch (InterruptedException e) {

				}

			} while (true);

		}).start();//end thread gems move




		//-------------------------Player Movement and Controls-------------------------//


		//Player movement and controls
		new Thread(() -> {

			//Loop that continously moves the player
			do
			{



				//Check if the player is touching the floor
				if (player.WallTouching(wallFloor))
				{
					//the player is no longer falling, set the corresponding variable as so
					player.setFalling(false);

					//Check if the player is jumping, and if not, set the ySpeed to be zero
					if (!player.getJumping())
					{
						player.setYspeed(0);
					}//end not jumping

				}//end touching floor

				//if the player is not on the floor, apply gravity
				else
				{
					player.applyGravity();
				}//end not on floor

				//the amount to move the player from the wall by
				int fixMarg = 5;

				//Check if the player is touching the right wall, and if so, move then away from the wall
				if (player.WallTouching(wallRight))
				{
					player.setX(player.getX() - fixMarg);
					player.setXspeed(0);
				}//end touching right wall

				//Check if the player is touching the left wall, and if so, move then away from the wall
				else if (player.WallTouching(wallLeft))
				{
					player.setX(player.getX() + fixMarg);
					player.setXspeed(0);
				}//end touching left wall

				//Continuously call the movement function
				player.Move();

				try 
				{
					//Make it so that the above code does not run every step, but every several steps
					Thread.sleep(numOfFrames);
				} 
				catch (InterruptedException e){}
			}
			while (true);

		}).start();//end player movement

		//When the player presses a button
		scene.setOnKeyPressed(event ->
		{

			//Check if the left button is pressed
			boolean leftButtonCheck = (event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.A); //? 1:0;

			//Check if the right button is pressed
			boolean rightButtonCheck = (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.D); //? 1:0;

			//Check if the jump button is pressed
			boolean jumpButtonCheck = (event.getCode() == KeyCode.UP || event.getCode() == KeyCode.W);

			///If the left button is pressed, move to the left
			if (leftButtonCheck)
			{
				//Move the player if they are not touching the left wall
				if (player.WallTouching(wallLeft) == false)
				{
					player.setXspeed(-player.walkSpeed);
				}
				//keep the player still
				else
				{
					player.setXspeed(0);
				}
			}//end left button pressed

			//If the right button is pressed, move to the right
			if (rightButtonCheck)
			{
				if (player.WallTouching(wallRight) == false)
				{
					player.setXspeed(player.walkSpeed);
				}
				else
				{
					player.setXspeed(0);
				}
			}//end right button pressed

			//If the jump button is pressed and the player is touching the floor
			if (jumpButtonCheck && player.WallTouching(wallFloor))
			{
				player.setJumping(true);
				player.Jump();
			}



		});//end player moving


		//If a key is released: the purpose of the following code is to make it so that the player only moves if a key is held down
		scene.setOnKeyReleased(event ->
		{

			//check if the left button was released
			boolean leftButtonCheck = (event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.A); //? 1:0;

			//check if the right button was released
			boolean rightButtonCheck = (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.D); //? 1:0;

			//if the left or right button was pressed, set the player to stop moving
			if (leftButtonCheck || rightButtonCheck)
			{
				player.setXspeed(0);
			}

		});//end player stop moving




	}//end playGame

	/** This function displays the time left
	 * 
	 */
	public static void displayTimer(Duration gameDuration, Timeline gameTimer, Text timerText)
	{

		Timeline remainingTimeTimer = new Timeline(

				new KeyFrame(Duration.seconds(1), e -> {

					double remainingTime = gameDuration.toSeconds() - gameTimer.getCurrentTime().toSeconds();

					timerText.setText("Timer: " + String.format("%.0f", remainingTime));

				})

				);

		remainingTimeTimer.setCycleCount((int) gameDuration.toSeconds());

		remainingTimeTimer.play();

	}//end displayTimer

	/** This function returns a random number between two parameters
	 * @param min the minimum number possible
	 * @param max the maximum number possible
	 * @return a random integer between the provided min and max
	 */
	public static int randomRange(int min, int max)
	{
		return (int)(Math.random() * (max - min) + min);
	}//end randomRange


	/** Here, the players final score is printed
	 * @param stage
	 * @param score The player final score
	 */
	public static void finalScore(Stage stage, int score)
	{
		
		Text ScoreText = new Text("Your Final Score is " + score);
		ScoreText.setFont(Font.font("Times New Roman", 100));
		ScoreText.setFill(Color.BLACK);
		
		VBox vbox = new VBox(ScoreText);
		vbox.setAlignment(Pos.CENTER);
		vbox.setStyle(maincolor);

		//Create the scene with the specified graphics, screen dimensions, and background color
		Scene scene = new Scene(vbox, screenWidth, screenHeight);

		//Set and show the scene
		stage.setScene(scene);
		stage.setTitle("GemGame");
		stage.show();

	}//end finalScore



}//end class
