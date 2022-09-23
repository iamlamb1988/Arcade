package arcade.game.blackjack.blackjack_items.instances;

import arcade.customer.Player;
import arcade.game.blackjack.blackjack_items.BlackJackSeat;

//Should THIS class be a private class within BlackJackTable instances?
public class BlackJackSeat_Default implements BlackJackSeat{
	private Player player;

	//Seat Overrides:
	@Override
	public boolean isOccupied(){return player!=null;}

	//BlackJackSeat Overrides:
	@Override
	public double getCreditsPocket(){return -1;}

	@Override
	public double getCreditsBet(byte handIndex){return -1;}

	@Override
	public byte getNumberOfCardsInHand(byte handIndex){return -1;}

	@Override
	public byte getPoints(byte handIndex){return -1;}

	@Override
	public boolean isNatural(byte handIndex){return false;}

	@Override
	public boolean isBust(byte handIndex){return false;}

	@Override
	public boolean isSoft(byte handIndex){return false;}
}