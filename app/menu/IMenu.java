package app.menu;

import app.IAppItem;
import app.Drawable2D;

//All implementations MUST extend JPanel (Typecasts will assume so)
public interface IMenu extends IAppItem, Drawable2D{}