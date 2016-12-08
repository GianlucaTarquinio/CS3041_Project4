package views;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import application.Project4Application;
import controllers.GoToMainController;
import controllers.MakeAccountController;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class RegisterScreen extends JPanel implements IView {
	Project4Application app;
	private JPasswordField passwordField;
	private JTextField textField;
	private JPasswordField passwordField_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	JLabel lblNewLabel_2, lblNewLabel_3, lblThisEmailIs, lblEmailsDoNot, lblAllFieldsMust;
	JButton btnNewButton;
	
	
	public RegisterScreen(Project4Application app) {
		this.app = app;
		setBackground(new Color(230, 230, 230));
		setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(6, 6, 75, 29);
		add(btnBack);
		btnBack.addActionListener(new GoToMainController(app));
		
		JLabel lblNewLabel = new JLabel("Make an account");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		lblNewLabel.setBounds(334, 60, 332, 48);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Confirm Password");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(229, 208, 180, 29);
		add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(421, 208, 350, 35);
		add(passwordField);
		passwordField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblUsername.setBounds(229, 126, 180, 29);
		add(lblUsername);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(421, 126, 350, 35);
		add(textField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPassword.setBounds(229, 167, 180, 29);
		add(lblPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setColumns(10);
		passwordField_1.setBounds(421, 167, 350, 35);
		add(passwordField_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(421, 249, 350, 35);
		add(textField_1);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblFirstName.setBounds(229, 249, 180, 29);
		add(lblFirstName);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(421, 290, 350, 35);
		add(textField_2);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblLastName.setBounds(229, 290, 180, 29);
		add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblEmail.setBounds(229, 331, 180, 29);
		add(lblEmail);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(421, 331, 350, 35);
		add(textField_3);
		
		JLabel lblConfirmEmail = new JLabel("Confirm Email");
		lblConfirmEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfirmEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblConfirmEmail.setBounds(229, 372, 180, 29);
		add(lblConfirmEmail);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(421, 372, 350, 35);
		add(textField_4);
		
		btnNewButton = new JButton("Create Account");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnNewButton.setBounds(229, 426, 542, 55);
		add(btnNewButton);
		btnNewButton.addActionListener(new MakeAccountController(app, this));
		
		lblAllFieldsMust = new JLabel("All fields must be filled in");
		lblAllFieldsMust.setForeground(new Color(255, 0, 0));
		lblAllFieldsMust.setBounds(425, 108, 168, 16);
		
		lblNewLabel_2 = new JLabel("Passwords do not match");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setBounds(775, 217, 161, 16);
		
		lblNewLabel_3 = new JLabel("This username is taken");
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setBounds(775, 135, 151, 16);
		
		lblThisEmailIs = new JLabel("This email is taken");
		lblThisEmailIs.setForeground(Color.RED);
		lblThisEmailIs.setBounds(775, 340, 151, 16);
		
		lblEmailsDoNot = new JLabel("Emails do not match");
		lblEmailsDoNot.setForeground(Color.RED);
		lblEmailsDoNot.setBounds(775, 381, 151, 16);
	}
	
	public String[] getInputVals() {
		return new String[] {textField.getText(), new String(passwordField_1.getPassword()), new String(passwordField.getPassword()), 
			textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText()};
	}
	
	public void setWarnings(boolean empty, boolean uTaken, boolean pMatch, boolean eTaken, boolean eMatch) {
		remove(lblAllFieldsMust);
		remove(lblNewLabel_2);
		remove(lblNewLabel_3);
		remove(lblThisEmailIs);
		remove(lblEmailsDoNot);
		if(empty) add(lblAllFieldsMust);
		if(uTaken) add(lblNewLabel_3);
		if(pMatch) add(lblNewLabel_2);
		if(eTaken) add(lblThisEmailIs);
		if(eMatch) add(lblEmailsDoNot);
	}
	
	public void setButtonStatus(boolean status) {
		btnNewButton.setEnabled(status);
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
