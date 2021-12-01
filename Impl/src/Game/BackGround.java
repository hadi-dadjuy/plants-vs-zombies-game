package Game;

import Game.GameElementAdapter;

public class BackGround extends GameElementAdapter
{	

	public BackGround(int x,int y,int type)
	{
		super("Images/mainBG"+type+".jpg",x,y);
	}

}
