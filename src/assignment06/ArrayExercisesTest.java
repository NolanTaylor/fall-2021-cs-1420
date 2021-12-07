/*
 * A collection of unit tests for Assignment #6.  To make this work, you'll need to 
 * follow a few steps to get JUnit tests set up in your project.  Do this:
 * 
 *     + Make sure the Package Explorer view tab is visible in Eclipse.
 *           (You can always activate view tabs under Window->Show View.)
 *           
 *     + Right-click the ArrayExercises class, select New -> JUnit Test Case     
 *         - For the name of the test class, choose something that will not collide
 *           with this class name.  (You can delete it later, so "Deleteme" would be fine.)
 *         - Use JUnit Jupiter test if it is available, otherwise use JUnit 4.
 *         - 'Finish' this dialog.
 *         
 *     + Eclipse will warn you that JUnit 5 is not on the build path, and it will give
 *       you the option of adding it.  (We need it, it's the entire point of these steps.)
 *         - Hit 'OK' to complete the dialog.
 *         
 *     + You can delete the new class it created, or you can add unit tests to it.
 *         - You won't submit that class.
 *         
 *     + Copy this class (ArrayExercisesTest) into your assignment06 folder (if you
 *       have not done so already).  As long as JUnit 4 or JUnit 5 is set up in your
 *       project, the tests should run fine!
 *       
 *  Peter Jensen
 *  
 * Modified by:
 * @author ***Put your name here***
 * @version ***Put the date here***
 */
package assignment06;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.Arrays;  // OK in tests, not allowed in ArrayExercises

// Imports for JUnit 4 (currently unused)

// import static org.junit.Assert.*;
// import org.junit.Test;

// Imports for JUnit 5

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/* I generated unit tests for all the functions in ArrayExercises.
 * To run the tests, just run this code.
 */
public class ArrayExercisesTest
{
	/* This is my first example unit test.  A unit test is just a piece of
	 * code that calls some method or builds some object, and tests 
	 * for errors.  The code/test is up to the programmer.  
	 * 
	 * The unit test library provides functions for 'asserting' correctness.
	 * I use assertEquals below.  If the two values are not equal, the
	 * unit test library records a failure.
	 * 
	 * There are other assert functions in the unit test library that are
	 * useful for noting errors.  If the function below completes without
	 * recording a failure, then the test is marked as a success.
	 */
	@Test
	public void testRandomArray01()
	{
		// Call the function, ask for an array of thirty elements.
		
		int[] result;
		int size = 30;
		
		result = ArrayExercises.randomArray(size);  // This calls the function I'm testing.
		
		// The function has a specific contract that guarantees things
		//  about it's return value.  Check to make sure the method
		//  call did what it was supposed to.
		
		// Make sure the size of the result array is correct.
		
		assertEquals(size, result.length);  // If unequal, an error is recorded.
		
		// Make sure the required numbers [0..n-1] are in the array.
		
		numberLoop:  for (int n = 0; n < size; n++)  // Notice that I labeled this loop
		{
			// Search for n in the array.  When found, move on to the next n.
			
			for (int pos = 0; pos < size; pos++)
				if (result[pos] == n)
					continue numberLoop;  // Found it, continue the outer loop.  (I have not shown this yet.)
			
			// If we get this far, the number n was not found.  This is an error.
			
			fail("Number missing from random array: " + n + " in " + Arrays.toString(result));  // Record an error 	
		}		
		
		// If the number loop completes without failing, all tests pass!  
		//   (When this method ends normally, the test is marked as passing.)
	}

	/* I wanted two unit tests for my function.  The first one, above,
	 *   just makes sure the basic operation of 'randomArray' is 
	 *   correct.  This second unit test makes sure the 'randomness'
	 *   is correct.  A truly random shuffle has equal likelihood
	 *   of any outcome.  I repeatedly generate random arrays,
	 *   then I count up results, and then check to make
	 *   sure that each outcome occurred with similar probability.
	 *   
	 * Because of the fact that random numbers may produce results
	 *   that look uneven, I loop many times to reduce the likelihood
	 *   of random results looking like an error. 
	 *   
	 * I do not expect students to study this code - it is poor code.
	 *   (I don't like the way I'm counting permutations.)  There
	 *   are better ways, but you haven't seen the required lectures
	 *   yet, so I'm using a more primitive solution.  I expect your
	 *   unit tests to be much less complex.
	 */ 
	@Test
	public void testRandomArray02()
	{
		// An array of three has six permutations.
		
		// Counts of how many times each permutation appears.
		
		int count012 = 0;
		int count021 = 0;
		int count102 = 0;
		int count120 = 0;
		int count201 = 0;
		int count210 = 0;
		
		// Repeatedly generate arrays (1,000,000 times).
		
		for (int count = 0; count < 1_000_000; count++)
		{
			// Generate an array of 3 elements.
			
			int[] result = ArrayExercises.randomArray(3);  // This calls the function I'm testing.
			
			// Keep counts of each permutation in the array.
			
			if (result[0] == 0 && result[1] == 1)       // [0, 1, 2]
				count012++;
			else if (result[0] == 0 && result[1] == 2)  // [0, 2, 1]
				count021++;
			else if (result[0] == 1 && result[1] == 0)  // [1, 0, 2]
				count102++;
			else if (result[0] == 1 && result[1] == 2)  // [1, 2, 0]
				count120++;
			else if (result[0] == 2 && result[1] == 0)  // [2, 0, 1]
				count201++;
			else // only other possibility is [2, 1, 0]
				count210++;
		}
		
		// Check each permutation.  It should occur 166,666 times on average.  Accept
		//   anything within +/- 3,000.
		
		if (Math.abs(166_666 - count012) > 3_000)
		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count012); 	
		
		if (Math.abs(166_666 - count021) > 3_000)
		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count021); 	
		
		if (Math.abs(166_666 - count102) > 3_000)
		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count102); 	
		
		if (Math.abs(166_666 - count120) > 3_000)
		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count120); 	
		
		if (Math.abs(166_666 - count201) > 3_000)
		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count201); 	
		
		if (Math.abs(166_666 - count210) > 3_000)
		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count210); 	
		
		// If execution completes without failing, the test passes!  
		//   (When this method ends normally, the test is marked as passing.)
	}

	
	@Test
	public void testReverseOrder01()
	{
		char[] testArray = {'a', 'b', 'c'};
		
		ArrayExercises.reverseOrder(testArray);
		
		assertEquals(testArray[0], 'c');
		assertEquals(testArray[1], 'b');
		assertEquals(testArray[2], 'a');
	}
	
	@Test
	public void testReverseOrder02()
	{
		char[] testArray = {'a', 'b', 'c', 'd'};
		
		ArrayExercises.reverseOrder(testArray);
		
		assertEquals(testArray[0], 'd');
		assertEquals(testArray[1], 'c');
		assertEquals(testArray[2], 'b');
		assertEquals(testArray[3], 'a');
	}

	@Test
	public void testCount01()
	{
		String[] testArray = {"Farewell", "Sayonara", "Goodbye", "So long", "Sayonara", "Don't text me at 3 in the morning saying 'U up?' because 'new phone who dis?'"};
		
		assertEquals(ArrayExercises.count(testArray, "Sayonara"), 2);
	}
	
	@Test
	public void testCount02()
	{
		String[] testArray = {null, "AAAAA", null, "I'm gone!!", null, "I'm just gonna use the door", null, "Hey guys?", "Yeah?", null, "**** you guys"};
		
		assertEquals(ArrayExercises.count(testArray, null), 5);
	}
	
	@Test
	public void testCount03()
	{
		String[] testArray = {"That guy", "needs therapy", null, "I hope there's dead therapist out there that can give him the help he needs"};
		
		assertEquals(ArrayExercises.count(testArray, "Brigadoon"), 0);
	}

	@Test
	public void testReplace01()
	{
		String[] testArray = {"Because", "Everything", "Everything", "Happens", "Sound like terrible things can", "Happen", "For a", "Reason", "No reason"};
		
		ArrayExercises.replace(testArray, "Everything", "Nothing");
		
		assertEquals(testArray[1], "Nothing");
		assertEquals(testArray[2], "Nothing");
	}
	
	@Test
	public void testReplace02()
	{
		String differentWall = "Wa";
		differentWall += "ll";
		String[] testArray = {"Not", "Every", "Wall", "Can be an accent", differentWall};
		
		ArrayExercises.replace(testArray, "Wall", "floor");
		ArrayExercises.replace(testArray, "Every", null);
		
		assertEquals(testArray[2], "floor");
		assertEquals(testArray[1], null);
		if (testArray[4].equals("floor"))
		{
			fail("Same string was replaced, not same object");
		}
	}
	
	@Test
	public void testReplace03()
	{
		String[] testArray = {"Are you?", null};
		
		ArrayExercises.replace(testArray, null, "ghosts?");
		
		assertEquals(testArray[1], "ghosts?");
	}

	@Test
	public void testComputeAreas01()
	{
		double[] testWidths = {3, 7, 4, 0};
		double[] testHeights = {2, 1, 5, 32};
		
		double[] areas = ArrayExercises.computeAreas(testWidths, testHeights);
		
		assertEquals(areas[0], 6);
		assertEquals(areas[1], 7);
		assertEquals(areas[2], 20);
		assertEquals(areas[3], 0);
		
		if (areas.length != 4)
		{
			fail("Wrong array length");
		}
	}

	@Test
	public void testRemove01()
	{
		Color differentGreen = new Color(0, 255, 255);
		differentGreen = new Color(0, 255, 0);
		Color[] testArray = {Color.RED, Color.GREEN, Color.BLUE, differentGreen};
		
		testArray = ArrayExercises.remove(testArray, Color.GREEN);
		
		assertEquals(testArray[0], Color.RED);
		assertEquals(testArray[1], Color.BLUE);
		
		if (testArray.length != 2)
		{
			fail("Expected size 3, got size" + testArray.length);
		}
	}
	
	@Test
	public void testRemove02()
	{
		Color[] testArray = {Color.RED, null, Color.GREEN, null, Color.BLUE};
		
		testArray = ArrayExercises.remove(testArray, null);
		
		assertEquals(testArray[0], Color.RED);
		assertEquals(testArray[1], Color.GREEN);
		assertEquals(testArray[2], Color.BLUE);
	}
	
	@Test
	public void testRemove03()
	{
		Color[] testArray = {Color.RED, Color.GREEN, null, Color.BLUE, Color.GREEN};
		
		testArray = ArrayExercises.remove(testArray, Color.GREEN);
		
		assertEquals(testArray[0], Color.RED);
		assertEquals(testArray[1], null);
		assertEquals(testArray[2], Color.BLUE);
		
		if (testArray.length != 3)
		{
			fail("Expected size 3, got size" + testArray.length);
		}
	}

	@Test
	public void testSort01()
	{
		int[] testArray = {2, 5, 7, 4};
		
		ArrayExercises.sort(testArray);
		
		assertEquals(testArray[0], 7);
		assertEquals(testArray[1], 5);
		assertEquals(testArray[2], 4);
		assertEquals(testArray[3], 2);
	}
	
	@Test
	public void testSort02()
	{
		int[] testArray = {4, -2, 13, 8, 13, 4, -17};
		
		ArrayExercises.sort(testArray);
		
		assertEquals(testArray[0], 13);
		assertEquals(testArray[1], 13);
		assertEquals(testArray[2], 8);
		assertEquals(testArray[3], 4);
		assertEquals(testArray[4], 4);
		assertEquals(testArray[5], -2);
		assertEquals(testArray[6], -17);
		
		if (testArray.length != 7)
		{
			fail("Wrong array length");
		}
	}

	@Test
	public void testFindSmallest01()
	{
		Rectangle[] testArray = {new Rectangle(4, 2), new Rectangle(1, 13), new Rectangle(3, 3)};
		
		Rectangle smallest = ArrayExercises.findSmallest(testArray);
		
		assertEquals(smallest, testArray[0]);
	}
	
	@Test
	public void testFindSmallest02()
	{
		Rectangle[] testArray = {new Rectangle(4, 2), new Rectangle(1, 13), new Rectangle(8, 1), new Rectangle(3, 3)};
		
		Rectangle smallest = ArrayExercises.findSmallest(testArray);
		
		assertEquals(smallest, testArray[2]);
	}
	
	@Test
	public void testFindSmallest03()
	{
		Rectangle[] testArray = {new Rectangle(1, 1), new Rectangle(0, 234), new Rectangle(203529, 0)};
		
		Rectangle smallest = ArrayExercises.findSmallest(testArray);
		
		assertEquals(smallest, testArray[2]);
	}
}
