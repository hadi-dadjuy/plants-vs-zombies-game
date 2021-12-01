package Game;

public class Bang extends GameElementAdapter
{
	private long lastTime=0;
	private long waitTime=500;
	public Bang(int x,int y) {
		// TODO Auto-generated constructor stub
		super("Images/Bang.gif", x, y);
		SoundStore.get().Play(Sounds.Boom);

	}

	@Override
	public void Step() {
		// TODO Auto-generated method stub
		super.Step();
		if(lastTime==0)
			lastTime=System.currentTimeMillis();
		if(lastTime+waitTime<System.currentTimeMillis())
			this.Destroy();
	}
}
