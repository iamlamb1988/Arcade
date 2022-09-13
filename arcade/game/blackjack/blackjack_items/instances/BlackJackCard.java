package arcade.game.blackjack.blackjack_items.instances;

import arcade.game_items.*;

public class BlackJackCard extends Card{
	public final byte value;

    public BlackJackCard(char faceValue, char suitValue){
        super(faceValue,suitValue);
		if(faceValue<='9') value = (byte)(faceValue-'0');
		else if(faceValue=='T' || faceValue=='J' || faceValue=='Q' || faceValue=='K') value = (byte)10;
		else if(faceValue=='A') value = (byte)11;
		else value=(byte)-1; //error return
    }

	public BlackJackCard(Card originalCard){ //will create a copy of card
		this(originalCard.face,originalCard.suit);
	}

	private BlackJackCard(char faceValue, char suitValue, byte pointValue){
		super(faceValue,suitValue);
		value=pointValue;
	}

	public BlackJackCard clone(){
		return new BlackJackCard(face,suit,value);
	}
}