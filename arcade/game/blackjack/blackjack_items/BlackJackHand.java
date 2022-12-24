package arcade.game.blackjack.blackjack_items;

import arcade.game.blackjack.blackjack_items.instances.BlackJackCard;

public interface BlackJackHand{
	public byte getCardQ();
	public byte getCardValue(byte cardIndex);
	public char getCardSuit(byte cardIndex);
	public char getCardFace(byte cardIndex);
	public byte getBJvalue();
	public boolean isSoft();
	public boolean isNat();

	public void receiveCard(BlackJackCard card);
	public BlackJackCard discardCard(byte cardIndex);
}