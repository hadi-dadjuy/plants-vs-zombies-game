package Game;

public class SunFlower extends GameElementAdapter
{
	private static String ImageNames[]={"Images/SunFlower_(1).gif"};
	private long waitTime=3000;
	private long waitTimeIMG=100;
	private long lastTimeIMG=0;
	private long lastTime=System.currentTimeMillis();
	private int cIMG=0;
	private long eatWaitTime=10000;
	private long eatLastTime=0;
	public SunFlower(int x, int y) 
	{
		super( ImageNames[0], x, y);

	}

	private void setStars()
	{
	
		if(lastTime+waitTime<System.currentTimeMillis())
		{
			Game.addNewEntity(new Star((int) (this.getX()+Random.get(30, 42)),this.getY()+10));
			waitTime=Random.get(8000, 15000);
			lastTime=System.currentTimeMillis();
		}
	}
	private void nextImage()
	{
		cIMG=(cIMG+1)%54;
		ChangeImage("Images/SunFlower_("+(cIMG+1)+").gif");
	}
	
	@Override
	public void Step() {
		// TODO Auto-generated method stub
		super.Step();
		if (lastTimeIMG+waitTimeIMG<System.currentTimeMillis())
		{
			this.nextImage();
			lastTimeIMG=System.currentTimeMillis();
		}	
		setStars();

	}
	@Override
	public void CollideWith(GameElementAdapter element) {
		// TODO Auto-generated method stub
		super.CollideWith(element);
		if(element instanceof Zombie)
		{
			if(eatLastTime==0)
			{
				eatLastTime=System.currentTimeMillis();
				SoundStore.get().Play(Sounds.Eat);
			}
			if(eatLastTime+eatWaitTime<System.currentTimeMillis())
				this.Destroy();
		}
	}



}
