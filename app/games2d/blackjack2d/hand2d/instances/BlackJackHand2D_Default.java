package app.games2d.blackjack2d.hand2d.instances;

import app.games2d.blackjack2d.hand2d.BlackJackHand2D;
import arcade.game.blackjack.blackjack_items.instances.BlackJackHand_Default;
import java.awt.Graphics;

public class BlackJackHand2D_Default extends BlackJackHand_Default implements BlackJackHand2D{
	//BlackJackHand2D Overrides:
	@Override
	public void drawHand(Graphics brush,int xPos_px, int yPos_px){}

	@Override
	public void drawCard(Graphics brush, byte cardIndex, int xPos_px, int yPos_px){}
}