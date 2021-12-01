package Game;

import java.awt.Graphics;
import java.awt.Image;

public class Sprite
{
	private Image image;
	
	public Sprite(Image image) 
	{
		this.image=image;
	}
	public int getWidth()
	{
		return this.image.getWidth(null);
	}
	public int getHeight()
	{
		return this.image.getHeight(null);
	}
	public void draw(Graphics g,int X,int Y)
	{
		g.drawImage(image, X, Y, null);
	}
}
