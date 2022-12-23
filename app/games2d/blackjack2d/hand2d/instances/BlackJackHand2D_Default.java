package app.games2d.blackjack2d.hand2d.instances;

import animation.Animation;
import app.games2d.blackjack2d.hand2d.BlackJackHand2D;
import arcade.game.blackjack.blackjack_items.instances.BlackJackCard;
import arcade.game.blackjack.blackjack_items.instances.BlackJackHand_Default;
import java.awt.Graphics;
import java.util.ArrayList;

//The PARENT class SHOULD allow Generic type with Upper Limit as BlackJackCard
//For now.. multiple type casts will take place.
public class BlackJackHand2D_Default extends BlackJackHand_Default implements BlackJackHand2D{
	private ArrayList<BlackJackCard> h_hand2D;
	private Animation handAnm;

	public BlackJackHand2D_Default(){
		super();
		h_hand2D=this.getHandRef();
		//TODO cast cards to their 2D form.
	}

	//BlackJackHand2D Overrides:
	@Override
	public void drawHand(Graphics brush,int xPos_px,int yPos_px){
		//TODO NOT need to necessarily draw all the cards.
		//Just needs to draw the representation.
	}

	@Override
	public void drawCard(Graphics brush, byte cardIndex, int xPos_px, int yPos_px){
		//TODO
		//1. Obtain card
//		BlackJackCard tmp=h_hand2D.get(cardIndex)
		//2. Cast card to 2D (unchecked because GUARANTEED 2D implementation)
		//3. Draw image
		//4. Done
	}
}