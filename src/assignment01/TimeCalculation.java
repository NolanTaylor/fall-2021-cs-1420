package assignment01;

/**
 * 
 * This class takes a uID and converts it into its respective hours, minutes, and seconds
 * 
 * @author Nolan Taylor
 * @version August 27th, 2021
 *
 */

public class TimeCalculation
{

	public static void main(String[] args)
	{
		// Declaring the uID variable :/
		int uID = 1364690;
		
		System.out.println("My uID number is u" + uID + ".");
		
		// Converting uID to hours
		int hours = uID / (60 * 60);
		// Using modulo to find leftover minutes
		int minutes = (uID / 60) % 60;
		// Same with seconds
		int seconds = uID % 60;
		
		System.out.print(uID + " seconds is ");
		System.out.print(hours + " hour(s), ");
		System.out.print(minutes + " minute(s), and ");
		System.out.println(seconds + " second(s).");
	}

}
