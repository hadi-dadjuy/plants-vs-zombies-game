package Game;

public class WallNut extends GameMovableElementAdapter
{
	private static String ImageNames[]={"Images/WallNut_(1).gif","Images/WallNutEat_(1).gif",
		"Images/WallNutEat_(2).gif","Images/WallNutEat_(3).gif"};
	
	private long waitTimeIMG=100;
	private long lastTimeIMG=0;
	private boolean isEated=false;
	private int cIMG=0;
	private long eatWaitTime1=8000;
	private long eatWaitTime2=8000;
	private long eatWaitTime3=8000;
	private long eatWaitTime4=8000;
	private long eatLastTime=0;
	public WallNut(int x,int y) 
	{
		super(ImageNames[0],x,y);
	}

	private void nextImage()
	{
		cIMG=(cIMG+1)%44;
		ChangeImage("Images/WallNut_("+(cIMG+1)+").gif");
	}
	
	@Override
	public void Step() {
		// TODO Auto-generated method stub
		super.Step();
		
		if (lastTimeIMG+waitTimeIMG<System.currentTimeMillis() && isEated==false)
		{
			this.nextImage();
			lastTimeIMG=System.currentTimeMillis();
		}	

	}
	@Override
	public void CollideWith(GameElementAdapter element) {
		// TODO Auto-generated method stub
		super.CollideWith(element);
		if(element instanceof Zombie)
		{
			if(eatLastTime==0)
				eatLastTime=System.currentTimeMillis();
			else if(eatLastTime+eatWaitTime1<System.currentTimeMillis() && eatWaitTime1!=0)
			{
				isEated=true;
				SoundStore.get().Play(Sounds.Eat);
				ChangeImage(ImageNames[1]);
				eatWaitTime1=0;
				eatLastTime=System.currentTimeMillis();
			}
			else if(eatLastTime+eatWaitTime2<System.currentTimeMillis() && eatWaitTime2!=0)
			{
				isEated=true;
				SoundStore.get().Play(Sounds.Eat);
				ChangeImage(ImageNames[2]);
				eatWaitTime2=0;
				eatLastTime=System.currentTimeMillis();			
			}
			else if(eatLastTime+eatWaitTime3<System.currentTimeMillis() && eatWaitTime3!=0)
			{
				isEated=true;
				SoundStore.get().Play(Sounds.Eat);
				ChangeImage(ImageNames[3]);
				eatWaitTime3=0;
				eatLastTime=System.currentTimeMillis();	
			}
			else if(eatLastTime+eatWaitTime4<System.currentTimeMillis() && eatWaitTime4!=0)
			{
				isEated=true;
				SoundStore.get().Play(Sounds.Eat);
				eatWaitTime4=0;
				eatLastTime=System.currentTimeMillis();	
				this.Destroy();
			}
		}
		
	}
	
	
	
	
}
