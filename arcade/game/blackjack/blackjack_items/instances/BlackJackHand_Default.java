package arcade.game.blackjack.blackjack_items.instances;

import arcade.game.blackjack.blackjack_items.BlackJackHand;
import java.util.ArrayList;

public class BlackJackHand_Default implements BlackJackHand{
	private ArrayList<BlackJackCard> h_hand;

	public BlackJackHand_Default(){
		h_hand=new ArrayList<BlackJackCard>();
	}

	//BlackJackHand Overrides:
	@Override
	public byte getCardQ(){return (byte)h_hand.size();}

	@Override
	public byte getCardValue(byte cardIndex){return h_hand.get(cardIndex).value;}

	@Override
	public char getCardSuit(byte cardIndex){return h_hand.get(cardIndex).suit;}

	@Override
	public char getCardFace(byte cardIndex){return h_hand.get(cardIndex).face;}

	@Override
	public byte getBJvalue(){
		byte R=0,
			 aceCtr=0;

		for(BlackJackCard x : h_hand){
			R+=x.value;
			if(x.face=='A') ++aceCtr;
		}
		while(R>21 && aceCtr>0){
			R-=10;
			--aceCtr;
		}
		return R;
	}

	@Override
	public boolean isSoft(){
		byte R=0,
			 aceCtr=0;

		for(BlackJackCard x : h_hand){
			R+=x.value;
			if(x.face=='A') ++aceCtr;
		}
		while(R>21 && aceCtr>0){
			R-=10;
			--aceCtr;
		}
		return aceCtr>0;
	}

	@Override
	public boolean isNat(){
		return (h_hand.size()==2 && (h_hand.get(0).value+h_hand.get(1).value)==21);
	}

	@Override
	public void receiveCard(BlackJackCard card){h_hand.add(card);}

	@Override
	public BlackJackCard discardCard(byte cardIndex){return h_hand.remove(cardIndex);}
}