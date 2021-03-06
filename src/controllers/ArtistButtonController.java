package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import application.Project4Application;
import views.ListingView;

public class ArtistButtonController implements ActionListener {
	Project4Application app;
	int genreIndex, artistIndex;
	ListingView listingView;
	
	public ArtistButtonController(Project4Application app, int genreIndex, int artistIndex, ListingView listingView) {
		this.app = app;
		this.genreIndex = genreIndex;
		this.artistIndex = artistIndex;
		this.listingView = listingView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		listingView.setButtonStates(false);
		ArrayList<String> titles = app.getAppData().getTitlesInArtistInGenre(genreIndex, artistIndex);
		ArrayList<ActionListener> actions = new ArrayList<ActionListener>();
		for(int i = 0; i < titles.size(); i++) {
			actions.add(new CdButtonController(app, genreIndex, artistIndex, i, listingView));
		}
		listingView.setList(titles, actions);
	}

}
