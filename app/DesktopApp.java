package app;

import app.menu.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DesktopApp extends JFrame{
	public DesktopApp(int width_px, int height_px){
		super();
		setSize(width_px,height_px);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MainMenu tmpM = new MainMenu(this,width_px,height_px);
		add(tmpM);
		setVisible(true);
	}
}