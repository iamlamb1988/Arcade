package app.release.sandbox.tablecycle;

import app.menu.gamemenu.GameMenu;
import app.DesktopApp;
import app.PanelSwapAction;
import app.menu.IMenu;
import animation.SingleImage;
import app.menu.gamemenu.GamePanel;
import app.menu.gamemenu.GameField;
import arcade.currency.currency_items.CarbonCoin;
import app.games2d.blackjack2d.shoe2d.BlackJackCard2D;
import app.games2d.blackjack2d.table2d.instances.BlackJackTable2D_Default;
import arcade.game.blackjack.blackjack_items.BlackJackTable;
import arcade.game.blackjack.blackjack_items.instances.BlackJackTable_Default;
import javax.swing.JButton;

public class TableCycle extends GameMenu{
	private BlackJackTable t;

	public TableCycle(DesktopApp parentApp, IMenu previous, int width_px, int height_px){
		super(parentApp,previous,width_px,height_px);
		t=new BlackJackTable2D_Default<CarbonCoin,BlackJackCard2D>();

		//Add Main Menu Bar (with back button)
		GamePanel m = new GamePanel(width_px,60);
		m.setLocation(0,0);
		m.setBG(new SingleImage(m.getWidth(),m.getHeight(),128,128,128,255));

		JButton tmp=new JButton("Main Menu");
		tmp.setSize(100,40);
		tmp.setLocation(m.getWidth()-tmp.getWidth()-10,10);
		tmp.addActionListener(new PanelSwapAction(parentApp,this,previous));
		tmp.setVisible(true);
		m.add(tmp);
		add(m);

		//Add Action Menu Bar
		GamePanel a = new GamePanel(width_px,160);
		a.setLocation(0,height_px-a.getHeight());
		a.setBG(new SingleImage(a.getWidth(),a.getHeight(),128,128,128,255));
		add(a);

		//Add Primary Field
		GameField f=new GameField(0,m.getHeight(),width_px,height_px-a.getHeight()-m.getHeight());
		add(f);
	}
}