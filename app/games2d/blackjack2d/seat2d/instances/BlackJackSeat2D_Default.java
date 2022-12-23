package app.games2d.blackjack2d.seat2d.instances;

import animation.Animation;
import app.games2d.blackjack2d.seat2d.BlackJackSeat2D;
import arcade.game.blackjack.blackjack_items.instances.BlackJackSeat_Default;
import java.awt.Graphics;

public class BlackJackSeat2D_Default extends BlackJackSeat_Default implements BlackJackSeat2D{
	private Animation seatAnm;
	
	public BlackJackSeat2D_Default(){
		//set Default value for seatAnm
		
	}

	//BlackJackSeat2D Overrides:
	@Override
	public void drawSeat(Graphics brush, int xPos, int yPos){
		seatAnm.draw(xPos,yPos,brush);
	}

	@Override
	public void drawCardFront(Graphics brush, byte handIndex, byte cardIndex, int xPos, int yPos){
		
	}

	@Override
	public void drawCardBack(Graphics brush, byte handIndex, byte cardIndex, int xPos, int yPos){
		//TODO
	}
}