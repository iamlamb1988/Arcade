package app.debug;

import app.menu.*;
import animation.*;
import arcade.game.blackjack.blackjack_items.*;
import javax.swing.*;
import java.awt.*;

public class ShoeTest extends JPanel implements IMenu{
	private Animation bg;
	private BlackJackShoe sh;
	public ShoeTest(int width_px, int height_px){
		setSize(width_px,height_px);
		setLayout(null);
		setBG(new SingleImage(width_px,height_px,0,255,0,255));
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