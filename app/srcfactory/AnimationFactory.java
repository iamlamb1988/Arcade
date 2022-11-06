package app.srcfactory;

import resources.ImgFetcher;
import animation.SingleImage;

//Should this be an interface instead of a class? (Probably..)
public class AnimationFactory{ //Set to builder pattern?
	private ImgFetcher iF;

	public AnimationFactory(){iF=new ImgFetcher();}

	public SingleImage genShoeImage(int width_px, int height_px){
		return new SingleImage(iF.genShoeImage(width_px,height_px));
	}
}