package arcade.game.blackjack.blackjack_items.instances;

import arcade.HonorCode;
import arcade.game.game_items.Card;
import arcade.game.game_items.Shoe;
import arcade.game.blackjack.blackjack_items.BlackJackShoe;
import arcade.game.blackjack.blackjack_items.CheatAccessCards;
import java.util.Collections;
import java.util.ArrayList;

public class BlackJackShoe_Default<C extends BlackJackCard> implements BlackJackShoe, HonorCode{
	protected ArrayList<C> list,
						   discard;

	private boolean honest;

	public BlackJackShoe_Default(){ //single deck implementation
		list = new ArrayList<C>(52);
		discard = new ArrayList<C>(52);
		ArrayList<Card> tmp=Shoe.genStandardDeck();

		C upgrade;
		while(tmp.size()>0){
			upgrade = (C)(new BlackJackCard(tmp.remove(0)));
			list.add(upgrade);
		}
		honest=true;
	}

	protected BlackJackShoe_Default(BlackJackShoe_Default<C> originalShoe){
		list = new ArrayList<C>(52);
		discard = new ArrayList<C>(52);
		for(BlackJackCard x : originalShoe.list){
			list.add((C)x.clone());
		}
		for(BlackJackCard x : originalShoe.discard){
			discard.add((C)x.clone());
		}

		if(this instanceof RogueBJShoe) honest=false;
		else honest=true;
	}

	public CheatAccessCards genRogueClone(){
		return new RogueBJShoe(this);
	}

	//Shoe Overrides:
    @Override
	public void shuffleShoe(){Collections.shuffle(list);}

	@Override
    public Card dealTop(){return list.remove(0);}

	@Override
	public void discard(Card dis){
		discard.add((C)dis);
	}

	//HonorCode Overrides:
	public boolean isHonorable(){ //needs to check on list and discard
		return honest;
	}

	private class RogueBJShoe<CR extends C> extends BlackJackShoe_Default implements BlackJackShoe, CheatAccessCards{
		private RogueBJShoe(BlackJackShoe_Default<CR> org){
			super(org);
		}

		//CheatAccessCards Overrides:
		@Override
		public ArrayList<BlackJackCard> getCardsRef(){return this.list;}

		@Override
		public ArrayList<BlackJackCard> getDiscardsRef(){return this.discard;}
	}
}