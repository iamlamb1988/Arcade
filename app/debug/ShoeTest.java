package app.debug;

import app.menu.IMenu;
import app.games2d.blackjack2d.shoe2d.BlackJackCard2D;
import app.games2d.blackjack2d.shoe2d.instances.BlackJackShoe2D_Default;
import animation.Animation;
import animation.SingleImage;
import arcade.game_items.Shoe;
import arcade.game.blackjack.blackjack_items.BlackJackShoe;
import arcade.game.blackjack.blackjack_items.instances.BlackJackShoe_Default;
import arcade.game.blackjack.blackjack_items.instances.BlackJackCard;
import arcade.game.blackjack.blackjack_items.CheatAccessCards;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.util.Collections;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;

public class ShoeTest extends JPanel implements IMenu{
	private Animation bg;
	private BlackJackCard2D c;

	private final BlackJackShoe sh;

	public ShoeTest(int width_px, int height_px){
		super();
		setSize(width_px,height_px);
		setLayout(null);
		setBG(new SingleImage(width_px,height_px,0,255,0,255));

		sh = (BlackJackShoe2D_Default)(new BlackJackShoe2D_Default(100,125).genRogueClone());
		sh.shuffleShoe();
		CheatAccessCards cheat = (CheatAccessCards)sh;
		ArrayList<BlackJackCard> list = cheat.getCardsRef();
		ArrayList<BlackJackCard> discard = cheat.getDiscardsRef();

		JButton draw = new JButton("Draw"),
				showShoe = new JButton("Show Shoe"),
				showDiscard = new JButton("Show Discard Pile"),
				shuffle = new JButton("Shuffle"),
				reset = new JButton("Reset Shoe");

		draw.setLocation(10,10);
		draw.setSize(150,40);
		draw.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				c = (BlackJackCard2D)sh.drawTop();
				System.out.println(c.face+" of "+c.suit+" : "+c.value);
				discard.add(c);
				repaint();
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

	//Paint Override
	@Override
	public void paintComponent(Graphics p){
		super.paintComponent(p);
		bg.drawTopLeft(p);
		if(c!=null)
			c.drawFront(p,250,150);
	}
}