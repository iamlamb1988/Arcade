package app.menu;

import animation.*;
import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel implements IMenu{
	private Animation bg;
	public MainMenu(int width_px, int height_px){
		super();
		setSize(width_px,height_px);
		setLayout(null);
		setBG(new SingleImage(width_px,height_px,255,0,0,255));

		//Add Test Shoe button
		JButton sbs = new JButton("Shoe Tester");
		sbs.setLocation(10,10);
		sbs.setSize(150,40);
		add(sbs);

		setVisible(true);
	}

	//IAppItem Overrides:
	@Override
	public void setBG(Animation Background){bg=Background;}

	//Paint Override
	@Override
	public void paintComponent(Graphics p){
		bg.drawTopLeft(p);
	}
}