package quiz01;

/**
 * This program reads the file named "DataNames.txt" and prints a random
 * weight and taste value for each entry in the text file
 * 
 * Nolan Taylor
 * September 18, 2021
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GenerateData
{

	public static void main(String[] args) throws IOException
	{
		File filename = new File("DataNames.txt");
        Scanner file = new Scanner(filename); 
        
        while (file.hasNext())
        {
        	// generate a random weight double between 2 and 10 grams
        	double randWeight = Math.random() * 8.0 + 2.0;
        	// generate a random taste int between 0 and 9
        	int randTaste = (int) (Math.random() * 10);
        	
        	// print the name of the nut and the random weight and taste values
        	System.out.println(file.next() + " " + randWeight + " " + randTaste);
        }
        
        file.close();
	}

}
