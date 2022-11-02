package app.games2d.blackjack2d.table2d.instances;

import arcade.game.blackjack.blackjack_items.instances.BlackJackTable_Default;
import arcade.currency.CurrencyDecimal;
import app.games2d.blackjack2d.shoe2d.BlackJackCard2D;

//Note: Need to prepare anonymous inner 'Cheat' tables that implement the Cheat interface
public class BlackJackTable2D_Default
	<Cur extends CurrencyDecimal,C extends BlackJackCard2D>
	extends BlackJackTable_Default
{
	public BlackJackTable2D_Default(){
		//Default shoes MUST be called in an upgrade similar to Card -> Card2D within Shoe and Shoe2D
		super();
		//1. Upgrade all cards to a 2D;
		//2. Upgrade the Shoe itself to 2D;
		//3. Upgrade 'this' table itself to 2D;
	}
}