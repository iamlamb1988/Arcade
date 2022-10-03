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

	//super Overrides:
	//Need to Override Component add(Component comp)
	// Component add(Component comp){
		// if(comp instanceof IAppItem)
			// itmL.add((IAppItem)comp);
		// return super.add(comp);
	// }

	//IAppItem Overrides:
	@Override
	public double getXdbl(){return getX();}

	@Override
	public double getYdbl(){return getY();}

	@Override
	public int getXint(){return getX();}

	@Override
	public int getYint(){return getY();}

	@Override
	public void setBG(Animation Background){bg=Background.clone();}

	//Drawable2D Overrides:
	@Override
	public void dwblDrawTL(Graphics brush){
		bg.drawTopLeft(brush);
		for(IAppItem x : itmL){
			x.dwblDraw(brush,x.getXint(),x.getYint());
		}
	}

	@Override
	public void dwblDraw(Graphics brush, int xPos_px, int yPos_px){
		bg.draw(xPos_px,yPos_px,brush);
		for(IAppItem x : itmL){
			x.dwblDraw(brush,x.getXint()+xPos_px,x.getYint()+yPos_px);
		}
	}

	//Paint Override:
	@Override
	public void paintComponent(Graphics p){
		super.paintComponent(p);
		dwblDrawTL(p);
	}
}