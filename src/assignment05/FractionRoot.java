package assignment05;

/**
 * This program uses the fraction class to approximate the square root of
 * a fraction given an approximation value for the number of steps
 * 
 * @author Nolan Taylor
 * @version 10/1/21
 */

import java.util.Scanner;

public class FractionRoot
{

	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		// prompt the user for a numerator, denominator, and number of times to loop
		System.out.print("Enter the numerator: ");
		long num = keyboard.nextLong();
		
		System.out.print("Enter the denominator: ");
		long denom = keyboard.nextLong();
		
		System.out.print("Enter an approximation: ");
		int approx = keyboard.nextInt();
		
		// store the user's fraction and create a new fraction object to hold the square root
		Fraction fraction = new Fraction(num, denom);
		Fraction currentX = new Fraction(1);
		
		// loop through the iterative formula a number of times equal to the approx value
		// for each loop, divide and add the fraction by the current iteration, then divide by 2
		for (int i = 0; i < approx; i++)
		{
			Fraction nextX = fraction;
			nextX = nextX.divide(currentX);
			nextX = nextX.add(currentX);
			nextX = nextX.multiply(new Fraction(1, 2));
			currentX = nextX;
		}
		
		
		// print the approximate square root for the user to see
		System.out.println("The square root of " + fraction + " is approximately " + currentX + ".");
	}

}
