package app.srcfactory;

import resources.ImgFetcher;
import animation.Animation;
import animation.SingleImage;

public class AnimationFactory{
	private ImgFetcher iF;

	public AnimationFactory(){
		iF=new ImgFetcher();
	}

	public SingleImage genShoeImage(int width_px, int height_px){
		return new SingleImage(width_px,height_px,iF.genShoeImage(width_px,height_px));
	}
}