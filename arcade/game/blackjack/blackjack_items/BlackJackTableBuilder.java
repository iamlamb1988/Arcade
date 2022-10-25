package arcade.game.blackjack.blackjack_items;

//The purpose of this class is to generate BlackJackTable instances with ease.
//This class will have the ability so quickly set common defaults to a table.
public class BlackJackTableBuilder{
	//DEFAULT Structure
	private byte MAX_SEAT_NUMBER;

	//DEFAULT Rules
	private boolean isMaxBet;
	private double maxBet;
	private boolean isMinBet;
	private double minBet;
	private byte maxNumOfHands;
	private byte maxNumOfAceSplits;
	private boolean autoStandOnSplitAce;

	public BlackJackTableBuilder(){
		
	}
}