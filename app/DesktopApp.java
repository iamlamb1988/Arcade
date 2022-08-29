package app;

import app.menu.*;
import javax.swing.*;

public class DesktopApp extends JFrame{
	public DesktopApp(int width_px, int height_px){
		super();
		setSize(width_px,height_px);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(new MainMenu(width_px,height_px));
		setVisible(true);
	}
}