package Game;

import java.awt.event.MouseEvent;


public class Element 
{

	private static final String[] ImageNames = {"Images/PeaShooter_(1).gif","Images/SunFlower_(1).gif","Images/Shovel.gif","Images/WallNut_(1).gif",
		"Images/CherryBomb_(1).gif"};
	private static Sprite	sprite[]=new Sprite[100];
	private static int iActiveTool=-1;
	private static int level=0;
	private static int cSprite=0;
	private static int [] coordsX=new int[250];
	private static int [] coordsY=new int[250];
	private static GameElementAdapter[] element=new GameElementAdapter[1000];
	private static int cElement=0;
	private static int cCoords=0;

	public static int checkButton()
	{
		return iActiveTool;
	}
	public static void setElement(int type)
	{
		
		iActiveTool=type;
	}
	public static void getElement()
	{
		iActiveTool=-1;
	}
	public static void setLevel(int i)
	{
		cSprite=0;
		for(int x=0;x<i;x++)
			sprite[cSprite++]=SpriteStore.get().getSprite(ImageNames[x]);
		level=i;
		cCoords=0;
		for(int x=0;x<250;x++)
		{
			coordsX[x]=0;
			coordsY[x]=0;
		}
	}
	public static void MouseAction(MouseEvent e,int action)
	{

			// action=0 move, action=1 click
			int curX=0;
			int curY=0;
			curX=getX(e.getX());
			curY=getY(e.getY());
			if (action==1 && iActiveTool!=-1 && curX!=-1 && curY!=-1) // click
			{					
				for(int i=0;i<cCoords;i++)
				{
					int sX=Search(coordsX,i, cCoords, curX);
					if( sX!=-1 && curY==coordsY[sX])
					{
						if(iActiveTool==2)
						{
							SoundStore.get().Play(Sounds.Plant);
							coordsX[sX]=-1;
							coordsY[sX]=0;
							element[sX].Destroy();
							element[sX]=null;
						}
						iActiveTool=-1;
						return;
					}
				}
				if(level==1  && curY==285)
				{
					SoundStore.get().Play(Sounds.Plant);
					element[cElement++]=new PeaShooter(curX,curY);
					Game.DecreaseScore(100);
			
				}
				else if(level==2 && curY>=185 && curY<=385)
				{
					if(iActiveTool==0)
					{
						SoundStore.get().Play(Sounds.Plant);
						element[cElement++]=new PeaShooter(curX,curY);
						Game.DecreaseScore(100);
					}
					else if(iActiveTool==1)
					{		
						SoundStore.get().Play(Sounds.Plant);
						element[cElement++]=new SunFlower(curX,curY);
						Game.DecreaseScore(50);
					}
				}
				else if(level>=3)
				{
					if(iActiveTool==0)
					{
						SoundStore.get().Play(Sounds.Plant);
						element[cElement++]=new PeaShooter(curX,curY);
						Game.DecreaseScore(100);
					}
					else if(iActiveTool==1)
					{
						SoundStore.get().Play(Sounds.Plant);
						element[cElement++]=new SunFlower(curX,curY);
						Game.DecreaseScore(50);
					}
					else if(iActiveTool==3)
					{
						SoundStore.get().Play(Sounds.Plant);
						element[cElement++]=new WallNut(curX,curY);
						Game.DecreaseScore(50);
					}
					else if((iActiveTool==4))
					{
						SoundStore.get().Play(Sounds.Plant);
						Game.addNewEntity(new CherryBomb(curX,curY));
						Game.DecreaseScore(150);
					}
				}
				if(iActiveTool!=4 && iActiveTool!=-1 )
				{
					Game.addNewEntity(element[cElement-1]);
					coordsX[cCoords]=curX;
					coordsY[cCoords]=curY;
					cCoords++;
				}
				iActiveTool=-1;

			}
			if (action==0 && iActiveTool!=-1) // move
			{
				sprite[iActiveTool].draw(Game.getBufferGraphics() , e.getX(), e.getY());
			}
		

		
	}
	
	private static  int getX(int x)
	{
		if(x>=35 && x<=110)
			return 40;
		else if(x>=111 && x<=188)
			return 115;
		else if(x>=189 && x<=270)
			return 193;
		else if(x>=271 && x<=350)
			return 276;
		else if(x>=351 && x<=435)
			return 356;
		else if(x>=436 && x<=520)
			return 441;
		else if(x>=521 && x<=595)
			return 526;
		else if(x>=596 && x<=675)
			return 600;
		else if(x>=676&& x<=755)
			return 680;
		else 
			return -1;
	}
	private static  int getY(int y)
	{
		if(y>=92 && y<=180)
			return 100;
		else if(y>=181 && y<=276)
			return 185;
		else if(y>=277 && y<=374)
			return 285;
		else if(y>=375 && y<=472)
			return 385;
		else if(y>=473 && y<=567)
			return 483;
		else 
			return -1;
	}
		

	private static int Search(int A[],int x1,int x2,int m)
	{
		int r=-1;
		for(int i=x1;i<x2;i++)
		{
			if(A[i]==m)
			{
				r=i;
				break;
			}
		}
		return r;
	}//end of Search method
}
