/**
 * This program plays a simple game of rock-paper-scissors (roshambo)
 * with the user.  (Students will complete this program as part of
 * lab #2.)  See the lab instructions.
 * 
 * Peter Jensen and (student name here)
 * August 31, 2021
 */
package lab02;

import java.util.Scanner;

public class RockPaperScissors
{
	public static void main(String[] args)
	{
		// Create a Scanner object.
		
		/** One line goes here **/
		
		Scanner keyboard = new Scanner(System.in);
		
		// Create two String variables.  Name them computerWord and userWord.
		// Initialize them to empty strings.

		/** One or two lines go here **/
		
		String computerWord = null, userWord = null;
		
	    // Make a random integer between [0...2].  If the random integer is a
	    //   0, set computerWord to "rock", if it's a 1, set computerWord
	    //   to "paper", otherwise set computerWord to "scissors".

		/** Code similar to experiment #1 goes here **/
		
		int value = (int) (Math.random() * 3);
		int userValue = -1;
		
		/* switch (value)
		{
		case 0: computerWord = "rock"; break;
		case 1: computerWord = "paper"; break;
		case 2: computerWord = "scissors"; break;
		} */ // okay so apparently we're not allowed to use stuff we haven't been taught yet sooo.... o well..
		
		if (value == 0) { computerWord = "rock"; }
		else if (value == 1) { computerWord = "paper"; }
		else if (value == 2) { computerWord = "scissors"; }
		
		// Using a Boolean flag, create an input loop that asks the player to enter
		//   their guess.  Print reasonable instructions.  Don't allow the program 
		//   to proceed until the player enters either "rock", "paper", or "scissors".
		//   Store it in userWord.

		/** Code similar to experiment #2 goes here **/
		
		boolean userInputIsOK = false;
		
		while ( !userInputIsOK )  // Loop as long as the user input is NOT ok
		{
			System.out.print("Choose rock, paper, or scissors: ");
			userWord = keyboard.next();
			
			if (userWord.equals("rock"))
			{
				userValue = 0;
				userInputIsOK = true;
			}
			else if (userWord.equals("paper"))
			{
				userValue = 1;
				userInputIsOK = true;
			}
			else if (userWord.equals("scissors"))
			{
				userValue = 2;
				userInputIsOK = true;
			}
		}
		
		// Print out the user's guess:  "You picked rock.", etc.
		// Print out the computer's guess:  "I picked rock.", etc.

		/** Two lines go here **/
		
		System.out.println("You picked " + userWord);
		System.out.println("I picked " + computerWord);
		
	    // Write a few 'if' statements to determine the result of the game and
	    //   print out the winner:  "I win",  "You win", "It's a tie"
	    // If the strings are the same, its a tie.
	    //  else if the player picks "rock" and the computer picks "scissors", the player wins,
	    //  else if ... (etc.)
		
		/** Many lines go here.  Use the ideas from the lab instructions and from experiment #3 **/
		
		// Okay! So.. I may have cheated a tinyy bit, by adding an additional userValue variable.
		// But just look at this!!! It looks so much nicer and cleaner, and only 3 lines!
		// And also technically only uses things we've been taught, so hopefully it's cool
		
		if (userValue == value) { System.out.println("It's a tie"); }
		else if (userValue - 1 == value || (userValue == 0 && value == 2)) { System.out.println("You win"); }
		else { System.out.println("I win"); }
	}
}
