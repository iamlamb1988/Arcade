package app.release.sandbox.shoecycle;

import animation.Animation;
import animation.SingleImage;
import app.DesktopApp;
import app.menu.IMenu;
import app.menu.gamemenu.GameMenu;
import app.menu.gamemenu.GameField;
import app.menu.gamemenu.GamePanel;

public class ShoeCycle extends GameMenu{
	public ShoeCycle(DesktopApp parentApp, IMenu previous, int width_px, int height_px){
		super(parentApp,previous,width_px,height_px);
		
		ActionPanel a = new ActionPanel(width_px,(int)(.2*height_px));
		a.setLocation(0,a.getHeight());
		a.setBG(new SingleImage(a.getWidth(),a.getHeight(),128,128,128,255));
		add(a);	
	}

	@Override
	public double getX2D(){return 0;} //This will always return 0 as a main menu

	@Override
	public double getY2D(){return 0;} //This will always return 0 as a main menu

	@Override
	public void setBG(Animation Background){}

	private class ActionPanel extends GamePanel{
		private ActionPanel(int width_px, int height_px){
			super(width_px,height_px);
		}
	}
}