package workshop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.LineBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class MainFrameTest {

	private JFrame frame;
	private static boolean isVisible = false;
	private JPanel popup;
	private JPanel popupTwo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrameTest window = new MainFrameTest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrameTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 0, 800, 480);
		frame.getContentPane().add(panel);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				popup.setVisible(false);
				popupTwo.setVisible(false);
			}
		});
		panel.setLayout(null);

		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 785, 50);
		panel.add(toolBar);

		popup = new JPanel();
		popup.setBorder(new LineBorder(new Color(0, 0, 0)));
		popup.setBackground(Color.CYAN);
		popup.setBounds(0, 50, 260, 430);
		popup.setVisible(false);
		panel.add(popup);
		popup.setLayout(null);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				while (true) {
					if (!popupTwo.isShowing()) {
						popupTwo.setVisible(true);
						isVisible = true;
						break;
					} else {
						popupTwo.setVisible(false);
						break;
					}

				}
			}
		});
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setBounds(0, 0, 260, 50);
		popup.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("New button2");
		btnNewButton_1.setBackground(Color.BLUE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				while (true) {
					if (!popupTwo.isShowing()) {
						popupTwo.setVisible(true);
						isVisible = true;
						break;
					} else {
						popupTwo.setVisible(false);
						break;
					}

				}
			}
		});
		btnNewButton_1.setBounds(0, 50, 260, 50);
		popup.add(btnNewButton_1);

		// task options

		JButton settingsButton = new JButton("set");
		settingsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				while (true) {
					if (!popup.isShowing()) {
						popup.setVisible(true);
						isVisible = true;
						break;
					} else {
						popup.setVisible(false);
						popupTwo.setVisible(false);
						break;
					}
				}
			}
		});
		settingsButton.setBounds(750, 0, 50, 50);
		toolBar.add(settingsButton);

		JButton home = new JButton("Home");
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				popup.setVisible(false);
				popupTwo.setVisible(false);
			}

		});
		home.setBounds(750, 0, 50, 50);
		toolBar.add(home);

		popupTwo = new JPanel();
		popupTwo.setBackground(Color.YELLOW);
		popupTwo.setBounds(260, 50, 525, 393);
		popupTwo.setVisible(false);
		panel.add(popupTwo);

		//
		// JButton button = new JButton("New button");
		// button.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		// while (true) {
		// if (!popup.isShowing()) {
		// popup.setVisible(true);
		// isVisible = true;
		// break;
		// } else{
		// popup.setVisible(false);
		// break;
		// }
		// }
		// }
		// });
		// button.setBounds(333, 116, 120, 120);
		// panel.add(button);

	}

}
