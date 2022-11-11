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
		t.shuffleShoe();

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

		//Add Stat Panel
		GamePanel s=new GamePanel((int)(.2*width_px),height_px-a.getHeight()-m.getHeight());
		s.setLocation(0,m.getHeight());
		s.setBG(new SingleImage(s.getWidth(),s.getHeight(),255,255,0,255));
		JLabel statUpdate = new JLabel("Updates Here");
		statUpdate.setSize(s.getWidth()-10,s.getHeight()/2-10);
		statUpdate.setLocation(10,10);
		s.add(statUpdate);
		add(s);

		//Add Primary Field
		GameField f=new GameField(s.getWidth(),m.getHeight(),width_px-s.getWidth(),height_px-a.getHeight()-m.getHeight());
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
		JButton stT = new JButton("Dealer Stat");
		stT.setSize(100,30);
		stT.setLocation(10,10);
		stT.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String R=
					"<html><body>Dealer Stats:"+
					"<p>Dealer CardCount: "+t.getTableCardQty()+"</p>"+
					"<p>Dealer Up Value: "+t.getTableHandValue()+"</p>"+
					"<p>Dealer Up Cards:</p>";

				byte qi=t.getTableCardQty();
				for(byte i=0;i<qi;++i){
					R+=("<p>"+t.getTableCardFace(i)+" of "+t.getTableCardSuit(i)+"</p>");
				}
				statUpdate.setText(R+"</body></html>");
			}
		});
		a.add(stT);

		JButton hitT = new JButton("Dealer hit");
		hitT.setSize(stT.getSize());
		hitT.setLocation(stT.getX(),stT.getY()+stT.getHeight()+10);
		hitT.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				t.dealDealer();
				byte i=(byte)(t.getTableCardQty()-1);
				statUpdate.setText("Dealer new Card: "+t.getTableCardFace(i)+" of "+t.getTableCardSuit(i));
			}
		});
		a.add(hitT);

		JButton st2 = new JButton("P2 Stat");
		st2.setSize(90,30);
		st2.setLocation((width_px-st2.getWidth())/2,10);
		st2.addActionListener(new SeatStatAction((byte)1,statUpdate));
		a.add(st2);

		JButton st1 = new JButton("P1 Stat");
		st1.setSize(st2.getSize());
		st1.setLocation(st2.getX()-st1.getWidth()-10,st2.getY());
		st1.addActionListener(new SeatStatAction((byte)0,statUpdate));
		a.add(st1);

		JButton st3 = new JButton("P3 Stat");
		st3.setSize(st2.getSize());
		st3.setLocation(st2.getX()+st3.getWidth()+10,st2.getY());
		st3.addActionListener(new SeatStatAction((byte)2,statUpdate));
		a.add(st3);

		JButton hit1 = new JButton("P1 Hit");
		hit1.setSize(st1.getSize());
		hit1.setLocation(st1.getX(),st1.getY()+st1.getHeight()+10);
		hit1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				statUpdate.setText("<html><p>P1 hit button.</p><p>Will soon draw a card...</p></html>");
			}
		});
		a.add(hit1);

		JButton hit2 = new JButton("P2 Hit");
		hit2.setSize(st2.getSize());
		hit2.setLocation(st2.getX(),hit1.getY());
		hit2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				statUpdate.setText("<html><p>P2 hit button.</p><p>Will soon draw a card...</p></html>");
			}
		});
		a.add(hit2);

		JButton hit3 = new JButton("P3 Hit");
		hit3.setSize(st3.getSize());
		hit3.setLocation(st3.getX(),hit2.getY());
		hit3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				statUpdate.setText("<html><p>P3 hit button.</p><p>Will soon draw a card...</p></html>");
			}
		});
		a.add(hit3);
	}

	private class SeatStatAction implements ActionListener{
		private byte si; //seat index
		private JLabel l;//Label pointer

		private SeatStatAction(byte seatIndex, JLabel newL){
			si=seatIndex;
			l=newL;
		}

		@Override
		public void actionPerformed(ActionEvent e){
			l.setText(
				"<html><body><p>Seat Index: "+
				si+"</p><p>Number of Cards: "+
				t.getSeatHandQty(si,(byte)0)+"</p></body></html>"
			);
		}
	}
}