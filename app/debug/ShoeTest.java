package app.debug;

import app.menu.IMenu;
import app.srcfactory.AnimationFactory;
import app.srcfactory.card2d.Card2DAnimationFactory;
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
	private Animation bg,
					  i;

	private final BlackJackShoe sh;

	public ShoeTest(int width_px, int height_px){
		super();
		setSize(width_px,height_px);
		setLayout(null);
		setBG(new SingleImage(width_px,height_px,0,255,0,255));

		Card2DAnimationFactory aF = new Card2DAnimationFactory();
		aF.setActualSize(100,125);
		aF.setSpacing(7,7);
		aF.setSuitSize(20,30);
		aF.setFaceSize(20,30);
		aF.setBG(aF.genCardBorder(100, 125, 10)); //ARBITRARY NEEDS FIXED UPON 2D REFACTOR
		aF.setFaces();
		aF.setSuits();
		aF.setCards();

		i=null;
		sh = new BlackJackShoe_Default().genRogueClone();
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
				BlackJackCard x = (BlackJackCard)sh.drawTop();
				System.out.println(x.face+" of "+x.suit+" : "+x.value);
				i=aF.getCard2D(x.face,x.suit);
				discard.add(x);
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
				i=null;
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
		if(i!=null)
			i.draw(250,150,p);
		
	}
}