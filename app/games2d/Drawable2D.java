package app.games2d;

import java.awt.Graphics;

public interface Drawable2D{ //is this necessary and/or redundant?
	public void drawTL(Graphics brush);
	public void draw(Graphics brush, int xPos_px, int yPos_px);
}