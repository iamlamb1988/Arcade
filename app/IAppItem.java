package app;

import animation.Animation;
import app.Drawable2D;

//Generic AppMenu Items such as Buttons, Labels, Panels, TextFields, etc
public interface IAppItem extends Drawable2D{
	public double getXdbl();
	public double getYdbl();
	public int getXint();
	public int getYint();
	public void setBG(Animation Background);
}