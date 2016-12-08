package views;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import application.Project4Application;

@SuppressWarnings("serial")
public class ListingView extends JPanel implements IView {
	Project4Application app;
	ArrayList<JButton> buttons;
	
	public ListingView(Project4Application app) {
		this.app = app;
		//this.setLayout(new GridLayout(0, 1));
		setLayout(null);
	}
	
	public void setList(ArrayList<String> strList, ArrayList<ActionListener> actionList) {
		int size = strList.size();
		int height = 100;
		setPreferredSize(new Dimension(700, size*height));
		removeAll();
		buttons = new ArrayList<JButton>();
		for(int i = 0; i < size; i++) {
			JButton b = new JButton(strList.get(i));
			b.addActionListener(actionList.get(i));
			b.setBounds(0, i * height, 800, height);
			add(b);
			buttons.add(b);
		}
		update();
	}
	
	public void setButtonStates(boolean state) {
		for(int i = 0; i < buttons.size(); i++) {
			buttons.get(i).setEnabled(state);
		}
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
