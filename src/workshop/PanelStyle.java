package workshop;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class PanelStyle {

	private JFrame frame;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtUsername;
	private JTextField txtEmail;
	private JTextField txtRepeatEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelStyle window = new PanelStyle();
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
	public PanelStyle() {
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
		panel.setBounds(197, 11, 400, 400);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(20, 5, 86, 20);
		panel.add(txtFirstName);
		txtFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		txtFirstName.setText("First name");
		
		txtFirstName.addMouseListener(new MouseAdapter(){
	            @Override
	            public void mouseClicked(MouseEvent e){
	            	txtFirstName.setText("");
	            }
	        });
		 
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(111, 5, 86, 20);
		panel.add(txtLastName);
		txtLastName.setText("Last name");
		txtLastName.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(202, 5, 86, 20);
		panel.add(txtUsername);
		txtUsername.setText("username");
		txtUsername.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(293, 5, 86, 20);
		panel.add(txtEmail);
		txtEmail.setText("email");
		txtEmail.setColumns(10);
		
		txtRepeatEmail = new JTextField();
		txtRepeatEmail.setBounds(157, 30, 86, 20);
		panel.add(txtRepeatEmail);
		txtRepeatEmail.setText("repeat email");
		txtRepeatEmail.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(660, 207, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
