package brewery.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import brewery.datamodel.ButtonAdder;
import brewery.datamodel.FileIO;
import brewery.datamodel.Profile;
import brewery.datamodel.TextFieldTester;

import java.awt.CardLayout;

public class CreateNewUserPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	static boolean isPasswordProtected = true;
	
	private static JTextField firstName;
	private static JTextField lastName;
	private static JTextField username;
	private static JTextField email;
	private static ArrayList<String> originalText = new ArrayList<String>();

	private static MainFrame frame;
	private static AllPanels panels;

	private JPanel container;
	protected static final Container CenterTextBox = null;
	private static JPanel textFieldContainer;
	private static JPanel JButtonContainerOne;
	private static JPanel JButtonContainerTwo;

	public CreateNewUserPanel(MainFrame mainFrame, AllPanels allPanels)
			throws IOException{

		// initialize panels
		frame = mainFrame;
		panels = allPanels;
	
		
		//boolean isPassword = isPasswordProtected;

		// defines the panel dimensions
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(800, 480));
		setBackground(new Color(210, 180, 140));
		setVisible(false);
		setLayout(new CardLayout(0, 0));

		// add all buttons, labels, etc., to this JPanel(container)
		container = new JPanel();
		container.setSize(new Dimension(800, 480));
		container.setBackground(new Color(204, 153, 102));
		add(container, "name_57873481318249");
		container.setLayout(null);

		textFieldContainer = new JPanel();
		textFieldContainer.setBounds(197, 11, 400, 400);
		container.add(textFieldContainer);
		textFieldContainer.setLayout(null);
		
		JButtonContainerOne = new JPanel();
		JButtonContainerOne.setBounds(0, 350, 200, 50);
		container.add(JButtonContainerOne);
		JButtonContainerOne.setLayout(null);
		
		JButtonContainerTwo = new JPanel();
		JButtonContainerTwo.setBounds(600, 350, 200, 50);
		container.add(JButtonContainerTwo);
		JButtonContainerTwo.setLayout(null);

		GuiFactory.addButtonStyleTwo(frame, "Back", JButtonContainerOne, 0, 0,
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						panels.getCreateNewUserPanel().setVisible(false);
						panels.getSignInPanel().setVisible(true);

					}
				});

	
		// adds text field
		addTextFieldOne(textFieldContainer);
		
		//first "Next" button
		GuiFactory.addButtonStyleTwo(frame, "Next1", JButtonContainerTwo, 0, 0,
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						String textFieldFirstName = firstName.getText();
						String textFieldLastName = lastName.getText();
						String textFieldUsername = username.getText();
						String textFieldEmail = email.getText();
						
						ArrayList<String> inputText = new ArrayList<String>();
						inputText.add(textFieldFirstName);
						inputText.add(textFieldLastName);
						inputText.add(textFieldUsername);
						inputText.add(textFieldEmail);
						
	
						TextFieldTester.textFieldTester(originalText, inputText);
					

						removeTextField(textFieldContainer);
						
						ButtonAdder.removeNewUserButton(frame, panels, JButtonContainerTwo);
						
						addTextFieldTwo(textFieldContainer);
						addTextFieldTwoButtons(textFieldContainer);
						
						//Second "next" button
						GuiFactory.addButtonStyleTwo(frame, "Next2", JButtonContainerTwo, 0, 0,
								new ActionListener() {
							
								
									@Override
									public void actionPerformed(ActionEvent e) {


									


									}
								});
						
						//refreshed panel
						panels.getCreateNewUserPanel().setVisible(false);
						panels.getCreateNewUserPanel().setVisible(true);

					}
	
				});
		

		

	}// end CreateNewUser()

	// tests the text inside the text fields for the correct input
	public static void TestTextField(JPanel CenterTextBox) {
		
		int i = 0;

		// gets the text fields from the CenterTextBox JPanel
		for (Component c : CenterTextBox.getComponents()) {

			
			if (c instanceof JTextField) {

				String inputText = ((JTextField) c).getText();

				if (inputText.equals(" ") || inputText.equals("")) {
					System.out.println("please enter stuff in text field");
				}

				// There is def a better way to write this, but I couldn't
				// figure it out
				if (inputText.equals("First Name")) {
					System.out.println("original text not allowed");
				}
				if (inputText.equals("Last Name")) {
					System.out.println("original text not allowed");
				}
				if (inputText.equals("Username")) {
					System.out.println("original text not allowed");
				}
				if (inputText.equals("E-mail")) {
					System.out.println("original text not allowed");
				}
				if (inputText.equals("Re-enter E-mail")) {
					System.out.println("original text not allowed");
				}
				else{
					i = i + 1;
				}
				

			}// end if
			else {
			}

//			if (i == 5){
//				isIncorrectInput = false;
//				break;
//			}

			
		}// end for
		
		
	}// end TestTextField

	public static void ClearTextBox(JPanel CenterTextBox) {

		for (Component c : CenterTextBox.getComponents()) {

			if (c instanceof JTextField) {
				((JTextField) c).setText("");
			}
		}
	}

	public static void addTextFieldOne(JPanel textcontainer) {

		firstName = new JTextField();
		firstName.setText("First Name");
		firstName.setHorizontalAlignment(SwingConstants.CENTER);
		firstName.setBounds(60, 20, 280, 50);

		firstName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (firstName.getText().equals("First Name")) {
					firstName.setText("");
				}// end if
			}
		});
		
		//adds the original text to a string for TextFieldTester
		originalText.add("First Name");
		
		textcontainer.add(firstName);
		firstName.setColumns(10);

		lastName = new JTextField();
		lastName.setText("Last Name");
		lastName.setHorizontalAlignment(SwingConstants.CENTER);
		lastName.setBounds(60, 80, 280, 50);

		// clears text field when clicked once
		lastName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (lastName.getText().equals("Last Name")) {
					lastName.setText("");
				}// end if
			}
		});

		//adds the original text to a string for TextFieldTester
		originalText.add("Last Name");
		
		textcontainer.add(lastName);
		lastName.setColumns(10);

		username = new JTextField();
		username.setText("Username");
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setBounds(60, 140, 280, 50);

		// clears text field when clicked once
		username.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (username.getText().equals("Username")) {
					username.setText("");
				}// end if
			}
		});

		//adds the original text to a string for TextFieldTester
		originalText.add("Username");
		
		textcontainer.add(username);
		username.setColumns(10);

		email = new JTextField();
		email.setText("E-mail");
		email.setHorizontalAlignment(SwingConstants.CENTER);
		email.setBounds(60, 240, 280, 50);

		// clears text field when clicked once
		email.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (email.getText().equals("E-mail")) {
					email.setText("");
				}// end if
			}
		});

		//adds the original text to a string for TextFieldTester
		originalText.add("E-mail");
		
		textcontainer.add(email);
		email.setColumns(10);

		JTextField reEmail = new JTextField();
		reEmail.setText("Re-enter E-mail");
		reEmail.setHorizontalAlignment(SwingConstants.CENTER);
		reEmail.setBounds(60, 300, 280, 50);

		// clears text field when clicked once
		reEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (reEmail.getText().equals("Re-enter E-mail")) {
					reEmail.setText("");
				}// end if
			}
		});

		//adds the original text to a string for TextFieldTester
		originalText.add("Re-enter E-mail");
		
		textcontainer.add(reEmail);
		reEmail.setColumns(10);

	}

	public static void addTextFieldTwo(JPanel textcontainer){

		
		JTextField passwordQuestion = new JTextField();
		passwordQuestion.setText("Would you like this profile to be password protected?");
		passwordQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		passwordQuestion.setBounds(20, 20, 350, 50);
		textcontainer.add(passwordQuestion);
		passwordQuestion.setColumns(10);
	
	}
		
	public static boolean addTextFieldTwoButtons(JPanel textcontainer){
		JButton noButtom = new JButton("No");
		noButtom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				isPasswordProtected = false;
				
				
			}
		});
		noButtom.setBounds(50, 150, 100, 50);
		textcontainer.add(noButtom);
		
		
		JButton yesButtom = new JButton("Yes");
		yesButtom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				isPasswordProtected = true;
				
			}
		});
		yesButtom.setBounds(150, 150, 100, 50);
		textcontainer.add(yesButtom);
		
		return isPasswordProtected;
		
	}
	
	
	public static void removeTextField(JPanel textcontainer){
		
		Component[] comps = textcontainer.getComponents();
		for (int i = 0; i < comps.length; i++) {

			if (comps[i] instanceof JTextField) {
				textcontainer.remove(comps[i]);
			}
		}// end for
	}
	
}// end class
