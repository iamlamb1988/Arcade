package animation;

import resources.ImgFetcher;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class SingleImage extends BufferedImage implements Animation{
	private Graphics2D p;
	private ImgFetcher iF;

	public SingleImage(
		int width_px, int height_px,
		int R, int G, int B, int A
	){
		super(width_px,height_px,BufferedImage.TYPE_INT_ARGB);
		p=(Graphics2D)this.createGraphics();
		iF=new ImgFetcher();

		int tmpC = new Color(R,G,B,A).getRGB();

		for(int x=0;x<width_px;++x){
			for(int y=0;y<height_px;++y){
				setRGB(x,y,tmpC);
			}
		}
	}

	public SingleImage(int width_px, int height_px, Image img){
		super(width_px,height_px,BufferedImage.TYPE_INT_ARGB);
		p=(Graphics2D)this.createGraphics();
		iF=new ImgFetcher();

		while(!p.drawImage(img,0,0,null)){}
	}

	//Animation Overrides
	@Override
	public void drawTopLeft(Graphics paintBrush){paintBrush.drawImage(this,0,0,null);}

	@Override
	public void draw(int xPos, int yPos, Graphics paintBrush){paintBrush.drawImage(this,xPos,yPos,null);}
}