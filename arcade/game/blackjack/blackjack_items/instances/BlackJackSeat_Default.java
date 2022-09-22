package arcade.game.blackjack.blackjack_items;

//Should THIS class be a private class within BlackJackTable instances?
public class BlackJackSeat_Default{
	private Player player;

	//Seat Overrides:
	@Override
	public boolean isOccupied(){return player!=null;}

	//BlackJackSeat Overrides:
	@Override
	public double getCreditsPocket(){return false;}

	@Override
	public double getCreditsBet(byte handIndex){return false;}

	@Override
	public byte getNumberOfCardsInHand(byte handIndex){return false;}

	@Override
	public byte getPoints(byte handIndex){return false;}

	@Override
	public boolean isNatural(byte handIndex){return false;}

	@Override
	public boolean isBust(byte handIndex){return false;}

	@Override
	public boolean isSoft(byte handIndex){return false;}
}