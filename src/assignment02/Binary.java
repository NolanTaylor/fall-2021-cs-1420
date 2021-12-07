package assignment02;

/**
 * 
 * This program converts a given integer between 0 and 255 to its binary counterpart
 * 
 * @author Nolan Taylor
 * @version September 2, 2021
 *
 */

import java.util.Scanner;

public class Binary
{
	
	public static void main(String[] args)
	{
		// Declaring n, the user's number, and each digit of the possible binary combinations
		
		int n, digit_0, digit_1, digit_2, digit_3, digit_4, digit_5, digit_6, digit_7;
		int n_og;
		
		Scanner keyboard;
		keyboard = new Scanner(System.in);
		
		// Ask the user for an integer
		// and store n's value in OG n to print after n is altered
		
		System.out.print("Enter a number: ");
		n = keyboard.nextInt();
		n_og = n;
		
		// Find each digit by dividing n by the place's value
		// then subtracting that value from n
		
		digit_0 = n / 128; n -= digit_0 * 128;
		digit_1 = n / 64;  n -= digit_1 * 64;
		digit_2 = n / 32;  n -= digit_2 * 32;
		digit_3 = n / 16;  n -= digit_3 * 16;
		digit_4 = n / 8;   n -= digit_4 * 8;
		digit_5 = n / 4;   n -= digit_5 * 4;
		digit_6 = n / 2;   n -= digit_6 * 2;
		digit_7 = n % 2;
		
		System.out.println("The decimal number " + n_og + " is " +
			digit_0 + digit_1 + digit_2 + digit_3 + digit_4 + digit_5 + digit_6 + digit_7 + 
			" in binary.");
	}

}
