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
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		//create checkered SingleImage (will be replaced with a professional image)
		BufferedImage tmpB=new BufferedImage(f.getWidth(),f.getHeight(),BufferedImage.TYPE_INT_ARGB);
		BufferedImage chkFlg=new BufferedImage(100,100,BufferedImage.TYPE_INT_ARGB);
		Graphics2D p= chkFlg.createGraphics();
		p.setColor(new Color(127,255,127));
		p.fillRect(0,0,chkFlg.getWidth()/2,chkFlg.getHeight()/2);
		p.fillRect(chkFlg.getWidth()/2,chkFlg.getHeight()/2,chkFlg.getWidth()/2,chkFlg.getHeight()/2);
		p.setColor(new Color(0,127,0));
		p.fillRect(0,chkFlg.getHeight()/2,chkFlg.getWidth()/2,chkFlg.getHeight()/2);
		p.fillRect(chkFlg.getWidth()/2,0,chkFlg.getWidth()/2,chkFlg.getHeight()/2);

		p=tmpB.createGraphics();
		for(int y=0;y<tmpB.getHeight();y+=chkFlg.getHeight()){
			for(int x=0;x<tmpB.getWidth();x+=chkFlg.getWidth()){
				while(!p.drawImage(chkFlg,x,y,null)){}
			}
		}
		//end checkeredFlag drawing
		f.setBG(new SingleImage(tmpB));

		JLabel p2 = new JLabel("Player 2");
		p2.setSize(90,30);
		p2.setLocation((f.getWidth()-p2.getWidth())/2,(int)(0.8*f.getHeight()));
		f.add(p2);

		JLabel p1 = new JLabel("Player 1");
		p1.setSize(p2.getSize());
		p1.setLocation(f.getWidth()/6-p1.getWidth()/2,p2.getY());
		f.add(p1);

		JLabel p3 = new JLabel("Player 3");
		p3.setSize(p2.getSize());
		p3.setLocation(5*f.getWidth()/6-p3.getWidth()/2,p2.getY());
		f.add(p3);

		tmpB=null;
		chkFlg=null;
		p=null;
		add(f);
		
		//add Action Menu Buttons
		JButton stand2 = new JButton("P2 Stand");
		stand2.setSize(90,30);
		stand2.setLocation((width_px-stand2.getWidth())/2,10);
		stand2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println("P2 stand button. Most likely not do much here.");
			}
		});
		a.add(stand2);

		JButton stand1 = new JButton("P1 Stand");
		stand1.setSize(stand2.getSize());
		stand1.setLocation(stand2.getX()-stand1.getWidth()-10,stand2.getY());
		stand1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println("P1 stand button. Most likely not do much here.");
			}
		});
		a.add(stand1);

		JButton stand3 = new JButton("P3 Stand");
		stand3.setSize(stand2.getSize());
		stand3.setLocation(stand2.getX()+stand3.getWidth()+10,stand2.getY());
		stand3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println("P3 stand button. Most likely not do much here.");
			}
		});
		a.add(stand3);

		JButton hit1 = new JButton("P1 Hit");
		hit1.setSize(stand1.getSize());
		hit1.setLocation(stand1.getX(),stand1.getY()+stand1.getHeight()+10);
		hit1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println("P1 hit button. Will soon draw a card...");
			}
		});
		a.add(hit1);

		JButton hit2 = new JButton("P2 Hit");
		hit2.setSize(stand2.getSize());
		hit2.setLocation(stand2.getX(),hit1.getY());
		hit2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println("P2 hit button. Will soon draw a card...");
			}
		});
		a.add(hit2);

		JButton hit3 = new JButton("P3 Hit");
		hit3.setSize(stand3.getSize());
		hit3.setLocation(stand3.getX(),hit2.getY());
		hit3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println("P3 hit button. Will soon draw a card...");
			}
		});
		a.add(hit3);
	}
}