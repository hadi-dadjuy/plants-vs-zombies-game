package Game;

public class Pea extends GameMovableElementAdapter
{
	private long lastTime=0;

	private static String ImageNames[]={"Images/Pea.png"};
	public Pea(int x, int y) {
		super(ImageNames[0], x, y);
		setSpeedX(10);
		setSpeedY(0);
		setRightDirection();
		StartMoving();
		SoundStore.get().Play(Sounds.Pea);
	}
	
	@Override
	protected void CollideRightBorder() {
		// TODO Auto-generated method stub
		super.CollideRightBorder();
		ChangeImage("Images/Pea1.png");	
	}
	@Override
	public void CollideWith(GameElementAdapter element) {
		// TODO Auto-generated method stub
		super.CollideWith(element);
		if(lastTime==0)
			lastTime=System.currentTimeMillis();
		else if(element instanceof Zombie)
		{
			ChangeImage("Images/Pea1.png");
			lastTime=0;
		}
	}

	
	@Override
	public void Step() {
		// TODO Auto-generated method stub
		super.Step();
		if(this.getSprite()==SpriteStore.get().getSprite("Images/Pea1.png"))
			this.Destroy();
	}
}
