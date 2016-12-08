package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import application.Project4Application;
import views.BrowseScreen;
import views.ListingView;
import views.StartScreen;

public class BrowseButtonController implements ActionListener {
	Project4Application app;
	StartScreen startScreen;
	
	public BrowseButtonController(Project4Application app, StartScreen startScreen) {
		this.app = app;
		this.startScreen = startScreen;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		startScreen.setBrowseButtonStatus(false);
		BrowseScreen browse = new BrowseScreen(app);
		ListingView listingView = browse.getListingView();
		ArrayList<String> genres = app.getAppData().getGenres();
		ArrayList<ActionListener> actions = new ArrayList<ActionListener>();
		for(int i = 0; i < genres.size(); i++) {
			actions.add(new GenreButtonController(app, i, listingView));
		}
		listingView.setList(genres, actions);
		app.setCurrentScreen(browse);
	}

}
