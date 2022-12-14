package resources;

import java.awt.Toolkit;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

//The purpose of this class is to build and load images.
public class ImgFetcher{ //Should resources be within app folder?
	protected Image genFileImage(String PathName){
		Image R=Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(PathName));
		while(R.getWidth(null)<0 || R.getHeight(null)<0){} //wait to finish..
		return R;
	}

	protected BufferedImage genFileImage(String pathName, int width_px, int height_px){
		 Image org=genFileImage(pathName);
		 BufferedImage R=new BufferedImage(width_px,height_px,BufferedImage.TYPE_INT_ARGB);
		 Graphics2D P = (Graphics2D)R.getGraphics();
		 AffineTransform T=new AffineTransform();
		 T.scale((double)width_px/org.getWidth(null),(double)height_px/org.getHeight(null));
		 while(!P.drawImage(org,T,null)){}//idempotent function.. wait to finish
		 return R;
	}

	public BufferedImage genShoeImage(int width_px, int height_px){
		return genFileImage("Deck.png",width_px,height_px);
	}

	public BufferedImage genAPaintImage(int width_px, int height_px){
		return genFileImage("Apaint.png",width_px,height_px);
	}
}