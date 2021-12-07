package quiz01;

/**
 * This program takes a user input for the name, weight, and taste of any number of nuts.
 * It then calculates the average weight of each nut and the number of nuts with a taste
 * to weight ratio of at least 2.0
 * 
 * Nolan Taylor
 * September 18, 2021
 */

import java.util.Scanner;

public class AnalyzeData
{

	public static void main(String[] args)
	{
        Scanner keyboard = new Scanner(System.in);
        
        int dataEntries = 0;
        double averageWeight = 0.0;
        int tastyNuts = 0;

        // tell the user what the program will do
        System.out.println("This program will determine the average weight of each nut and how many nuts"
        		+ " have a taste to gram ratio of at least 2.0 \n");
        
        // ask the user for the number of data entries
        System.out.print("Please enter the number of data entries: ");
        dataEntries = keyboard.nextInt();
        System.out.println();
        
        // loop for each data entry, asking the user for a name, weight, and taste of each entry
        for (int i = 0; i < dataEntries; i++)
        {
        	String name = null;
        	double weight = 0.0;
        	int taste = 0;
        	
        	System.out.print("Enter the name for entry " + i + ": ");
        	name = keyboard.next();
        	
        	System.out.print("Enter the weight for entry " + i + ": ");
        	weight = keyboard.nextDouble();
        	
        	System.out.print("Enter the taste for entry " + i + ": ");
        	taste = keyboard.nextInt();
        	
        	System.out.println();
        	
        	// for each entry add its weight to a total average to be divided later
        	// and if its ratio of taste to weight is at least 2.0, increment a counter
        	averageWeight += weight;
        	
        	if (taste / weight >= 2.0) { tastyNuts++; }
        }
        
        
        // provide the user the information
        System.out.println("The average weight of the " + dataEntries + " nuts is " + averageWeight / dataEntries);
        System.out.println("The number of nuts with a taste to gram ratio of at least 2.0 is " + tastyNuts);
	}
}
