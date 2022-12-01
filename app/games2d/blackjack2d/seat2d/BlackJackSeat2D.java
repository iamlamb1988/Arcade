package app.games2d.blackjack2d.seat2d;

import arcade.game.blackjack.blackjack_items.BlackJackSeat;
import java.awt.Graphics;

public interface BlackJackSeat2D extends BlackJackSeat{
	public void drawSeat(Graphics brush, int xPos, int yPos);
	public void drawCardFront(Graphics brush, byte handIndex, byte cardIndex, int xPos, int yPos);
	public void drawCardBack(Graphics brush, byte handIndex, byte cardIndex, int xPos, int yPos);
}