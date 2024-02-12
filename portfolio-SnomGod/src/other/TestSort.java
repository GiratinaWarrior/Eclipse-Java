/** 
 * Simer Aim
 * Course: ICS 4U
 * Teacher: Mrs. McCaffery
 * Date: 2023/01/16
 * Description: This is the test sorting class, where the sorting efficiency results are placed in a file
 */
package other;

import skillshowcase.Array;
import sorting.Sort;
import java.io.*;
import java.util.*;
import linked_list.LList;

import file.ExcelFileIOTask;

public class TestSort {

	//Create a private scanner
	private static Scanner myInput = new Scanner(System.in);
	
	//create a private filename variable that decides what file to add the information to
	private static final String FileName = "SortResults.txt";
	
	public static void main(String[] args) throws IOException {
		
		//the array of sorting methods for arrays that will be testing
		String[] sortfunc_array = {"shell", "selection", "bubble", "insertion", "quick"};
		
		//for each sorting algorithm, test them with random elements and print the results to a file
		for (int a = 0; a < sortfunc_array.length; a++)
		{
			testSort_Array_Random(sortfunc_array[a]);
		}
		
		//for each sorting algorithm, test them when they are in reverse order and print the results to a file
		for (int a = 0; a < sortfunc_array.length; a++)
		{
			testSort_Array_Reverse(sortfunc_array[a]);
		}
		
		//the array of sorting methods for linked lists that will be testing
		String[] sortfunc_list = {"selection", "bubble", "insertion"};
		
		//for each sorting algorithm, test them with random elements and print the results to a file
		for (int a = 0; a < sortfunc_list.length; a++)
		{
			testSort_List_Random(sortfunc_list[a]);
		}
		
		//for each sorting algorithm, test them when they are in reverse order and print the results to a file
		for (int a = 0; a < sortfunc_list.length; a++)
		{
			testSort_List_Reverse(sortfunc_list[a]);
		}
		
		
	}//end main
	
	/**
	 * @param method the type of array sorting algorithm to be used
	 * @throws IOException
	 */
	public static void testSort_Array_Random(String method) throws IOException
	{
		
//---------------------Initialize------------------//
		
		//variables that hold the averages for each value
		double AvgTime = 0;
		double AvgLoop = 0;
		double AvgRecu = 0;
		double AvgSwap = 0;
		double AvgComp = 0;
		
		//how many test tuns will be made
		int numOfTests = 10;
		
		//size of the array
		int size = 10;
		
		//values that hold the start and end time
		long startTime = 0;
		long endTime = 0;
		
//----------------------Sort---------------------//
		
		for (int a = 0; a < numOfTests; a++)
		{
			//Check which sorting method we're testing
			switch (method)
			{
				//Testing the shell sort
				case "shell":
					
					startTime = System.nanoTime();
					Sort.shell(Array.createRandomIntArray(size, -5, 10));
					endTime = System.nanoTime();
		
					break;//end test shell
					
				//Testing the bubble sort
				case "bubble":
					
					startTime = System.nanoTime();
					Sort.bubble(Array.createRandomIntArray(size, -5, 10));
					endTime = System.nanoTime();
					
					break;//end bubble sort
					
				//Testing the bubble sort
				case "selection":
					
					startTime = System.nanoTime();
					Sort.selection(Array.createRandomIntArray(size, -5, 10));
					endTime = System.nanoTime();
					
					break;//end bubble sort
					
				case "insertion":
					
					startTime = System.nanoTime();
					Sort.insertion(Array.createRandomIntArray(size, -5, 10));
					endTime = System.nanoTime();
					
					break;
					
				case "quick":
					
					startTime = System.nanoTime();
					Sort.quick(Array.createRandomIntArray(size, -5, 10));
					endTime = System.nanoTime();
					
					break;
				
			}
			
			long time = endTime - startTime;
			
			AvgTime += time;
			
			//System.out.println("Swaps Made: " + Sort.swaps);
			
			AvgLoop += Sort.loops;
			AvgSwap += Sort.swaps;
			AvgComp += Sort.comparisons;
			AvgRecu += Sort.recursions;
			
		}

		
//--------------------Print results-------------//
		
		AvgTime /= numOfTests;
		AvgLoop /= numOfTests;
		AvgSwap /= numOfTests;
		AvgComp /= numOfTests;
		
		String[] tstLine = 
			{
				"Algorithm: " + method + "", 
				"Average Time (ns): " + AvgTime, 
				"Array Order: Random", 
				"Size: " + size, 
				"Average Number of Loops: " + AvgLoop,
				"Average Number of Recursions: " + AvgRecu,
				"Average Number of Swaps: " + AvgSwap,
				"Average Number of Comparisons: " + AvgComp
			};
		
		for (int a = 0; a < tstLine.length; a++)
		{
			System.out.println(tstLine[a]);
		}
		
		System.out.println("");
		
		for (int a = 0; a < tstLine.length; a++)
		{
			ExcelFileIOTask.addToFileEnd(FileName, (tstLine[a]));
		}
		
		ExcelFileIOTask.addToFileEnd(FileName, "");
		
		
	}//end testSort_Array_Random
	
	/**
	 * @param method the type of array sorting algorithm to be used
	 * @throws IOException
	 */
	public static void testSort_Array_Reverse(String method) throws IOException
	{
		
//---------------------Initialize------------------//
		
		//variables that hold the averages for each value
		double AvgTime = 0;
		double AvgLoop = 0;
		double AvgRecu = 0;
		double AvgSwap = 0;
		double AvgComp = 0;
		
		//how many test tuns will be made
		int numOfTests = 10;
		
		//size of the array
		int size = 10;
		
		//values that hold the start and end time
		long startTime = 0;
		long endTime = 0;
		
		int[] newArr = Array.createRandomIntArray(size, -5, 10);
		
		newArr = Array.sortHighToLow(newArr);
		
//----------------------Sort---------------------//
		
		for (int a = 0; a < numOfTests; a++)
		{
			//Check which sorting method we're testing
			switch (method)
			{
				//Testing the shell sort
				case "shell":
					
					startTime = System.nanoTime();
					Sort.shell(newArr);
					endTime = System.nanoTime();
		
					break;//end test shell
					
				//Testing the bubble sort
				case "bubble":
					
					startTime = System.nanoTime();
					Sort.bubble(newArr);
					endTime = System.nanoTime();
					
					break;//end bubble sort
					
				//Testing the bubble sort
				case "selection":
					
					startTime = System.nanoTime();
					Sort.selection(newArr);
					endTime = System.nanoTime();
					
					break;//end bubble sort
					
				case "insertion":
					
					startTime = System.nanoTime();
					Sort.insertion(newArr);
					endTime = System.nanoTime();
					
					break;
					
				case "quick":
					
					startTime = System.nanoTime();
					Sort.quick(newArr);
					endTime = System.nanoTime();
					
					break;
				
			}
			
			long time = endTime - startTime;
			
			AvgTime += time;
			
			//System.out.println("Swaps Made: " + Sort.swaps);
			
			AvgLoop += Sort.loops;
			AvgSwap += Sort.swaps;
			AvgComp += Sort.comparisons;
			AvgRecu += Sort.recursions;
			
		}

		
//--------------------Print results-------------//
		
		AvgTime /= numOfTests;
		AvgLoop /= numOfTests;
		AvgSwap /= numOfTests;
		AvgComp /= numOfTests;
		
		String[] tstLine = 
			{
				"Algorithm: " + method + "", 
				"Average Time (ns): " + AvgTime, 
				"Array Order: Reverse", 
				"Size: " + size, 
				"Average Number of Loops: " + AvgLoop,
				"Average Number of Recursions: " + AvgRecu,
				"Average Number of Swaps: " + AvgSwap,
				"Average Number of Comparisons: " + AvgComp
			};
		
		for (int a = 0; a < tstLine.length; a++)
		{
			System.out.println(tstLine[a]);
		}
		
		System.out.println("");
		
		for (int a = 0; a < tstLine.length; a++)
		{
			ExcelFileIOTask.addToFileEnd(FileName, (tstLine[a]));
		}
		
		ExcelFileIOTask.addToFileEnd(FileName, "");
		
		
	}//testSort_Array_Reverse

	/**
	 * @param method the type of linked list sorting algorithm to be used
	 * @throws IOException
	 */
	public static void testSort_List_Random(String method) throws IOException
	{
		
//---------------------Initialize------------------//
		
		//variables that hold the averages for each value
		double AvgTime = 0;
		double AvgLoop = 0;
		double AvgRecu = 0;
		double AvgSwap = 0;
		double AvgComp = 0;
		
		//how many test tuns will be made
		int numOfTests = 10;
		
		//size of the array
		int size = 10;
		
		//values that hold the start and end time
		long startTime = 0;
		long endTime = 0;
		
//----------------------Sort---------------------//
		
		for (int a = 0; a < numOfTests; a++)
		{
			//Check which sorting method we're testing
			switch (method)
			{
				//Testing the shell sort
				case "shell":
					
					startTime = System.nanoTime();
					Sort.shell(LList.createRandomList(size, -5, 10));
					endTime = System.nanoTime();
		
					break;//end test shell
					
				//Testing the bubble sort
				case "bubble":
					
					startTime = System.nanoTime();
					Sort.bubble(LList.createRandomList(size, -5, 10));
					endTime = System.nanoTime();
					
					break;//end bubble sort
					
				//Testing the bubble sort
				case "selection":
					
					startTime = System.nanoTime();
					Sort.selection(LList.createRandomList(size, -5, 10));
					endTime = System.nanoTime();
					
					break;//end bubble sort
					
				case "insertion":
					
					startTime = System.nanoTime();
					Sort.insertion(LList.createRandomList(size, -5, 10));
					endTime = System.nanoTime();
					
					break;
					
				case "quick":
					
					startTime = System.nanoTime();
					Sort.quick(LList.createRandomList(size, -5, 10));
					endTime = System.nanoTime();
					
					break;
				
			}
			
			long time = endTime - startTime;
			
			AvgTime += time;
			
			//System.out.println("Swaps Made: " + Sort.swaps);
			
			AvgLoop += Sort.loops;
			AvgSwap += Sort.swaps;
			AvgComp += Sort.comparisons;
			AvgRecu += Sort.recursions;
			
		}

		
//--------------------Print results-------------//
		
		AvgTime /= numOfTests;
		AvgLoop /= numOfTests;
		AvgSwap /= numOfTests;
		AvgComp /= numOfTests;
		
		String[] tstLine = 
			{
				"Algorithm: " + method + "", 
				"Average Time (ns): " + AvgTime, 
				"List Order: Random", 
				"Size: " + size, 
				"Average Number of Loops: " + AvgLoop,
				"Average Number of Recursions: " + AvgRecu,
				"Average Number of Swaps: " + AvgSwap,
				"Average Number of Comparisons: " + AvgComp
			};
		
		for (int a = 0; a < tstLine.length; a++)
		{
			System.out.println(tstLine[a]);
		}
		
		System.out.println("");
		
		for (int a = 0; a < tstLine.length; a++)
		{
			ExcelFileIOTask.addToFileEnd(FileName, (tstLine[a]));
		}
		
		ExcelFileIOTask.addToFileEnd(FileName, "");
		
	}//testSort_List_Random

	/**
	 * @param method the type of linked list sorting algorithm to be used
	 * @throws IOException
	 */
	public static void testSort_List_Reverse(String method) throws IOException
	{
		
//---------------------Initialize------------------//

		//variables that hold the averages for each value
		double AvgTime = 0;
		double AvgLoop = 0;
		double AvgRecu = 0;
		double AvgSwap = 0;
		double AvgComp = 0;
		
		//how many test tuns will be made
		int numOfTests = 10;
		
		//size of the array
		int size = 10;
		
		//values that hold the start and end time
		long startTime = 0;
		long endTime = 0;
		
		LinkedList<Integer> rndList = LList.createRandomList(size, -5, 10);
		
		rndList = reverseList(rndList);
		
//----------------------Sort---------------------//
		
		for (int a = 0; a < numOfTests; a++)
		{
			//Check which sorting method we're testing
			switch (method)
			{
				//Testing the shell sort
				case "shell":
					
					startTime = System.nanoTime();
					Sort.shell(rndList);
					endTime = System.nanoTime();
		
					break;//end test shell
					
				//Testing the bubble sort
				case "bubble":
					
					startTime = System.nanoTime();
					Sort.bubble(rndList);
					endTime = System.nanoTime();
					
					break;//end bubble sort
					
				//Testing the bubble sort
				case "selection":
					
					startTime = System.nanoTime();
					Sort.selection(rndList);
					endTime = System.nanoTime();
					
					break;//end bubble sort
					
				case "insertion":
					
					startTime = System.nanoTime();
					Sort.insertion(rndList);
					endTime = System.nanoTime();
					
					break;
					
				case "quick":
					
					startTime = System.nanoTime();
					Sort.quick(rndList);
					endTime = System.nanoTime();
					
					break;
				
			}
			
			long time = endTime - startTime;
			
			AvgTime += time;
			
			//System.out.println("Swaps Made: " + Sort.swaps);
			
			AvgLoop += Sort.loops;
			AvgSwap += Sort.swaps;
			AvgComp += Sort.comparisons;
			AvgRecu += Sort.recursions;
			
		}

		
//--------------------Print results-------------//
		
		AvgTime /= numOfTests;
		AvgLoop /= numOfTests;
		AvgSwap /= numOfTests;
		AvgComp /= numOfTests;
		
		String[] tstLine = 
			{
				"Algorithm: " + method + "", 
				"Average Time (ns): " + AvgTime, 
				"List Order: Reverse", 
				"Size: " + size, 
				"Average Number of Loops: " + AvgLoop,
				"Average Number of Recursions: " + AvgRecu,
				"Average Number of Swaps: " + AvgSwap,
				"Average Number of Comparisons: " + AvgComp
			};
		
		for (int a = 0; a < tstLine.length; a++)
		{
			System.out.println(tstLine[a]);
		}
		
		System.out.println("");
		
		for (int a = 0; a < tstLine.length; a++)
		{
			ExcelFileIOTask.addToFileEnd(FileName, (tstLine[a]));
		}
		
		ExcelFileIOTask.addToFileEnd(FileName, "");
		
	}//testSort_List_Reverse

	/** This method reverses the list to be from high to low
	 * @param list
	 */
	public static LinkedList<Integer> reverseList(LinkedList<Integer> list) 
	{
		
		list = Sort.bubble(list);
		
		LinkedList<Integer> newList = new LinkedList<Integer>();
		
		for (int a = 0; a < list.size(); a++)
		{
			newList.add(a, list.get(list.size() - 1 - a));
		}
		 
		return newList;

	}//end reverseList

}//end class
