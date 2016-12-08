package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import application.Project4Application;
import views.RegisterScreen;

public class MakeAccountButtonController implements ActionListener {
	Project4Application app;
	
	public MakeAccountButtonController(Project4Application app) {
		this.app = app;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		app.setCurrentScreen(new RegisterScreen(app));
	}

}
