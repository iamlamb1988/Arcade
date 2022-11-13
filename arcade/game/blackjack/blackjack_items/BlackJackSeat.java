package arcade.game.blackjack.blackjack_items;

import arcade.game.blackjack.blackjack_items.instances.BlackJackCard;
import arcade.game.game_items.Seat;

public interface BlackJackSeat extends Seat{
	public double getCreditsPocket();
	public double getCreditsBet(byte handIndex);

	public byte getNumberOfHands();
	public byte getNumberOfCardsInHand(byte handIndex);
	public byte getPoints(byte handIndex);
	public byte getCardValue(byte handIndex, byte cardIndex);
	public char getCardFace(byte handIndex, byte cardIndex);
	public char getCardSuit(byte handIndex, byte cardIndex);

	public void receiveCard(byte handIndex, BlackJackCard card);
	public BlackJackCard discardCard(byte handIndex, byte cardIndex);

	public boolean isNatural(byte handIndex);
	public boolean isBust(byte handIndex);
	public boolean isSoft(byte handIndex);
}