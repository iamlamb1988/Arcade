package app.debug;

import app.DesktopApp;
import app.PanelSwapAction;
import app.menu.IMenu;
import app.games2d.blackjack2d.shoe2d.BlackJackCard2D;
import app.games2d.blackjack2d.shoe2d.instances.BlackJackShoe2D_Default;
import animation.Animation;
import animation.SingleImage;
import arcade.game.game_items.Shoe;
import arcade.game.blackjack.blackjack_items.BlackJackShoe;
import arcade.game.blackjack.blackjack_items.instances.BlackJackShoe_Default;
import arcade.game.blackjack.blackjack_items.instances.BlackJackCard;
import arcade.game.blackjack.blackjack_items.CheatAccessCards;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;

public class ShoeTest extends JPanel implements IMenu{
	private Animation bg;
	private BlackJackCard2D c;

	private final BlackJackShoe sh;

	public ShoeTest(DesktopApp parentApp, IMenu previous, int width_px, int height_px){
		super();
		setSize(width_px,height_px);
		setLayout(null);
		setBG(new SingleImage(width_px,height_px,0,255,0,255));

		sh = (BlackJackShoe2D_Default)(new BlackJackShoe2D_Default(100,125).genRogueClone());
		sh.shuffleShoe();
		CheatAccessCards cheat = (CheatAccessCards)sh;
		ArrayList<BlackJackCard> list = cheat.getCardsRef();
		ArrayList<BlackJackCard> discard = cheat.getDiscardsRef();

		JButton back = new JButton("Main Menu"),
				draw = new JButton("Draw"),
				showShoe = new JButton("Show Shoe"),
				showDiscard = new JButton("Show Discard Pile"),
				shuffle = new JButton("Shuffle"),
				reset = new JButton("Reset Shoe");

		back.setSize(150,40);
		back.setLocation(width_px-back.getWidth()-30,10);
		back.addActionListener(new PanelSwapAction(parentApp,this,(JPanel)previous));
		add(back);

		draw.setLocation(10,10);
		draw.setSize(150,40);
		draw.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(list.size()>0){
					c = (BlackJackCard2D)sh.dealTop();
					System.out.println(c.face+" of "+c.suit+" : "+c.value);
					discard.add(c);
					repaint();
				}else{
					System.out.println("No more cards in Shoe.");
				}
			}
		});
		add(draw);

		showShoe.setLocation(10,10+40+10);   //60
		showShoe.setSize(150,40);
		showShoe.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println("REMAINING CARDS: "+list.size());
				for(BlackJackCard x : list){
					System.out.println(x.face+" of "+x.suit+" value: "+x.value);
				}
				System.out.println("DONE\n");
			}
		});

		add(showShoe);

		showDiscard.setLocation(10,60+40+10);//110
		showDiscard.setSize(150,40);
		showDiscard.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println("DISCARDS CARDS: "+discard.size());
				for(BlackJackCard x : discard){
					System.out.println(x.face+" of "+x.suit+" value: "+x.value);
				}
				System.out.println("DONE\n");
			}
		});
		add(showDiscard);

		shuffle.setLocation(10,110+40+10);   //160
		shuffle.setSize(150,40);
		shuffle.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println("SHUFFLE SHOE:");
				sh.shuffleShoe();
				System.out.println("DONE\n");
			}
		});
		add(shuffle);

		reset.setLocation(10,160+40+10);   //210
		reset.setSize(150,40);
		reset.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println("RESET SHOE:");
				while(discard.size()>0){
					list.add(discard.remove(0));
				}
				sh.shuffleShoe();
				c=null;
				repaint();
				System.out.println("DONE\n");
			}
		});
		add(reset);

		setVisible(true);
	}

	//IAppItem Overrides:
	public void setBG(Animation background){bg=background;}

	//Drawable2D Overrides:
	public void dwblDrawTL(Graphics brush){
		
	}

	public void dwblDraw(Graphics brush, int xPos_px, int yPos_px){
		
	}

	//Paint Override
	@Override
	public void paintComponent(Graphics p){
		super.paintComponent(p);
		bg.drawTopLeft(p);
		if(c!=null)
			c.drawFront(p,250,150);
	}
}