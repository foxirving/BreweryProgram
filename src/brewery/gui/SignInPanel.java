package brewery.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import java.awt.CardLayout;

import javax.swing.JTextField;

import brewery.datamodel.ButtonAdder;
import brewery.datamodel.FileIO;

public class SignInPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private static MainFrame frame;
	private static AllPanels panels;

	// creates getter for the JPanel/columnPanel to be used in the CreateNewUser
	// class
	private JPanel columnPanel;

	public SignInPanel(MainFrame mainFrame, AllPanels allPanels)
			throws IOException {
		setBackground(Color.PINK);

		// initialize panels
		frame = mainFrame;
		panels = allPanels;

		// defines the panel dimensions
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(800, 480));
		setBackground(new Color(210, 180, 140));
		setLayout(new CardLayout(0, 0));

		// add all buttons, labels, etc., to this JPanel(container)
		JPanel container = new JPanel();
		container.setBackground(new Color(204, 153, 102));
		add(container, "containerOne");
		container.setLayout(null);
		JPanel contentPane = new JPanel(null);
		contentPane.setPreferredSize(new Dimension(500, 400));
		container.add(contentPane);

		// creates a Scroll Pane
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(150, 10, 500, 470);
		scrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		container.add(scrollPane);

		JPanel borderlaoutpanel = new JPanel();
		scrollPane.setViewportView(borderlaoutpanel);
		borderlaoutpanel.setLayout(new BorderLayout(0, 0));

		// this is where all buttons get added to
		columnPanel = new JPanel();
		borderlaoutpanel.add(columnPanel, BorderLayout.NORTH);
		columnPanel.setLayout(new GridLayout(0, 1, 10, 10));
		columnPanel.setBackground(Color.gray);

		// adds button with a profile's username in the button
		// method located in Button Adder class
		ButtonAdder.addNewUserButton(frame, panels, columnPanel);

		// adds button that takes user to the CreateNewUser panel
		GuiFactory.addButton(frame, "+ new user", columnPanel, 200, 250,
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						// moves the program from one panel to the next
						panels.getSignInPanel().setVisible(false);
						panels.getCreateNewUserPanel().setVisible(true);

					}
				});

	}// end SignInPanel()

	public JPanel getColumnPanel() {
		return columnPanel;
	}

}// end SignInPanel class
