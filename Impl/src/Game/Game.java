package Game;



import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Game 
{

	private static PlayerInfo currentPlayer;
	private static LevelStatus levelStatus=LevelStatus.LevelNotStarted;
	private static GameElementAdapter	Entities[]	=new GameElementAdapter[999999];
	private static int					cEntities	=0;
	private JFrame						frmMain;
	private static BufferStrategy	 buffer;
	private long waitTime=300000;
	private static Graphics graphics;
	public Game() throws IOException 
	{
		
		GraphicsEnvironment genv=GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device=genv.getDefaultScreenDevice();
		GraphicsConfiguration gc=device.getDefaultConfiguration();
		frmMain=new JFrame(gc);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.setUndecorated(true);
		frmMain.setResizable(false);
		frmMain.setLayout(null);
		frmMain.setIgnoreRepaint(true);
		device.setFullScreenWindow(frmMain);
		device.setDisplayMode(new DisplayMode(GameConstants.GameWidth , GameConstants.GameHeight ,	32 , 0));	
		frmMain.requestFocus();
		frmMain.addKeyListener(new KeyHandler());
		frmMain.addMouseListener(new MouseHandler());
		frmMain.addMouseMotionListener(new MouseHandler());
		frmMain.createBufferStrategy(2);
		buffer=frmMain.getBufferStrategy();
		buffer.show();	
	
	}


	
	public static PlayerInfo getPlayer()
	{
		return currentPlayer;
	}
	
	public static Graphics getBufferGraphics()
	{
		return graphics;
	}
	public void setPlayerInfo(PlayerInfo p)
	{
		currentPlayer=new PlayerInfo(p);
	}
	
	public PlayerInfo getPlayerInfo()
	{
		return currentPlayer;
	}
	public void setNextEntity(GameElementAdapter element)
	{
		element.setID(cEntities);
		Entities[cEntities++]=element;
	}
	
	public static void addNewEntity(GameElementAdapter element)
	{
		element.setID(cEntities);
		Entities[cEntities++]=element;
	}
	public static void setGameStatus(LevelStatus levelStatus)
	{
		Game.levelStatus=levelStatus;
	}
	public static void IncreaseScore(int score)
	{
		currentPlayer.setScore(currentPlayer.getScore()+score);
		SoundStore.get().Play(Sounds.Score);
	}
	public static void DecreaseScore(int score)
	{
		currentPlayer.setScore(currentPlayer.getScore()-score);
	}

	public void clearEntities()
	{
		cEntities=0;
	}
	
	public LevelStatus Game_Loop(int level) throws IOException, InterruptedException
	{
		RandomZombies.RandomZombiesSize(level);
		PositionThreart.setDefault();
		Element.setLevel(level);
		while (true)
		{
			if (levelStatus==LevelStatus.LevelRunning)
				Thread.sleep(120);
			if(waitTime==300000)
			{
				SoundStore.get().Play(Sounds.BG);
				waitTime=0;
			}
			else 
				waitTime++;
			graphics=buffer.getDrawGraphics();
			if (RandomZombies.getDestroyedZombies()==3)
			{
				SoundStore.get().Play(Sounds.Wined);
					levelStatus=LevelStatus.LevelWined;
			}
			
			if (levelStatus==LevelStatus.LevelRunning)
			{
				for (int i=0 ; i<cEntities ; i++)
					Entities[i].Step();
				CheckCollisions();
			}
			for (int i=0; i<cEntities ; i++)
				Entities[i].draw(graphics);
			Messages.showMessages(currentPlayer , graphics , levelStatus);
			if(levelStatus==LevelStatus.LevelRunning)
			{
				RandomZombies.setZombies(level);
				RandomStars.setStars(level);
			}
				buffer.show();
				graphics.dispose();
				if ((levelStatus==LevelStatus.waitNextLevel)||(levelStatus==LevelStatus.waitGameOver))
					return levelStatus;
		}// End of While(true)
		
	}

	public void Game_Start()
	{
		levelStatus=LevelStatus.LevelNotStarted;
	}
	
	
	public static void NotifyDeath(GameElementAdapter element)
	{
		Entities[cEntities-1].setID(element.getID());
		Entities[element.getID()]=Entities[--cEntities];
	}
	
	private void CheckCollisions()
	{
		// Check collision of all moving elements with static elements
		for (int mm=1 ; mm<cEntities ; mm++)
		{
			for (int i=mm+1 ; i<cEntities ; i++)
			{
				GameElementAdapter me=(GameElementAdapter) Entities[mm];
				GameElementAdapter him=(GameElementAdapter) Entities[i];
				if (me.Contains(him))
				{
					me.CollideWith(him);
					him.CollideWith(me);
				}
			}
		}
	} // end of method check collisions
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	private class MouseHandler extends MouseAdapter implements MouseListener , MouseMotionListener
	{

		@Override
		public void mouseClicked(MouseEvent e)
		{
			if (levelStatus==LevelStatus.LevelRunning)
			{
				//Element.MouseAction(e, 1);
				for (int i=0 ; i<cEntities ; i++)
					if (Entities[i].WantMouseEvents())
					{
						Entities[i].mouseClicked(e);
					}
				return;
			}
		}
		
		@Override
		public void mouseDragged(MouseEvent e)
		{
		}
		
		@Override
		public void mouseEntered(MouseEvent e)
		{

		}
		
		@Override
		public void mouseExited(MouseEvent e)
		{
		}
		
		@Override
		public void mousePressed(MouseEvent e)
		{
			Element.MouseAction(e, 1);
		
			if (levelStatus==LevelStatus.LevelRunning)
			{
				for (int i=0 ; i<cEntities ; i++)
					if (Entities[i].WantMouseEvents())
					{
						Entities[i].mousePressed(e);
					}
				return;
			}
		}
		
		@Override
		public void mouseReleased(MouseEvent e)
		{
			if (levelStatus==LevelStatus.LevelRunning)
			{
				for (int i=0 ; i<cEntities ; i++)
					if (Entities[i].WantMouseEvents())
					{
						Entities[i].mouseReleased(e);
					}
				return;
			}
		}
		@Override
		public void mouseMoved(MouseEvent e) 
		{
			Element.MouseAction(e, 0);
		}

		
	}

		
		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ key Adapter
		private class KeyHandler extends KeyAdapter
		{
			public void keyPressed(KeyEvent e)
			{
				if (levelStatus==LevelStatus.LevelRunning)
				{
					// say to all elements that a key Pressed
					for (int i=0 ; i<cEntities ; i++)
						if (Entities[i].WantKeyEvents())
							Entities[i].KeyPressed(e);
					return;
				}
			}
			
			public void keyReleased(KeyEvent e)
			{
				if (e.getKeyCode()==KeyEvent.VK_ESCAPE)
				{
					if (levelStatus==LevelStatus.LevelStop_Player ||
							levelStatus==LevelStatus.LevelWined)
						levelStatus=LevelStatus.waitGameOver;
					if (levelStatus==LevelStatus.LevelRunning )
						levelStatus=LevelStatus.LevelStop_Player;
					return;
				}
				if (e.getKeyCode()==KeyEvent.VK_CONTROL)
				{
					if (levelStatus==LevelStatus.GameOver)
						levelStatus=LevelStatus.waitGameOver;
					if ((levelStatus==LevelStatus.LevelWined))
						levelStatus=LevelStatus.waitNextLevel;
					if (levelStatus==LevelStatus.LevelNotStarted ||
							levelStatus==LevelStatus.LevelStop_Player)
						levelStatus=LevelStatus.LevelRunning;
					return;
				}
			
			}// End of Key Adapter
		}
}
