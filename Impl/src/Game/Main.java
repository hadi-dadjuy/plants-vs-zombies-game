package Game;



import java.io.IOException;


public class Main 
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
		int curLevel=1;
		LevelStatus gamestatus=LevelStatus.waitNextLevel;
		
		SoundStore.get().LoadSounds();
		while (gamestatus==LevelStatus.waitNextLevel && curLevel<=Levels.FinalLevel)
		{
			SoundStore.get().Play(Sounds.BG);
			Game game=new Game();

			Levels.SetLevel(game ,curLevel);
			
			game.Game_Start();
			
			gamestatus=game.Game_Loop(curLevel++);
			if (gamestatus==LevelStatus.waitGameOver)
				System.exit(0);
		}
		
		if (gamestatus==LevelStatus.waitNextLevel && curLevel==Levels.FinalLevel+1)
			System.out.print("You Complete this GAME...");
		
		System.exit(0);
		
	}// end of main

}
