package app.menu.gamemenu;

import animation.Animation;
import animation.SingleImage;
import app.DesktopApp;
import app.menu.IMenu;
import javax.swing.JPanel;
import java.awt.Graphics;

public class GameMenu extends JPanel implements IMenu{
	private Animation bg;
	public GameMenu(DesktopApp parentApp, int width_px, int height_px){
		super();
		setSize(width_px,height_px);
		bg=new SingleImage(width_px,height_px,255,0,255,255);
	}

	public GameMenu(DesktopApp parentApp, IMenu previous, int width_px, int height_px){
		this(parentApp,width_px,height_px);
		
	}

	//IAppItem Overrides:
	@Override
	public double getX2D(){return 0;} //This will always return 0 as a main menu

	@Override
	public double getY2D(){return 0;} //This will always return 0 as a main menu

	@Override
	public void setBG(Animation Background){bg=Background.clone();}
	
	//Drawable2D Overrides:
	@Override
	public void dwblDrawTL(Graphics brush){
		
	}

	@Override
	public void dwblDraw(Graphics brush, int xPos_px, int yPos_px){
		
	}

	//Paint Override:
	@Override
	public void paint(Graphics p){
		super.paint(p);
		bg.drawTopLeft(p);
		//draw remaining drawable objects
	}
}