import java.util.HashMap;
import java.util.Map;
public class WoodenDoor extends Encryption{
	public Map<Integer, Character> locks;
	public Door masterLock;
	public WoodenDoor(Encryption e)
	{
		locks = new HashMap<Integer, Character>();
		masterLock = new Door(e);
		placeLocks();
	}
	public void placeLocks()
	{
		while(locks.size() != 10)
		{
			int index = (int) (Math.random() * 10);
			while (locks.containsKey(index))
				index = (int) (Math.random() * 10);
			locks.put(index, masterLock.code.charAt(index));
		}
	}
	public class Door
	{
		public String code;
		public Encryption next;
		public Door(Encryption e)
		{
			next = new Encryption();
			code = "StayWithUs";
		}
		public Encryption unlock(String key)
		{
			if (key.equals("StayWithUs"))
				return next;
			return null;
		}
	}
	
	//the code is "StayWithUs"

}
