package app.games2d.blackjack2d.shoe2d.instances;

import arcade.game.blackjack.blackjack_items.instances.BlackJackShoe_Default;
import arcade.game.blackjack.blackjack_items.instances.BlackJackCard;
import arcade.game.blackjack.blackjack_items.BlackJackShoe;
import app.games2d.blackjack2d.shoe2d.BlackJackCard2D;
import app.games2d.blackjack2d.shoe2d.BlackJackShoe2D;
import app.games2d.Drawable2D;
import app.srcfactory.card2d.Card2DAnimationFactory;
import java.util.ArrayList;
import java.awt.Graphics;

public class BlackJackShoe2D_Default extends BlackJackShoe_Default implements BlackJackShoe2D{
	public BlackJackShoe2D_Default(int width_px, int height_px){
		super();
		//Next: Type cast list to hold BlackJackShoe2D:
		//1. Establish a temporary animation factory.
		Card2DAnimationFactory aF = new Card2DAnimationFactory();
		aF.setActualSize(width_px,height_px);
		aF.setSpacing((int)(0.07*width_px),((int)(0.07*width_px)));
		aF.setSuitSize(20,30);
		aF.setFaceSize(20,30);
		aF.setBG(aF.genCardBorder(100, 125, 10)); //ARBITRARY NEEDS FIXED UPON 2D REFACTOR
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
			upgradeList.add(new BlackJackCard2D(original,null,null));
		}
		list=(ArrayList<BlackJackCard>)upgradeList;

		//3. destruct animation factory.
		
	}
	//BlackJackShoe Overrides:
	public void drawShoeTL(Graphics brush){}
	public void drawShoe(Graphics brush, int xPos_px, int yPos_px){}

	//Drawable2D Overrides:
	public void drawTL(Graphics brush){}
	public void draw(Graphics brush, int xPos_px, int yPos_px){}
}