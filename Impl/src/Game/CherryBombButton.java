package Game;

import java.awt.event.MouseEvent;

public class CherryBombButton extends GameElementAdapter
{
	private boolean isActive=false;
	public CherryBombButton(int x, int y) {
		super(Buttons.CherryBombDisable, x, y);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void Step() {
		// TODO Auto-generated method stub
		super.Step();
		if(Game.getPlayer().getScore()>=150)
		{
			ChangeImage(Buttons.CherryBomb);
			isActive=true;
		}
		else
		{
			ChangeImage(Buttons.CherryBombDisable);
			isActive=false;
		}

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseClicked(e);
		if(e.getX()>=this.getX() && e.getX()<=this.getX()+this.getWidth() && 
				e.getY()>=this.getY() && e.getY()<=this.getY()+this.getHeight() && isActive==true)
		{
			if(Element.checkButton()==-1)
			{
				Element.setElement(4);
			}
			else
			{
				Element.getElement();
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mousePressed(e);
		if(e.getX()>=this.getX() && e.getX()<=this.getX()+this.getWidth() && 
				e.getY()>=this.getY() && e.getY()<=this.getY()+this.getHeight() && isActive==true)
		ChangeImage(Buttons.CherryBombBorder);
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseReleased(e);
		if(e.getX()>=this.getX() && e.getX()<=this.getX()+this.getWidth() && 
				e.getY()>=this.getY() && e.getY()<=this.getY()+this.getHeight() && isActive==true)
		ChangeImage(Buttons.CherryBomb);
	}
	
	@Override
	public boolean WantMouseEvents() {
		// TODO Auto-generated method stub
		return true;
	}


}
