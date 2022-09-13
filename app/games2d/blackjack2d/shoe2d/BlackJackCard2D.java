package app.games2d.blackjack2d.shoe2d;

import arcade.game.blackjack.blackjack_items.instances.BlackJackCard;
import animation.Animation;
import app.games2d.Drawable2D;

public interface BlackJackCard2D extends BlackJackCard, Drawable2D{
	public void drawFaceTL(Graphics brush);
	public void drawFace(Graphics brush, int xPos_px, int yPos_px);
	public void drawBackTL(Graphics brush);
	public void drawBack(Graphics brush, int xPos_px, int yPos_px);
}