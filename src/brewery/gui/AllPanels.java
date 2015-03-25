package brewery.gui;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AllPanels extends JPanel {
	
	/*
	 * This class is responsible for initialing all the panels to be used anywhere in the project
	 */

	private static final long serialVersionUID = 1L;
	
	//Initializes all panels and frames
	private static MainFrame frame;
	private static CreateNewUserPanel createNewUserPanel;
	private static SignInPanel signInPanel;
	private static UserMainProfilePanel userMainProfilePanel;
	private static WelcomePanel welcomePanel;


	public AllPanels(MainFrame mainFrame) throws IOException{
		
		//create variables for each panel
		frame = mainFrame;
		
		createNewUserPanel = new CreateNewUserPanel(frame, this);
	
		signInPanel = new SignInPanel(frame, this);
		
		userMainProfilePanel = new UserMainProfilePanel(frame, this);
		
		welcomePanel = new WelcomePanel(frame, this);
		
	}
	
	//allows anyone get any panel they need at that instance
	public CreateNewUserPanel getCreateNewUserPanel() {
		return createNewUserPanel;
	}


	public SignInPanel getSignInPanel() {
		return signInPanel;
	}


	public UserMainProfilePanel getUserMainProfilePanel() {
		return userMainProfilePanel;
	}


	public WelcomePanel getWelcomePanel() {
		return welcomePanel;
	}


}
