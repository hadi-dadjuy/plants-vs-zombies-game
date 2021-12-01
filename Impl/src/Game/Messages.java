package Game;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Messages 
{
	public static void showMessages(PlayerInfo playerInfo,Graphics graphic,LevelStatus levelStatus) 
	{
		ShowInfo(playerInfo,graphic,  levelStatus);
		ShowLevelNotStarted(playerInfo,graphic, levelStatus);
		ShowGameOver(playerInfo,graphic, levelStatus);
		ShowMenu(playerInfo,graphic, levelStatus);
		ShowLevelWinned(playerInfo,graphic, levelStatus);
	}
	
	
	private static void ShowMenu(PlayerInfo currentPlayer , Graphics graphics ,
			LevelStatus Levelstatus)
	{
		if (Levelstatus==LevelStatus.LevelStop_Player)
		{
			graphics.setColor(Color.gray);
			graphics.fillRect(150 , 472 , 500 , 80);
			graphics.setColor(Color.red);
			graphics.setFont(new Font("Arial" , Font.BOLD , 28));
			graphics.drawString("Game Stop . . ." , 315 , 502);
			graphics.setColor(Color.WHITE);
			graphics.setFont(new Font("Tahoma" , Font.BOLD , 12));
			graphics.drawString("Press  ESC to exit game" , 340 , 527);
			graphics.drawString("Press  Ctrl  to resume game" , 328 , 545);
		}
	}
	
	
	private static void ShowInfo(PlayerInfo playerInfo,Graphics graphics,LevelStatus levelStatus)
	{
		graphics.setColor(Color.red);
		graphics.setFont(new Font("Comic Sans MS",Font.ITALIC,20));
		graphics.drawString(playerInfo.getScore()+"", 22, 81);
		graphics.setColor(Color.BLACK);
		graphics.setFont(new Font("Comic Sans MS",Font.BOLD,19));
		graphics.drawString(playerInfo.getPlayerName()+"'s House", 5, 592);
		graphics.setColor(Color.BLACK);
		graphics.setFont(new Font("Tahoma",Font.BOLD,12));
		graphics.drawString("Level : "+playerInfo.getCurrentLevel(), 730, 592);
	}
	
	
	private static void ShowLevelNotStarted(PlayerInfo currentPlayer , Graphics graphics ,
			LevelStatus Levelstatus)
	{
		if (Levelstatus==LevelStatus.LevelNotStarted)
		{
			
			graphics.setColor(Color.gray);
			graphics.fillRect(150 , 472 , 500 , 80);
			graphics.setFont(new Font("Arial" , Font.BOLD ,25));
			graphics.setColor(Color.red);
			graphics.drawString("Welcome to Plants vs Zombies" , 220 , 502);
			graphics.setColor(Color.WHITE);
			graphics.setFont(new Font("Tahoma" , Font.BOLD , 15));
			graphics.drawString("Press Ctrl to start the game" , 300 , 532);
		}
	}
	
	private static void ShowGameOver(PlayerInfo currentPlayer , Graphics graphics ,
			LevelStatus Levelstatus)
	{
		if (Levelstatus==LevelStatus.GameOver)
		{
			graphics.setColor(Color.gray);
			graphics.fillRect(150 , 472 , 500 , 80);
			graphics.setColor(Color.red);
			graphics.setFont(new Font("Arial" , Font.BOLD , 28));
			graphics.drawString("Game Over !" , 300 , 507);
			graphics.setColor(Color.WHITE);
			graphics.setFont(new Font("Tahoma" , Font.BOLD , 12));
			graphics.drawString("Press Ctrl to Exit" , 330 , 532);
		}
	}
	
	private static void ShowLevelWinned(PlayerInfo currentPlayer , Graphics graphics ,
			LevelStatus Levelstatus)
	{
		if (Levelstatus==LevelStatus.LevelWined)
		{
			graphics.setColor(Color.gray);
			graphics.fillRect(150 , 472 , 500 , 80);
			graphics.setColor(Color.red);
			graphics.setFont(new Font("Arial" , Font.BOLD , 28));
			graphics.drawString("Level Complete ! " , 285 , 504);
			graphics.setColor(Color.WHITE);
			graphics.setFont(new Font("Tahoma" , Font.BOLD , 12));
			graphics.drawString("Press Ctrl to start next level" , 310 , 532);
		}
	}
	
	

}
