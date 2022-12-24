package app.games2d.blackjack2d.hand2d;

import java.awt.Graphics;

public interface BlackJackHand2D{
	public void drawHand(Graphics brush,int xPos_px, int yPos_px);
	public void drawCard(Graphics brush, byte cardIndex, int xPos_px, int yPos_px);
}