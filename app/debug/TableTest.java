package app.debug;

import app.DesktopApp;
import app.PanelSwapAction;
import app.menu.IMenu;
import arcade.game.blackjack.blackjack_items.instances.BlackJackTable_Default;
import animation.Animation;
import animation.SingleImage;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class TableTest extends JPanel implements IMenu{
	private Animation bg;
	private BlackJackTable_Default t;

	public TableTest(DesktopApp parentApp, IMenu previous, int width_px, int height_px){
		super();
		setSize(width_px,height_px);
		BufferedImage bgg = new BufferedImage(width_px,height_px,BufferedImage.TYPE_INT_ARGB);
		Graphics2D p = bgg.createGraphics();
		p.setColor(new Color(255,255,0,255));
		p.fillRect(0,0,width_px,height_px);
		bg=new SingleImage(bgg);

		JButton back = new JButton("Main Menu"),
				dDraw = new JButton("Dealer Draw"),
				addPlr = new JButton("Add Player");

		back.setSize(150,40);
		back.setLocation(width_px-back.getWidth()-30,10);
		back.addActionListener(new PanelSwapAction(parentApp,this,(JPanel)previous));
		add(back);

		dDraw.setSize(150,40);
		dDraw.setLocation(10,10);
		add(dDraw);

		addPlr.setSize(150,40);
		addPlr.setLocation(10,60);
		add(addPlr);
	}

	//IAppItem Overrides:
	public void setBG(Animation background){bg=background;}

	//Paint Override
	@Override
	public void paintComponent(Graphics p){
		super.paintComponent(p);
		bg.drawTopLeft(p);
	}
}