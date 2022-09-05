package app.srcfactory.card2d;

import app.srcfactory.AnimationFactory;
import animation.Animation;
import animation.SingleImage;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics2D;

//This class preserves Card Images
public class Card2DAnimationFactory extends AnimationFactory{
	//Ratios for Standard Card (3.5" x 2.5")
	private final byte LEN_RATIO;
	private final byte WDT_RATIO;

	private Animation bg;
	private Animation BackBG;

	private Animation ACE;

	private boolean isUpSeparate; //Are the bg and BGborder separate?

	public Card2DAnimationFactory(){
		super();
		LEN_RATIO=(byte)7;
		WDT_RATIO=(byte)5;
		isUpSeparate=false;
	}

	public boolean isBG_Set(){return bg!=null;}
	public boolean isBackGB_Set(){return BackBG!=null;}

	public void setBG(BufferedImage newBG){
		BufferedImage R = new BufferedImage(newBG.getWidth(),newBG.getHeight(),BufferedImage.TYPE_INT_ARGB);
		Graphics2D P = R.createGraphics();
		while(!P.drawImage(newBG,0,0,null)){}
		bg=new SingleImage(R);
	}

	

	//Should this function move to Card2DAnimationFactory?
	public SingleImage genCardImage2D(char face, char suit,
		int width_px, int height_px,
		int borderThickness_px){
		BufferedImage R = new BufferedImage(width_px,height_px,BufferedImage.TYPE_INT_ARGB);
		Graphics2D P = (Graphics2D)R.createGraphics();

		//Draw white backrground
		P.setColor(new Color(255,255,255,255));
		P.fillRect(0,0,width_px,height_px);

		//Draw Blue Border
		P.setColor(new Color(0,255,255,255)); //cyan
		P.fillRect(0,0,borderThickness_px,height_px); //Left
		P.fillRect(width_px-borderThickness_px,0,borderThickness_px,height_px); //Right
		P.fillRect(0,0,width_px,borderThickness_px); //Top
		P.fillRect(0,height_px-borderThickness_px,width_px,borderThickness_px); //Bottom

		//next?
		return new SingleImage(R);
	}
}