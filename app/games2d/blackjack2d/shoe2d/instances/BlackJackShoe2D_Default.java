package app.games2d.blackjack2d.shoe2d.instances;

import animation.Animation;
import arcade.game.blackjack.blackjack_items.BlackJackShoe;
import arcade.game.blackjack.blackjack_items.instances.BlackJackCard;
import arcade.game.blackjack.blackjack_items.instances.BlackJackShoe_Default;
import arcade.game.blackjack.blackjack_items.CheatAccessCards;
import app.games2d.blackjack2d.shoe2d.BlackJackCard2D;
import app.games2d.blackjack2d.shoe2d.BlackJackShoe2D;
import app.Drawable2D;
import app.srcfactory.card2d.Card2DAnimationFactory;
import java.util.ArrayList;
import java.awt.Graphics;

public class BlackJackShoe2D_Default extends BlackJackShoe_Default implements BlackJackShoe2D{
	private double xP;
	private double yP;
	private Animation bg;

	public BlackJackShoe2D_Default(int width_px, int height_px){
		super();
		xP=yP=0;

		//1. Establish a temporary animation factory.
		Card2DAnimationFactory aF = new Card2DAnimationFactory();
		aF.setActualSize(width_px,height_px);
		aF.setSpacing((int)(0.07*width_px),((int)(0.07*width_px)));
		aF.setSuitSize(20,30);
		aF.setFaceSize(20,30);
		aF.setBG(aF.genCardBorder(100, 125, 10)); //ARBITRARY NEEDS FIXED UPON 2D REFACTOR
		aF.setBackBG(aF.genCardBorder(100, 125, 10)); //ARBITRARY NEEDS FIXED UPON 2D REFACTOR
		aF.setFaces();
		aF.setSuits();
		aF.setCards();

		//2. Set Background.
		aF.setBG(aF.genShoeImage(width_px,height_px));

		//3. Assign images to 2D Cards.
		ArrayList<BlackJackCard2D> upgradeList = new ArrayList<BlackJackCard2D>();
		BlackJackCard original;
		while(list.size()>0){
			original = list.remove(0);
			upgradeList.add(new BlackJackCard2D(original,aF.genCard2D(original.face,original.suit),aF.genCardBG()));
		}

		//4. Add 2D Cards back to original List..
		while(upgradeList.size()>0){
			list.add(upgradeList.remove(0));
		}
	}

	private BlackJackShoe2D_Default(BlackJackShoe2D_Default original){
		super(original);
	}

	@Override
	public CheatAccessCards genRogueClone(){
		return new RogueBJShoe2D(this);
	}

	//BlackJackShoe Overrides:
	public void drawShoeTL(Graphics brush){}
	public void drawShoe(Graphics brush, int xPos_px, int yPos_px){}

	//IAppItem Overrides:
	public double getXdbl(){return xP;}
	public double getYdbl(){return yP;}
	public int getXint(){return (int)xP;}
	public int getYint(){return (int)yP;}
	public void setBG(Animation Background){} //NEED TO IMPLEMENT

	//Drawable2D Overrides:
	public void dwblDrawTL(Graphics brush){}
	public void dwblDraw(Graphics brush, int xPos_px, int yPos_px){}

	private class RogueBJShoe2D extends BlackJackShoe2D_Default implements BlackJackShoe, CheatAccessCards{
		private RogueBJShoe2D(BlackJackShoe2D_Default org){
			super(org);
		}

		//CheatAccessCards Overrides:
		@Override
		public ArrayList<BlackJackCard> getCardsRef(){return this.list;}

		@Override
		public ArrayList<BlackJackCard> getDiscardsRef(){return this.discard;}
	}
}