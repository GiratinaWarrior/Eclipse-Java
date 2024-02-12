/** 
 * Simer Aim
 * Course: ICS 4U
 * Teacher: Mrs. McCaffery
 * Date: 2023/01/16
 * Description: This is the die class, which holds the functions for the die class
 */
package dieclasses;

import Uno.Array;

/**
 * The Die class
 */
public class Die {

	//Declare the sides and faces variables
	private int sides = 0;
	private int[] faces = new int[0];
	private int topValue;
	
	//Variable to check if the die can be rolled
	private boolean canRoll = true;
	
	//Exception errors for if the die has negative sides or a negative face
	Exception NegativeSides = new Exception("Die cannot have negative sides");
	Exception NegativeFace = new Exception("Die cannot have a negative face");
	Exception RollEmpty = new Exception("Cannot roll an empty die");
	
	/** 
	 * Empty die
	 */
	public Die() {}
	
	/**
	 * Creates a die with a specified number of sides, sets the faces to go from 1 - the number of sides
	 * @param numOfSides the number of sides the dice will have
	 * @throws Exception
	 */
	public Die(int sides) throws Exception
	{
		if  (sides >= 0)
		{
			//declare the number of sides the dice has
			this.sides = sides;
			if (sides > 0) 
			{
				this.topValue = rollDie();
			}
		}
		else
		{
			throw NegativeSides;
		}
		
		//declare the array for the individual faces
		this.faces = new int[sides];
		
		//Set the faces of the die to be values from 1 to the number of sides
		for (int a = 0; a < sides; a++)
		{
			this.faces[a] = a + 1;
		}
		
		//set the top value to be whatever is initially rolled
	
	}//end Die(sides)
	
	/** 
	 * Creates a die with a specified set of number 
	 * @param numbers the set of numbers the die will have
	 */
	public Die(int[] numbers) throws Exception
	{
		//declare the number of sides to be the length of the array of numbers
		this.sides = numbers.length;
		
		//declare the faces to be the size of the number of sides
		this.faces = new int[this.sides];
		
		//set the faces of the die to the desired array of faces
		for (int a = 0; a < numbers.length; a++)
		{
			this.faces[a] = numbers[a];
			if (numbers[a] < 0)
			{
				throw NegativeFace;
			}
		}
		
		//roll the Die to get the top value
		this.topValue = rollDie();
		
	}//end Die(numbers)
	
	/**
	 * @return the number of sides
	 */
	public int getNumOfSides()
	{
		return this.sides;
	}
	
	/**
	 * @return the array of numbers on the faces
	 */
	public int[] getNumOnFaces()
	{
		return this.faces;
	}
	
	/**
	 * @return the current number on top
	 */
	public int getTopValue()
	{
		return this.topValue;
	}
	
	/**
	 * @return if the die is enabled to be rolled
	 */
	public boolean getCanRoll()
	{
		return this.canRoll;
	}
	
	/**
	 * @param sides the new number of sides
	 */
	public void setNumOfSides(int sides) throws Exception
	{
		
		if (sides < 0)
		{
			throw NegativeSides;
		}
		
		//declare the number of sides
		this.sides = sides;
		 
		//create a new array that is a copy of the original faces of the die
		int[] oldFaces = Array.copyArray(this.faces);
		
		//make the array of faces to be a new array with the new number of sides
		this.faces = new int[sides];
		
		//if the die will have less sides than before
		if (sides < oldFaces.length)
		{
			//set the faces to be the same up to the new number of sides
			/*
			 * i.e. If a 6 sided die is changed to have 4 sides, then the new faces would be (1, 2, 3, 4)
			 * everything after 4 would be removed
			*/
			
			for (int a = 0; a < sides; a++)
			{
				this.faces[a] = oldFaces[a];
			}
		}//end if less sides
		
		//if the die will have more sides than before
		else if (sides > oldFaces.length && oldFaces.length != 0)
		{
			/*
			 *  i.e. If a 6 sided die is change to have 10 sides,
			 *  the new faces would be (1, 2, 3, 4, 5, 6, 0, 0, 0, 0)
			 *  everything after 6 is removed
			 */
			
			
			//set the faces to be the same as the old faces
			for (int a = 0; a < oldFaces.length; a++)
			{
				this.faces[a] = oldFaces[a];
			}
			
			//set the new extra faces to 0
			for (int a = oldFaces.length; a < sides; a++)
			{
				this.faces[a] =  oldFaces[oldFaces.length % 1] + a;
			}
		}//end else if more sides
		
		//if the die originally had no sides
		else if (sides > oldFaces.length && oldFaces.length == 0)
		{
			//Set the faces of the die to be values from 1 to the number of sides
			for (int a = 0; a < sides; a++)
			{
				this.faces[a] = a + 1;
			}
		}
		
	}//end setNumOfSides()
	
	/**
	 * @param faces the new numbers on the faces
	 * @throws Exception 
	 */
	public void setNumOnFaces(int[] faces) throws Exception
	{
		this.faces = Array.copyArray(faces);
		
		for (int a = 0; a < this.faces.length; a++)
		{
			if (this.faces[a] < 0)
			{
				throw NegativeFace;
			}
		}
		
		this.sides = this.faces.length;
	}

	/**
	 * @param newCanRoll the new value of the canRoll variable
	 */
	public void setCanRoll(boolean newCanRoll)
	{
		this.canRoll = newCanRoll;
	}
	
	/**
	 * @return the number randomly rolled
	 * @throws Exception 
	 */
	public int rollDie() throws Exception
	{	
		
		if (this.sides == 0)
		{
			throw RollEmpty;
		}
		
		//declare the new top value to be a random number on the die
		if (canRoll && this.faces.length > 0)
		{
			this.topValue = this.faces[(int) (Math.random() * (this.faces).length)];
		//	wasRolled = true;
		}
		else
		{
		//	wasRolled = false;
		}
		
		//return the new rolled number
		return getTopValue();//this.topValue;
		
	}//end rollDie()
	
	/**
	 *  This method prints the faces of the die
	 */
	public void showFaces()
	{
		//print out the faces
		Array.print(this.faces);
		
	}//end showFaces()
 	
	/**
	 * @param newFace the face to add the the dice
	 * @throws Exception 
	 */
	public void addFace(int newFace) throws Exception
	{
		
		if (newFace < 0)
		{
			throw NegativeFace;
		}
		
		//insert a new face to the end of the die
		this.faces = Array.insertElement(this.faces, newFace, this.faces.length);
		this.sides++;
		
	}//end addFace()
	
	/**
	 * @param newFaces the array of faces to add to the die
	 * @throws Exception 
	 */
	public void addFaces(int [] newFaces) throws Exception
	{
		//Individually insert each face onto the die
		for (int a = 0; a < newFaces.length; a++)
		{
			if (newFaces[a] < 0)
			{
				throw NegativeFace;
			}
			this.faces = Array.insertElement(this.faces, newFaces[a], this.faces.length);
			this.sides++;
		}
	}//end addFaces()
	
	/**
	 * @param oldFace the face to remove from the die
	 */
	public void removeFace(int oldFace)
	{
		//get the position of the face to be removed
		int facePos = Array.findElement(oldFace, this.faces);
		
		//if the face exists, remove it from the die
		if (facePos != -1)
		{
			this.faces = Array.deleteElement(this.faces, facePos);
			this.sides--;
		}
		
	}//end removeFace()
	
	/**
	 * This method completely removes any instance of a certain face from a die
	 * @param oldFace the face to completely erase from the die
	 */
	public void removeFaces(int oldFace)
	{
		//Loop while the face still exists
		do
		{
			//remove the face from the die
			removeFace(oldFace);
			
		}  while (faceExists(oldFace));
		
	}//end removeFaces()
	
	/**
	 * @param oldFace the original face to be replace
	 * @param newFace the new face to replace
	 * @throws Exception 
	 */
	public void replaceFace(int oldFace, int newFace) throws Exception
	{
		//get the position of the face to replace
		int oldPos = Array.findElement(oldFace, this.faces);
		
		if (newFace < 0) throw NegativeFace;
		
		//if the face exists, replace the old face with the new face
		if (oldPos != -1) Array.replaceElement(this.faces, newFace, oldPos);
			
	}//end replaceFace()

	/**
	 * @param face the face to find in a die
	 * @return boolean whether the face exists or not
	 */
	public boolean faceExists(int face)
	{
		return (Array.findElement(face, this.faces) >= 0);
	}
	
	
	
}//end Die class
