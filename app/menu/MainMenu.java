package app.menu;

import app.PanelSwapAction;
import app.DesktopApp;
import app.debug.ShoeTest;
import app.debug.TableTest;
import app.menu.gamemenu.GameMenu;
import app.release.sandbox.shoecycle.ShoeCycle;
import animation.Animation;
import animation.SingleImage;
import app.DesktopApp;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends IMenu{
	private MainMenu self;
	private DesktopApp parent;
	private Animation bg;
	public MainMenu(DesktopApp parentApp, int width_px, int height_px){
		super(width_px,height_px);
		self=this;
		parent=parentApp;
		setBG(new SingleImage(width_px,height_px,255,0,0,255));

		//Add Test Shoe button (WILL BE DESTROYED SOON)
		JButton sbs = new JButton("Shoe Tester");
		sbs.setLocation(10,10);
		sbs.setSize(150,40);
		sbs.addActionListener(new PanelSwapAction(parent,this,new ShoeTest(parent,this,width_px,height_px)));
		add(sbs);

		//Add Table Test (WILL BE DESTROYED SOON)
		JButton sbt = new JButton("Table Tester");
		sbt.setLocation(10,60);
		sbt.setSize(150,40);
		sbt.addActionListener(new PanelSwapAction(parent,this,new TableTest(parent,this,width_px,height_px)));
		add(sbt);

		//Add Shoe Cycle instance
		JButton shoeCyc = new JButton("Shoe Cycle");
		shoeCyc.setLocation(10,110);
		shoeCyc.setSize(150,40);
		shoeCyc.addActionListener(new PanelSwapAction(parent,this,new ShoeCycle(parent,this,width_px,height_px)));
		add(shoeCyc);

		setVisible(true);
	}

	//IAppItem Overrides:
	@Override
	public double getX2D(){return 0;} //This will always return 0 as a main menu

	@Override
	public double getY2D(){return 0;} //This will always return 0 as a main menu

	@Override
	public void setBG(Animation Background){bg=Background;}


	//Drawable2D Overrides:
	@Override
	public void dwblDrawTL(Graphics brush){
		bg.drawTopLeft(brush);
		//draw all attached components
	}

	@Override
	public void dwblDraw(Graphics brush, int xPos_px, int yPos_px){
		bg.draw(xPos_px,yPos_px,brush);
		//draw all attached components
	}

	//Paint Override
	@Override
	public void paintComponent(Graphics p){
		super.paintComponent(p);
		dwblDrawTL(p);
	}
}