package assignment02;

/**
 * 
 * This program converts a given temperature in Fahrenheit to Celsius
 * 
 * @author Nolan Taylor
 * @version September 2, 2021
 *
 */

import java.util.Scanner;

public class Temperature
{
	
	public static void main(String[] args)
	{
		Scanner keyboard;
		keyboard = new Scanner(System.in);
		
		// Ask the user for a Fahrenheit temperature
		
		System.out.print("Enter a Fahrenheit temperature: ");
		
		int fahrenheit = keyboard.nextInt();
		
		// Calculate the Celsius temperature, multiplying first as to not truncate the integer too early
		
		int celsius = (fahrenheit - 32) * 5 / 9;
		
		// Print the Celsius temperature for the user to see
		
		System.out.println(fahrenheit + "F is " + celsius + "C");
	}

}
