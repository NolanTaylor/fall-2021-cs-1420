package quiz04;

public class StackOfBoxes
{
	private Box top_box;
	
	public StackOfBoxes()
	{
		top_box = null;
	}
	
	// get the box on top
	public Box getTopBox()
	{
		return top_box;
	}
	
	// add a box on top
	public void addBox(Box box)
	{
		box.setUnder(top_box);
		top_box = box;
	}
	
	// remove the top box and return it
	public Box removeTopBox()
	{
		Box temp_box = top_box;
		top_box = top_box.getUnder();
		return temp_box;
	}
	
	// get the height of the stack
	public int getHeight()
	{
		return top_box.getHeight();
	}
}
