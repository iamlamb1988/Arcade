package resources;

import java.awt.Toolkit;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

//The purpose of this class is to build and load images.
public class ImgFetcher{ //only fetches hard saved images, does not generate.
	private Toolkit tk;
	// List of images on this line

	public void ImgFetcher(){
		tk=Toolkit.getDefaultToolkit();
	}

	public void destruct(){ //set all references to null;
		tk=null;
	}

	private Image genShoeImage(){
		Image R=tk.getImage(getClass().getResource("Deck.png"));
		while(R.getWidth(null)<0 || R.getHeight(null)<0){} //wait to finish..
		return R;
	}

	public BufferedImage genShoeImage(int width_px, int height_px){
		Image org=genShoeImage();
		BufferedImage R=new BufferedImage(width_px,height_px,BufferedImage.TYPE_INT_ARGB);
		Graphics2D P = (Graphics2D)R.getGraphics();
		AffineTransform T=new AffineTransform();
		T.scale((double)R.getWidth()/width_px,(double)R.getHeight()/height_px);
		while(!P.drawImage(org,T,null)){}//idempotent function.. wait to finish
		return R;
	}
}