package assignment04;
/**
 * This program scans a .txt file of financial transactions
 * and finds an arithmetic error on a certain date.
 * 
 * @author Nolan Taylor
 * @version 9/25/21
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArithmeticErrorFinder
{
	/**
	 * This function converts a dollar amount as a string
	 * into a double of that amount, removing the dollar sign
	 * 
	 * @param money
	 * @return double
	 */
	public static double toDouble(String money)
	{
		return Double.parseDouble(money.substring(1));
	}
	
	/**
	 * 
	 * This function compares two doubles to see if they are
	 * almost equal, as doubles are rarely exactly equal due
	 * to rounding
	 * 
	 * @param double_1
	 * @param double_2
	 * @return boolean
	 */
	public static boolean almostEqual(double double_1, double double_2)
	{
		// checks if the two double values are within
		// 1e-8ths of each other
		if (Math.abs(double_1 - double_2) < 1e-8)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * 
	 * This function parses an entry, returning the transaction value
	 * if the entry was a BUY or SELL, and going a layer deeper if it
	 * is a SUBGROUP
	 * 
	 * @param fileScanner
	 * @return double
	 */
	public static double parseEntry(Scanner fileScanner)
	{
		if (fileScanner.next().equals("SUBGROUP"))
		{
			return parseSubgroup(fileScanner);
		}
		else
		{
			fileScanner.next();
			return toDouble(fileScanner.next());
		}
	}
	
	/**
	 * 
	 * This function parses a subgroup, looping through each
	 * entry in the subgroup and parsing those to find any
	 * arithmetic errors. If an error is found, the function
	 * print the date and mismatching values then terminates
	 * the program
	 * 
	 * @param fileScanner
	 * @return double
	 */
	public static double parseSubgroup(Scanner fileScanner)
	{
		// get the number of entries in the transaction group
		int entryCount = fileScanner.nextInt();
		// skip the words 'ITEMS' and 'ON'
		fileScanner.next(); fileScanner.next();
		// get the date as a string
		String date = fileScanner.next();
		// skip 'TOTALING'
		fileScanner.next();
		// convert the dollar value of the transaction group to a double
		double total = toDouble(fileScanner.next());
		// create a new double to compare to the total
		double totalCompare = 0.0;
		
		// for each entry, parse that entry
		for (int i = 0; i < entryCount; i++)
        {
        	totalCompare += parseEntry(fileScanner);
        }
		
		// compare the totals, if they are equal return them.
		// otherwise, print the mismatching information and throw an exception
		if (almostEqual(total, totalCompare))
		{
			return total;
		}
		else
		{
			System.out.println("Arithmetic error on " + date + ".");
			System.out.println("Amount is recorded as $" + String.format("%.2f", total) + 
					", should actually be $" + String.format("%.2f", totalCompare) + ".");
			throw new InputMismatchException();
		}
	}

	public static void main(String[] args)
	{
		String filename = null;
		Scanner keyboard = new Scanner(System.in);
		
		// ask the user for a file name
		System.out.print("Enter file name: ");
		filename = keyboard.next();
        
        try (Scanner fileScanner = new Scanner(new File(filename));)
        {           
            double total = parseSubgroup(fileScanner);
            
            // if the program parsed the file without throwing an error,
            // there were no arithmetic errors, in which case throw this exception
            throw new IOException();
        }
        // if the file is not found, throw this exception
        catch (FileNotFoundException e)
        {
        	System.out.print("File " + filename + " cannot be accessed.");
        }
        catch (IOException e)
        {
            System.out.print("File " + filename + " does not have any arithmetic errors.");
        }
        catch (InputMismatchException e)
        {
            System.out.println("An error has terminated checking.");
        }
        
        keyboard.close();
	}

}
