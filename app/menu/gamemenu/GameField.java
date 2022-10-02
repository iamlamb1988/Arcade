package app.menu.gamemenu;

import animation.Animation;
import app.IAppItem;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.Graphics;

public class GameField extends JPanel implements IAppItem{
	private Animation bg;
	private double xPos;
	private double yPos;
	private ArrayList<IAppItem> itmL;

	//IAppItem Overrides:
	@Override
	public double getX2D(){return xPos;}

	@Override
	public double getY2D(){return yPos;}

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