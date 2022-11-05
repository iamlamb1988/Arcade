package arcade.game.blackjack;

import arcade.currency.Currency;
import arcade.game.Game;
import arcade.game.game_items.Shoe;

import java.util.List;

public class BlackJack implements Game{
	private Shoe s;

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
	public boolean isHonest(){return isHonorable();}

	@Override
	public List<Currency> getInputCredits() {
		return null;
	}

	@Override
	public List<Currency> getOutputCredits() {
		return null;
	}

	//HonorCode Overrides:
	@Override
	public boolean isHonorable(){
		return false;
	}
}