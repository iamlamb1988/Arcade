package app.menu;

import animation.*;
import app.debug.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JPanel implements IMenu{
	private MainMenu self;
	private Animation bg;
	public MainMenu(int width_px, int height_px){
		super();
		self=this;
		setSize(width_px,height_px);
		setLayout(null);
		setBG(new SingleImage(width_px,height_px,255,0,0,255));

		//Add Test Shoe button
		JButton sbs = new JButton("Shoe Tester");
		sbs.setLocation(10,10);
		sbs.setSize(150,40);
		sbs.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println("NEXT: Swat this Menu with the field Panel!!!");
				// JPanel Par = (JPanel)self.getParent();
				// Par.remove(self);
				// Par.add(new ShoeTest(width_px,height_px));
			}
		});
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