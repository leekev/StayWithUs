import java.util.HashSet;
import java.util.Set;

public class PatternGenerator {
	public PatternGenerator()
	{

	}

	public int run(int number, Set<Integer> set)
	{
		//if (number == 0)
			return zero(set);
//		if (number == 1)
//			return one(set);
//		if (number == 2)
//			return two(set);
//		if (number == 3)
//			return three(set);
//		return four(set);
	}

	public int zero(Set<Integer> set)
	{
		int random = (int) (Math.random() * 100);
		int hash = Integer.toString(random).hashCode();
		set.add(hash);
		set.add(hash/2);
		set.add(hash * 2);
		set.add(hash/4);
		set.add(hash * 4);
		set.add(hash/8);
		return hash*8;
	}

//	public int one(Set<Integer> set)
//	{
//		
//
//	}
//	public int two(Set<Integer> set)
//	{
//
//	}
//	public int three(Set<Integer> set)
//	{
//
//	}
//	public int four(Set<Integer> set)
//	{
//
//	}
}
