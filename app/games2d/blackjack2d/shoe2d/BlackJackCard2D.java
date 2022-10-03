package app.games2d.blackjack2d.shoe2d;

import arcade.game.blackjack.blackjack_items.instances.BlackJackCard;
import animation.Animation;
import app.Drawable2D;
import java.awt.Graphics;

public class BlackJackCard2D extends BlackJackCard implements Drawable2D{
	private Animation front;
	private Animation back;

	public BlackJackCard2D(BlackJackCard original, Animation frontAnm, Animation backAnm){
		super(original);
		if(frontAnm!=null)
			front=frontAnm.clone();

		if(backAnm!=null)
			back=backAnm.clone();

	}

	//parent override:
	@Override
	public BlackJackCard clone(){
		return new BlackJackCard2D(this,front,back);
	}
	
	public void drawFrontTL(Graphics brush){front.drawTopLeft(brush);}
	public void drawFront(Graphics brush, int xPos_px, int yPos_px){front.draw(xPos_px,yPos_px,brush);}
	public void drawBackTL(Graphics brush){back.drawTopLeft(brush);}
	public void drawBack(Graphics brush, int xPos_px, int yPos_px){back.draw(xPos_px,yPos_px,brush);}

	//Drawable2D Overrides:
	@Override
	public void dwblDrawTL(Graphics brush){drawBackTL(brush);}

	@Override
	public void dwblDraw(Graphics brush, int xPos_px, int yPos_px){drawBack(brush,xPos_px,yPos_px);}
}