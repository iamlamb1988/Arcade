package app.menu.gamemenu;

import animation.Animation;
import app.DesktopApp;
import app.menu.IMenu;
import javax.swing.JPanel;
import java.awt.Graphics;

public class GameMenu extends JPanel implements IMenu{
	public GameMenu(DesktopApp parentApp, int width_px, int height_px){
		super();
		setSize(width_px,height_px);
	}

	public GameMenu(DesktopApp parentApp, IMenu previous, int width_px, int height_px){
		super();
		setSize(width_px,height_px);
		setVisible(true);
	}

	//IAppItem Overrides:
	public void setBG(Animation Background){}
	
	//Drawable2D Overrides:
	@Override
	public void dwblDrawTL(Graphics brush){
		
	}

	@Override
	public void dwblDraw(Graphics brush, int xPos_px, int yPos_px){
		
	}
}