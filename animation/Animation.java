package animation;

import java.awt.Graphics;

public interface Animation{
	public void drawTopLeft(Graphics p);
	public void draw(int xPos, int yPos, Graphics p);
}