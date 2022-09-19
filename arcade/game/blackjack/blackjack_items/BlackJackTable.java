package arcade.game.blackjack.blackjack_items;

import arcade.HonorCode;

public interface BlackJackTable extends HonorCode{
	public double getTableCredits();
	public double getSeatPocketCredits(byte seatIndex);
	public byte getTableHandValue();
	public byte getSeatHandValue(byte seatIndex, byte handIndex);

	//5 independant end results
	public boolean isSeatNaturalWin(byte seatIndex);
	public boolean isSeatHandWin(byte seatIndex, byte handIndex);
	public boolean isPush(byte seatIndex, byte handIndex);
	public boolean isSeatHandLoss(byte seatIndex, byte handIndex);
	public boolean isSeatHandBust(byte seatIndex,byte handIndex);
}