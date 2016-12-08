package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import application.Project4Application;
import controllers.GoToMainController;
import controllers.LogInController;

@SuppressWarnings("serial")
public class LogInView extends JPanel implements IView {
	Project4Application app;
	JPasswordField passwordField;
	JTextField textField;
	JButton btnNewButton;
	JLabel lblNewLabel_2;
	
	public LogInView(Project4Application app) {
		this.app = app;
		setBackground(new Color(230, 230, 230));
		setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(6, 6, 75, 29);
		add(btnBack);
		btnBack.addActionListener(new GoToMainController(app));
		
		JLabel lblNewLabel = new JLabel("Log in");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		lblNewLabel.setBounds(439, 60, 122, 48);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(229, 199, 180, 29);
		add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(421, 199, 350, 35);
		add(passwordField);
		passwordField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblUsername.setBounds(203, 158, 206, 29);
		add(lblUsername);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(421, 158, 350, 35);
		add(textField);
		
		btnNewButton = new JButton("Log In");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnNewButton.setBounds(229, 240, 542, 55);
		add(btnNewButton);
		btnNewButton.addActionListener(new LogInController(app, this));
		 
		//This would be implemented in the complete interface
		JButton lblNewLabel_3 = new JButton("Forgot Username");
		lblNewLabel_3.setBounds(772, 168, 122, 16);
		add(lblNewLabel_3);
		
		//This would be implemented in the complete interface
		JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.setBounds(772, 209, 122, 16);
		add(btnForgotPassword);
		
		lblNewLabel_2 = new JLabel("Login credentials rejected");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setBounds(425, 136, 252, 16);
	}
	
	public String[] getInputVals() {
		return new String[] {textField.getText(), new String(passwordField.getPassword())};
	}
	
	public void setWarning(boolean noMatch) {
		remove(lblNewLabel_2);
		if(noMatch) add(lblNewLabel_2);
	}
	
	public void setButtonStatus(boolean state) {
		btnNewButton.setEnabled(state);
		update();
	}
	
	
	@Override
	public void update() {
		revalidate();
		repaint();
	}

	@Override
	public void removeFromFrame(JFrame jf) {
		jf.remove(this);
	}

	@Override
	public void addToFrame(JFrame jf) {
		jf.setContentPane(this);
	}

}
