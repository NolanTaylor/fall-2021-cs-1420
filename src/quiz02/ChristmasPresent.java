package quiz02;

/**
 * This is a class for a Christmas present object.
 * The object represents the height, width, and depth of the box,
 * as well as the present inside the box.
 * The object will also calculate the volume and surface area of the present.
 * 
 * @author Nolan Taylor
 * @version 10/5/21
 */

public class ChristmasPresent
{
	private int width, height, depth;
	private String contents;
	
	/**
	 * Constructor function that sets the object's dimensions
	 * and the contents of the present.
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @param present
	 */
	public ChristmasPresent(int x, int y, int z, String present)
	{
		this.width = x;
		this.height = y;
		this.depth = z;
		this.contents = present;
	}
	
	// Getter functions that each return their respective variables from the object
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	public int getDepth() { return depth; }
	public String getContents() { return contents; }
	
	/**
	 * A function that overrides the current contents of the box with a new one.
	 * 
	 * @param newContent
	 */
	public void setContents(String newContent)
	{
		this.contents = newContent;
	}
	
	/**
	 * This function calculates the volume of the present.
	 * 
	 * @return volume
	 */
	public int getVolume()
	{
		int volume = width * height * depth;
		return volume;
	}
	
	/**
	 * This function calculates the surface area of the present.
	 * 
	 * @return surface area
	 */
	public int getSurfaceArea()
	{
		int surfaceArea = 2 * ((width * depth) + (height * depth) + (height * width));
		return surfaceArea;
	}
	
	/**
	 * This function converts the object into a readable string.
	 * 
	 * @return the object as a string
	 */
	public String toString()
	{
		return "A " + width + "x" + height + "x" + depth + " present with " + contents + " inside.";
	}
}
