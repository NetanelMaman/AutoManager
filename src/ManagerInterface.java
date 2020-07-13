import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ManagerInterface extends JFrame implements ActionListener {

	private JPanel actionsButtonJPanel;
	public JPanel action;
	private JButton registerB;
	private JButton loginB;
	private ArrayList<CarModel> cars;
	private DatabaseManager manager = DatabaseManager.getInstance(System.getProperty("user.dir") + "/Database/Cars",
			System.getProperty("user.dir") + "/Database/Users");
	
	public ManagerInterface() {
		super("ManagerInterface");
		
		actionsButtonJPanel = new JPanel();
		actionsButtonJPanel.setLayout(new GridLayout(1, 3));
		
		this.createDisplay();
	}
	
	
	private void createDisplay() {
		JPanel loginLabel = new JPanel();
		loginLabel.setLayout(new GridLayout(1, 3));
		JLabel instructionsLabel = new JLabel("Login or Register");
		instructionsLabel.setFont(new Font("Arial", Font.PLAIN, 50));
		instructionsLabel.setBackground(Color.WHITE);
		instructionsLabel.setForeground(Color.BLACK);
		loginLabel.add(instructionsLabel);
		
		JButton b;

		registerB = new JButton("Register");
		registerB.setFont(new Font("Arial", Font.PLAIN, 50));
		registerB.setBackground(Color.WHITE);
		registerB.setForeground(Color.BLACK);
		registerB.addActionListener(this);
		loginLabel.add(registerB);
		
		loginB = new JButton("Login");
		loginB.setFont(new Font("Arial", Font.PLAIN, 50));
		loginB.setBackground(Color.WHITE);
		loginB.setForeground(Color.BLACK);
		loginB.addActionListener(this);
		loginLabel.add(loginB);
		
		
		add(loginLabel, BorderLayout.NORTH);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (LoginInterface.loggedIn) {
			//cars = manager.getAllCars();
		}
		if (e.getActionCommand().equals("Login")) {
			action = new LoginInterface();
			add(action, BorderLayout.CENTER);
			revalidate();
		}
		
	}
	
}
