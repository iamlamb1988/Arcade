package app;

import java.awt.Graphics;

public interface Drawable2D{ //is this necessary and/or redundant?
	public void dwblDrawTL(Graphics brush);
	public void dwblDraw(Graphics brush, int xPos_px, int yPos_px);
}