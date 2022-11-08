package app.games2d.blackjack2d.table2d.instances;

import arcade.game.blackjack.blackjack_items.instances.BlackJackTable_Default;
import arcade.currency.CurrencyDecimal;
import app.games2d.blackjack2d.shoe2d.BlackJackCard2D;

//Note: Need to prepare anonymous inner 'Cheat' tables that implement the Cheat interface
public class BlackJackTable2D_Default
	<Cur extends CurrencyDecimal,C extends BlackJackCard2D>
	extends BlackJackTable_Default<Cur,C>
{
	public BlackJackTable2D_Default(){
		super();
		//Several pieces need to be considered. Will need a base constructor with MANY parameters
		//1. Upgrade all cards to a 2D;
		//2. Upgrade the Shoe itself to 2D;
		//3. Upgrade 'this' table itself to 2D;
	}

	//Create Rogue Table that implements the Cheat interface
}