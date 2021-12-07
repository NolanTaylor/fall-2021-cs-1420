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

public class CircleArea
{

	public static void main(String[] args)
	{
		Scanner keyboard;
		keyboard = new Scanner(System.in);
		
		
		// Asking the user to input a radius
		
		System.out.print("Enter a radius: ");
		
		// Storing the radius in a double variable
		
		double radius;
		radius = keyboard.nextDouble();
		
		// Calculating the circle's area with pi(r^2)
		
		double area = Math.PI * radius * radius;
		
		// Printing the area for the user to see
		
		System.out.println("A circle of radius " + radius + " has an area of " + area);

	}

}
