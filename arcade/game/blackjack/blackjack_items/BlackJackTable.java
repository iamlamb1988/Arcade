package arcade.game.blackjack.blackjack_items;

import arcade.HonorCode;

//SINGLE RESPONSIBILITY: move cards and money to and from hands and shoes
//Does NOT enforce rules (The BlackJackGame classes will enforce fair play)
public interface BlackJackTable extends HonorCode{
	//Get methods
	public boolean isSeatOccupied(byte seatIndex);
	public double getTableCredits();
	public double getSeatPocketCredits(byte seatIndex);
	public byte getTableCardQty();
	public byte getTableCardValue(byte cardIndex);
	public char getTableCardFace(byte cardIndex);
	public char getTableCardSuit(byte cardIndex);
	public byte getTableHandValue();
	public byte getSeatHandQty(byte seatIndex, byte handIndex);
	public byte getSeatHandValue(byte seatIndex, byte handIndex);

	//5 independant end results
	public boolean isSeatNaturalWin(byte seatIndex);
	public boolean isSeatHandWin(byte seatIndex, byte handIndex);
	public boolean isPush(byte seatIndex, byte handIndex);
	public boolean isSeatHandLoss(byte seatIndex, byte handIndex);
	public boolean isSeatHandBust(byte seatIndex,byte handIndex);

	//Set methods
	public void shuffleShoe();
	public void dealHoleCard();
	public void dealDealer();
	public void dealCard(byte seatIndex,byte handIndex);
	public void takeBet(byte seatIndex, byte handIndex);
	public void awardBet(byte seatIndex, byte handIndex);
	public void clearTable();
}