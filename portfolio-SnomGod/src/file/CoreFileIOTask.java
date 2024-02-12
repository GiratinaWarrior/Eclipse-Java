package file;

import java.util.*;

import skillshowcase.Array;

import java.io.*;

public class CoreFileIOTask {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			
		//Create the writers
		FileWriter CoreFileWriter = new FileWriter("CoreFileIOTask.txt");
		PrintWriter myOutput = new PrintWriter(CoreFileWriter);
		
		//Create the randomized marks array
		int[] randArray = Array.createRandomIntArray(20, 40, 100);
		
		//Create the list of names
		String[] Names = {"Amatar", "Boksiu", "Cierfa", "Dianshow", "Eivio", "Jakelite", "Karma", "Llussier", "Mumumumumonsier", "Nonciense"};
		
		int names_pos = 0;
		
		//Print the names and numbers to the created file
		for (int a = 0; a < 20; a++)
		{
			if (a % 4 == 0 && a != 0)
			{
				myOutput.println(Names[names_pos]);
				names_pos++;
			}
			myOutput.println(randArray[a]);
		}
		
		myOutput.println(Names[names_pos]);
		
		//close the file
		myOutput.close();
		
		//Create the readers
		FileReader CodeFileReader = new FileReader("CoreFileIOTask.txt");
		BufferedReader CoreFileInput = new BufferedReader(CodeFileReader);
		
		//initialize the total numbers
		double totalNumber = 0;
		
		boolean test_b = false;
		
		//read the file and print out the names and numbers
		for (int b = 1; b < 26; b++)
		{
			//if b is a multiple of 5 and not 0
			if (b % 5 == 0 && b != 0)
			{
				//if not testing b
				if (test_b == false)
				{
					String name = CoreFileInput.readLine();
					System.out.println(name + "'s Mark: " + totalNumber/4 + "%");
					totalNumber = 0;
						
				}//end not testing b
				
				//if testing b
				else
				{
					System.out.println("b % 5 where b != 0 is: " + b);
				}//end testing b
				
			}//end if
			
			//if b is not a multiple of or is 0
			else
			{
				//if not testing the value of b
				if (!test_b)
				{
					try
					{
						int mark = Integer.parseInt(CoreFileInput.readLine());
						totalNumber+=mark;
						//System.out.print(mark);
					}
					catch (NumberFormatException e)
					{
						System.out.println("");
					}
				
				}//end if not testing b
				
				//if testing the value of b
				else
				{
				//	System.out.println("b is not a multiple of 5 nor 0: b = " + b);
					System.out.println("b = " + b);
				}//end testing b
				
			}//end else
			
		}//end loop
		
		/*
		 * 
		 * if (b % 5 == 0)
			{
				String name = CoreFileInput.readLine();
				System.out.println(name + "'s Marks: ");
			}
			else
			{
				int mark = Integer.parseInt(CoreFileInput.readLine());
				System.out.println(mark);
			}
		 */
		
		//close the reader
		CoreFileInput.close();
		
		
	}

}
