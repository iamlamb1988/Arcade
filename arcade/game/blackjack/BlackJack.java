package arcade.game.blackjack;

import arcade.currency.Currency;
import arcade.game.Game;
import arcade.game_items.Shoe;

import java.util.List;

public class BlackJack implements Game{
	private Shoe S,		//Primary Shoe
				 DS;	//Discard Pile

	//Need a Currency List... somehow
	//public BlackJack(){
	//	S=new Shoe();
	//	DS=new Shoe();
	//}

	//Game Overrides
	@Override
	public String getName(){
		return "Name of blackjack game";
	}

	@Override
	public List<Currency> getInputCredits() {
		return null;
	}

	@Override
	public List<Currency> getOutputCredits() {
		return null;
	}
}