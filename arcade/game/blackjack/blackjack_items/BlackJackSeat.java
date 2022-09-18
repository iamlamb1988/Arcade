package arcade.game.blackjack.blackjack_items;

import arcade.game_items.Seat;

public interface BlackJackSeat extends Seat{
	public byte getPoints();
	public byte getPoints(byte handIndex); //in multiple hands
	public byte getNumberOfCardsInHand();
	public byte getNumberOfCardsInHand(byte handIndex);
}