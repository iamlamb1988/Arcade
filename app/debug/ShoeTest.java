package app.debug;

import app.menu.IMenu;
import animation.Animation;
import animation.SingleImage;
import arcade.game_items.Shoe;
import arcade.game.blackjack.blackjack_items.BlackJackShoe;
import arcade.game.blackjack.blackjack_items.BlackJackCard;
import arcade.game.blackjack.blackjack_items.*;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.util.Collections;
import java.util.ArrayList;
import java.awt.event.*;
import java.awt.Graphics;

public class ShoeTest extends JPanel implements IMenu{
	private Animation bg;
	private final BlackJackShoe sh;

	public ShoeTest(int width_px, int height_px){
		setSize(width_px,height_px);
		setLayout(null);
		setBG(new SingleImage(width_px,height_px,0,255,0,255));
		
		sh = new BlackJackShoe().genRogueClone();		
		sh.shuffleShoe();
		CheatAccessCards cheat = (CheatAccessCards)sh;

		System.out.println("DEBUG IS HONORABLE?: "+sh.isHonorable());

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
				BlackJackCard x = (BlackJackCard)sh.drawTop();
				System.out.println(x.face+" of "+x.suit+" : "+x.value);
				cheat.getDiscardsRef().add(x);
			}
		});
		add(draw);

		showShoe.setLocation(10,10+40+10);   //60
		showShoe.setSize(150,40);
		showShoe.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println("REMAINING CARDS:");
				ArrayList<BlackJackCard> list = cheat.getCardsRef();
				for(BlackJackCard x : list){
					System.out.println(x.face+" of "+x.suit+" value: "+x.value);
				}
				System.out.println("DONE");
			}
		});

		add(showShoe);

		showDiscard.setLocation(10,60+40+10);//110
		showDiscard.setSize(150,40);
		showDiscard.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println("DISCARDS CARDS:");
				ArrayList<BlackJackCard> list = cheat.getDiscardsRef();
				for(BlackJackCard x : list){
					System.out.println(x.face+" of "+x.suit+" value: "+x.value);
				}
				System.out.println("DONE");
			}
		});
		add(showDiscard);

		shuffle.setLocation(10,110+40+10);   //160
		shuffle.setSize(150,40);
		shuffle.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println("SHUFFLE SHOE:");
				Collections.shuffle(cheat.getCardsRef());
				System.out.println("DONE");
			}
		});
		add(shuffle);

		reset.setLocation(10,160+40+10);   //210
		reset.setSize(150,40);
		reset.addActionListener(null);
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
	}
}