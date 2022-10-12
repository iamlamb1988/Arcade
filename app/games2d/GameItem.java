package app.games2d;

import app.IAppItem;

interface GameItem extends IAppItem{
	public void setX(double xP);
	public void setY(double yP);
	public void d_x(double xChange);
	public void d_y(double yChange);
}