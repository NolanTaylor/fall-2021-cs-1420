package assignment05;

/**
 * This program creates several fraction objects and tests
 * them by multiplying and dividing them.
 * 
 * @author Nolan Taylor
 * @version 9/28/21
 */

public class FractionTester
{

	public static void main(String[] args)
	{	
		System.out.println("fraction tester:");
		
		Fraction f = new Fraction(1, 5);
		Fraction g = new Fraction(2, 6);
		Fraction h = new Fraction(8, 4);
		
		// test if the reduction worked correctly
		System.out.println("Fraction f contains: " + f);
		System.out.println("Fraction g contains: " + g);
		System.out.println("Fraction h contains: " + h);
		
		Fraction a = f.multiply(g);
		Fraction b = g.divide(h);
		Fraction c = h.add(g);
		Fraction d = f.subtract(h);
		
		// test if multiply, divide, add, and subtract all work correctly
		System.out.println("Fraction f multiplied by g is: " + a);
		System.out.println("Fraction g divided by h is: " + b);
		System.out.println("Fraction h added to g is: " + c);
		System.out.println("Fraction f subracted by h is: " + d);
		
		if (a.getNumerator() != 1 || a.getDenominator() != 15 ||
			b.getNumerator() != 1 || b.getDenominator() != 6 ||
			c.getNumerator() != 7 || c.getDenominator() != 3 ||
			d.getNumerator() != -9 || d.getDenominator() != 5)
		{
			System.out.println("All tests completed, errors found.");
		}
		else
		{
			System.out.println("All tests completed, no errors.");
		}
	}

}
