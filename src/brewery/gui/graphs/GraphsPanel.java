package brewery.gui.graphs;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import brewery.datamodel.ButtonAdder;
import brewery.datamodel.FileIO;
import brewery.datamodel.Profile;
import brewery.datamodel.Profile;
import brewery.gui.AllPanels;
import brewery.gui.GuiFactory;
import brewery.gui.MainFrame;

public class GraphsPanel extends JPanel{
	

	private static final long serialVersionUID = 1L;

	private static MainFrame frame;
	private static AllPanels panels;
	private Profile profile;

	public GraphsPanel(MainFrame mainFrame, AllPanels allPanels) throws IOException {

		// initialize panels
		frame = mainFrame;
		panels = allPanels;
		profile = new Profile();

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
		
		
		GuiFactory.addButtonStyleTwo(frame, "Back", container, 0, 0,
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						panels.getGraphsPanel().setVisible(false);
						panels.getUserMainProfilePanel().setVisible(true);

					}
				});

	
		// adds text field
		
		GuiFactory.newLabel("Graph Panel", container, 200, 200);
		
		
	}//end graph panel


}
