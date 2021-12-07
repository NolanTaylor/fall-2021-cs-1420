package quiz04;

public class StackTest
{
	public static void main(String[] args)
	{
		StackOfBoxes stack = new StackOfBoxes();
		
		stack.addBox(new Box("fore"));
		stack.addBox(new Box("morgana"));
		stack.addBox(new Box("mistoffelees"));
		
		System.out.println(stack.removeTopBox().getThing());
		
		stack.addBox(new Box("aspargus"));
		stack.addBox(new Box("mona"));
		
		for (int i = 0; i < 4; i++)
		{
			System.out.println(stack.removeTopBox().getThing());
		}

		for (int i = 0; i < 13; i++)
		{
			stack.addBox(new Box("" + i));
		}
		
		System.out.println("The stack is " + stack.getHeight() + " boxes tall.");
	}
}
