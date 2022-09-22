package app.menu;

import app.PanelSwapAction;
import app.DesktopApp;
import app.debug.ShoeTest;
import app.debug.TableTest;
import animation.Animation;
import animation.SingleImage;

import app.DesktopApp;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
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
		sbs.addActionListener(new PanelSwapAction(parent,this,new ShoeTest(parent,this,width_px,height_px)));
		add(sbs);

		//Add Table Test
		JButton sbt = new JButton("Table Tester");
		sbt.setLocation(10,60);
		sbt.setSize(150,40);
		sbt.addActionListener(new PanelSwapAction(parent,this,new TableTest(parent,this,width_px,height_px)));
		sbt.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println("Not yet ready for debugging.");
			}
		});
		add(sbt);
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