package Game;

public class PeaShooter extends GameMovableElementAdapter 
{
	

	private static String ImageNames[]={"Images/PeaShooter_(1).gif"};
	private long waitTime=1580;
	private long waitTimeIMG=100;
	private long lastTimeIMG=0;
	private long lastTime=0;
	private int cIMG=0;
	private long eatWaitTime=8000;
	private long eatLastTime=0;
	private boolean isDarting=false;
	private int position;
	public PeaShooter(int x, int y) {
		super( ImageNames[0], x, y);
		if(y==100)
			position=1;
		else if(y==185)
			position=2;
		else if(y==285)
			position=3;
		else if(y==385)
			position=4;
		else if(y==483)
			position=5;
	}

	private void Dart()
	{
		if(isDarting==true)
		{
			if (lastTime+waitTime<System.currentTimeMillis())
			{
				SoundStore.get().Play(Sounds.Pea);
				Game.addNewEntity(new Pea(this.getX()+40, this.getY()+5));
				lastTime=System.currentTimeMillis();
			}
			
		}
	}
	
	
	private void nextImage()
	{
		cIMG=(cIMG+1)%24;
		ChangeImage("Images/PeaShooter_("+(cIMG+1)+").gif");
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
		this.isDarting=PositionThreart.isThreat(position);
		this.Dart();
	}
	
	
	@Override
	public void CollideWith(GameElementAdapter element) {
		// TODO Auto-generated method stub
		super.CollideWith(element);
		if(element instanceof Zombie)
		{
			if(eatLastTime==0)
				eatLastTime=System.currentTimeMillis();
			if(eatLastTime+eatWaitTime<System.currentTimeMillis())
				this.Destroy();
		}
	}


}
