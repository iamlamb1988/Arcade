package app.games2d.blackjack2d.seat2d;

import arcade.game.blackjack.blackjack_items.BlackJackSeat;

public interface BlackJackSeat2D extends BlackJackSeat{
	public void drawSeat(int xPos, int yPos);
	public void drawCardFront(byte handIndex, byte cardIndex, int xPos, int yPos);
	public void drawCardBack(byte handIndex, byte cardIndex, int xPos, int yPos);
}