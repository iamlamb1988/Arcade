package app.debug;

import app.menu.IMenu;
import app.srcfactory.AnimationFactory;
import app.srcfactory.card2d.Card2DAnimationFactory;
import resources.*;
import animation.Animation;
import animation.SingleImage;
import javax.swing.*;
import java.awt.Graphics;

public class AnimationTest extends JPanel implements IMenu{
	private Animation bg,
					  i;

	public AnimationTest(int width_px, int height_px){
		super();
		setSize(width_px,height_px);
		setLayout(null);
		setBG(new SingleImage(width_px,height_px,255,255,0,255));

		// CardImgFetcher cif = new CardImgFetcher();
		// cif.fetchAll();

		Card2DAnimationFactory cf = new Card2DAnimationFactory(80,80);
		i=cf.genCardFace('K');

		JButton up = new JButton("Up");
		up.setLocation(10,10);
		up.setSize(150,40);
		add(up);

		JButton down = new JButton("Down");
		down.setLocation(10,60);   //60
		down.setSize(150,40);
		add(down);

		setVisible(true);
	}

	//IAppItem Overrides:
	public void setBG(Animation background){bg=background;}

	//Paint Override
	@Override
	public void paintComponent(Graphics p){
		super.paintComponent(p);
		bg.drawTopLeft(p);
		i.draw(200,200,p);
	}
}