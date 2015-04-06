package brewery.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.RootPaneContainer;
import javax.swing.border.Border;

public class GuiFactory extends JPanel {

	/*
	 * This class makes it easy to add new buttons, labels, and images to any
	 * class it need
	 */

	private static final long serialVersionUID = 1L;
	private static MainFrame frame;
	private static AllPanels panels;

	public GuiFactory(MainFrame mainFrame, AllPanels allPanels) {
		// initialize panels
		frame = mainFrame;
		panels = allPanels;
	}

	// adds a new label
	public static void newLabel(String labelName, JPanel currentPanel, int x,
			int y) {
		{
			JTextField txtField = new JTextField();
			txtField.setFont(new Font("DejaVu Serif Condensed", Font.PLAIN, 20));
			Border emptyBorder = BorderFactory.createEmptyBorder();
			txtField.setBackground(new Color(204, 153, 102));
			txtField.setBorder(emptyBorder);
			txtField.setText(labelName);
			txtField.setBounds(x, y, 250, 40);
			txtField.setColumns(10);
			txtField.setEditable(false);
			currentPanel.add(txtField);
		}
	}// end NewLabel()

	// adds a new button
	public static void addButton(Component frameToAddTo, String buttonName,
			JPanel currentPanel, int x, int y, ActionListener newAction) {

		{// button instance

			// creates new button
			JButton newButtonHandle = new JButton(buttonName);
			newButtonHandle.setForeground(new Color(51, 0, 0));
			newButtonHandle.setBackground(new Color(210, 180, 140));
			newButtonHandle.setFont(new Font("DejaVu Serif Condensed",
					Font.PLAIN, 47));
			Border emptyBorder = BorderFactory.createEmptyBorder();
			newButtonHandle.setBorder(emptyBorder);

			newButtonHandle.addActionListener(newAction);
			newButtonHandle.setBounds(x, y, 400, 105);
			newButtonHandle.setLayout(null);
			currentPanel.add(newButtonHandle);
			newButtonHandle.setVisible(true);

		}// end button instance

	}// end AddButton()

	// adds a new image from the "images" folder
	public static void addImage(String imageSource, JPanel currentPanel, int x,
			int y) {

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("images/" + imageSource));
		lblNewLabel.setBounds(x, y, 450, 238);
		currentPanel.add(lblNewLabel);
	}

	// adds a new tool bar at the top on the panel
	public static void topToolBar(JPanel currentPanel) {

		JToolBar toolBar = new JToolBar("toptoolbar");
		toolBar.setBounds(0, 0, 800, 50);
		currentPanel.add(toolBar);

		JButton settingsButton = new JButton("set");
		settingsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		settingsButton.setBounds(750, 0, 50, 50);
		toolBar.add(settingsButton);

	}// end TopToolBar()

	// adds a new error message
	public static void errorMessage(JTextField errorName, JPanel currentPanel,
			int x, int y) {

		errorName = new JTextField();
		errorName.setBounds(x, y, 100, 20);
		errorName.setForeground(Color.RED);
		errorName.setBackground(new Color(204, 153, 102));
		Border emptyBorder = BorderFactory.createEmptyBorder();
		errorName.setBorder(emptyBorder);
		errorName.setText("invalid input");
		errorName.setColumns(10);
		currentPanel.add(errorName);

	}

	public static void addButtonStyleTwo(Component frameToAddTo,
			String buttonName, JPanel currentPanel, int x, int y,
			ActionListener newAction) {
	
		{// button instance
	
			// creates new button
			JButton newButtonHandle = new JButton(buttonName);
			newButtonHandle.setForeground(new Color(51, 0, 0));
			newButtonHandle.setBackground(new Color(210, 180, 140));
			newButtonHandle.setFont(new Font("DejaVu Serif Condensed",
					Font.PLAIN, 47));
			Border emptyBorder = BorderFactory.createEmptyBorder();
			newButtonHandle.setBorder(emptyBorder);
	
			newButtonHandle.addActionListener(newAction);
			newButtonHandle.setBounds(x, y, 200, 50);
			newButtonHandle.setLayout(null);
			currentPanel.add(newButtonHandle);
			newButtonHandle.setVisible(true);
	
		}// end button instance
	
	}// end AddButton()


}// end class
