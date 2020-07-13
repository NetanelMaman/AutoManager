import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginInterface extends JPanel implements ActionListener {

	private JTextField getID;
	private JTextField getPassword;
	private JButton button;
	private DatabaseManager manager = DatabaseManager.getInstance(System.getProperty("user.dir") + "/Database/Cars",
			System.getProperty("user.dir") + "/Database/Users");
	public static boolean loggedIn = false;
	
	
	public LoginInterface() {
		this.setLayout(new GridLayout(1, 3));
		this.setBackground(Color.WHITE);
		this.createDisplay();
	}
	
	private void createDisplay() {
		getID = new JTextField("UserID");
		getID.setEditable(true);
		getID.setFont(new Font("Arial", Font.PLAIN, 50));
		getID.setBackground(Color.WHITE);
		getID.setForeground(Color.BLACK);
		add(getID);
		
		getPassword = new JTextField("Password");
		getPassword.setEditable(true);
		getPassword.setFont(new Font("Arial", Font.PLAIN, 50));
		getPassword.setBackground(Color.WHITE);
		getPassword.setForeground(Color.BLACK);
		add(getPassword);
		
		button = new JButton("Submit patients details");
		button.setBackground(Color.WHITE);
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Arial", Font.PLAIN, 50));
		button.addActionListener(this);
		add(button);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JLabel message = new JLabel("Please fill all the details");
		message.setFont(new Font("Arial", Font.PLAIN, 50));
		message.setBackground(Color.WHITE);
		message.setForeground(Color.BLACK);
		
		if (getID.getText().equals("UserID")) {
			message.setText("Please type valid id");
			JOptionPane.showMessageDialog(this, message);
			return;
		}
		if (getPassword.getText().equals("Password")) {
			message.setText("Please type valid password");
			JOptionPane.showMessageDialog(this, message);
			return;
		}
		
		loggedIn = manager.signIn(getID.getText(), getPassword.getText());
		if (loggedIn) {
			message.setText("Loggin was succesful, Welcome");
			JOptionPane.showMessageDialog(this, message);
		} else {
			message.setText("ID doesn't exist or wrong password given");
			JOptionPane.showMessageDialog(this, message);
		}
	}

}
