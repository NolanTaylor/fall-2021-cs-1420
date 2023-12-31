package lab08;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Rect objects represent a rectangle shape
 * drawn to the screen at a particular position
 * with some size and color.
 *
 * @author Nolan Taylor
 * @version 10/26/21
 */
public class Rect extends Shape
{
    // Instance variables.
    private int width, height;

    /**
     * Constructor - initializes the position, diameter, and
     * color of this circle object.
     *
     * @param x
     *         the x coordinate of this object's position
     *
     * @param y
     *         the x coordinate of this object's position
     *
     * @param width
     *              width of the rectangle
     *              
     * @param height
     * 				the height of the rectangle
     *
     * @param color
     *             the color of this rectangle
     */
    public Rect (int x, int y, int width, int height, Color color)
    {
		super (x, y, color);
		
		this.width = width;
		this.height = height;
    }

    /**
     * Draws the rectangle at it's current position and color
     * to the specified graphics object.
     *
     * @param g
     *         the graphics object (where to draw to)
     */
    public void draw (Graphics g)
    {
    	g.setColor (color);
    	g.fillRect(x, y, width, height);
    }  
    
    /**
     * Returns true if the coordinates are within the circle.
     *
     * @param targetX
     *               an x coordinate
     *
     * @param targetY
     *               a y coordinate
     *
     * @return
     *        true if the coordinates are within the shape
     */
    public boolean isInside (int targetX, int targetY)
    {	
    	return targetX >= x &&
    		       targetX < x + width &&
    		       targetY >= y &&
    		       targetY < y + height;
    }
}
