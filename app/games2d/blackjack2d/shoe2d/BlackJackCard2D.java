package app.games2d.blackjack2d.shoe2d;

import arcade.game.blackjack.blackjack_items.instances.BlackJackCard;
import animation.Animation;
import app.games2d.Drawable2D;
import java.awt.Graphics;

public class BlackJackCard2D extends BlackJackCard implements Drawable2D{
	private Animation face;
	private Animation back;

	public BlackJackCard2D(BlackJackCard original, Animation frontAnm, Animation backAnm){
		super(original);
		front=frontAnm.clone();
		back=backAnm.clone();
	}

	public void drawFaceTL(Graphics brush){face.drawTL(brush);}
	public void drawFace(Graphics brush, int xPos_px, int yPos_px){front.draw(xPos_px,yPos_px,brush);}
	public void drawBackTL(Graphics brush){back.drawTopLeft(brush);}
	public void drawBack(Graphics brush, int xPos_px, int yPos_px){back.draw(xPos_px,yPos_px,brush);}

	//Drawable2D Overrides:
	@Override
	public void drawTL(Graphics brush){drawBackTL(brush);}

	@Override
	public void draw(Graphics brush, int xPos_px, int yPos_px){drawBack(brush,xPos_px,yPos_px);}
}