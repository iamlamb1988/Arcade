package arcade.game.blackjack.blackjack_items;

import arcade.game_items.Seat;

public interface BlackJackSeat extends Seat{
	public double getCreditsPocket();
	public double getCreditsBet(byte handIndex);

	public byte getNumberOfCardsInHand(byte handIndex);
	public byte getPoints(byte handIndex);

	public boolean isNatural(byte handIndex);
	public boolean isBust(byte handIndex);
	public boolean isSoft(byte handIndex);
}