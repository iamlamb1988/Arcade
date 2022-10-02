package app.menu;

import app.IAppItem;

//All implementations MUST extend JPanel (Typecasts will assume so)

//The idea of any IMenu is that it takes the entire space of the mother JFrame
//The mother JFrame should have only 1 IMenu attached at a time (Swappable)
public interface IMenu extends IAppItem{}