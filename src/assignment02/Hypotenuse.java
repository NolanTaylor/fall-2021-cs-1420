package assignment02;

/**
 * 
 * This program finds the area of a circle given a user input radius
 * 
 * @author Nolan Taylor
 * @version September 2, 2021
 *
 */

import java.util.Scanner;

public class Hypotenuse
{

	public static void main(String[] args)
	{
		Scanner keyboard;
		keyboard = new Scanner(System.in);
		
		double side_a;
		double side_b;
		
		// Asking user for sides A and B
		
		System.out.print("Enter side A: ");
		side_a = keyboard.nextDouble();
		
		System.out.print("Enter side B: ");
		side_b = keyboard.nextDouble();
		
		// Calculating the hypotenuse with Pythagorean Theorem
		
		double hypotenuse = Math.sqrt(side_a * side_a + side_b * side_b);
		
		// Printing the hypotenuse for the user to see
		
		System.out.println("The hypotenuse of a triangle with sides " + side_a + " and " + side_b + " is: " + hypotenuse);
		
	}

}
