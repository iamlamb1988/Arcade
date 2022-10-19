package app.release.sandbox.shoecycle;

import animation.Animation;
import animation.SingleImage;
import app.DesktopApp;
import app.PanelSwapAction;
import app.menu.IMenu;
import app.games2d.GameItem;
import app.menu.gamemenu.GameMenu;
import app.menu.gamemenu.GameField;
import app.menu.gamemenu.GamePanel;
import app.games2d.blackjack2d.shoe2d.instances.BlackJackShoe2D_Default;
import app.games2d.blackjack2d.shoe2d.BlackJackShoe2D;
import app.games2d.blackjack2d.shoe2d.BlackJackCard2D;
import arcade.game.blackjack.blackjack_items.instances.BlackJackCard;
import arcade.game.blackjack.blackjack_items.CheatAccessCards;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

//This SHOULD be using the Shoe methods as much as possible and cheat methods as little as possible.
public class ShoeCycle extends GameMenu{
	private BlackJackShoe2D sh; //need to test generic interface
	private ArrayList<BlackJackCard> shList;
	private ArrayList<BlackJackCard> disc;
	private BlackJackCard2D c;

	public ShoeCycle(DesktopApp parentApp, IMenu previous, int width_px, int height_px){
		super(parentApp,previous,width_px,height_px);
		sh=(BlackJackShoe2D_Default)(new BlackJackShoe2D_Default<BlackJackCard2D>(1000/7,200)).genRogueClone();
		sh.shuffleShoe();
		CheatAccessCards cheat = (CheatAccessCards)sh;
		shList = cheat.getCardsRef();
		disc = cheat.getDiscardsRef();

		BlackJackCard2D tmp2d;
		for(BlackJackCard x : shList){
			tmp2d=(BlackJackCard2D)x;
			tmp2d.setFrontUpside();
			// tmp2d.setX(width_px-tmp2d.){}
		}
		c=null;

		//Draw Action Menu
		ActionPanel a = new ActionPanel(width_px,160);
		a.setLocation(0,height_px-a.getHeight());
		a.setBG(new SingleImage(a.getWidth(),a.getHeight(),128,128,128,255));

		JButton drw=new JButton("Draw");
		drw.setSize(100,90);
		drw.setLocation((a.getWidth()-drw.getWidth())/2,(a.getHeight()-drw.getHeight())/2);
		drw.setVisible(true);
		a.add(drw);

		JButton flp=new JButton("Flip");
		flp.setSize(100,40);
		flp.setLocation(drw.getX()-flp.getWidth()-10,drw.getY());
		flp.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(c!=null){
					c.flipCard();
					repaint();
				}
			}
		});
		flp.setVisible(true);
		a.add(flp);

		JButton dis=new JButton("Discard");
		dis.setSize(100,40);
		dis.setLocation(flp.getX(),flp.getY()+flp.getHeight()+10);
		dis.setVisible(true);
		a.add(dis);

		JButton shStat=new JButton("Remaining");
		shStat.setSize(100,40);
		shStat.setLocation(width_px-shStat.getWidth()-10,10);
		shStat.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println("DEBUG: Generate table for "+shList.size()+" remaining Card(s).");
				for(BlackJackCard x : shList){System.out.println(x.face+" of "+x.suit);}
				System.out.println(shList.size()+" remaining Card(s).");
			}
		});
		shStat.setVisible(true);
		a.add(shStat);

		JButton disStat=new JButton("Discarded");
		disStat.setSize(100,40);
		disStat.setLocation(shStat.getX(),shStat.getY()+disStat.getHeight()+10);
		disStat.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println("DEBUG: Generate table for "+disc.size()+" discarded Card(s).");
				for(BlackJackCard x : disc){System.out.println(x.face+" of "+x.suit);}
				System.out.println(disc.size()+" discarded Card(s).");
			}
		});
		disStat.setVisible(true);
		a.add(disStat);

		JButton rst=new JButton("Reset");
		rst.setSize(100,40);
		rst.setLocation(disStat.getX(),disStat.getY()+rst.getHeight()+10);
		rst.setVisible(true);
		a.add(rst);

		add(a);

		//Menu
		ActionPanel m = new ActionPanel(width_px,60);
		m.setLocation(0,0);
		m.setBG(new SingleImage(m.getWidth(),m.getHeight(),128,128,128,255));

		JButton tmp=new JButton("Main Menu");
		tmp.setSize(100,40);
		tmp.setLocation(m.getWidth()-tmp.getWidth()-10,10);
		tmp.addActionListener(new PanelSwapAction(parentApp,this,previous));
		tmp.setVisible(true);
		m.add(tmp);
		add(m);

		//Add game field
		GameField f=new GameField(0,m.getHeight(),width_px,height_px-a.getHeight()-m.getHeight());
		add(f);

		//Add dependant methods
		drw.addActionListener(new CardDrawingAction(f));
		dis.addActionListener(new CardDrawingAction(f){
			@Override
			public void actionPerformed(ActionEvent e){
				if(c!=null){
					sh.discard(c);
					gf.removeGameItem(c);
					c=null;
				}
				repaint();
			}
		});
		rst.addActionListener(new CardDrawingAction(f){
			@Override
			public void actionPerformed(ActionEvent e){
				if(c!=null){
					sh.discard(c);
					gf.removeGameItem(c);
					c=null;
				}
				sh.reset();
				sh.shuffleShoe();
				System.out.println("Shoe Reset and Shuffled.");
				repaint();
			}
		});
	}

	private class ActionPanel extends GamePanel{//Singleton class that deploys
		private ActionPanel(int width_px, int height_px){super(width_px,height_px);}
	}

	private class CardDrawingAction implements ActionListener{
		GameField gf;

		private CardDrawingAction(GameField gamefield){gf=gamefield;}

		@Override
		public void actionPerformed(ActionEvent e){
			if(c!=null){
				gf.removeGameItem(c);
				sh.discard(c);
			}
			c=(BlackJackCard2D)sh.dealTop();
			gf.addGameItem(c);
			repaint();
		}
	}
}