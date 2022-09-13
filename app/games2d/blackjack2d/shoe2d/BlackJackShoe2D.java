package app.games2d.blackjack2d.shoe2d;

import app.games2d.Drawable2D;

public interface BlackJackShoe2D extends BlackJackShoe, Drawable2D{
	public void drawShoeTL(Graphics brush);
	public void drawShoe(Graphics brush, int xPos_px, int yPos_px);
}