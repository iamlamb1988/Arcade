package app.menu.gamemenu;

import animation.Animation;
import animation.SingleImage;
import app.IAppItem;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.Graphics;

public class GameField extends JPanel implements IAppItem{
	private Animation bg;
	private ArrayList<IAppItem> itmL;

	public GameField(int xPos_px, int yPos_px, int width_px, int height_px){
		super();
		setLayout(null);
		setSize(width_px,height_px);
		setBG(new SingleImage(width_px,height_px,0,255,0,255));
		setVisible(true);
		itmL = new ArrayList<IAppItem>();
	}

	public GameField(int width_px,int height_px){
		this(0,0,width_px,height_px);
	}

	//super Overrides:
	

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
		
	}

	@Override
	public void dwblDraw(Graphics brush, int xPos_px, int yPos_px){
		
	}
}