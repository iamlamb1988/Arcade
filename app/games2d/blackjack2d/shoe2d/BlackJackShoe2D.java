package app.games2d.blackjack2d.shoe2d;

import arcade.game.blackjack.blackjack_items.BlackJackShoe;
import app.games2d.GameItem;
import java.awt.Graphics;

public interface BlackJackShoe2D extends BlackJackShoe, GameItem{
	public void drawShoeTL(Graphics brush);
	public void drawShoe(Graphics brush, int xPos_px, int yPos_px);
}