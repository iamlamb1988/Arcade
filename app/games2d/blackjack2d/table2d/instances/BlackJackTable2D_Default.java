package app.games2d.blackjack2d.table2d.instances;

import arcade.game.blackjack.blackjack_items.instances.BlackJackTable_Default;
import arcade.currency.CurrencyDecimal;
import app.games2d.blackjack2d.shoe2d.BlackJackCard2D;
import app.srcfactory.card2d.Card2DAnimationFactory;

//Note: Need to prepare anonymous inner 'Cheat' tables that implement the Cheat interface
public class BlackJackTable2D_Default
	<Cur extends CurrencyDecimal>
	extends BlackJackTable_Default<Cur>
{
	public BlackJackTable2D_Default(int cardWidth_px,int cardHeight_px){
		super();
		//Several pieces need to be considered. Will need a base constructor with MANY parameters
		//1.	Upgrade all cards to a 2D.
			//1.1	Set up a default Card Animation2D generator.
		//2.	Upgrade the Shoe itself to 2D.
		//3.	Upgrade Seats to 2D.
		//4.	Upgrade 'this' table itself to 2D.
	}

	public BlackJackTable2D_Default(int cardHeight_px){
		this((int)(cardHeight_px*Card2DAnimationFactory.R_H),cardHeight_px);
	}
	//Create Rogue Table that implements the Cheat interface
}