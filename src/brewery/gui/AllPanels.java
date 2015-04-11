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
	private static DisplayTemperaturePanel displayTemperaturePanel;
	private static SignInPanel signInPanel;
	private static MainProfilePanel userMainProfilePanel;
	private static WelcomePanel welcomePanel;
	
	//quickStart Panel
	private static brewery.gui.quickStart.InProcessPanel inProcessPanel;
	private static brewery.gui.quickStart.InputStepsPanel inputStepsPanel;
	private static brewery.gui.quickStart.ReviewInputStepsPanel reviewInputStepsPanel;
	
	//Graphs Panel
	private static brewery.gui.graphs.GraphsPanel graphsPanel;
	

	public AllPanels(MainFrame mainFrame) throws IOException{
		
		//create variables for each panel
		frame = mainFrame;
		
		createNewUserPanel = new CreateNewUserPanel(frame, this);
		
		displayTemperaturePanel = new DisplayTemperaturePanel(frame, this);
	
		signInPanel = new SignInPanel(frame, this);
		
		userMainProfilePanel = new MainProfilePanel(frame, this);
		
		welcomePanel = new WelcomePanel(frame, this);
		
		//Quick Start Panels
		
		inProcessPanel = new brewery.gui.quickStart.InProcessPanel(frame, this);
		
		inputStepsPanel = new brewery.gui.quickStart.InputStepsPanel(frame, this);
		
		reviewInputStepsPanel = new brewery.gui.quickStart.ReviewInputStepsPanel(frame, this);
		
		//graphs panel
		
		graphsPanel = new brewery.gui.graphs.GraphsPanel(frame, this);
		
		
	}
	
	//allows anyone get any panel they need at that instance
	public CreateNewUserPanel getCreateNewUserPanel() {
		return createNewUserPanel;
	}

	public DisplayTemperaturePanel getDisplayTemperaturePanel() {
		return displayTemperaturePanel;
	}

	public SignInPanel getSignInPanel() {
		return signInPanel;
	}


	public MainProfilePanel getUserMainProfilePanel() {
		return userMainProfilePanel;
	}


	public WelcomePanel getWelcomePanel() {
		return welcomePanel;
	}
	
	//Quick start panels

	public brewery.gui.quickStart.InProcessPanel getInProcessPanel() {
		return inProcessPanel;
	}

	public brewery.gui.quickStart.InputStepsPanel getInputStepsPanel() {
		return inputStepsPanel;
	}

	public brewery.gui.quickStart.ReviewInputStepsPanel getReviewInputStepsPanel() {
		return reviewInputStepsPanel;
	}

	//graphs panel
	public brewery.gui.graphs.GraphsPanel getGraphsPanel() {
		return graphsPanel;
	}
	

}
