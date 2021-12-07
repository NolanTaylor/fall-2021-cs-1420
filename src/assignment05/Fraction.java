package assignment05;

/**
 * This is a class that holds a fraction.
 * The fraction is able to be multiplied and divided
 * and be converted into a string
 * 
 * @author Nolan Taylor
 * @version 9/28/21
 */

public class Fraction
{
	long numerator;
	long denominator;
	
	/**
	 * The constructor function for the object.
	 * Makes a fraction from the arguments numerator and denominator
	 * 
	 * @param n
	 * @param d
	 */
	public Fraction(long n, long d)
	{
	    this.numerator = n;
	    this.denominator = d;
	    
	    // compute the greatest common divisor of x and y using a
	    // well-known algorithm.

	    long gcd = n;
	    long remainder = d;

	    while (remainder != 0)
	    {
	        long temp = remainder;
	        remainder = gcd % remainder;
	        gcd = temp;
	    }
	    
	    this.numerator = n / gcd;
	    this.denominator = d / gcd;
	}
	
	/**
	 * A second constructor function that initializes the object using only one
	 * integer, the numerator, and sets the denominator to 1
	 * 
	 * @param n
	 */
	public Fraction(long n)
	{
		this.numerator = n;
	    this.denominator = 1;
	}
	
	/**
	 * This function returns the fraction object as a string of the numerator over the denominator
	 * 
	 */
	public String toString()
	{
		return this.numerator + "/" + this.denominator;
	}
	
	/**
	 * This function adds another fraction to the object
	 * and returns the sum of the two fractions
	 * 
	 * @param rightHandSide
	 * @return sum of fractions
	 */
	public Fraction add(Fraction rightHandSide)
	{
		// create a variable to hold the result
		Fraction result;
	    
	    // create a new fraction by adding the numerators of the fractions multiplied to have the same denominator
	    result = new Fraction(this.numerator * rightHandSide.denominator + rightHandSide.numerator * this.denominator, 
	    		this.denominator * rightHandSide.denominator);
	    
	    return result;
	}
	
	/**
	 * This function subtracts another fraction from the object
	 * and returns the difference of the two fractions
	 * 
	 * @param rightHandSide
	 * @return difference of fractions
	 */
	public Fraction subtract(Fraction rightHandSide)
	{
		// create a variable to hold the result
		Fraction result;
		
		// create a new fraction by adding the numerators of the fractions multiplied to have the same denominator
		result = new Fraction(this.numerator * rightHandSide.denominator - rightHandSide.numerator * this.denominator, 
	    		this.denominator * rightHandSide.denominator);
	    
	    return result;
	}
	
	/**
	 * This function multiplies another fraction with the object
	 * and returns the product of the two fractions
	 * 
	 * @param rightHandSide
	 * @return product of fractions
	 */
	public Fraction multiply(Fraction rightHandSide)
	{
	    // Create a variable to hold the result
	    Fraction result;  

	    // Build a new Fraction object - send the products to the constructor.
	    result = new Fraction(this.numerator * rightHandSide.numerator,
	    		this.denominator * rightHandSide.denominator);

	     // Pass the resulting fraction back to the caller.
	     return result; 
	}
	
	/**
	 * This function divides another fraction with the object
	 * and returns the quotient of the two fractions
	 * 
	 * @param rightHandSide
	 * @return quotient of fractions
	 */
	public Fraction divide(Fraction rightHandSide)
	{
	    // Create a variable to hold the result
	    Fraction result;  

	    // Build a new Fraction object - send the products to the constructor.
	    result = new Fraction(this.numerator * rightHandSide.denominator,
	    		this.denominator * rightHandSide.numerator);

	     // Pass the resulting fraction back to the caller.
	     return result; 
	}
	
	public long getNumerator()
	{
	    return numerator;
	}
	
	public long getDenominator()
	{
	    return denominator;
	}

	public static void main(String[] args)
	{

	}

}
