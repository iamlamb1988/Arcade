package app.srcfactory;

import resources.ImgFetcher;
import animation.Animation;
import animation.SingleImage;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class AnimationFactory{ //Set to builder pattern?
	private ImgFetcher iF;

	public AnimationFactory(){
		iF=new ImgFetcher();
	}

	public SingleImage genShoeImage(int width_px, int height_px){
		return new SingleImage(iF.genShoeImage(width_px,height_px));
	}

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