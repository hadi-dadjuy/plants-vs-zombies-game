package Game;

public class Random 
{
	public static long get(long x,long y)
	{
		long p=0;
		if(x<y)
		{
			p=(long) (x+(y-x)*Math.random());
		}
		return p;
	}

}
