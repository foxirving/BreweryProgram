package brewery.gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.CardLayout;

import javax.swing.JButton;

import java.awt.GridLayout;

/*
 * This is the welcome page when the user boots up the GUI
 */

public class WelcomePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static MainFrame frame;
	private static AllPanels panels;

	public WelcomePanel(MainFrame mainFrame, AllPanels allPanels)
			throws IOException {

		// initialize man frame and all the panels
		frame = mainFrame;
		panels = allPanels;

		// defines the panel dimensions
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(800, 480));
		setBackground(new Color(230, 180, 140));
		//card layout is very important when adding the panels to the main frame
		setLayout(new CardLayout(0, 0));

		//add all buttons, labels, etc., to this JPanel(container)
		JPanel container = new JPanel();
		container.setBackground(new Color(104, 53, 102));
		add(container, "containerOne");
		container.setLayout(null);
		
		//Adds welcome image
		//these methods are located in GuiFctory class
		GuiFactory.addImage("welcome.png", container, 175, 42);

		// adds the Start button
		GuiFactory.addButton(frame, "Start", container, 200, 350,
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

					panels.getWelcomePanel().setVisible(false);
					panels.getSignInPanel().setVisible(true);

					}
				});

	}// end WelcomePanel()
}// end class