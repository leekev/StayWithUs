import java.util.Set;

public class WinCondition extends Encryption{
	public boolean winner;
	public PatternGenerator generate;
	public Set<String> set;
	public WinCondition()
	{
		winner = false;
		generate = new PatternGenerator((int)(Math.random() * 5));
	}
	
	public class WinNode
	{
		public WinNode next;
		public WinNode()
		{
			
		}
	}
}
