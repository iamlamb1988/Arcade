package app.srcfactory;

import java.awt.Toolkit;
import resources.*; //all resources
import java.awt.Image;

//The purpose of this class is to build and load images.
public class ImgFetcher{ //only fetches hard saved images, does not generate.
	private Toolkit tk;
	// List of images on this line

	public ImgFetcher(){
		tk=Toolkit.getDefaultToolkit();
	}

	public destruct(){ //set all references to null;
		tk=null;
	}

	public Image getShoeImage(){
		Image R=tk.getImage(getClass().getResource("Deck.png"));
		while(R.getWidth(null)<0 || R.getHeight(null)<0){} //wait to finish..
		return R;
	}
}