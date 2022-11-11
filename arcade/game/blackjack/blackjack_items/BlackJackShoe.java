package arcade.game.blackjack.blackjack_items;

import arcade.HonorCode;
import arcade.game.game_items.Card;
import arcade.game.game_items.Shoe;
import arcade.game.blackjack.blackjack_items.instances.BlackJackCard;
import java.util.ArrayList;

public interface BlackJackShoe extends Shoe, HonorCode{
	public static ArrayList<BlackJackCard> genStandardBlackJackDecks(byte num_of_decks){
		ArrayList<Card> org=Shoe.genStandardDeck();
		ArrayList<BlackJackCard> upgradeOrg=new ArrayList<BlackJackCard>(52);
		ArrayList<BlackJackCard> R=new ArrayList<BlackJackCard>(52*num_of_decks);
		--num_of_decks;

		while(org.size()>0){
			upgradeOrg.add(new BlackJackCard(org.remove(0)));
		}

		for(;num_of_decks>0;--num_of_decks){
			for(BlackJackCard x : upgradeOrg){
				R.add(x.clone());
			}
		}

		while(upgradeOrg.size()>0){
			R.add(upgradeOrg.remove(0));
		}

		return R;
	}
}