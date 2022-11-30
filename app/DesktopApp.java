package app;

import app.menu.MainMenu;
import javax.swing.JFrame;

public class DesktopApp extends JFrame{
	public DesktopApp(int width_px, int height_px){
		super();
		setLayout(null);
		setSize(width_px,height_px);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MainMenu tmpM = new MainMenu(this,width_px-16,height_px-39);
		add(tmpM);
		setVisible(true);
	}
}