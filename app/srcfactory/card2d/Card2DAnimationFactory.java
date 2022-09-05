package app.srcfactory.card2d;

import app.srcfactory.AnimationFactory;
import java.awt.image.BufferedImage;

//This class preserves Card Images
public class Card2DAnimationFactory extends AnimationFactory{
	private BufferedImage bg;
	private BufferedImage BGborder;
	private BufferedImage BackBG;
	private boolean isUpSeparate; //Are the bg and BGborder separate?

	public Card2DAnimationFactory(){
		super();
		isUpSeparate=false;
	}

	public void mergeBGandBorder(){}

	
}