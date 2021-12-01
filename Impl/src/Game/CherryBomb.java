package Game;

public class CherryBomb extends GameMovableElementAdapter
{
	private static String[] ImageName={"Images/CherryBomb_(1).gif"};
	private int cIMG=0;
	private long lastTime=0;
	private long waitTime=200;
	public CherryBomb( int x, int y) 
	{
		super(ImageName[0], x, y);
		// TODO Auto-generated constructor stub
	}
	

	
	public void Step()
	{
		super.Step();
		if (lastTime+waitTime<System.currentTimeMillis())
		{
			this.nextImage();
			lastTime=System.currentTimeMillis();
		}
	}
	
	private void nextImage()
	{
		
		if(cIMG==0)
			SoundStore.get().Play(Sounds.BombFall);
		cIMG=(cIMG+1)%15;
		ChangeImage("Images/CherryBomb_("+(cIMG+1)+").gif");
		if(cIMG==14)
		{
			int x=this.getX();
			int y=this.getY();
			if(x>=160)
				x=x-50;
			if(y>=160)
				y=y-50;
			Game.addNewEntity(new Bang(x,y));
			this.Destroy();
		}
	
	}
	
	
}
