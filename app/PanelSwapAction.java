package app;

import javax.swing.*;
import java.awt.event.*;

public class PanelSwapAction implements ActionListener{
		private final DesktopApp parentFrame;
		private final JPanel src;
		private final JPanel dst;

		public PanelSwapAction(
			DesktopApp appFrame,
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
			parentFrame.repaint();
		}
	}