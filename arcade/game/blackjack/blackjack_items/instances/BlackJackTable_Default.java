package arcade.game.blackjack.blackjack_items;

import arcade.game.blackjack.BlackJackTable;
import arcade.currency.CurrencyDecimal;

//Designed for a single Currency only
public class BlackJackTable_Default implements BlackJackTable{
	private BlackJackShoe shoe;
	private CurrencyDecimal balance;

	private BlackJackCard hole;
	private ArrayList<BlackJackCard> hand; //face up cards only.

	//BlackJackTable Overrides:
	public double getTableCredits(){balance.getDecAmnt();}
	public double getSeatPocketCredits(byte seatIndex);
	public byte getTableHandValue();
	public byte getSeatHandValue(byte seatIndex, byte handIndex);

	//5 independant end results
	public boolean isSeatNaturalWin(byte seatIndex);
	public boolean isSeatHandWin(byte seatIndex, byte handIndex);
	public boolean isPush(byte seatIndex, byte handIndex);
	public boolean isSeatHandLoss(byte seatIndex, byte handIndex);
	public boolean isSeatHandBust(byte seatIndex,byte handIndex);

	//Set methods
	public void dealCard(byte seatIndex,byte handIndex);
	public void takeBet(byte seatIndex, byte handIndex);
	public void awardBet(byte seatIndex, byte handIndex);
	public void clearTable();
}