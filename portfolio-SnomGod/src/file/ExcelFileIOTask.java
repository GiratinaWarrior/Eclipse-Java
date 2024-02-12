package file;

import java.util.*;

import skillshowcase.Array;

import java.io.*;

public class ExcelFileIOTask {

	private static Scanner myInput = new Scanner(System.in);
	
	private static final String FileName = "highscores.txt";
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		boolean ContinueFileFunc = true;
		
		//Loop that repeats while the user is choosing a menu function
		do
		{
			//Ask the user what file function they would like to choose
			System.out.println("What file function would you like to choose? (type the word in the brackets. Case sensitive)");
			System.out.println("- Add To A File (add) \n- Append To A File (append) \n- Edit A File (edit) \n- Done with files (done)");
			
			//User inputs their options
			String MenuOpt = myInput.next();
			
			//Do thing based on what the user input
			switch(MenuOpt)
			{
				//If the user wants to add something to a file
				case "add":
					
					//declare boolean confirmation variables
					boolean txtChosen_Add = false;
					boolean lnChosen = false;
					
					String txt;
					int ln = 0;
					
					//Loop that repeats while the user hasn't decided on a text to add
					do
					{
						//Ask the user what they want to add to the file
						System.out.println("What word would you like to add to the file?");
						
						//input the text
						txt = myInput.next();
						
						//Ask the user if they are satisfied with this text
						System.out.println("Are you satisfied with this text? (say 'yes' for yes)");
						
						//input their confirmation
						String confirmTxt = myInput.next();
						
						//If the user types 'yes', then the text is set in stone, and the loop ends
						if (confirmTxt.equalsIgnoreCase("yes"))
						{
							txtChosen_Add = true;
						}
						
					} while (!txtChosen_Add);
					
					//Loop that repeats while the user hasn't decide which line to add the text to
					do
					{
						//Ask the user what line to add the text to
						System.out.println("What line would you like to add this text to?");
						
						//Input code
						try
						{
							//The user inputs they line they want to add the text to
							ln = myInput.nextInt();
							
							//If the input is invalid. Print a message saying so
							if (ln < 0)
							{
								System.out.println("Invalid Line. Enter a number greater than 0");
							}
							//If the input is valid, ask for confirmation
							else
							{
								//Ask the user if they are satisfied with this text
								System.out.println("Are you satisfied with this line? (say 'yes' for yes)");
								
								//Input their confirmation 
								String confirmLn = myInput.next();
								
								//if the user has confirmed their choice for this line, then end the loop
								if (confirmLn.equalsIgnoreCase("yes"))
								{
									lnChosen = true;
								}
								
							}
							
						}
						//If the user inputs a non-integer value, print a message pointing out the error
						catch (InputMismatchException e)
						{
							System.out.println("Invalid Input.");
						}
						
					}
					while (!lnChosen);
					
					addToFile(FileName, txt, ln);
					
					System.out.println("Text successfully added to the file.");
					
					break;//end add
					
				//If the user wants to append to a file
				case "append":
					
					//declare boolean confirmation variables
					boolean txtChosen_Append = false;

					String txt_append;
					
					//Loop that repeats while the user hasn't decided on a text to add
					do
					{
						//Ask the user what they want to add to the file
						System.out.println("What word would you like to append to the file?");
						
						//input the text
						txt_append = myInput.next();
						
						//Ask the user if they are satisfied with this text
						System.out.println("Are you satisfied with this text? (say 'yes' for yes)");
						
						//input their confirmation
						String confirmTxt = myInput.next();
						
						//If the user types 'yes', then the text is set in stone, and the loop ends
						if (confirmTxt.equalsIgnoreCase("yes"))
						{
							txtChosen_Append = true;
						}
						
					} while (!txtChosen_Append);
					
					addToFileEnd(FileName, txt_append);
					
					System.out.println("Text successfully appended to file.");
					
					break;//end append
					
				//If the user wants to edit a file
				case "edit":
					
					boolean oldString_Chosen = false;
					boolean newString_Chosen = false;
					
					String txt_old;
					String txt_new;
					
					break;//end edit
					
				//If the user is finished with their files
				case "done":
					ContinueFileFunc = false; //end loop
					break;//end files
					
				//If the user enters anything else
				default:
					System.out.println("Invalid Option.");
					break;//end else
					
			}//end switch
			
		
		} while (ContinueFileFunc); //end loop
		
	}//end main

	
	/**
	 * This function edits a file by replacing the string
	 * @param filePath The file that is to be edited
	 * @param oldString the string in the file to be replaced
	 * @param newString the new string that is to replace the oldString
	 */
	public static void editFile(String filePath, String oldString, String newString)
    {
		//Create the file to be replaced
        File fileToBeModified = new File(filePath);
         
        //declare the variable containing the old contact
        String oldContent = "";
         
        //Create the reader
        BufferedReader reader = null;
        
        //create the writer
        FileWriter writer = null;
         
        try
        {
        	//declare the reader to read the file that is to be modified
            reader = new BufferedReader(new FileReader(fileToBeModified));
             
            
            //Read out every line in the files and add them to the old content string
            String line = reader.readLine(); 
            while (line != null) 
            {
                oldContent += line + "\n";
              
                line = reader.readLine();
            }
             
            
            //Create the new string, and replace the original string with the new string
            String newContent = oldContent.replaceAll(oldString, newString);
             
            //Declare the writer
            writer = new FileWriter(fileToBeModified);
             
            //print the new content to the file
            writer.write(newContent);
        }
        
        //Catch an file IO error
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Close the reader and the writer
                 
                reader.close();
                 
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
        
    }//end editFile

	
	/**
	 * Add a string on a new line at the end of a file
	 * @param filePath the file that will be written target
	 * @param textAdd the string to add to the file
	 */
	public static void addToFileEnd(String filePath, String textAdd) throws IOException 
	{
		
		//declare writers
		try (
				FileWriter f = new FileWriter(filePath, true);
				BufferedWriter b = new BufferedWriter(f);
				PrintWriter p = new PrintWriter(b);
			) 
		
		{
			
           //Print the new text to the file
			p.println(textAdd);
		}
		
		//catch an IOException, such as the file not existing
		catch (IOException i) {
         //   i.printStackTrace();
        }
		
	}//end addToFileEnd()
	
	
	/**
	 * Add a string to any position within a file
	 * @param filePath the file to be added to
	 * @param textAdd the file to be 
	 * @param pos the line to add the string to
	 * @throws IOException
	 */
	public static void addToFile(String filePath, String textAdd, int pos) throws IOException
	{	
	    
		//Create the scanner to scan the file
		Scanner sc = new Scanner(new File(filePath));

		//Create a string bugger
		StringBuffer buffer = new StringBuffer();

		//Add the current contents of the file to the string buffer
		while (sc.hasNextLine()) {
			buffer.append(sc.nextLine() + "\n");
		}

		//convert the string buffer to a regular string
		String fileContents = buffer.toString();

		//close the scanner
		sc.close();

		//create a new scanner for the file
		Scanner sf = new Scanner(new File(filePath));

		//Set the variable for the current line
		int currentLine = 0;

		//Set the variable for the current text
		String currentLineTxt = "";

		//Loop that repeats until the line where text is going to be added is reached
		do
		{

			//Set currentLineTxt to be the current line that is read
			currentLineTxt = sf.nextLine();

			//if the current line is where the text should be added, end loop the
			if (currentLine >= pos)
			{
				break;
			}
			//If not, increment currentLine by 1, and continue the loop
			else
			{
				currentLine++;
			}

		} while (true);

		//close the scanner
		sf.close();

		//Set the old line to be the current text at the line that will have new text
		String oldLine = currentLineTxt;
		
		//set the new line to be the old line, followed by a line seperater, and then the new line
		String newLine = textAdd + "\n" + currentLineTxt;
		
		//add the line to the file
		fileContents = fileContents.replaceAll(oldLine, newLine);

		//create the writer
		FileWriter writer = new FileWriter(filePath);
		
		//print all of the file contents to the file
		writer.append(fileContents);
	
		//clean out the writer
		writer.flush();
		
		//close the file
		writer.close();
		
	}//end addToFile
	
}//end class
