package quiz02;

/**
 * 
 * A tester program to showcase the ChristmasPresent class.
 * 
 * @author Nolan Taylor
 * @version 10/5/21
 */

public class Tester
{

	public static void main(String[] args)
	{
		System.out.println("Testing the ChristmasPresent class:");
		
		// Test the functions for volume and surface area
		ChristmasPresent present1 = new ChristmasPresent(30, 70, 12, "Toy Train");
		
		System.out.println("The volume of present 1 is " + present1.getVolume());
		System.out.println("The surface area  of present 1 is " + present1.getSurfaceArea());
		
		ChristmasPresent present2 = new ChristmasPresent(8, 11, 3, "Santa's Unfilled Tax Forms");
		
		System.out.println("The volume of present 2 is " + present2.getVolume());
		System.out.println("The surface area of present 2 is " + present2.getSurfaceArea());
		
		ChristmasPresent present3 = new ChristmasPresent(538, 213, 627, "Pony");
		
		// Test the getter and setter functions as well as the toString function
		System.out.println("Present 3 is " + present3);
		System.out.println("The width of present 3 is " + present3.getWidth());
		System.out.println("Changing present 3's contents to a Laser Pony");
		
		present3.setContents("Laser Pony");
		
		System.out.println("Present 3 now contains a " + present3.getContents());
	}

}
