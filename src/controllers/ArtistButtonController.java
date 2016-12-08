package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		String genre = app.getAppData().getGenres().get(genreIndex);
		String artist = app.getAppData().getArtistsInGenre(genreIndex).get(artistIndex);
		System.out.println(genre + ", " + artist);
	}

}
