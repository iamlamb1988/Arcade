package app.release.sandbox.seatcycle;

import javax.swing.JButton;

import animation.SingleImage;
import app.DesktopApp;
import app.PanelSwapAction;
import app.games2d.blackjack2d.shoe2d.BlackJackShoe2D;
import app.games2d.blackjack2d.shoe2d.instances.BlackJackShoe2D_Default;
import app.games2d.blackjack2d.seat2d.BlackJackSeat2D;
import app.games2d.blackjack2d.seat2d.instances.BlackJackSeat2D_Default;
import app.menu.IMenu;
import app.menu.gamemenu.GameField;
import app.menu.gamemenu.GameMenu;
import app.menu.gamemenu.GamePanel;
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
		for(byte i=0;i<seatL.length;++i){seatL[i]=new BlackJackSeat2D_Default();}

		GamePanel m = new GamePanel(width_px,60);
		m.setLocation(0,0);
		m.setBG(new SingleImage(m.getWidth(),m.getHeight(),128,128,128,255));
		add(m);
		
		JButton mm=new JButton("Main Menu");
		mm.setSize(100,40);
		mm.setLocation(m.getWidth()-mm.getWidth()-10,10);
		mm.addActionListener(new PanelSwapAction(parentApp,this,previous));
		mm.setVisible(true);
		m.add(mm);

		GamePanel a = new GamePanel(width_px,160);
		a.setLocation(0,height_px-a.getHeight());
		a.setBG(new SingleImage(a.getWidth(),a.getHeight(),128,128,128,255));
		add(a);

		//Add game field
		GameField f=new GameField(0,m.getHeight(),width_px,height_px-a.getHeight()-m.getHeight());
		add(f);
	}
}