package Game;

public class RandomStars
{
	private static int Count=15;
	private static long lastTime=System.currentTimeMillis();
	private static long waitTime=4000;



	public static void setStars(int level)
	{	
		StarsComing();
	}
	private static void StarsComing()
	{
		if(lastTime+waitTime<System.currentTimeMillis() && Count>0)
		{
			Game.addNewEntity(new Star((int)Random.get(120, 600),(int)Random.get(60, 200)));
			Count--;
			lastTime=System.currentTimeMillis();
			waitTime=Random.get(5000, 12000);
		}

	}
	
	

}
