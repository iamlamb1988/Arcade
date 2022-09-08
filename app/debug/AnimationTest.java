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

		Card2DAnimationFactory c2Df = new Card2DAnimationFactory(150,150);
		c2Df.setActualSize(100,125);
		c2Df.setSpacing(7,7);
		c2Df.setSuitSize(20,30);
		c2Df.setFaceSize(20,30);

		c2Df.setBG(c2Df.genCardBorder(100, 125, 10)); //ARBITRARY NEEDS FIXED UPON 2D REFACTOR
		c2Df.setFaces();
		c2Df.setSuits();
		c2Df.setCards();
		// i=c2Df.genCardFace('K');
		i=c2Df.getCard2D('A','S');

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