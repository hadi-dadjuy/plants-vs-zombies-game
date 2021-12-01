package Game;

import java.awt.event.MouseEvent;

public class ShovelButton extends GameElementAdapter
{
	
	public ShovelButton(int x, int y) {
		super(Buttons.ShovelButton, x, y);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseClicked(e);
		if(e.getX()>=this.getX() && e.getX()<=this.getX()+this.getWidth() && 
				e.getY()>=this.getY() && e.getY()<=this.getY()+this.getHeight())
		{
			if(Element.checkButton()==-1)
			{
				Element.setElement(2);
				
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
				e.getY()>=this.getY() && e.getY()<=this.getY()+this.getHeight())
		ChangeImage(Buttons.ShovelBorder);
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseReleased(e);
		if(e.getX()>=this.getX() && e.getX()<=this.getX()+this.getWidth() && 
			e.getY()>=this.getY() && e.getY()<=this.getY()+this.getHeight())
		ChangeImage(Buttons.ShovelButton);
	}
	
	@Override
	public boolean WantMouseEvents() {
		// TODO Auto-generated method stub
		return true;
	}



}
