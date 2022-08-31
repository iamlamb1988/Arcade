package arcade.game.blackjack.blackjack_items;

import java.util.ArrayList;
import arcade.game_items.Card;
import arcade.game_items.Shoe;

public class BlackJackShoe implements Shoe{
	private ArrayList<BlacJackCard> list;
	
	public BlackJackShoe(){ //single deck implementation
		Shoe tmp=genStandardDeck();

		BlackJackCard upgrade;
		while(tmp.getSize()>0){
			upgrade = new BlackJackCard(tmp.remove(0));
			list.add(upgrade);
		}
	}

    @Override
    public Card drawTop(){return null;}
}