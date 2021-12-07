package assignment03;

import java.util.Scanner;

public class HailstoneSearch
{

	public static void main(String[] args)
	{
		Scanner keyboard;
		keyboard = new Scanner(System.in);
		
		// declare the amount of steps the user is looking for, the steps the program will increment, and the initial number
		int steps = 0;
		int count = 0;
		int initial = 2;
		
		// ask the user for the steps to converge to 1
		System.out.print("Enter number of steps: ");
		steps = keyboard.nextInt();
		
		// using the hailstone sequence, keep incrementing the initial number until the steps taken to converge is equal to the user inputted steps
		while (true)
		{
			// set local initial to global initial
			int n = initial;
			
			while (n != 1)
			{
				// if even, divide by 2
				if (n % 2 == 0) { n /= 2; }
				// if odd, multiply by 3 and add 1
				else { n = n * 3 + 1; }
				
				count++;
			}
			
			if (count == steps) { break; }
			// increment global initial and reset the count
			else { initial++; count = 0; }
		}
		
		// print the initial number that converged in those steps
		System.out.println("The Hailstone sequence starting at " + initial + " takes " + count + " steps to converge to 1.");
	}

}
