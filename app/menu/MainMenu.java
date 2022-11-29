package app.menu;

import app.PanelSwapAction;
import app.DesktopApp;
import app.release.sandbox.shoecycle.ShoeCycle;
import app.release.sandbox.shoecycle.SeatCycle;
import app.release.sandbox.tablecycle.TableCycle;
import resources.ImgFetcher;
import animation.SingleImage;
import javax.swing.JButton;

public class MainMenu extends IMenu{
	private DesktopApp parent;

	public MainMenu(DesktopApp parentApp, int width_px, int height_px){
		super(width_px,height_px);
		parent=parentApp;
		setBG(new SingleImage(new ImgFetcher().genAPaintImage(width_px,height_px)));

		//Add ShoeCycle instance
		JButton shoeCyc = new JButton("Shoe Cycle");
		shoeCyc.setLocation(10,10);
		shoeCyc.setSize(150,40);
		shoeCyc.addActionListener(new PanelSwapAction(parent,this,new ShoeCycle(parent,this,width_px,height_px)));
		add(shoeCyc);

		//Add SeatCycle instance
		JButton seatCyc = new JButton("Seat Cycle");
		seatCyc.setLocation(10,shoeCyc.getY()+shoeCyc.getHeight()+10);
		seatCyc.setSize(150,40);
		seatCyc.addActionListener(new PanelSwapAction(parent,this,new SeatCycle(parent,this,width_px,height_px)));
		add(seatCyc);

		//Add TableCycle instance
		JButton tableCyc = new JButton("Table Cycle");
		tableCyc.setLocation(10,seatCyc.getY()+seatCyc.getHeight()+10);
		tableCyc.setSize(150,40);
		tableCyc.addActionListener(new PanelSwapAction(parent,this,new TableCycle(parent,this,width_px,height_px)));
		add(tableCyc);
		setVisible(true);
	}
}