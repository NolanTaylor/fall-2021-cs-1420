package assignment03;

import java.util.Scanner;

public class Hailstone
{

	public static void main(String[] args)
	{
		Scanner keyboard;
		keyboard = new Scanner(System.in);
		
		// declare initial number and a bool flag for user inputting a positive number
		boolean posNumFlag = false;
		int initial = 0;
		
		// run while positive number flag is false
		while (!posNumFlag)
		{
			// ask the user for a number
			System.out.print("Input initial number: ");
			initial = keyboard.nextInt();
			
			// if number is positive, break the loop and print the number
			if (initial > 0) { posNumFlag = true; System.out.print(initial + " "); }
		}
		
		// declare the number of steps it will take to converge
		int count = 0;
		
		// while the number hasn't yet converged to 1
		while (initial != 1)
		{
			// if even, divide by 2
			if (initial % 2 == 0) { initial /= 2; }
			// if odd, multiply by 3 and add 1
			else { initial = initial * 3 + 1; }
			
			// print the number and increase the step count
			System.out.print(initial + " ");
			count++;
		}
		
		// print the steps it took to converge
		System.out.println();
		System.out.println("The series converged in " + count + " steps");
	}

}
