package Game;

public class RandomZombies
{
	private static int Count;
	private static long lastTime=System.currentTimeMillis();
	private static int[] coord={100,185,285,385,483};
	private static long waitTime=12000;
	private static int destroyedZombies=0;
	public static void RandomZombiesSize(int level)
	{
			destroyedZombies=0;
			Count=level*6+level*3;
	}
	public static  void setZombies(int level)
	{
		if(level==1)
		{
			ZombiesComing1();
		}
		else if(level==2)
		{
			ZombiesComing2();
		}
		else if(level>=3)
		{
			ZombiesComing3();
		}
		
			
	}

	private static void ZombiesComing1()
	{
		
		if(lastTime+waitTime<System.currentTimeMillis() && Count>0)
		{
			Game.addNewEntity(new Zombie(745,285));
			Count--;
			lastTime=System.currentTimeMillis();
			waitTime=Random.get(8000,16000);
		}

	}
	private static void ZombiesComing2()
	{
		if(lastTime+waitTime<System.currentTimeMillis() && Count>0)
		{
			Game.addNewEntity(new Zombie(745,coord[(int) Random.get(1, 4)]));
			Count--;
			lastTime=System.currentTimeMillis();
			waitTime=Random.get(6000,12000);
		}
	}
	private static void ZombiesComing3()
	{
		if(lastTime+waitTime<System.currentTimeMillis() && Count>0)
		{
			Game.addNewEntity(new Zombie(745,coord[(int) Random.get(0, 5)]));
			Count--;
			lastTime=System.currentTimeMillis();
			waitTime=Random.get(7000,14000);
		}
		
	}
	public static int getDestroyedZombies() {
		return destroyedZombies;
	}

	public static void increaseDestroyedZombies() {
		RandomZombies.destroyedZombies ++;
	}

}
