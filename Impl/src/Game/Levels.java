package Game;

import java.awt.Cursor;

public abstract class Levels 
{
	public static final int	FinalLevel	=5;
	
	public static void SetLevel(Game game , int level)
	{
		if (level==1)
		{
			// configs of Level 1
			PlayerInfo p=new PlayerInfo();
			p.setScore(50);
			p.setPlayerName("Hadi Dadjuy");
			p.setCurrentLevel(1);
			game.setPlayerInfo(p);
			LoadMap(game , 1);
		}
		
		else if (level<=FinalLevel)
		{
			//PlayerInfo p=new PlayerInfo();
			PlayerInfo p=game.getPlayerInfo();
			p.setCurrentLevel(p.getCurrentLevel()+1);
			p.setScore(150);
			p.setPlayerName("Hadi Dadjuy");
			game.setPlayerInfo(p);
			LoadMap(game , level);
		}
		
	}
	
	private static void LoadMap(Game game , int level)
	{
		if (level==1)
			LoadMap1(game);
		if (level==2)
			LoadMap2(game);
		if (level==3)
			LoadMap3(game);
		if (level==4 )
			LoadMap4(game);
		if (level==5 )
			LoadMap5(game);
	}
	
	
	
	private static void LoadMap1(Game game)
	{
		game.clearEntities();
		// Static parts
		game.setNextEntity(new BackGround(0,0,1));
		game.setNextEntity(new PeaShooterButton(90,11));

	}

	private static void LoadMap2(Game game)
	{
		game.clearEntities();
		// Static parts
		game.setNextEntity(new BackGround(0,0,2));
		game.setNextEntity(new PeaShooterButton(90,11));
		game.setNextEntity(new SunFlowerButton(145,11));

	}
	private static void LoadMap3(Game game)
	{
		game.clearEntities();
		// Static parts
		game.setNextEntity(new BackGround(0,0,3));
		game.setNextEntity(new PeaShooterButton(90,11));
		game.setNextEntity(new SunFlowerButton(144,11));
		game.setNextEntity(new ShovelButton(519,0));
	}
	
	private static void LoadMap4(Game game)
	{
		game.clearEntities();
		// Static parts
		game.setNextEntity(new BackGround(0,0,3));
		game.setNextEntity(new PeaShooterButton(90,11));
		game.setNextEntity(new SunFlowerButton(144,11));
		game.setNextEntity(new ShovelButton(519,0));
		game.setNextEntity(new WallNutButton(199,11));

	}
	
	private static void LoadMap5(Game game)
	{
		game.clearEntities();
		// Static parts
		game.setNextEntity(new BackGround(0,0,3));
		game.setNextEntity(new PeaShooterButton(90,11));
		game.setNextEntity(new SunFlowerButton(144,11));
		game.setNextEntity(new ShovelButton(519,0));
		game.setNextEntity(new WallNutButton(199,11));
		game.setNextEntity(new CherryBombButton(252,11));

	}
}
