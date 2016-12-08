package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import application.Project4Application;
import views.ListingView;

public class GenreButtonController implements ActionListener {
	Project4Application app;
	int genreIndex;
	ListingView listingView;
	
	public GenreButtonController(Project4Application app, int genreIndex, ListingView listingView) {
		this.app = app;
		this.genreIndex = genreIndex;
		this.listingView = listingView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		listingView.setButtonStates(false);
		ArrayList<String> artists = app.getAppData().getArtistsInGenre(genreIndex);
		ArrayList<ActionListener> actions = new ArrayList<ActionListener>();
		for(int i = 0; i < artists.size(); i++) {
			actions.add(new ArtistButtonController(app, genreIndex, i, listingView));
		}
		listingView.setList(artists, actions);
	}

}
