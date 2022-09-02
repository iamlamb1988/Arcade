package arcade.game.blackjack.blackjack_items;

import arcade.Cheat;
import java.util.ArrayList;

public interface CheatAccessCards extends Cheat{
	public ArrayList<BlackJackCard> getCardsRef();
	public ArrayList<BlackJackCard> getDiscardsRef();
}