package arcade.game.blackjack.blackjack_items;

import java.util.Collections;
import java.util.ArrayList;
import arcade.game_items.Card;
import arcade.game_items.Shoe;

public class BlackJackShoe implements Shoe{
	private ArrayList<BlackJackCard> list;
	
	public BlackJackShoe(){ //single deck implementation
		list = new ArrayList<BlackJackCard>();
		ArrayList<Card> tmp=Shoe.genStandardDeck();

		BlackJackCard upgrade;
		while(tmp.size()>0){
			upgrade = new BlackJackCard(tmp.remove(0));
			list.add(upgrade);
		}
	}

    @Override
	public void shuffleShoe(){Collections.shuffle(list);}
    public Card drawTop(){return list.remove(0);}
}