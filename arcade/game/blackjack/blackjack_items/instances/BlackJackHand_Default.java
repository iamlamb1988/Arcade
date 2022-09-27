package arcade.game.blackjack.blackjack_items.instances;

import java.util.ArrayList;

public class BlackJackHand_Default{
	private ArrayList<BlackJackCard> h_hand;

	public BlackJackHand_Default(){
		h_hand=new ArrayList<BlackJackCard>();
	}

	public byte getCardQ(){return (byte)h_hand.size();}

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

	public boolean isNat(){
		return (h_hand.size()==2 && (h_hand.get(0).value+h_hand.get(1).value)==21);
	}

	public void receiveCard(BlackJackCard card){h_hand.add(card);}
	public BlackJackCard discardCard(){return h_hand.remove(h_hand.size()-1);}
}