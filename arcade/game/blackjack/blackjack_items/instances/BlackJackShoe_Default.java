package arcade.game.blackjack.blackjack_items.instances;

import arcade.HonorCode;
import arcade.game.game_items.Card;
import arcade.game.blackjack.blackjack_items.BlackJackShoe;
import arcade.game.blackjack.blackjack_items.CheatAccessCards;
import java.util.Collections;
import java.util.ArrayList;

public class BlackJackShoe_Default implements BlackJackShoe, HonorCode{
	protected ArrayList<BlackJackCard> list;
	protected ArrayList<BlackJackCard> discard;

	private boolean honest;
	public BlackJackShoe_Default(byte num_of_decks){
		list = BlackJackShoe.genStandardBlackJackDecks(num_of_decks);
		discard = new ArrayList<BlackJackCard>(list.size());
		honest=true;
	}

	public BlackJackShoe_Default(){this((byte)1);}

	protected BlackJackShoe_Default(BlackJackShoe_Default originalShoe){
		list=new ArrayList<BlackJackCard>(originalShoe.list.size()+originalShoe.discard.size());
		discard=new ArrayList<BlackJackCard>(list.size());
		for(BlackJackCard x : originalShoe.list){list.add(x.clone());}
		for(BlackJackCard x : originalShoe.discard){discard.add(x.clone());}
		honest=false;
	}

	public CheatAccessCards genRogueClone(){return new RogueBJShoe(this);}

	//Shoe Overrides:
	@Override
	public boolean isEmpty(){return list.size()==0;}

	@Override
	public int getRemainingQty(){return list.size();}

	@Override
	public int getDiscardQty(){return discard.size();}

    @Override
	public void shuffleShoe(){Collections.shuffle(list);}

	@Override
    public Card dealTop(){return list.remove(0);}

	@Override
	public void reset(){
		for(BlackJackCard x: discard){list.add(x);}
		discard.clear();
	}

	@Override
	public void discard(Card dis){
		discard.add((BlackJackCard)dis);
	}

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