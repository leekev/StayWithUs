
public class Moat extends Encryption {
	public Encryption[] defense;
	public Moat(Encryption e)
	{
		defense = new Encryption[10];
		fillMoat();
	}
	
	public void fillMoat()
	{
		for (int i = 0; i < 10; i ++)
		{
			defense[i] = null;
		}
		defense[8] = new Encryption();
	}

}
