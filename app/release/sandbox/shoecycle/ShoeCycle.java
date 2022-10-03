package app.release.sandbox.shoecycle;

import animation.Animation;
import animation.SingleImage;
import app.DesktopApp;
import app.menu.IMenu;
import app.menu.gamemenu.GameMenu;
import app.menu.gamemenu.GameField;
import app.menu.gamemenu.GamePanel;
import javax.swing.JButton;

public class ShoeCycle extends GameMenu{
	public ShoeCycle(DesktopApp parentApp, IMenu previous, int width_px, int height_px){
		super(parentApp,previous,width_px,height_px);
		
		JButton tmp;

		ActionPanel a = new ActionPanel(width_px,(int)(0.2*height_px));
		a.setLocation(0,height_px-a.getHeight());
		a.setBG(new SingleImage(a.getWidth(),a.getHeight(),128,128,128,255));

		tmp=new JButton("Draw");
		tmp.setSize(100,40);
		tmp.setLocation((a.getWidth()-tmp.getWidth())/2,(a.getHeight()-tmp.getHeight())/2);
		tmp.setVisible(true);
		a.add(tmp);

		add(a);	
	}

	private class ActionPanel extends GamePanel{
		private ActionPanel(int width_px, int height_px){
			super(width_px,height_px);
		}
	}
}