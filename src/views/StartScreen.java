package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import application.Project4Application;
import controllers.MakeAccountButtonController;
import model.User;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class StartScreen extends JPanel implements IView {
	Project4Application app;
	
	public StartScreen(Project4Application app) {
		this.app = app;
		User user = app.getActiveUser();
		setBackground(new Color(230, 230, 230));
		setLayout(null);
		
		JLabel lblYouAreNot = new JLabel("You are not logged in");
		lblYouAreNot.setBounds(20, 6, 157, 16);
		add(lblYouAreNot);
		
		JButton lblMakeAnAccount = new JButton("Make an account");
		lblMakeAnAccount.setForeground(new Color(0, 0, 0));
		lblMakeAnAccount.setBounds(776, 7, 133, 16);
		add(lblMakeAnAccount);
		lblMakeAnAccount.addActionListener(new MakeAccountButtonController(app));
		
		JButton lblLogIn = new JButton("Log in");
		lblLogIn.setForeground(new Color(0, 0, 0));
		lblLogIn.setBounds(920, 7, 60, 16);
		add(lblLogIn);
		
		JLabel lblChoose = new JLabel("Order from our large collection of CDs!");
		lblChoose.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		lblChoose.setBounds(118, 60, 764, 74);
		add(lblChoose);
		
		JButton btnNewButton = new JButton("Browse");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(150, 168, 700, 65);
		add(btnNewButton);
		
		JButton btnSearch_1 = new JButton("Search");
		btnSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnSearch_1.setBounds(150, 245, 700, 65);
		add(btnSearch_1);
		
		JButton btnSearch = new JButton("About this store");
		btnSearch.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnSearch.setBounds(150, 322, 700, 65);
		add(btnSearch);
		
		JButton btnRequestAssistance = new JButton("Request assistance");
		btnRequestAssistance.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnRequestAssistance.setBounds(150, 399, 700, 65);
		add(btnRequestAssistance);
		
		if(user != null) {
			JButton btnMyWishlist = new JButton("My Wishlist");
			btnMyWishlist.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			btnMyWishlist.setBounds(150, 476, 700, 65);
			add(btnMyWishlist);
			
			JButton btnRecommendationsForMe = new JButton("Recommendations for me");
			btnRecommendationsForMe.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			btnRecommendationsForMe.setBounds(150, 553, 700, 65);
			add(btnRecommendationsForMe);
		} else {
			JLabel lblNewLabel = new JLabel("Log in to gain access to your wishlist");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(250, 500, 500, 40);
			add(lblNewLabel);
			
			JLabel lblAndOurRecommendations = new JLabel("and our recommendations for you");
			lblAndOurRecommendations.setHorizontalAlignment(SwingConstants.CENTER);
			lblAndOurRecommendations.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblAndOurRecommendations.setBounds(250, 530, 500, 25);
			add(lblAndOurRecommendations);
		}
	}

	@Override
	public void update() {

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
