/**
 * This class contains the main method and is responsible for opening and
 * reading the data file, obtaining user input, performing some validation
 * and handling all errors that may occur.
 * 
 * @author Nazzerine Waldon
 * @version 09/19/2017
 */

package project1;

import java.io.*;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class ColorConverter {

	public static void main (String[] args) throws FileNotFoundException {
		
		// If there is no file, print error statement and exit program
		if (args.length < 1) {
			System.err.println("Error: No file has been specified.");
			System.exit(0);
		}
		// create object of File type that has chosen file of data
		File file = new File (args[0]);
		// open and read from the file using Scanner
		try {
			Scanner scanner = new Scanner(file);
			// create an empty ColorList and add each color into the ColorList
			ColorList colors = new ColorList();
			while(scanner.hasNext()) {
				String str = scanner.nextLine();
				//split by the comma value to separate name and hex value
				String[] fileColors = str.split(",");
				// trim the values inside fileColors
				fileColors[0] = fileColors[0].trim();
				fileColors[1] = fileColors[1].trim();
				// add the values from the fileColors array into the ColorList
				colors.add(new Color(fileColors[1], fileColors[0]));
			}
			
			// once scanner has read through the entire file, close scanner
			scanner.close();
			
			String input = "";
			
			// run program as long as user does not respond with quit
			while(!input.equalsIgnoreCase("quit")){
				System.out.println("Enter the color in HEX format (#RRGGBB) or \"quit\" to stop:");
				// read in user response
				Scanner userResponse = new Scanner(System.in);
				// as long as user does not respond with quit, have input = the user response and trim
				if (userResponse.hasNextLine()) {
					input = userResponse.nextLine();
					input = input.trim();
					try{
						// create Color object with the user response/input
						Color c = new Color(input);
						// search for the color in colorList by name or hex value using the respective ColorList methods
						if (colors.getColorByHexValue(input) == null) {
							c = new Color(input);
						} else {
							c = colors.getColorByHexValue(input);
						}
						// print the information about the color (format from Project 1 specifications) using toString method from Color class
						String info = c.toString();
						
						System.out.println();
						System.out.println("Color information:");
						System.out.println(info);
						System.out.println();
						 
					// throw exception if user input is invalid
					} catch (IllegalArgumentException i) {
						System.err.println("Error: This is not a valid color specification.");
					}
				// end program if next line doesn't exist or user inputs "quit"
				} else {
					System.exit(0);
				}
			}
		// throw exception if file is not found
		} catch (FileNotFoundException f) {
			System.err.println("Error: File not found.");
		}
	}
}



