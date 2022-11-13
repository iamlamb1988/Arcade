package arcade.game.blackjack.blackjack_items.instances;

import arcade.game.blackjack.blackjack_items.BlackJackTable;
import arcade.game.blackjack.blackjack_items.BlackJackShoe;
import arcade.game.blackjack.blackjack_items.BlackJackSeat;
import app.games2d.blackjack2d.shoe2d.BlackJackCard2D;
import arcade.currency.CurrencyDecimal;
import arcade.currency.currency_items.CarbonCoin;
import java.util.ArrayList;

//Designed for a single Currency only
public class BlackJackTable_Default
	<Cur extends CurrencyDecimal>
	implements BlackJackTable
{
	private byte MaxSeats;
	private byte MaxHands;

	//Ace rules upon split:
	private boolean SplitAceHit;
	private boolean SplitAceDD;

	private BlackJackShoe shoe;
	private CurrencyDecimal balance;
	private ArrayList<BlackJackSeat> seat;

	private BlackJackCard hole; // will be shifted to hand upon up flip
	private BlackJackHand_Default hand; //face up cards only.

	//NEEDS a constructor with generic type that extends CurrencyDecimal
	//These constructor settings will most likely move to the "Builder Class"
	public BlackJackTable_Default(){
		MaxSeats=7;
		MaxHands=4;
		SplitAceHit=SplitAceDD=false;

		shoe=new BlackJackShoe_Default();
		balance=new CarbonCoin();
		seat=new ArrayList<BlackJackSeat>(MaxSeats);

		for(byte i=0;i<MaxSeats;++i){seat.add(new BlackJackSeat_Default());}

		// Initiate a seat
		hand = new BlackJackHand_Default();
	}

	//BlackJackTable Overrides:
	@Override
	public boolean isSeatOccupied(byte seatIndex){return seat.get(seatIndex).isOccupied();}

	@Override
	public double getTableCredits(){return balance.getDecAmnt();}

	@Override
	public double getSeatPocketCredits(byte seatIndex){return -1;}

	@Override
	public byte getTableCardQty(){return hand.getCardQ();}

	@Override
	public byte getTableCardValue(byte cardIndex){return hand.getCardValue(cardIndex);}

	@Override
	public char getTableCardFace(byte cardIndex){return hand.getCardFace(cardIndex);}

	@Override
	public char getTableCardSuit(byte cardIndex){return hand.getCardSuit(cardIndex);}

	@Override
	public byte getTableHandValue(){return hand.getBJvalue();}

	@Override
	public byte getSeatHandQty(byte seatIndex, byte handIndex){
		return seat.get(seatIndex).getNumberOfCardsInHand(handIndex);
	}

	@Override
	public byte getSeatHandCardValue(byte seatIndex, byte handIndex, byte cardIndex){
		return seat.get(seatIndex).getCardValue(handIndex, cardIndex);
	}

	@Override
	public char getSeatHandCardFace(byte seatIndex, byte handIndex, byte cardIndex){
		return seat.get(seatIndex).getCardFace(handIndex, cardIndex);
	}

	@Override
	public char getSeatHandCardSuit(byte seatIndex, byte handIndex, byte cardIndex){
		return seat.get(seatIndex).getCardSuit(handIndex, cardIndex);
	}

	@Override
	public byte getSeatHandValue(byte seatIndex, byte handIndex){
		return seat.get(seatIndex).getPoints(handIndex);
	}

	@Override
	public boolean isSeatNaturalWin(byte seatIndex){return false;}

	@Override
	public boolean isSeatHandWin(byte seatIndex, byte handIndex){return false;}

	@Override
	public boolean isPush(byte seatIndex, byte handIndex){return false;}

	@Override
	public boolean isSeatHandLoss(byte seatIndex, byte handIndex){return false;}

	@Override
	public boolean isSeatHandBust(byte seatIndex,byte handIndex){return false;}

	@Override
	public void shuffleShoe(){shoe.shuffleShoe();}

	@Override
	public void dealHoleCard(){hole=(BlackJackCard)shoe.dealTop();}

	@Override
	public void dealDealer(){hand.receiveCard((BlackJackCard)shoe.dealTop());}

	@Override
	public void dealCard(byte seatIndex,byte handIndex){
		seat.get(seatIndex).receiveCard(handIndex,(BlackJackCard)shoe.dealTop());
	}

	@Override
	public void takeBet(byte seatIndex, byte handIndex){}

	@Override
	public void awardBet(byte seatIndex, byte handIndex){}

	@Override
	public void clearTable(){
		//0. remove the hole card to shoe
		//1. move all cards from all hands.
		//2. delete all but 1 hand from all seats (Or seats with a person)
		//3. move all discards to shoe.
		shoe.reset();

		//4. shuffle shoe.
		shuffleShoe();
	}

	//HonorCode Overrides
	@Override
	public boolean isHonorable(){return false;}
}