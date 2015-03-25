package brewery.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JTextField;

import brewery.datamodel.ButtonAdder;
import brewery.datamodel.FileIO;
import brewery.datamodel.Profile;

import java.awt.CardLayout;

public class CreateNewUserPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private static MainFrame frame;
	private static AllPanels panels;
	private static Profile profile;

	// private static JTextField txtField;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldUsername;
	private JTextField textFieldEmail;
	private JTextField textFieldPassword;
	private JTextField textFieldPasswordAgain;
	private JPanel container;

	public CreateNewUserPanel(MainFrame mainFrame, AllPanels allPanels)
			throws IOException {

		// initialize panels
		frame = mainFrame;
		panels = allPanels;

		// defines the panel dimensions
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(800, 480));
		setBackground(new Color(210, 180, 140));
		setVisible(false);
		setLayout(new CardLayout(0, 0));

		//add all buttons, labels, etc., to this JPanel(container)
		container = new JPanel();
		container.setSize(new Dimension(800, 480));
		container.setBackground(new Color(204, 153, 102));
		add(container, "name_57873481318249");
		container.setLayout(null);

		//back button
		GuiFactory.addButton(frame, "back", container, 0, 350,
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						panels.getCreateNewUserPanel().setVisible(false);
						panels.getSignInPanel().setVisible(true);

					}
				});

		// saves data the user input
		GuiFactory.addButton(frame, "Create", container, 400, 350,
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						//test to see if the user has a left any text fields blank
						if (textFieldFirstName.getText().equals("")) {

							//error message
							GuiFactory.errorMessage(textFieldFirstName, container, 175, 65);
						
						if (textFieldLastName.getText().equals("")) {

							GuiFactory.errorMessage(textFieldFirstName, container, 575, 65);
							
						}
						if (textFieldUsername.getText().equals("")) {

							GuiFactory.errorMessage(textFieldFirstName, container, 175, 150);
							
						}
						if (textFieldEmail.getText().equals("")) {

							GuiFactory.errorMessage(textFieldFirstName, container, 575, 150);
							
						}
						if (textFieldPassword.getText().equals("")) {

							GuiFactory.errorMessage(textFieldFirstName, container, 450, 225);
							
						}
						if (textFieldPasswordAgain.getText().equals("")) {

							GuiFactory.errorMessage(textFieldFirstName, container, 450, 275);
							
						}

						//if the user input all needed data, the program then saves the data
						} else {
							//gets each String from each text field
							String textFieldFirstNameValue = textFieldFirstName
									.getText();
							String textFieldLastNameValue = textFieldLastName
									.getText();
							String textFieldUsernameValue = textFieldUsername
									.getText();
							String textFieldEmailValue = textFieldEmail
									.getText();
							String textFieldPasswordValue = textFieldPassword
									.getText();

							//passes it though the profile class
							profile = new Profile(textFieldFirstNameValue,
									textFieldLastNameValue,
									textFieldUsernameValue,
									textFieldEmailValue, textFieldPasswordValue);
							
							//passes it through the FileIO class to be serialized
							FileIO.saveProfile(profile);

							//clears text fields
							textFieldFirstName.setText("");
							textFieldLastName.setText("");
							textFieldUsername.setText("");
							textFieldEmail.setText("");
							textFieldPassword.setText("");
							textFieldPasswordAgain.setText("");
							
							//removes all buttons from the sign in panel, then adds them again
							//this is to update the button list with the new profile the user just created
							ButtonAdder.removeNewUserButton(frame, panels, panels.getSignInPanel().getColumnPanel());
							ButtonAdder.addNewUserButton(frame, panels, panels.getSignInPanel().getColumnPanel());
							
							//adds "+ new user" button after the other buttons have been updated
							GuiFactory.addButton(frame, "+ new user", panels.getSignInPanel().getColumnPanel(), 200, 250,
									new ActionListener() {

										@Override
										public void actionPerformed(ActionEvent e) {

											// moves the program from one panel to the next
											panels.getSignInPanel().setVisible(false);
											panels.getCreateNewUserPanel().setVisible(true);

										}
									});
					
							//moves to the sign in panel
							panels.getCreateNewUserPanel().setVisible(false);
							panels.getSignInPanel();
							panels.getSignInPanel().setVisible(true);

						}// end else
					}
				});

		//text fields
		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(175, 25, 200, 40);
		container.add(textFieldFirstName);
		textFieldFirstName.setColumns(10);

		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(575, 25, 200, 40);
		container.add(textFieldLastName);
		textFieldLastName.setColumns(10);

		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(175, 100, 200, 40);
		container.add(textFieldUsername);
		textFieldUsername.setColumns(10);

		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(575, 100, 200, 40);
		container.add(textFieldEmail);
		textFieldEmail.setColumns(10);

		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(225, 225, 200, 40);
		container.add(textFieldPassword);
		textFieldPassword.setColumns(10);

		textFieldPasswordAgain = new JTextField();
		textFieldPasswordAgain.setBounds(225, 275, 200, 40);
		container.add(textFieldPasswordAgain);
		textFieldPasswordAgain.setColumns(10);

		// Labels
		GuiFactory.newLabel("First Name", container, 50, 25);
		GuiFactory.newLabel("Last Name", container, 450, 25);
		GuiFactory.newLabel("Username", container, 50, 100);
		GuiFactory.newLabel("E-mail", container, 450, 100);

		GuiFactory.newLabel("Passoword protected: y/n ", container, 50, 175);

		GuiFactory.newLabel("Password", container, 50, 225);
		GuiFactory.newLabel("Re-type Password", container, 50, 275);

	}// end CreateNewUse()
}// end CreateNewUser class
