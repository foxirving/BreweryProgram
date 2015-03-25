package brewery.gui;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import brewery.datamodel.FileIO;

public class MainFrame extends JPanel {

	private static final long serialVersionUID = 1L;
	
	//Initializes the main frame and all the panels in the GUI
	private static JFrame frame;
	static AllPanels allPanels;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					MainFrame.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws IOException
	 */
	public MainFrame() throws IOException {
		initialize();

		//AllPanels class is used to initialize all the panels and uses a getter to allow anyone to get these panels
		allPanels = new AllPanels(this);

		//add each panel to the frame
		//Do NOT edit the order that theses panels are added to the frame.
		frame.getContentPane().add(allPanels.getWelcomePanel());
		allPanels.getWelcomePanel().setVisible(true);

		frame.getContentPane().add(allPanels.getSignInPanel());
		allPanels.getSignInPanel().setVisible(false);

		frame.getContentPane().add(allPanels.getCreateNewUserPanel());
		allPanels.getCreateNewUserPanel().setVisible(false);

		frame.getContentPane().add(allPanels.getUserMainProfilePanel());
		allPanels.getUserMainProfilePanel().setVisible(false);
		

	}// end MainFrame()

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new CardLayout(0, 0));
	}

	public Container getContentPane() {
		// TODO Auto-generated method stub
		return frame;
	}

}// end MainFrame class
