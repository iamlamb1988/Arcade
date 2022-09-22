package arcade.game.blackjack.blackjack_items.instances;

import arcade.game.blackjack.blackjack_items.BlackJackTable;
import arcade.game.blackjack.blackjack_items.BlackJackShoe;
import arcade.currency.CurrencyDecimal;
import arcade.currency.currency_items.CarbonCoin;
import arcade.game_items.Seat;
import java.util.ArrayList;

//Designed for a single Currency only
public class BlackJackTable_Default implements BlackJackTable{
	private byte MaxSeats;
	private byte MaxHands;

	//Ace rules upon split:
	private boolean SplitAceHit;
	private boolean SplitAceDD;

	private BlackJackShoe shoe;
	private CurrencyDecimal balance;
	private ArrayList<Seat> seat;

	private BlackJackCard hole; // will be shifted to hand upon up flip
	private ArrayList<BlackJackCard> hand; //face up cards only.

	//NEEDS a constructor with generic type that extends CurrencyDecimal
	public BlackJackTable_Default(){
		MaxSeats=7;
		MaxHands=4;
		SplitAceHit=SplitAceDD=false;

		shoe=new BlackJackShoe_Default();
		balance=new CarbonCoin();
		// Initiate a seat

		hand = new ArrayList<BlackJackCard>();
		
	}

	//BlackJackTable Overrides:
	public double getTableCredits(){return balance.getDecAmnt();}
	public double getSeatPocketCredits(byte seatIndex){return -1;}
	public byte getTableHandValue(){return -1;}
	public byte getSeatHandValue(byte seatIndex, byte handIndex){return -1;}

	//5 independant end results
	public boolean isSeatNaturalWin(byte seatIndex){return false;}
	public boolean isSeatHandWin(byte seatIndex, byte handIndex){return false;}
	public boolean isPush(byte seatIndex, byte handIndex){return false;}
	public boolean isSeatHandLoss(byte seatIndex, byte handIndex){return false;}
	public boolean isSeatHandBust(byte seatIndex,byte handIndex){return false;}

	//Set methods
	public void dealCard(byte seatIndex,byte handIndex){}
	public void takeBet(byte seatIndex, byte handIndex){}
	public void awardBet(byte seatIndex, byte handIndex){}
	public void clearTable(){}

	//HonorCode Overrides
	@Override
	public boolean isHonorable(){return false;}
}