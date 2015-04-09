package brewery.datamodel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import brewery.gui.AllPanels;
import brewery.gui.GuiFactory;
import brewery.gui.MainFrame;
import brewery.temperatureDataModel.RxTxComm;

public class ButtonAdder {

	private static MainFrame frame;
	private static AllPanels panels;
	private static Profile profile;

	private static Profile instance;

	private ButtonAdder() {

	}

	public static Profile getInstance() {
		if (instance == null) {
			instance = new Profile();
		}
		return instance;
	}

	// adds a new button for every serialized file that exists in the profile
	// folder
	public static void addNewUserButton(MainFrame mainFrame,
			AllPanels allPanels, JPanel currentPanel) {

		// initialize panels
		frame = mainFrame;
		panels = allPanels;
		profile = new Profile();

		for (int i = 0; i < Profile.readProfileFolder().length; i++) {
			if (Profile.readProfileFolder()[i].isFile()) {

				String username = Profile.readProfileFolder()[i].getName();

				// adds button with that user name
				addUserButton(frame, username, currentPanel,
						new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {

								String name = getInstance().getCurrentProfile();
								name = username;
								//System.out.println(name);

								panels.getSignInPanel().setVisible(false);
								panels.getUserMainProfilePanel().setVisible(
										true);

							}
						});
			}// end if
			else {
			}

		}// end for
	}// end addNewUserButton method

	// Method that adds a new button, used by the AddNewUSerButton method
	public static void addUserButton(Component frameToAddTo, String buttonName,
			JPanel currentPanel, ActionListener newAction) {

		{// button instance

			// creates new button
			JButton newButtonHandle = new JButton(buttonName);
			newButtonHandle.addActionListener(newAction);
			newButtonHandle.setBounds(15, 0, 400, 105);
			newButtonHandle.setForeground(new Color(51, 0, 0));
			newButtonHandle.setBackground(new Color(255, 102, 153));
			newButtonHandle.setFont(new Font("DejaVu Serif Condensed",
					Font.PLAIN, 47));
			Border emptyBorder = BorderFactory.createEmptyBorder();
			newButtonHandle.setBorder(emptyBorder);
			newButtonHandle.setLayout(null);
			currentPanel.add(newButtonHandle);
			newButtonHandle.setVisible(true);

		}// end button instance

	}// end AddButton()

	// removes all buttons from a list
	public static void removeNewUserButton(MainFrame mainFrame,
			AllPanels allPanels, JPanel currentPanel) {

		// initialize panels
		frame = mainFrame;
		panels = allPanels;

		// looks through a specified panel and removes all button components
		// example use of this method found in CreateNewUserPanel class
		Component[] comps = currentPanel.getComponents();
		for (int i = 0; i < comps.length; i++) {

			if (comps[i] instanceof JButton) {
				currentPanel.remove(comps[i]);
			}
		}// end for

	}// end removeNewUserButton
}// end class
