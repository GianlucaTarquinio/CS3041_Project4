package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import application.Project4Application;
import views.StartScreen;

public class GoToMainController implements ActionListener {
	Project4Application app;
	
	public GoToMainController(Project4Application app) {
		this.app = app;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		app.setCurrentScreen(new StartScreen(app));
	}

}
