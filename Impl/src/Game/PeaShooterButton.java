package Game;

import java.awt.event.MouseEvent;


public class PeaShooterButton extends GameElementAdapter
{
	private boolean isActive=false;
	public PeaShooterButton(int x, int y) {
		super(Buttons.PeaShooterDisable, x, y);
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public void Step() {
		// TODO Auto-generated method stub
		super.Step();
		if(Game.getPlayer().getScore()>=100)
		{
			ChangeImage(Buttons.PeaShooter);
			isActive=true;
		}
		else
		{
			ChangeImage(Buttons.PeaShooterDisable);
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
				Element.setElement(0);
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
				e.getY()>=this.getY() && e.getY()<=this.getY()+this.getHeight()&& isActive==true)
		ChangeImage(Buttons.PeaShooterBorder);
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseReleased(e);
		if(e.getX()>=this.getX() && e.getX()<=this.getX()+this.getWidth() && 
				e.getY()>=this.getY() && e.getY()<=this.getY()+this.getHeight() && isActive==true)
		ChangeImage(Buttons.PeaShooter);
	}
	
	@Override
	public boolean WantMouseEvents() {
		// TODO Auto-generated method stub
		return true;
	}
}
