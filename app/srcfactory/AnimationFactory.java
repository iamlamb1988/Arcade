package app.srcfactory;

import resources.ImgFetcher;
import animation.Animation;
import animation.SingleImage;

public class AnimationFactory{
	private ImgFetcher iF;
	private AnimationFactory aF;
	public AnimationFactory(){
		iF=new ImgFetcher();
		aF=new AnimationFactory();
	}

	public SingleImage genShoeImage(int width_px, int height_px){
		return aF.genShoeImage(width_px,height_px);
	}
}