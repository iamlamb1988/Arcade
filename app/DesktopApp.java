package app;

import app.menu.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class DesktopApp extends JFrame{
	//private ArrayList<IAppItem> list; //potential list of IAppItems
	public DesktopApp(int width_px, int height_px){
		super();
		setSize(width_px,height_px);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MainMenu tmpM = new MainMenu(this,width_px,height_px);
		list.add(tmpM);
		add(tmpM);
		setVisible(true);
	}

	public static ActionListener genPanelSwapAction(
		JFrame appFrame,
		JPanel source,
		JPanel destination
	){
		return genPanelSwapAction(appFrame,source,destination);
	}

	private class PanelSwapAction implements ActionListener{
		private final JFrame parentFrame;
		private final JPanel src;
		private final JPanel dst;

		private PanelSwapAction(
			JFrame appFrame,
			JPanel source,
			JPanel destination
		){
			parentFrame=appFrame;
			src=source;
			dst=destination;
		}

		@Override
		public void actionPerformed(ActionEvent e){
			parentFrame.remove(src);
			parentFrame.add(dst);
		}
	}
}