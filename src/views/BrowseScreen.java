package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import application.Project4Application;
import controllers.ArtistButtonController;
import controllers.BrowseButtonController;
import controllers.GenreButtonController;
import controllers.GoToMainController;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class BrowseScreen extends JPanel implements IView {
	Project4Application app;
	ListingView panel;
	
	public BrowseScreen(Project4Application app) {
		this.app = app;
		setBackground(new Color(230, 230, 230));
		setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(6, 6, 75, 29);
		add(btnBack);
		btnBack.addActionListener(new GoToMainController(app));
		
		JLabel lblNewLabel = new JLabel("Browse");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		lblNewLabel.setBounds(429, 60, 142, 48);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 150, 800, 500);
		add(scrollPane);
		
		panel = new ListingView(app, scrollPane);
		scrollPane.setViewportView(panel);
	}
	
	public ListingView getListingView() {
		return panel;
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
