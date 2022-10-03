package app.menu.gamemenu;

import animation.Animation;
import animation.SingleImage;
import app.DesktopApp;
import app.menu.IMenu;
import javax.swing.JPanel;
import java.awt.Graphics;

public class GameMenu extends IMenu{
	public GameMenu(DesktopApp parentApp, int width_px, int height_px){
		super(width_px,height_px);
		setBG(new SingleImage(width_px,height_px,255,0,255,255));
	}

	public GameMenu(DesktopApp parentApp, IMenu previous, int width_px, int height_px){
		this(parentApp,width_px,height_px);
		//use the previous IMenu argument.
	}
}