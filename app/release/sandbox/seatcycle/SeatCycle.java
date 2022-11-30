package app.release.sandbox.seatcycle;

import app.DesktopApp;
import app.games2d.blackjack2d.shoe2d.BlackJackShoe2D;
import app.games2d.blackjack2d.shoe2d.instances.BlackJackShoe2D_Default;
import app.games2d.blackjack2d.seat2d.BlackJackSeat2D;
import app.games2d.blackjack2d.seat2d.instances.BlackJackSeat2D_Default;
import app.menu.IMenu;
import app.menu.gamemenu.GameMenu;
import app.srcfactory.card2d.Card2DAnimationFactory;

public class SeatCycle extends GameMenu{
	private BlackJackShoe2D sh;
	private BlackJackSeat2D[] seatL;

	public SeatCycle(DesktopApp parentApp, IMenu previous, int width_px, int height_px){
		super(parentApp,previous,width_px,height_px);
		sh=(BlackJackShoe2D_Default)(
			new BlackJackShoe2D_Default(
				(int)(Card2DAnimationFactory.R_H*200),200)
		).genRogueClone();
		sh.shuffleShoe();

		seatL = new BlackJackSeat2D[4];
		for(byte i=0;i<seatL.length;++i){
			seatL[i]=new BlackJackSeat2D_Default();
		}
	}

	
}