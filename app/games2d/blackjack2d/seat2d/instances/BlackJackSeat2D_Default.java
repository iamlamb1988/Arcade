package app.games2d.blackjack2d.seat2d.instances;

import app.games2d.blackjack2d.seat2d.BlackJackSeat2D;
import arcade.game.blackjack.blackjack_items.instances.BlackJackSeat_Default;

public class BlackJackSeat2D_Default extends BlackJackSeat_Default implements BlackJackSeat2D{
	
	//BlackJackSeat2D Overrides:
	@Override
	public void drawSeat(int xPos, int yPos){}

	@Override
	public void drawCardFront(byte handIndex, byte cardIndex, int xPos, int yPos){}

	@Override
	public void drawCardBack(byte handIndex, byte cardIndex, int xPos, int yPos){}
}