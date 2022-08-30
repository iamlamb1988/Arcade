package app.debug;

import app.menu.*;
import animation.*;
import javax.swing.*;
import java.awt.*;

public class ShoeTest extends JPanel implements IMenu{
	private Animation bg;
	public ShoeTest(int width_px, int height_px){
		setSize(width_px,height_px);
		setLayout(null);
		setBG(new SingleImage(width_px,height_px,0,255,0,255));
		setVisible(true);
	}

	//IAppItem Overrides:
	public void setBG(Animation Background){}

	//Paint Override
	@Override
	public void paintComponent(Graphics p){
		bg.drawTopLeft(p);
	}
}