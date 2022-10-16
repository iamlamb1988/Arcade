package app.debug;

import animation.*;
import app.*;
import app.menu.*;
import app.srcfactory.card2d.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.image.*;

public class FaceDrawDebug extends IMenu{
	private Animation cardimg;
	public FaceDrawDebug(int width_px, int height_px){
		super(width_px,height_px);

		int HEIGHT=250, WIDTH;
		Card2DAnimationFactory af = new Card2DAnimationFactory(HEIGHT);
		WIDTH=af.getCardWidth();
		af.setSpacing(10,10);
		af.setSuitSize(50,70);
		af.setFaceSize(50,70);

		af.setBG(af.genCardBorder(WIDTH,HEIGHT,(int)(0.05*WIDTH)));
		af.setBackBG(af.genCardBorder(WIDTH,HEIGHT,(int)(0.05*WIDTH)));

		af.setFaces();
		af.setSuits();
		af.setCards();

		cardimg=af.genCard2D('K','H');
		repaint();
	}

	@Override
	public void paintComponent(Graphics p){
		super.paintComponent(p);
		p.drawImage((BufferedImage)cardimg,0,0,null);
	}
}