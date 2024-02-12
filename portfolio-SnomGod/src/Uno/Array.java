/** 
 * Simer Aim
 * Course: ICS 3U
 * Teacher: Mrs. McCaffery
 * Date: 2022/11/16
 * Description: This class has all of the different functions for arrays
 */
package Uno;

import java.util.*;

public class Array 
{

	public static void main(String[] args) 
	{
		
//		int[] Samwitch = createRandomIntArray(5, 0, 5);
//		
//		print(Samwitch);
//		
//		Samwitch = sortHighToLow(Samwitch);
//		
//		print(Samwitch);

	}//end main

	/*
	 * Method Name: countElements
	 * Description: counts the number of times a value appears in an array
	 * Parameters: int value, int[] array
	 * Returns: int numOfElements
	 */
	public static int countElements(int value, int[] array) {
	
		//declares the variable for the number of elements that match the value
		int numOfElements = 0;
	
		//for-loop that repeats as many times as the array's total length
		for (int a = 0; a < array.length; a++) {
	
			//checks if the value is equal to the element at a certain position
			if (value == array[a]) {
				numOfElements++; 
			}//end if element found
	
		}//end loop
	
		//returns the number of elements
		return numOfElements;
	
	}//end countElements

	/*
	 * Method Name: print
	 * Description: Prints an integer array
	 * Parameters: int [] array
 	 * Returns: void
	 */
	public static void print(int [] array) {	

		//loop the prints the elements in an array on one line
		for (int i = 0; i < array.length; i++) {

			System.out.print(array[i] + " ");

		}//end loop

		//prints out an extra space for the next line
		System.out.println("");

		
	}//end print

	/*
	 * Method Name: print
	 * Description: Prints a string array
	 * Parameters: String [] array
	 * Returns: void
	 */
	public static void print(String [] array) {

		//loop the prints out each element of an array on one line
		for (int i = 0; i < array.length; i++) {

			System.out.print(array[i] + " ");

		}

		//prints out an extra space for the next line
		System.out.println("");
		
	}//end print

	/*
	 * Method Name: print
	 * Description: Prints a double array
	 * Parameters: double [] array
	 * Returns: void
	 */
	public static void print(double [] array) {

		//loop that prints out the elements of a double array on one line
		for (int i = 0; i < array.length; i++) {

			System.out.print(array[i] + " ");

		}

		//prints out an extra space for the next line
		System.out.println("");
		
	}//end print

	/*
	 * Method Name: print
	 * Description: Prints a Card array
	 * Parameters: card [] array
	 * Returns: void
	 */
	public static void print(Card [] array) {

		//loop that prints out the elements of a double array on one line
		for (int i = 0; i < array.length; i++) {

			System.out.print(array[i] + " ");

		}

		//prints out an extra space for the next line
		System.out.println("");
		
	}//end print
	
	/*
	 * Method Name: createEmptyIntArray
	 * Description: creates an empty integer array
	 * Parameters: int size
	 * Returns: int [] newArray
	 */
	public static int[] createEmptyIntArray(int size) {

		//declared a new array with a specified size
		int[] newArray = new int[size];

		//returns the new array
		return newArray;
		
	}//end createEmptyIntArray

	/*
	 * Method Name: createRandomIntArray
	 * Description: creates an integer array with random integer values
	 * Parameters: int size, int min, int max
	 * Returns: int [] newArray
	 */
	public static int[] createRandomIntArray(int size, int min, int max) {

		//declares a new array with the specificed size
		int[] newArray = new int[size];

		//loop that gives each position in an array a random number between the specificed minimum and maximum
		for (int a = 0; a < size; a++) {

			newArray[a] = (int) (Math.random() * (max - min + 1)) + min;

		}//end for loop

		//returns the new array
		return newArray;

	}//end createRandomIntArray

	/*
	 * Method Name: findMax
	 * Description: finds the position of the biggest number in an integer array
	 * Parameters: int [] array
	 * Returns: int position
	 */
	public static int findMax(int [] array) {

		//declares the position variable, set to 0
		int position = 0;

		//creates a num variable that is set to the arrays first value
		int num = array[0];

		//loop that repeats as many times as the length of the array
		for  (int a = 0; a  < array.length; a++) {

			//checks if num is less than the number at the given position of the array
			if (num < array[a]) {
				num = array[a]; //if the number is smaller, then it becomes the number at that position, while the position variable is set to that position
				position = a;
			}//end findMax check

		}//end loop

		//returns the position
		return position;
	}//end findMax

	/*
	 * Method Name: findMin
	 * Description: finds the position of the smallest number in an integer array
	 * Parameters: int [] array
	 * Returns: int position
	 */
	public static int findMin(int [] array) {

		//declares the position variable
		int position = 0;

		//creates a num variable that is set to the arrays first value
		int num = array[0];

		//loop that repeats as many times as the length of the array
		for  (int a = 0; a  < array.length; a++) {

			//checks if num is bigger than the number at the given position of the array
			if (num > array[a]) {
				num = array[a];  //if the number is bigger, then it becomes the number at that position, while the position variable is set to that position
				position = a;
			}//end findMin check

		}//end loop

		//returns the position
		return position;
		
	}//end findMin

	/*
	 * Method Name: swapElements
	 * Description: swaps two elements' position in an integer array
	 * Parameters: int [] array, int position1, int position2
	 * Returns: void
	 */
	public static void swapElements(int [] array, int position1, int position2) {

		//declares a new variable that will be the medium for swapping the elements, set to be equal to position2
		int position3 = array[position2];

		//makes the element at position2 equal to the element at position1
		array[position2] = array[position1];

		//makes the element at position1 equal to the original value of the element at position2
		array[position1] = position3;

	}//end swapElements

	/*
	 * Method Name: swapElements
	 * Description: swaps two elements' position in an integer array
	 * Parameters: double [] array, int position1, int position2
	 * Returns: void
	 */
	public static void swapElements(double [] array, int position1, int position2) {

		//declares a new variable that will be the medium for swapping the elements, set to be equal to position2
		double position3 = array[position2];

		//makes the element at position2 equal to the element at position1
		array[position2] = array[position1];

		//makes the element at position1 equal to the original value of the element at position2
		array[position1] = position3;

	}//end swapElements

	/*
	 * Method Name: swapElements
	 * Description: swaps two elements' position in an integer array
	 * Parameters: String [] array, int position1, int position2
	 * Returns: void
	 */
	public static void swapElements(String [] array, int position1, int position2) {

		//declares a new variable that will be the medium for swapping the elements, set to be equal to position2
		String position3 = array[position2];

		//makes the element at position2 equal to the element at position1
		array[position2] = array[position1];

		//makes the element at position1 equal to the original value of the element at position2
		array[position1] = position3;

	}//end swapElements

	/*
	 * Method Name: findElement
	 * Description: finds the position of the give element in an array
	 * Parameters: int value, int[] array
	 * Returns: int position
	 */
	public static int findElement(int value, int[] array) {

		//declares the position variable
		int position = 0;

		//declares the variable that checks if the loop continues
		boolean loopContinue = true;

		//loop that repeats while the program is searching for an element
		do
		{

			try
			{
				
				//checks if the given value is equal to the element at the given position 
				if (value == array[position]) {
					loopContinue = false; //ends the loop
				}//end if value is array[position]

				//if the value is not equal to the element at the given position
				else {

					//checks if the position is greater than or equal to the arrays total length
					if (position >= array.length) {
						loopContinue = false; //ends the loop
					}//if pos >= length

					//if the position is less than the arrays total length
					else {
						position++; //raises the positon variable by one in order to redo the program
					}//else not pos >= length

				}//end if value is not array[pos]

			}//end try

			//catches an error if the element is not found
			catch (ArrayIndexOutOfBoundsException e) {
				loopContinue = false; //ends the loop
				position = -1; //sets the position to -1
			}//end catch outofbounds

		} while(loopContinue == true);

		//returns the position
		return position;
		
	}//end findElement

	/*
	 * Method Name: findElement
	 * Description: finds the position of the give element in an array
	 * Parameters: String value, String [] array
	 * Returns: int position
	 */
	public static int findElement(String value, String [] array) {

		//declares the position variable
		int position = 0;

		//declares the variable that checks if the loop continues
		boolean loopContinue = true;

		//loop that repeats while the program is searching for an element
		do
		{

			try
			{
				
				//checks if the given value is equal to the element at the given position 
				if (value.equals(array[position])) {
					loopContinue = false; //ends the loop
				}//end if value is array[position]

				//if the value is not equal to the element at the given position
				else {

					//checks if the position is greater than or equal to the arrays total length
					if (position >= array.length) {
						loopContinue = false; //ends the loop
					}//if pos >= length

					//if the position is less than the arrays total length
					else {
						position++; //raises the positon variable by one in order to redo the program
					}//else not pos >= length

				}//end if value is not array[pos]

			}//end try

			//catches an error if the element is not found
			catch (ArrayIndexOutOfBoundsException e) {
				loopContinue = false; //ends the loop
				position = -1; //sets the position to -1
			}//end catch outofbounds

		} while(loopContinue == true);

		//returns the position
		return position;
		
	}//end findElement

	/*
	 * Method Name: countElements
	 * Description: counts the number of times a value appears in an array
	 * Parameters: String value, Card[] array
	 * Returns: int numOfElements
	 */
	public static int countElements(String value, Card[] array, int numOfCards) {

		//declares the variable for the number of elements that match the value
		int numOfElements = 0;

		//for-loop that repeats as many times as the array's total length
		for (int a = 0; a < array.length; a++) {

			try {
				//checks if the value is equal to the element at a certain position
				if ((array[a].getColor()).equals(value)) {
					numOfElements++; 
				}//end if element found
			}
			
			catch (NullPointerException e) {
				break;
			}
				
				
		}//end loop

		//returns the number of elements
		return numOfElements;

	}//end countElements
	
	/*
	 * Method Name: copyArray
	 * Description: creates a new array with the same elements in the same positions as the original array
	 * Parameters: int [] originalArray
	 * Returns: int [] newArray
	 */
	public static int[] copyArray(int [] originalArray) {

		//declares a new array with the same length as the original array
		int[] newArray = new int[originalArray.length];

		//loop that repeats as many times as the arrays length
		for (int a = 0; a < originalArray.length; a++) {

			//makes the elements of the newArray the same as the elements of the old array
			newArray[a] = originalArray[a];

		}//end loop

		//returns the copy of the array
		return newArray;
		
	}//end copyArray

	/*
	 * Method Name: copyArray
	 * Description: creates a new array with the same elements in the same positions as the original array
	 * Parameters: double [] originalArray
	 * Returns: double [] newArray
	 */
	public static double[] copyArray(double [] originalArray) {

		//declares a new array with the same length as the original array
		double[] newArray = new double[originalArray.length];

		//loop that repeats as many times as the arrays length
		for (int a = 0; a < originalArray.length; a++) {

			//makes the elements of the newArray the same as the elements of the old array
			newArray[a] = originalArray[a];

		}//end loop

		//returns the copy of the array
		return newArray;
		
	}//end copyArray
	
	/*
	 * Method Name: copyArray
	 * Description: creates a new array with the same elements in the same positions as the original array
	 * Parameters: String [] originalArray
	 * Returns: String [] newArray
	 */
	public static String[] copyArray(String [] originalArray) {

		//declares a new array with the same length as the original array
		String[] newArray = new String[originalArray.length];

		//loop that repeats as many times as the arrays length
		for (int a = 0; a < originalArray.length; a++) {

			//makes the elements of the newArray the same as the elements of the old array
			newArray[a] = originalArray[a];

		}//end loop

		//returns the copy of the array
		return newArray;
		
	}//end copyArray

	/*
	 * Method Name: checkIfCopy
	 * Description: checks if two arrays have the same values in the same positions
	 * Parameters: int [] array1, int [] array2
	 * Returns: boolean isCopy
	 */
	public static boolean checkIfCopy(int [] array1, int [] array2) {

		//declares the boolean variable that checks if the second array is a copy of the first
		boolean isCopy = false;

		//the position of an element
		int element = 0;

		//the boolean variable the checks if the loop should continue
		boolean loopContinue = false;

		//checks if the two arrays have the same length
		if (array1.length == array2.length) {

			//loop that repeats while the elements are currently the same
			do
			{

				try {
					
					//if the element in a position in the first array is the same as the element at the same position of the second array
					if (array1[element] == array2[element]) {

						//the loop will continue to check the other elements
						loopContinue = true;

						element++;


					}//end if

					//if the elements are different, the loop will end and isCopy will be set to false as the arrays are not copies
					else {

						loopContinue = false;
						isCopy = false;

					}//end else

				}//end try

				//catches an out of bounds error, ends the loop and declares isCopy as true
				catch (ArrayIndexOutOfBoundsException e) {

					loopContinue = false;
					isCopy = true;

				}//end catch


			} while (loopContinue == true);

		}//end if the arrays are the same length

		//return isCopy
		return isCopy;
		
	}//end checkIfCopy

	/*
	 * Method Name: checkIfIdentical
	 * Description: checks if two arrays have the same memory storage location
	 * Parameters: int [] array1, int [] array2
	 * Returns: boolean identical
	 */
	public static boolean checkIfIdentical(int [] array1, int [] array2) {

		//declares the variable for if the arrays have the same location in memory
		boolean identical = false;

		//checks if the arrays are the same
		if (array1 == array2) {
			identical = true;
		}//end if identical

		return identical;
		
	}//end checkIfIdentical

	/*
	 * Method Name: replaceElement
	 * Description: replaces an element at a certain position in an array with a different value
	 * Parameters: int [] array, int value, int position
	 * Returns: void
	 */
	public static void replaceElement(int [] array, int value, int position) {

		//sets the element at a certain position in an array with the given value
		array[position] = value;

	}//end replaceElement

	/*
	 * Method Name: replaceElements
	 * Description:  replaces multiple elements in an array with a give value
	 * Parameters: int [] array, int originalValue, int newValue
	 * Returns: void
	 */
	public static void replaceElements(int [] array, int originalValue, int newValue) {

		//loop that repeats as many
		for (int a = 0; a < array.length; a++) {

			if (array[a] == originalValue) {
				array[a] = newValue;
			}

		}//end loop

	}//end replaceElements

	/*
	 * Method Name: insertElement
	 * Description: inserts a new element into the given position of the array, moves the elements in a later position accordingly
	 * Parameters: int [] originalArray, int value, int position
	 * Returns: int [] newArray
	 */
	public static int[] insertElement(int [] originalArray, int value, int position) {

		//declares a new array that is one more element greater than the original array
		int[] newArray = new int[originalArray.length + 1];

		//Array that inserts all of the original values up just before the position with a new element
		for (int a = 0; a < position; a++) {

			newArray[a] = originalArray[a];

		}//end pre-pos loop

		//inserts a new element at the given position
		newArray[position] = value;

		//inserts all of the positions after the new position from the previous array into the new array
		for (int a = position + 1; a < newArray.length; a++) {

			newArray[a] = originalArray[a - 1];

		}//end after-pos loop

		//returns the new array
		return newArray;
		
	}//end insertElement

	/*
	 * Method Name: deleteElement
	 * Description: deletes an element at a certain position in an array
	 * Parameters: int [] originalArray, int position
	 * Returns: int [] newArray
	 */
	public static int[] deleteElement(int [] originalArray, int position) {

		//declares a new array with one value less than the original array
		int[] newArray = new int[originalArray.length - 1];

		//sets all of the the elements in the new array up to the position with the deleted element to be equal to the original array
		for (int a = 0; a < position; a++) {

			newArray[a] = originalArray[a];

		}//end pre-delete loop

		//sets all the elements of the new array to be equal all the elements of the original array after the position with the deleted element
		for (int b = position; b < newArray.length; b++) {

			newArray[b] = originalArray[b + 1];

		}//end post-delete loop

		//returns the new Array
		return newArray;
		
	}//end deleteElement

	/* Method Name: deleteElement
	 * Description: deletes an element at a certain position in an array
	 * Parameters: String [] originalArray, int position
	 * Returns: String [] newArray
	 */
	public static String [] deleteElement(String [] originalArray, int position) {

		//declares a new array with one value less than the original array
		String [] newArray = new String[originalArray.length - 1];

		//sets all of the the elements in the new array up to the position with the deleted element to be equal to the original array
		for (int a = 0; a < position; a++) {

			newArray[a] = originalArray[a];

		}//end pre-delete loop

		//sets all the elements of the new array to be equal all the elements of the original array after the position with the deleted element
		for (int b = position; b < newArray.length; b++) {

			newArray[b] = originalArray[b + 1];

		}//end post-delete loop

		//returns the new Array
		return newArray;
		
	}//end deleteElement
	
	/*
	 * Method Name: sortHightToLow
	 * Description: sorts the elements in an integer array from highest to lowest
	 * Parameters: int [] originalArray
	 * Returns: int [] newArray
	 */
	public static int[] sortHighToLow(int [] originalArray) {
		
		//creates a new Array that is a copy of the original array
		int[] newArray = Array.copyArray(originalArray);

		//boolean that determines whether to continue looping the following algorithm
		boolean loopContinue = false;

		//loop that sorts the elements from high to low
		do {
			
			//loops that swap the elements if the element on the lower end is less than the element on the high end, repeats for a total of (newArray.length) squared
			
			for (int b = 0; b < newArray.length; b++) {

				for (int a = 0; a < newArray.length; a++) {

					if (newArray[a] < newArray[b]) {

						swapElements(newArray, a, b);

					}//end if

				}//end for 'a' loop

			}//end for 'b' loop


		} while (loopContinue == true);

		//returns the sorted array
		return newArray;
		
	}//end sortHighToLow

	/*
	 * Method Name: sortLowToHigh
	 * Description: sorts the elements in an integer array from lowest to highest
	 * Parameters: int [] originalArray
	 * Returns: int [] newArray
	 */
	public static int[] sortLowToHigh(int [] originalArray) {
		
		//creates a new Array that is a copy of the original array
		int[] newArray = Array.copyArray(originalArray);

		//boolean that determines whether to continue looping the following algorithm
		boolean loopContinue = false;

		//loop that sorts the elements from low to high
		do {

			//loops that swap the elements if the element on the lower end is less than the element on the high end, repeats for a total of (newArray.length) squared
			for (int b = 0; b < newArray.length; b++) {

				for (int a = 0; a < newArray.length; a++) {

					if (newArray[a] > newArray[b]) {

						swapElements(newArray, a, b);

					}//end if

				}//end for 'a' loop

			}//end for 'b' loop

		} while (loopContinue == true);

		//returns the sorted array
		return newArray;
		
	}//end sortLowToHigh
	
	 /*Method Name: sortHightToLow
	 * Description: sorts the elements in an integer array from highest to lowest
	 * Parameters: int [] originalArray
	 * Returns: int [] newArray
	 */
	public static double[] sortHighToLow(double [] originalArray) {
		
		//creates a new Array that is a copy of the original array
		double[] newArray = Array.copyArray(originalArray);

		//boolean that determines whether to continue looping the following algorithm
		boolean loopContinue = false;

		//loop that sorts the elements from high to low
		do {
			
			//loops that swap the elements if the element on the lower end is less than the element on the high end, repeats for a total of (newArray.length) squared
			
			for (int b = 0; b < newArray.length; b++) {

				for (int a = 0; a < newArray.length; a++) {

					if (newArray[a] < newArray[b]) {

						swapElements(newArray, a, b);

					}//end if

				}//end for 'a' loop

			}//end for 'b' loop


		} while (loopContinue == true);

		//returns the sorted array
		return newArray;
		
	}//end sortHighToLow

	/*
	 * Method Name: sortLowToHigh
	 * Description: sorts the elements in an integer array from lowest to highest
	 * Parameters: int [] originalArray
	 * Returns: int [] newArray
	 */
	public static double[] sortLowToHigh(double [] originalArray) {
		
		//creates a new Array that is a copy of the original array
		double[] newArray = Array.copyArray(originalArray);

		//boolean that determines whether to continue looping the following algorithm
		boolean loopContinue = false;

		//loop that sorts the elements from low to high
		do {

			//loops that swap the elements if the element on the lower end is less than the element on the high end, repeats for a total of (newArray.length) squared
			for (int b = 0; b < newArray.length; b++) {

				for (int a = 0; a < newArray.length; a++) {

					if (newArray[a] > newArray[b]) {

						swapElements(newArray, a, b);

					}//end if

				}//end for 'a' loop

			}//end for 'b' loop

		} while (loopContinue == true);

		//returns the sorted array
		return newArray;
		
	}//end sortLowToHigh

}//end class
