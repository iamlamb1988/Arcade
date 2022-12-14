package app.menu.gamemenu;

import animation.Animation;
import animation.SingleImage;
import app.IAppItem;
import app.games2d.GameItem;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.Component;
import java.awt.Graphics;

public class GameField extends JPanel implements IAppItem{
	private Animation bg;
	private ArrayList<GameItem> itmL;

	public GameField(int xPos_px, int yPos_px, int width_px, int height_px){
		super();
		setLayout(null);
		setLocation(xPos_px,yPos_px);
		setSize(width_px,height_px);
		setBG(new SingleImage(width_px,height_px,0,255,0,255));
		setVisible(true);
		itmL = new ArrayList<GameItem>();
	}

	public GameField(int width_px,int height_px){
		this(0,0,width_px,height_px);
	}

	//The purpose of these "Final" helper functions is to avoid an infinite recursive call.
	private void addFinalGameItem(GameItem item){itmL.add(item);}

	private void addFinalComponent(Component item){super.add(item);}

	private void removeFinalGameItem(GameItem item){itmL.remove(item);}

	private void removeFinalComponent(Component item){
		
	}

	public boolean addGameItem(GameItem item){
		if(itmL.indexOf(item)>-1){return false;}
		itmL.add(item);
		if(item instanceof Component){
			addFinalComponent((Component)item);
		}
		return true;
	}

	public boolean removeGameItem(GameItem item){
		boolean r=itmL.remove(item);
		if(item instanceof Component)
			remove((Component)item);
		return r;
	}

	//super Overrides:
	@Override
	public Component add(Component comp){//Duplicate issue?
		if(comp instanceof GameItem)
			addFinalGameItem((GameItem)comp);
		return super.add(comp);
	}

	@Override
	public void remove(Component comp){
		if(comp instanceof GameItem)
			itmL.remove(comp);
		super.remove(comp);
	}

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