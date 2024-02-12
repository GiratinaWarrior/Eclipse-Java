/** 
 * Simer Aim
 * Course: ICS 4U
 * Teacher: Mrs. McCaffery
 * Date: 2023/01/16
 * Description: This is the die graphic class, which holds the functions for the die graphic class, which diplays the die in GUI
 */
package dieclasses;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * @author Simer Aim
 *
 */
public class DieGraphic {
	
	//initialize the variable containing the die
	Die myDie;
	
	//initialize the graphical component variables of the die
	Rectangle DieSide = new Rectangle();
	Text DieFace = new Text();
	
	//initialize the variable the checks the number of digits in the face
	boolean TwoDigit = false;
	
	//initialize the coordinate variables
	double DieX;
	double DieY;
	
	//initialize the side length and xScale variables
	double DieSize;
	double xScale = 1.5;
	
	//initialize the text to be displayed
	String DieText;
	
	//initialize the group of the graphical components
	Group FullDie;
	
//Declare spacing character spacing variables to be used for placing the text correctly
	//Single digits
	double SingleCharSpacingX = this.DieX + (this.DieSize * 3/18);
	double SingleCharSpacingY = this.DieY + (this.DieSize * 17/20);
	//Double digits
	double DoubleCharSpacingX = this.DieX + (this.DieSize * 1/12);
	double DoubleCharSpacingY = this.DieY + (this.DieSize * 17/20);
	
	///Errors for if the die has a negative face or negative sides
	Exception NegativeSides = new Exception("Die cannot have negative sides");
	Exception NegativeFace = new Exception("Die cannot have a negative face");
	
	//Error for if the die graphic has a negative size
	Exception NegativeSize = new Exception("Die cannot have a negative sidelength");
	
	Exception CannotRollEmpty = new Exception("Cannot roll an empty die");
	
	/**
	 *  Empty DieGraphic constructor
	 */
	public DieGraphic() {}
	
	/**
	 * @param newDie the dice to be displayed
	 * @param dX the x coordinate of the dice
	 * @param dY the y coordinate of the dice
	 * @param dSize the width and height of the dice
	 * @throws Exception 
	 */
	public DieGraphic(Die newDie, double dX, double dY, double dSize) throws Exception 
	{
	
//----------------------Rectangle---------------------------//
		
		if (dSize < 0)
		{
			throw NegativeSize;
		}
		
		//Set the variable for myDie to be the die in the parameters
		this.myDie = newDie;
		
		if (this.myDie.getNumOfSides() > 0) this.myDie.rollDie();
		
		//check if the current top value is a two digit number
		this.TwoDigit = Math.abs(myDie.getTopValue())/10.0 >= 1.0;
		
		//Set the size and coordinates of the Die
		this.DieSize = dSize;
		this.DieX = dX;
		this.DieY = dY;
		
		//Create the box of the  rectangle
		this.DieSide = new Rectangle(this.DieX, this.DieY, this.DieSize, this.DieSize);
		
		//if the top value is a two digit number, make the box wider
		if (this.TwoDigit)
		{
			this.DieSide.setWidth(this.DieSize * this.xScale);
		}
		
		//set the color and stroke
		this.DieSide.setFill(Color.WHITE);
		this.DieSide.setStroke(Color.BLACK);
		
//--------------------------Text---------------------------//
		
	//Declare spacing character spacing variables to be used for placing the text correctly
		//Single digits
		SingleCharSpacingX = this.DieX + (this.DieSize * 3/18);
		SingleCharSpacingY = this.DieY + (this.DieSize * 17/20);
		//Double digits
		DoubleCharSpacingX = this.DieX + (this.DieSize * 1/12);
		DoubleCharSpacingY = this.DieY + (this.DieSize * 17/20);
		
		//Declare the text that will appear on the die
		this.DieText = "" + myDie.getTopValue();
		
		//Create the text face
		this.DieFace = new Text(DoubleCharSpacingX, DoubleCharSpacingY, DieText);
		this.DieFace.setFill(Color.BLACK);
		this.DieFace.setFont(Font.font("Verdana", this.DieSize));
		 
		//reconfigure the group and update the new group
		reconfigureGroup();
		
		//update the graphical display of the die
		updateGraphic();
		
		//reconfigure the group and update the new group
		reconfigureGroup();

	}//end DieGraphic constructor
	
	/**
	 * @return the x coordinate of the die
	 */
	public double getX()
	{
		return this.DieX;
	}
	
	/**
	 * @return the y coordinate of the die
	 */
	public double getY()
	{
		return this.DieY;
	}
	
	/**
	 * @return the side length of the die
	 */
	public double getSize()
	{
		return this.DieSize;
	}

	/**
	 * @return the Die being used
	 */
	public Die getDie()
	{
		return this.myDie;
	}
	
	/**
	 * @return the Group that contains the dies graphical elements
	 */
	public Group getGraphic()
	{
		reconfigureGroup();
		return this.FullDie;
	}
	
	/**
	 * @param x the new double x coordinate of the die
	 */
	public void setX(double x) 
	{
		this.DieX = x;
	}
	
	/**
	 * @param x the new integer x coordinate of the die
	 */
	public void setX(int x) 
	{
		this.DieX = (double) x;
		updateGraphic();
	}
	
	/**
	 * @param y the new double y coordinate of the die
	 */
	public void setY(double y) 
	{
		this.DieX = y;
	}
	
	/**
	 * @param y the new integer y coordinate of the die
	 */
	public void setY(int y) 
	{
		this.DieX = (double) y;
	}

	/**
	 * @param size the new integer side length of the die
	 * @throws Exception 
	 */
	public void setSize(int size) throws Exception
	{
		if (size < 0)
		{
			throw NegativeSize;
		}
		this.DieSize = (double) size;
	}
	
	/**
	 * @param size the new double side length of the die
	 */
	public void setSize(double size) throws Exception
	{
		if (size < 0)
		{
			throw NegativeSize;
		}
		this.DieSize = size;
	}

	/**
	 *  This function updates the group by declaring a new group with the rectangle and textual elements
	 */
	public void reconfigureGroup()
	{
		//Declare the new group
		this.FullDie = new Group(this.DieSide, this.DieFace);
		
		//Check if the number is a two digit number
		if (this.TwoDigit)
		{
			//If the face is a two digit number, compress the xScale of the rectangle
			this.FullDie.setScaleX(1/this.xScale);
		}
		else
		{
			//If the face is a single digit number, reset the xScale of the rectangle
			this.FullDie.setScaleX(1);
		}
		
	}//reconfigureGroup()
	
	/**
	 * @return the number randomly rolled
	 * @throws Exception 
	 */
	public int rollDie() throws Exception
	{		
		
		//get the new top value after rolling the die
		int newTop = getDie().rollDie();
		
		//update the graphical elements
		updateGraphic();
		
		//set the new text of the face
		this.DieFace.setText("" + newTop);
		
		//return the new number
		return newTop;
		
	}//end rollDie()

	/**
	 *  This method updates the graphical elements of the die to be accurate
	 */
	public void updateGraphic()
	{
		
		//Check if the top number is a two digit number
		if (this.myDie != null)this.TwoDigit = Math.abs(myDie.getTopValue())/10.0 >= 1.0;
		
//Redeclare spacing character spacing variables to be used for placing the text correctly
		//Single digits
		SingleCharSpacingX = this.DieX + (this.DieSize * 3/18);
		SingleCharSpacingY = this.DieY + (this.DieSize * 17/20);
		//Double digits
		DoubleCharSpacingX = this.DieX + (this.DieSize * 1/12);
		DoubleCharSpacingY = this.DieY + (this.DieSize * 17/20);
		
		//set the number to offset the rectangle by
		double offSetX = this.DieSize * 0.25;//36.5;
		
		//this.DieSide.setX(this.DieX);
		
		//If the number is a single digit number
		if (!this.TwoDigit)
		{
			//Reset the location of the rectangle
			
			
			//Create the box of the  rectangle
			
			//Set the coordinates of the faces
			this.DieFace.setX(SingleCharSpacingX);
			this.DieFace.setY(SingleCharSpacingY);
			
			//reset the width of the rectangle
			this.DieSide.setWidth(this.DieSize);
			this.DieSide.setX(this.DieX);
			this.DieSide.setY(this.DieY);
			
			//reset the xScale of the Group
			if (this.FullDie != null) this.FullDie.setScaleX(1);
		}
		
		//If the number is a double digit number
		else
		{
			
			//Offset the rectangle
			this.DieSide.setLayoutX(-offSetX);
			
			//set the new coordinates of the die face
			this.DieFace.setX(DoubleCharSpacingX - offSetX);
			this.DieFace.setY(DoubleCharSpacingY);
			
			this.DieSide.setX(this.DieX);
			this.DieSide.setY(this.DieY);
			
			//update the width of the rectangle
			this.DieSide.setWidth(this.DieSize * this.xScale);
			//update the xScale of the Group
			if (this.FullDie != null) this.FullDie.setScaleX(1.0/this.xScale);
		}
		
	}//end updateGraphic()
	
	public void rollDieErrorThrow() throws Exception
	{
		throw CannotRollEmpty;
	}
	
}
//end DieGraphic class