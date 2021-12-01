package Game;

import java.awt.event.MouseEvent;

public class Star extends GameMovableElementAdapter
{
	
	public static final int Score=25;
	private static String ImageNames[]={"Images/Sun1.png"};
	private long lastTime=0;
	private long waitTime=200;
	private int cIMG=0;
	public Star( int x, int y) {
		super(ImageNames[0], x, y);
		setSpeedX(0);
		setSpeedY(2);
		setDownDirection();
		StartMoving();
	}
	@Override
	protected void CollideDownBorder() {
		// TODO Auto-generated method stub
		super.CollideDownBorder();
		this.Destroy();
	}

	private void nextImage()
	{
		cIMG=(cIMG+1)%4;
		ChangeImage("Images/Sun"+(cIMG+1)+".png");
	}
	@Override
	public void Step() {
		// TODO Auto-generated method stub
		super.Step();
		if(lastTime+waitTime<System.currentTimeMillis())
		{
			nextImage();
			lastTime=System.currentTimeMillis();
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseClicked(e);
		if(e.getX()>=this.getX() && e.getX()<=this.getX()+this.getWidth() && 
				e.getY()>=this.getY() && e.getY()<=this.getY()+this.getHeight())
		{
			Game.IncreaseScore(Score);
			this.Destroy();
		}
	}
	@Override
	public boolean WantMouseEvents() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
