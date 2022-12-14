package app.games2d.blackjack2d.shoe2d;

import arcade.game.blackjack.blackjack_items.instances.BlackJackCard;
import animation.Animation;
import app.games2d.GameItem;
import java.awt.Graphics;

public class BlackJackCard2D extends BlackJackCard implements GameItem{
	private Animation front;
	private Animation back;
	private Animation upside; //This will ONLY reference "front" XOR "back";
	private double xP; //X Position
	private double yP; //Y Position

	public BlackJackCard2D(
		BlackJackCard original,
		Animation frontAnm, Animation backAnm,
		double xPos, double yPos
	){
		super(original);
		if(frontAnm!=null)
			front=frontAnm.clone();

		if(backAnm!=null)
			back=backAnm.clone();

		upside=back;
		xP=xPos;
		yP=yPos;
	}

	public BlackJackCard2D(
		BlackJackCard original,
		Animation frontAnm, Animation backAnm
	){this(original,frontAnm,backAnm,0,0);}

	//Object overrides:
	@Override
	public BlackJackCard clone(){
		return new BlackJackCard2D(this,front,back);
	}

	//Custom functions
	public void setFrontUpside(){upside=front;}
	public void setBackUpside(){upside=back;}
	public void flipCard(){
		if(upside==back) upside=front;
		else upside=back;
	}
	public void drawFrontTL(Graphics brush){front.drawTopLeft(brush);}
	public void drawFront(Graphics brush, int xPos_px, int yPos_px){front.draw(xPos_px,yPos_px,brush);}
	public void drawBackTL(Graphics brush){back.drawTopLeft(brush);}
	public void drawBack(Graphics brush, int xPos_px, int yPos_px){back.draw(xPos_px,yPos_px,brush);}

	//IAppItem Overrides
	@Override
	public double getXdbl(){return xP;}

	@Override
	public double getYdbl(){return yP;}

	@Override
	public int getXint(){return (int)xP;}

	@Override
	public int getYint(){return (int)yP;}

	@Override
	public void setBG(Animation Background){ //Back of card only
		//Will do nothing for now to mantain immutability
		//1. Resize the image
		//2. Clone image
		//3. set the back to the clone
	}
	
	//GameItem Overrides:
	@Override
	public void setX(double xP){this.xP=xP;}

	@Override
	public void setY(double yP){this.yP=yP;}

	@Override
	public void d_x(double xChange){xP+=xChange;}

	@Override
	public void d_y(double yChange){yP+=yChange;}

	//Drawable2D Overrides:
	@Override
	public void dwblDrawTL(Graphics brush){upside.drawTopLeft(brush);}

	@Override
	public void dwblDraw(Graphics brush, int xPos_px, int yPos_px){upside.draw((int)xP,(int)yP,brush);}
}