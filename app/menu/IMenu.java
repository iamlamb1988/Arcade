package app.menu;

import animation.Animation;
import animation.SingleImage;
import app.IAppItem;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.Component;
import java.awt.Graphics;

public abstract class IMenu extends JPanel implements IAppItem{
	private Animation bg;
	private ArrayList<IAppItem> itmL;

	public IMenu(int width_px, int height_px){
		super();
		setLayout(null);
		setSize(width_px,height_px);
		bg=new SingleImage(width_px,height_px,255,0,255,255);
		itmL=new ArrayList<IAppItem>();
		setVisible(true);
	}

	//IAppItem Overrides:
	@Override
	public double getX2D(){return getX();}

	@Override
	public double getY2D(){return getY();}

	@Override
	public void setBG(Animation Background){bg=Background.clone();}

	//Drawable2D Overrides:
	@Override
	public void dwblDrawTL(Graphics brush){
		bg.drawTopLeft(brush);
		for(IAppItem x : itmL){
			x.dwblDraw(brush,(int)x.getX2D(),(int)x.getY2D());
		}
	}

	@Override
	public void dwblDraw(Graphics brush, int xPos_px, int yPos_px){
		bg.draw(xPos_px,yPos_px,brush);
		for(IAppItem x : itmL){
			x.dwblDraw(brush,(int)(x.getX2D()+xPos_px),(int)(x.getY2D()+yPos_px));
		}
	}
}