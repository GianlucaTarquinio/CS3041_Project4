package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import application.Project4Application;
import views.StartScreen;

public class LogOutController implements ActionListener {
	Project4Application app;
	
	public LogOutController(Project4Application app) {
		this.app = app;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		app.setActiveUser(null);
		app.setCurrentScreen(new StartScreen(app));
	}

}
