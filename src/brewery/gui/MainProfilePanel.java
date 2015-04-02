package brewery.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import brewery.datamodel.Profile;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainProfilePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private static MainFrame frame;
	private static AllPanels panels;
	private Profile currentProfile;

	public MainProfilePanel(MainFrame mainFrame, AllPanels allPanels) throws IOException {

		// initialize panels
		frame = mainFrame;
		panels = allPanels;

		// defines the panel dimensions
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(800, 480));
		setBackground(new Color(210, 180, 140));
		setLayout(new CardLayout(0, 0));

		//add all buttons, labels, etc., to this JPanel(container)
		JPanel container = new JPanel();
		container.setBackground(new Color(204, 153, 102));
		add(container, "containerOne");
		container.setLayout(null);
		JPanel contentPane = new JPanel(null);
		contentPane.setPreferredSize(new Dimension(500, 400));
		container.add(contentPane);

		//log out button
		GuiFactory.addButton(getParent(), "log out", container, 0, 50,
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						panels.getUserMainProfilePanel().setVisible(false);
						panels.getSignInPanel().setVisible(true);

					}
				});
		
		GuiFactory.addButton(getParent(), "Quick Start", container, 400, 50,
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						panels.getUserMainProfilePanel().setVisible(false);
						panels.getDisplayTemperaturePanel().setVisible(true);

					}
				});

		//creates the top bar
		GuiFactory.topToolBar(container);

	}// end UserMainProfile()
}// end UserMainProfile class
