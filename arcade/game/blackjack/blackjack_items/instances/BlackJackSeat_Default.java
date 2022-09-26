package arcade.game.blackjack.blackjack_items.instances;

import arcade.customer.Player;
import arcade.game.blackjack.blackjack_items.instances.BlackJackCard;
import arcade.game.blackjack.blackjack_items.BlackJackSeat;
import java.util.ArrayList;

//Should THIS class be a private class within BlackJackTable instances?
public class BlackJackSeat_Default implements BlackJackSeat{
	private Player player;
	private ArrayList<Hand> hand;

	public BlackJackSeat_Default(){
		hand = new ArrayList<Hand>();
		hand.add(new Hand()); //Add 1 hand
	}

	//Seat Overrides:
	@Override
	public boolean isOccupied(){return player!=null;}

	//BlackJackSeat Overrides:
	@Override
	public double getCreditsPocket(){return -1;}

	@Override
	public double getCreditsBet(byte handIndex){return -1;}

	@Override
	public byte getNumberOfCardsInHand(byte handIndex){return (byte)hand.get(handIndex).h_hand.size();}

	@Override
	public byte getPoints(byte handIndex){return hand.get(handIndex).getBJvalue();}

	@Override
	public boolean isNatural(byte handIndex){return hand.get(handIndex).isNat();}

	@Override
	public boolean isBust(byte handIndex){return hand.get(handIndex).getBJvalue()>21;}

	@Override
	public boolean isSoft(byte handIndex){return hand.get(handIndex).isSoft();}

	private class Hand{
		private ArrayList<BlackJackCard> h_hand;
		private Hand(){
			h_hand=new ArrayList<BlackJackCard>();
		}

		private byte getBJvalue(){
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

		private boolean isSoft(){
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

		private boolean isNat(){
			return (h_hand.size()==2 && (h_hand.get(0).value+h_hand.get(1).value)==21);
		}
	}
}