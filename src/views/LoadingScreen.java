package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import application.Project4Application;

@SuppressWarnings("serial")
public class LoadingScreen extends JPanel implements IView {
	Project4Application app;
	
	public LoadingScreen(Project4Application app) {
		this.app = app;
		setBackground(new Color(245, 245, 245));	
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		setLayout(gbl);
		
		JLabel loadLabel = new JLabel("Loading...");
		loadLabel.setFont(new Font("Serif", Font.BOLD, 72));
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.CENTER;
		gbl.setConstraints(loadLabel, c);
		add(loadLabel);
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
