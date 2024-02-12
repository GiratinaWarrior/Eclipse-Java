package file;

import java.util.*;

import skillshowcase.Array;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExceedFileIOTask {

	private static Scanner myInput = new Scanner(System.in);
	
	private static final String FileName = "highscores.txt";
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Writers for the original
		FileWriter ExceedFileWriter = new FileWriter(FileName);
		PrintWriter myOutput = new PrintWriter(ExceedFileWriter);
		
		String [] PlayerNames = {"First", "Second", "Third", "Fourth", "Fifth"};//{"Siuygraje", "Irarha", "Maueaga", "Etrah", "Ryavbrie"};
		
		int [] PlayerScores = {10, 8, 6, 4, 2};//Array.createRandomIntArray(PlayerNames.length, 10, 100);
		
		//boolean that determines whether to continue looping the following algorithm
		boolean loopContinue = false;

		//loop that sorts the elements from high to low
		do {
			
			//loops that swap the elements if the element on the lower end is less than the element on the high end, repeats for a total of (newArray.length) squared
			
			for (int b = 0; b < PlayerScores.length; b++) {

				for (int a = 0; a < PlayerScores.length; a++) {

					if (PlayerScores[a] < PlayerScores[b]) {

						Array.swapElements(PlayerScores, a, b);
						Array.swapElements(PlayerNames, a, b);

					}//end if

				}//end for 'a' loop

			}//end for 'b' loop


		} while (loopContinue == true);
		
		
		for (int p = 0; p < PlayerNames.length; p++)
		{
			myOutput.print(PlayerNames[p]);
			myOutput.print(": ");
			myOutput.println((PlayerScores[p]));
		}
		
		
		//close the writer
		myOutput.close();
		
		
		
		String name = "";
		
		int score = 0;
		
		int line = 0;
		
		String addAnother = "";
		
		do
		{	
			System.out.println("What player would you like to add to highscores? ");
			
			name = myInput.next();
			
			System.out.println("What high score did they get?");
			
			do 
			{
				try 
				{
					score = myInput.nextInt();
					
					if (score < 1)
					{
						System.out.println("Too Low.");
					}
					else
					{
						break;
					}
					
				}
				catch (InputMismatchException e)
				{
					System.out.println("Invalid Input");
				}
				
			} while (true);
			
			System.out.println("What line would you like to add this highscore to?");
			
			do
			{
				
				try 
				{
					line = myInput.nextInt();
					
					if (line < 0)
					{
						System.out.println("Too low.");
					}
					else
					{
						break;
					}
					
				}
				catch (InputMismatchException e)
				{
					System.out.println("Invalid Input");
				}
				
				
			} while (true);
			
			
			String stringToFile = name + ": " + score;
			
			AddToFile(stringToFile, FileName, line - 1);
			
			System.out.println("Highscore has been added!");
			
			System.out.println("Would you like to add another one? ('yes' for yes, anything else for no)");
			
			addAnother = myInput.next();
			
			if (!addAnother.equalsIgnoreCase("yes"))
			{
				break;
			}
			
		} while (true);
		
		
		
		//AddToFileEnd("Apruah: 126", FileName);
		//AddToFileEnd("Insind: 36", FileName);
		//AddToFile("Men-Huen: 500", FileName, 0);
		
	
	}

	public static void AddToFileEnd(String addedLine, String file) throws IOException
	{
		//Readers
		FileReader ExcelFileReader = new FileReader(file);
		BufferedReader ExcelFileInput = new BufferedReader(ExcelFileReader);
		
		//Create empty array list for the files lines
		ArrayList<String> FileLineList = new ArrayList<String>();
	
		String FileLine = "";
		
		//As long as the line is not empty, 
		do
		{
			
			FileLine = ExcelFileInput.readLine();
			
			FileLineList.add(FileLine);
			
		} while (FileLine != null);
		
		//Empty array that stores the lines of the text file
		String[] importedList = Array.createEmptyStringArray(FileLineList.size());
		
	//	System.out.println("Number of lines = " + importedList.length);
		
		//place the file line into the array
		for (int f = 0; f < importedList.length; f++)
		{
			importedList[f] = FileLineList.get(f);
		//	System.out.println("Line " + (f+1) + ": " + importedList[f]);
		}
		
		importedList[importedList.length - 1] = addedLine;
		
		ExcelFileInput.close();
		
		//Writers for the original
		FileWriter ExceedFileWriter = new FileWriter(file);//writer;
		PrintWriter myOutput = new PrintWriter(ExceedFileWriter);
		
		for (int o = 0; o < importedList.length; o++)
		{
			myOutput.println(importedList[o]);
			//System.out.println(importedList[o]);
		}
		
		myOutput.close();
		
		//return importedList;
	}//end importList
	
	public static void AddToFile(String addedLine, String file, int Line) throws IOException
	{
		//Readers
		FileReader ExcelFileReader = new FileReader(file);
		BufferedReader ExcelFileInput = new BufferedReader(ExcelFileReader);
		
		//Create empty array list for the files lines
		ArrayList<String> FileLineList = new ArrayList<String>();
	
		String FileLine = "";
		
		//As long as the line is not empty, 
		 while (FileLine != null)
		{
			
			FileLine = ExcelFileInput.readLine();
			
			FileLineList.add(FileLine);
			
		};
		
		//Empty array that stores the lines of the text file
		String[] importedList = Array.createEmptyStringArray(FileLineList.size());
	
		/*
		
		//place the file line into the array
		for (int f = 0; f < importedList.length; f++)
		{
			importedList[f] = FileLineList.get(f);
		//	System.out.println("Line " + (f+1) + ": " + importedList[f]);
		}
		
		importedList[importedList.length - 1] = addedLine;
		
		*/
		
		
		for (int f = 0; f < Line; f++)
		{
			importedList[f] = FileLineList.get(f);
		}
		
		importedList[Line] = addedLine;
		
		for (int f = Line; f < importedList.length - 1; f++)
		{
			importedList[f + 1] = FileLineList.get(f);
		}
		
		
		ExcelFileInput.close();
		
		//Writers for the original
		FileWriter ExceedFileWriter = new FileWriter(file);//writer;
		PrintWriter myOutput = new PrintWriter(ExceedFileWriter);
		
		for (int o = 0; o < importedList.length; o++)
		{
			myOutput.println(importedList[o]);
		//	System.out.println(importedList[o]);
		}
		
		
		myOutput.close();
	}

}
