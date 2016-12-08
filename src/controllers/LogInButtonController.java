package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import application.Project4Application;
import views.LogInView;

public class LogInButtonController implements ActionListener {
	Project4Application app;
	
	public LogInButtonController(Project4Application app) {
		this.app = app;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		app.setCurrentScreen(new LogInView(app));
	}

}
