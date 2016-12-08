package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import application.Project4Application;
import model.User;
import views.RegisterScreen;
import views.StartScreen;

public class MakeAccountController implements ActionListener {
	Project4Application app;
	RegisterScreen regView;
	
	public MakeAccountController(Project4Application app, RegisterScreen regView) {
		this.app = app;
		this.regView = regView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String[] inputVals = regView.getInputVals();//{username, pass, confirmPass, FirstName, LastName, email, confirmEmail}
		boolean uTaken = false, pMatch = false, eTaken = false, eMatch = false;
		if(!inputVals[1].equals(inputVals[2])) {
			pMatch = true;
		}
		if(!inputVals[5].equals(inputVals[6])) {
			eMatch = true;
		}
		if(pMatch || eMatch) {
			regView.setWarnings(uTaken, pMatch, eTaken, eMatch);
			regView.update();
			app.setCurrentScreen(regView);
		} else {
			short result = app.getAppData().addUser(new User(inputVals[0], inputVals[1], inputVals[3], inputVals[4], inputVals[5]));
			if(result == 0) {
				app.setActiveUser(app.getAppData().getUser(inputVals[0]));
				app.setCurrentScreen(new StartScreen(app));
			} else {
				uTaken = (result & 1) > 0;
				eTaken = (result & 2) > 0;
				regView.setWarnings(uTaken, pMatch, eTaken, eMatch);
				app.setCurrentScreen(regView);
			}
		}
	}

}