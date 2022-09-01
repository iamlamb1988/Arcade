package app.menu;

import app.PanelSwapAction;
import app.DesktopApp;
import app.debug.*;
import animation.Animation;
import animation.SingleImage;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel implements IMenu{
	private MainMenu self;
	private DesktopApp parent;
	private Animation bg;
	public MainMenu(DesktopApp parentApp, int width_px, int height_px){
		super();
		self=this;
		parent=parentApp;
		setSize(width_px,height_px);
		setLayout(null);
		setBG(new SingleImage(width_px,height_px,255,0,0,255));

		//Add Test Shoe button
		JButton sbs = new JButton("Shoe Tester");
		sbs.setLocation(10,10);
		sbs.setSize(150,40);
		sbs.addActionListener(new PanelSwapAction(parent,this,new ShoeTest(width_px,height_px)));
		add(sbs);

		setVisible(true);
	}

	//IAppItem Overrides:
	@Override
	public void setBG(Animation Background){bg=Background;}

	//Paint Override
	@Override
	public void paintComponent(Graphics p){
		super.paintComponent(p);
		bg.drawTopLeft(p);
	}
}