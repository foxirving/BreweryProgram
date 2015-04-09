package brewery.gui.quickStart;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import brewery.gui.AllPanels;
import brewery.gui.GuiFactory;
import brewery.gui.MainFrame;

public class InputStepsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static MainFrame frame;
	private static AllPanels panels;

	public InputStepsPanel(MainFrame mainFrame, AllPanels allPanels) {

		// initialize man frame and all the panels
		frame = mainFrame;
		panels = allPanels;

		// defines the panel dimensions
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(800, 480));
		setBackground(new Color(230, 180, 140));
		// card layout is very important when adding the panels to the main
		// frame
		setLayout(new CardLayout(0, 0));

		// add all buttons, labels, etc., to this JPanel(container)
		JPanel container = new JPanel();
		container.setBackground(new Color(204, 153, 102));
		add(container, "containerOne");
		container.setLayout(null);

		GuiFactory.newLabel("Input Steps Panel", container, 200, 200);

		GuiFactory.addButton(getParent(), "next", container, 400, 50,
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						panels.getInputStepsPanel().setVisible(false);
						panels.getReviewInputStepsPanel().setVisible(true);

					}
				});

	}

}
