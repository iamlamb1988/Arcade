package animation;

import java.awt.*;
import java.awt.image.*;

public class SingleImage extends BufferedImage implements Animation{
	private Graphics2D p;

	public SingleImage(
		int width_px, int height_px,
		int R, int G, int B, int A
	){
		super(width_px,height_px,BufferedImage.TYPE_INT_ARGB);
		p=this.createGraphics();

		int tmpC = new Color(R,G,B,A).getRGB();

		for(int x=0;x<width_px;++x){
			for(int y=0;y<height_px;++y){
				setRGB(x,y,tmpC);
			}
		}
	}
	
	public void drawTopLeft(Graphics paintBrush){paintBrush.drawImage(this,0,0,null);}
}