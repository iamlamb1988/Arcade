package app.menu;

import app.PanelSwapAction;
import app.DesktopApp;
import app.menu.gamemenu.GameMenu;
import app.release.sandbox.shoecycle.ShoeCycle;
import app.release.sandbox.tablecycle.TableCycle;
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

		//Add ShoeCycle instance
		JButton shoeCyc = new JButton("Shoe Cycle");
		shoeCyc.setLocation(10,10);
		shoeCyc.setSize(150,40);
		shoeCyc.addActionListener(new PanelSwapAction(parent,this,new ShoeCycle(parent,this,width_px,height_px)));
		add(shoeCyc);

		//Add TableCycle instance
		JButton tableCyc = new JButton("Table Cycle");
		tableCyc.setLocation(10,shoeCyc.getY()+shoeCyc.getHeight()+10);
		tableCyc.setSize(150,40);
		tableCyc.addActionListener(new PanelSwapAction(parent,this,new TableCycle(parent,this,width_px,height_px)));
		add(tableCyc);
		setVisible(true);
	}
}