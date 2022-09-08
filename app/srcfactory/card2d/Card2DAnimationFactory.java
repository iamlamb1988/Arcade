package app.srcfactory.card2d;

import app.srcfactory.AnimationFactory;
import animation.Animation;
import animation.SingleImage;
import resources.CardImgFetcher;
import java.lang.Math;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

//This class preserves Card Images
public class Card2DAnimationFactory extends AnimationFactory{
	//Ratios for Standard Card (3.5" x 2.5")
	private final byte LEN_RATIO;
	private final byte WDT_RATIO;
	private final double LEN_TO_WDT_FACTOR;
	private final double WDT_TO_LEN_FACTOR;

	private int actualWidth_px;
	private int actualHeight_px;
	private int actualFaceWidth_px;
	private int actualFaceHeight_px;
	private int actualSuitWidth_px;
	private int actualSuitHeight_px;
	private int actualTopOffset_px;		//spacing from edge to TL of face value
	private int actualSideOffset_px;	//spacing from edge to TL of face value

	private CardImgFetcher cif;

	private Animation bg;
	private Animation BackBG; //Not yet used...

	//Redundant? No because of Animation.
	private Animation[] faceImg;
	private Animation[] suitImg;
	private Animation[] fullImage;
	private boolean isUpSeparate; //Are the bg and BGborder separate?

	private void constructorHelp(){
		isUpSeparate=false;
		faceImg = new Animation[13];
		suitImg = new Animation[4];
		fullImage = new Animation[52];
	}

	public Card2DAnimationFactory(){
		super();
		LEN_RATIO=(byte)7;
		WDT_RATIO=(byte)5;
		LEN_TO_WDT_FACTOR=(double)LEN_RATIO/WDT_RATIO;
		WDT_TO_LEN_FACTOR=(double)WDT_RATIO/LEN_RATIO;

		constructorHelp();
		cif = new CardImgFetcher();
		cif.fetchAll();
	}

	public Card2DAnimationFactory(int width_px, int height_px){
		super();
		LEN_RATIO=(byte)7;
		WDT_RATIO=(byte)5;
		LEN_TO_WDT_FACTOR=(double)LEN_RATIO/WDT_RATIO;
		WDT_TO_LEN_FACTOR=(double)WDT_RATIO/LEN_RATIO;

		constructorHelp();
		cif = new CardImgFetcher();
		cif.fetchAll(width_px,height_px);
		actualWidth_px=width_px;
		actualHeight_px=height_px;
	}

	private byte getFaceIndex(char face){
		if(face=='T') return (byte)8;
		else if(face=='J') return (byte)9;
		else if(face=='Q') return (byte)10;
		else if(face=='K') return (byte)11;
		else if(face=='A') return (byte)12;

		byte value=(byte)(face-'2');
		if(value < 0 || value > 7) return -1;
		else return value;
	}

	private byte getSuitIndex(char suit){
		if(suit=='C') return 0;
		else if(suit=='D') return (byte)1;
		else if(suit=='H') return (byte)2;
		else if(suit=='S') return (byte)3;

		return -1;
	}

	public boolean isBG_Set(){return bg!=null;}
	public boolean isBackGB_Set(){return BackBG!=null;}

	public void setActualSize(int width_px, int height_px){
		actualWidth_px=width_px;
		actualHeight_px=height_px;
	}

	public void setSpacing(int topOffSet_px, int sideOffSet_px){
		actualTopOffset_px=topOffSet_px;
		actualSideOffset_px=sideOffSet_px;
	}

	public void setSuitSize(int width_px, int height_px){
		actualSuitWidth_px=width_px;
		actualSuitHeight_px=height_px;
	}

	public void setFaceSize(int width_px, int height_px){
		actualFaceWidth_px=width_px;
		actualFaceHeight_px=height_px;
	}

	public void setBG(Animation newBG){bg = newBG.clone();}

	public void setFaces(){
		faceImg[0]=new SingleImage(cif.getCardFace('2'),actualFaceWidth_px,actualFaceHeight_px);
		faceImg[1]=new SingleImage(cif.getCardFace('3'),actualFaceWidth_px,actualFaceHeight_px);
		faceImg[2]=new SingleImage(cif.getCardFace('4'),actualFaceWidth_px,actualFaceHeight_px);
		faceImg[3]=new SingleImage(cif.getCardFace('5'),actualFaceWidth_px,actualFaceHeight_px);
		faceImg[4]=new SingleImage(cif.getCardFace('6'),actualFaceWidth_px,actualFaceHeight_px);
		faceImg[5]=new SingleImage(cif.getCardFace('7'),actualFaceWidth_px,actualFaceHeight_px);
		faceImg[6]=new SingleImage(cif.getCardFace('8'),actualFaceWidth_px,actualFaceHeight_px);
		faceImg[7]=new SingleImage(cif.getCardFace('9'),actualFaceWidth_px,actualFaceHeight_px);
		faceImg[8]=new SingleImage(cif.getCardFace('T'),actualFaceWidth_px,actualFaceHeight_px);
		faceImg[9]=new SingleImage(cif.getCardFace('J'),actualFaceWidth_px,actualFaceHeight_px);
		faceImg[10]=new SingleImage(cif.getCardFace('Q'),actualFaceWidth_px,actualFaceHeight_px);
		faceImg[11]=new SingleImage(cif.getCardFace('K'),actualFaceWidth_px,actualFaceHeight_px);
		faceImg[12]=new SingleImage(cif.getCardFace('A'),actualFaceWidth_px,actualFaceHeight_px);
	}
	
	//additional methods/overloads for custom images.

	public void setSuits(){
		suitImg[0]=new SingleImage(cif.getCardSuit('C'),actualSuitWidth_px,actualSuitHeight_px);
		suitImg[1]=new SingleImage(cif.getCardSuit('D'),actualSuitWidth_px,actualSuitHeight_px);
		suitImg[2]=new SingleImage(cif.getCardSuit('H'),actualSuitWidth_px,actualSuitHeight_px);
		suitImg[3]=new SingleImage(cif.getCardSuit('S'),actualSuitWidth_px,actualSuitHeight_px);
	}

	//additional methods/overloads for custom images.

	//Full gen requires all sub images and dimensions set
	public void setCard2D(char face, char suit){
		byte faceIndex=getFaceIndex(face),
			 suitIndex=getSuitIndex(suit),
			 index=(byte)(faceIndex+13*suitIndex);

		BufferedImage R = new BufferedImage(actualWidth_px,actualHeight_px,BufferedImage.TYPE_INT_ARGB),
					  TR = new BufferedImage(actualWidth_px,actualHeight_px/2,BufferedImage.TYPE_INT_ARGB),
					  BR = new BufferedImage(actualWidth_px,actualHeight_px/2,BufferedImage.TYPE_INT_ARGB);

		//Draw Top Half TR -> Top Return BR -> Bottom Return
		Graphics2D P=TR.createGraphics();
		bg.drawTopLeft(P);

		//Draw face
		faceImg[getFaceIndex(face)].draw(actualSideOffset_px,actualTopOffset_px,P);

		//draw suit
		suitImg[getSuitIndex(suit)].draw(actualWidth_px-actualSuitWidth_px-actualSideOffset_px,actualTopOffset_px,P);

		//Prepare rotation of 180 and shift half of height
		AffineTransform T = new AffineTransform();
		T.rotate(Math.PI,BR.getWidth()/2,BR.getHeight()/2);
		P=(Graphics2D)BR.getGraphics();
		while(!P.drawImage(TR,T,null)){}

		//draw to finalized set
		P=R.createGraphics();
		while(!P.drawImage(TR,0,0,null)){}
		while(!P.drawImage(BR,0,TR.getHeight(),null)){}

		//set to standard index value
		fullImage[index] = new SingleImage(R);
	}

	public void setCards(){
		char[] f = new char[13];
		char[] s = new char[4];

		f[0]='2';
		f[1]='3';
		f[2]='4';
		f[3]='5';
		f[4]='6';
		f[5]='7';
		f[6]='8';
		f[7]='9';
		f[8]='T';
		f[9]='J';
		f[10]='Q';
		f[11]='K';
		f[12]='A';

		s[0]='C';
		s[1]='D';
		s[2]='H';
		s[3]='S';

		for(byte si=0;si<s.length;++si){
			for(byte fi=0;fi<f.length;++fi){
				setCard2D(f[fi],s[si]);
			}
		}
	}

	public Animation getCard2D(char face, char suit){
		 return fullImage[getSuitIndex(suit)*13+getFaceIndex(face)].clone();
	}

	//Obsolete
	public SingleImage genCardFace(char face){return new SingleImage(cif.getCardFace(face));}

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