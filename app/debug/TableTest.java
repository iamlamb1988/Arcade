package app.debug;

import app.DesktopApp;
import app.PanelSwapAction;
import app.menu.IMenu;
import arcade.game.blackjack.blackjack_items.instances.BlackJackTable_Default;
import animation.Animation;
import animation.SingleImage;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class TableTest extends JPanel implements IMenu{
	private Animation bg;
	private BlackJackTable_Default t;
	private JLabel status;

	public TableTest(DesktopApp parentApp, IMenu previous, int width_px, int height_px){
		super();
		setSize(width_px,height_px);
		BufferedImage bgg=new BufferedImage(width_px,height_px,BufferedImage.TYPE_INT_ARGB);
		Graphics2D p=bgg.createGraphics();
		p.setColor(new Color(255,255,0,255));
		p.fillRect(0,0,width_px,height_px);
		bg=new SingleImage(bgg);
		t=new BlackJackTable_Default();
		t.shuffleShoe();

		JButton back = new JButton("Main Menu"),
				chkPlayers = new JButton("How many players?"),
				chkCards = new JButton("How many cards"),
				dDraw = new JButton("Dealer Draw"),
				addPlr = new JButton("Add Player");

		back.setSize(150,40);
		back.setLocation(width_px-back.getWidth()-30,10);
		back.addActionListener(new PanelSwapAction(parentApp,this,(JPanel)previous));
		add(back);

		chkPlayers.setSize(150,40);
		chkPlayers.setLocation(10,10);
		chkPlayers.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){System.out.println("Not yet ready to test.");}
		});
		add(chkPlayers);

		chkCards.setSize(150,40);
		chkCards.setLocation(10,60);
		chkCards.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println("Not yet ready to test.");
			}
		});
		add(chkCards);

		dDraw.setSize(150,40);
		dDraw.setLocation(10,110);
		dDraw.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				t.dealDealer();
				byte tmpI=(byte)(t.getTableCardQty()-1);
				System.out.println(
					"Dealer Draws: "+
					t.getTableCardFace(tmpI)+" of "+
					t.getTableCardSuit(tmpI)
				);
			}
		});
		add(dDraw);

		addPlr.setSize(150,40);
		addPlr.setLocation(10,160);
		addPlr.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println("Not yet ready to test.");
			}
		});
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