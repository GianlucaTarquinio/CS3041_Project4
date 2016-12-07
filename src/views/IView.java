package views;

import javax.swing.JFrame;

public interface IView {
	public void update();
	public void removeFromFrame(JFrame jf);
	public void addToFrame(JFrame jf);
}
