package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import application.Project4Application;
import views.LogInView;
import views.StartScreen;

public class LogInController implements ActionListener {
	Project4Application app;
	LogInView logView;
	
	public LogInController(Project4Application app, LogInView logView) {
		this.app = app;
		this.logView = logView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		logView.setButtonStatus(false);
		String[] inputVals = logView.getInputVals(); //[username, password]
		if(app.getAppData().isValidUser(inputVals[0], inputVals[1])) {
			app.setActiveUser(app.getAppData().getUser(inputVals[0]));
			app.setCurrentScreen(new StartScreen(app));
		} else {
			logView.setWarning(true);
			logView.update();
			logView.setButtonStatus(true);
			app.setCurrentScreen(logView);
		}
	}

}
