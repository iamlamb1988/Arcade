package app.debug;

import app.DesktopApp;
import app.menu.IMenu;
import animation.Animation;
import animation.SingleImage;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class TableTest extends JPanel implements IMenu{
	private Animation bg;

	public TableTest(DesktopApp parentApp, IMenu previous, int width_px, int height_px){
		super();
		setSize(width_px,height_px);
		BufferedImage bgg = new BufferedImage(width_px,height_px,BufferedImage.TYPE_INT_ARGB);
		Graphics2D p = bgg.createGraphics();
		p.setColor(new Color(255,255,0,255));
		p.fillRect(0,0,width_px,height_px);
		bg=new SingleImage(bgg);
	}

	//IAppItem Overrides:
	public void setBG(Animation background){bg=background;}
	
	//Paint Override
	@Override
	public void paintComponent(Graphics p){
		super.paintComponent(p);
		bg.drawTopLeft(p);
	}
}