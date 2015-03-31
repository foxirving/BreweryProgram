package brewery.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class DisplayTemperaturePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static MainFrame frame;
	private static AllPanels panels;
	private JTextField textFieldDisplayTemp;
	private JPanel container;

	public DisplayTemperaturePanel(MainFrame mainFrame, AllPanels allPanels) {

		// initialize man frame and all the panels
		frame = mainFrame;
		panels = allPanels;

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

		textFieldDisplayTemp = new JTextField();
		textFieldDisplayTemp.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDisplayTemp.setFont(new Font("Tahoma",
				Font.BOLD | Font.ITALIC, 30));
		textFieldDisplayTemp.setText("89.54");
		textFieldDisplayTemp.setBounds(237, 94, 248, 132);
		textFieldDisplayTemp.setEditable(false);
		container.add(textFieldDisplayTemp);
		textFieldDisplayTemp.setColumns(10);

		//back button
				GuiFactory.addButton(frame, "back", container, 0, 350,
						new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {

								panels.getDisplayTemperaturePanel().setVisible(false);
								panels.getUserMainProfilePanel().setVisible(true);
							}
						});

	}// end DisplayTemperaturePanel()
}// end class
