
public class Moat extends Encryption {
	public Encryption[] defense;
	public Moat(Encryption e) //int key)
	{
		defense = new Encryption[10];
		fillMoat(e);
	}
	
	public void fillMoat(Encryption e) // int key)
	{
		for (int i = 0; i < 10; i ++)
		{
			defense[i] = null;
		}
		defense[8] = e;
	}
	
	@Override
	public void inspect() {
	    super.inspect("src/Moat.java");
	}

}
