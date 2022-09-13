package arcade.game.blackjack.blackjack_items.instances;

import arcade.HonorCode;
import arcade.game_items.Card;
import arcade.game_items.Shoe;
import arcade.game.blackjack.blackjack_items.BlackJackShoe;
import arcade.game.blackjack.blackjack_items.CheatAccessCards;
import java.util.Collections;
import java.util.ArrayList;

public class BlackJackShoe_Default implements Shoe, HonorCode{
	protected ArrayList<BlackJackCard> list,
									   discard;
	private boolean honest;

	public BlackJackShoe_Default(){ //single deck implementation
		list = new ArrayList<BlackJackCard>(52);
		discard = new ArrayList<BlackJackCard>(52);
		ArrayList<Card> tmp=Shoe.genStandardDeck();

		BlackJackCard upgrade;
		while(tmp.size()>0){
			upgrade = new BlackJackCard(tmp.remove(0));
			list.add(upgrade);
		}
		honest=true;
	}

	private BlackJackShoe_Default(BlackJackShoe_Default originalShoe){
		list = new ArrayList<BlackJackCard>(52);
		discard = new ArrayList<BlackJackCard>(52);
		for(BlackJackCard x : originalShoe.list){
			list.add(new BlackJackCard(x.face,x.suit));
		}
		for(BlackJackCard x : originalShoe.discard){
			discard.add(new BlackJackCard(x.face,x.suit));
		}

		if(this instanceof RogueBJShoe) honest=false;
		else honest=true;
	}

	public RogueBJShoe genRogueClone(){
		return new RogueBJShoe(this);
	}

	//Shoe Overrides:
    @Override
	public void shuffleShoe(){Collections.shuffle(list);}
    public Card drawTop(){return list.remove(0);}

	//HonorCode Overrides:
	public boolean isHonorable(){ //needs to check on list and discard
		return honest;
	}

	private class RogueBJShoe extends BlackJackShoe_Default implements BlackJackShoe, CheatAccessCards{
		private RogueBJShoe(BlackJackShoe_Default org){super(org);}

		//CheatAccessCards Overrides:
		@Override
		public ArrayList<BlackJackCard> getCardsRef(){return this.list;}

		@Override
		public ArrayList<BlackJackCard> getDiscardsRef(){return this.discard;}
	}
}