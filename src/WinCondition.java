import java.util.HashSet;
import java.util.Set;

public class WinCondition extends Encryption{
	private boolean winner;
	public PatternGenerator generate;
	public Set<Integer> set;
	public int key;
	public WinCondition()
	{
		set = new HashSet<Integer>();
		winner = false;
		generate = new PatternGenerator();
		key = generate.run((int)(Math.random() * 5), set);
	}
	public void unlock(int guess)
	{	
		if (key == guess)
			winner = true;
	}
	
	public boolean result()
	{
		return winner;
	}
}
