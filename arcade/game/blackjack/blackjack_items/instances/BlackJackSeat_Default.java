package arcade.game.blackjack.blackjack_items.instances;

import arcade.customer.Player;
import arcade.game.blackjack.blackjack_items.BlackJackSeat;
import java.util.ArrayList;

//Should THIS class be a private class within BlackJackTable instances?
public class BlackJackSeat_Default implements BlackJackSeat{
	private Player player;
	private ArrayList<BlackJackHand_Default> hand;

	public BlackJackSeat_Default(){
		hand = new ArrayList<BlackJackHand_Default>();
		hand.add(new BlackJackHand_Default()); //Add 1 hand
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
	public byte getNumberOfHands(){return (byte)hand.size();}

	@Override
	public byte getNumberOfCardsInHand(byte handIndex){return hand.get(handIndex).getCardQ();}

	@Override
	public byte getPoints(byte handIndex){return hand.get(handIndex).getBJvalue();}

	@Override
	public byte getCardValue(byte handIndex, byte cardIndex){return hand.get(handIndex).getCardValue(cardIndex);}

	@Override
	public char getCardFace(byte handIndex, byte cardIndex){return hand.get(handIndex).getCardFace(cardIndex);}

	@Override
	public char getCardSuit(byte handIndex, byte cardIndex){return hand.get(handIndex).getCardSuit(cardIndex);}

	@Override
	public void receiveCard(byte handIndex, BlackJackCard card){hand.get(handIndex).receiveCard(card);}

	@Override
	public BlackJackCard discardCard(byte handIndex, byte cardIndex){
		return hand.get(handIndex).discardCard(cardIndex);
	}

	@Override
	public boolean isNatural(byte handIndex){return hand.get(handIndex).isNat();}

	@Override
	public boolean isBust(byte handIndex){return hand.get(handIndex).getBJvalue()>21;}

	@Override
	public boolean isSoft(byte handIndex){return hand.get(handIndex).isSoft();}
}