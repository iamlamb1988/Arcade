package app.release.sandbox.shoecycle;

import animation.Animation;
import app.DesktopApp;
import app.menu.IMenu;
import app.menu.gamemenu.GameMenu;
import app.menu.gamemenu.GameField;
import app.menu.gamemenu.GamePanel;

public class ShoeCycle extends GameMenu{
	public ShoeCycle(DesktopApp parentApp, IMenu previous, int width_px, int height_px){
		super(parentApp,previous,width_px,height_px);
		
	}

	@Override
	public double getX2D(){return 0;} //This will always return 0 as a main menu

	@Override
	public double getY2D(){return 0;} //This will always return 0 as a main menu

	@Override
	public void setBG(Animation Background){}
}