package quiz04;

public class Box
{
	private Object thing;
	private Box under_me;
	
	public Box(Object thing)
	{
		this.thing = thing;
		under_me = null;
	}
	
	// get the thing in the box
	public Object getThing()
	{
		return thing;
	}
	
	// get the box under the box
	public Box getUnder()
	{
		return under_me;
	}
	
	// set the box under the box
	public void setUnder(Box under)
	{
		under_me = under;
	}
	
	// get the height of the box by adding 1 to the height of the box below it
	public int getHeight()
	{
		if (under_me == null)
		{
			return 1;
		}
		
		return 1 + under_me.getHeight();
	}
}
