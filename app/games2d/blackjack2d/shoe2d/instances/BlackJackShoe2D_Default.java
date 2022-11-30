package app.games2d.blackjack2d.shoe2d.instances;

import animation.Animation;
import animation.SingleImage;
import arcade.game.blackjack.blackjack_items.BlackJackShoe;
import arcade.game.blackjack.blackjack_items.instances.BlackJackCard;
import arcade.game.blackjack.blackjack_items.instances.BlackJackShoe_Default;
import arcade.game.blackjack.blackjack_items.CheatAccessCards;
import app.games2d.blackjack2d.shoe2d.BlackJackCard2D;
import app.games2d.blackjack2d.shoe2d.BlackJackShoe2D;
import app.srcfactory.card2d.Card2DAnimationFactory;
import java.util.ArrayList;
import java.awt.Graphics;

public class BlackJackShoe2D_Default extends BlackJackShoe_Default implements BlackJackShoe2D{
	private double xP;
	private double yP;
	Animation bg;
	Animation cse; //the shoe casing (could potentially draw back of card(s))

	public BlackJackShoe2D_Default(int width_px, int height_px){//Single deck instance
		super();
		xP=yP=0;

		//1. Establish a temporary animation factory.
		Card2DAnimationFactory aF = new Card2DAnimationFactory(width_px,height_px);
		aF.setSpacing((int)(0.07*width_px),((int)(0.07*width_px)));
		aF.setSuitSize((int)(0.2*width_px),(int)(0.2*height_px));
		aF.setFaceSize((int)(0.2*width_px),(int)(0.2*height_px));
		aF.setBG(aF.genCardBorder(width_px, height_px, (int)(0.1*width_px))); //ARBITRARY NEEDS FIXED UPON 2D REFACTOR
		aF.setBackBG(aF.genCardBorder(width_px, height_px, (int)(0.2*width_px))); //ARBITRARY NEEDS FIXED UPON 2D REFACTOR
		aF.setFaces();
		aF.setSuits();
		aF.setCards();

		//2. Set Background.
		aF.setBG(aF.genShoeImage(width_px,height_px));
		bg=new SingleImage(width_px,height_px,255,0,255,255);
		cse=new SingleImage(width_px,height_px,0,0,255,255);

		//3. Assign images to 2D Cards.
		ArrayList<BlackJackCard2D> upgradeList = new ArrayList<BlackJackCard2D>(52);
		BlackJackCard original;
		while(list.size()>0){
			original = (BlackJackCard)list.remove(0);
			upgradeList.add(new BlackJackCard2D(original,aF.genCard2D(original.face,original.suit),aF.genCardBG()));
		}

		//4. Add 2D Cards back to original List..
		while(upgradeList.size()>0){list.add(upgradeList.remove(0));}
	}

	public BlackJackShoe2D_Default(int height_px){
		this((int)(Card2DAnimationFactory.R_H*height_px),height_px);
	}

	//Cloning Constructor
	private BlackJackShoe2D_Default(BlackJackShoe2D_Default original){
		super(original);
		xP=original.getXdbl();
		yP=original.getYdbl();
		bg=original.bg.clone();
		cse=original.cse.clone();
	}

	@Override
	public CheatAccessCards genRogueClone(){return new RogueBJShoe2D(this);}

	//BlackJackShoe2D Overrides:
	@Override
	public void drawShoeTL(Graphics brush){dwblDrawTL(brush);}

	@Override
	public void drawShoe(Graphics brush, int xPos_px, int yPos_px){dwblDraw(brush,xPos_px,yPos_px);}

	//IAppItem Overrides:
	@Override
	public double getXdbl(){return xP;}

	@Override
	public double getYdbl(){return yP;}

	@Override
	public int getXint(){return (int)xP;}

	@Override
	public int getYint(){return (int)yP;}

	@Override
	public void setBG(Animation Background){bg=Background;}

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
	public void dwblDrawTL(Graphics brush){
		bg.drawTopLeft(brush);
		cse.drawTopLeft(brush);
	}
	public void dwblDraw(Graphics brush, int xPos_px, int yPos_px){
		bg.draw(xPos_px,yPos_px,brush);
		cse.draw(xPos_px,yPos_px,brush);
	}

	private class RogueBJShoe2D extends BlackJackShoe2D_Default implements BlackJackShoe, CheatAccessCards{
		private RogueBJShoe2D(BlackJackShoe2D_Default org){super(org);}

		//CheatAccessCards Overrides:
		@Override
		public ArrayList<BlackJackCard> getCardsRef(){return this.list;}

		@Override
		public ArrayList<BlackJackCard> getDiscardsRef(){return this.discard;}
	}
}