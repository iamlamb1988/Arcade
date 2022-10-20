package app.release.sandbox.tablecycle;

import app.menu.gamemenu.GameMenu;
import app.DesktopApp;
import app.menu.IMenu;
import arcade.game.blackjack.blackjack_items.BlackJackTable;
import arcade.game.blackjack.blackjack_items.instances.BlackJackTable_Default;

public class TableCycle extends GameMenu{
	private BlackJackTable t;
	
	public TableCycle(DesktopApp parentApp, IMenu previous, int width_px, int height_px){
		super(parentApp,previous,width_px,height_px);
		t=new BlackJackTable_Default();
	}
}