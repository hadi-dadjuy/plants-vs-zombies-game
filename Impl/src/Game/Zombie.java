package Game;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;


public class Zombie extends GameMovableElementAdapter
{
	
	private int position;
	private int cIMG=0;
	private int live=10;
	private long waitTime=230;
	private long eatWaitTime=8000;
	private long eatLastTime=0;
	private long lastTime=0;
	private boolean isBang=false;
	private boolean isEating=false;

	public Zombie(int x,int y)
	{
		super("Images/Zombie_(1).gif", x, y-8);
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
		setSpeedX(1);
		setSpeedY(0);
		setLeftDirection();
		StartMoving();
		PositionThreart.setThreat(position,true);

	}
	public void Step()
	{
		super.Step();
		if(isBang==false )
			this.StartMoving();
		PositionThreart.setThreat(position,true);
		if (lastTime+waitTime<System.currentTimeMillis() && isBang==false)
		{
			this.nextImage();
			lastTime=System.currentTimeMillis();
		}
		else if (lastTime+waitTime<System.currentTimeMillis() && isBang==true)
		{
			this.nextImageBang();
			lastTime=System.currentTimeMillis();
		}
		if(live==2)
		{
			cIMG=0;
		}
	}
	
	private void nextImage()
	{
	
		if(live==2 || live==1 || live==0)
		{
			cIMG=(cIMG+1)%6;
			ChangeImage("Images/Zombie("+(cIMG+1)+").gif");
			if(cIMG==5)
			{
				RandomZombies.increaseDestroyedZombies();
				//PositionThreart.setThreat(position, false);
				this.Destroy();
			}
		}
		else
		{
			cIMG=(cIMG+1)%4;
			ChangeImage("Images/Zombie_("+(cIMG+1)+").gif");
		}
	}
	
	
	private void nextImageBang()
	{
		cIMG=(cIMG+1)%30;
		ChangeImage("Images/ZombieBang_("+(cIMG+1)+").gif");
		if(cIMG==29)
		{
			PositionThreart.setThreat(position,false);
			this.Destroy();
		}
	}
	
	@Override
	protected void CollideLeftBorder() {
		super.CollideLeftBorder();
		SoundStore.get().Play(Sounds.GameOver);
		Game.setGameStatus(LevelStatus.GameOver);
		
	}
	
	@Override
	public void CollideWith(GameElementAdapter element) {
		super.CollideWith(element);
		if(element instanceof Pea)
		{
			live--;
			PositionThreart.setThreat(position,true);
			 if(live==0)
			{
				PositionThreart.setThreat(position,false);
				RandomZombies.increaseDestroyedZombies();
				this.Destroy();
			}
		}
		if(element instanceof WallNut )
		{
			this.StopMoving();
			isEating=true;
		}
		if(element instanceof Zombie)
		{
			if(isEating==false)
				this.StopMoving();
		}
		if((element instanceof SunFlower) || (element instanceof PeaShooter))
		{
			this.StopMoving();
			if(eatLastTime==0)
				eatLastTime=System.currentTimeMillis();
			if (eatWaitTime+eatLastTime<System.currentTimeMillis())
			{
				StartMoving();
			}
		}
		if(element instanceof Bang)
		{
			this.StopMoving();
			if(isBang==false)
			{
				isBang=true;
				cIMG=0;
			}
			waitTime=120;
		}
	}

}
