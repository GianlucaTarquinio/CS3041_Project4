package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import application.Project4Application;
import views.ListingView;

public class CdButtonController implements ActionListener {
	Project4Application app;
	int genreIndex, artistIndex, titleIndex;
	ListingView listingView;
	
	public CdButtonController(Project4Application app, int genreIndex, int artistIndex, int titleIndex, ListingView listingView) {
		this.app = app;
		this.genreIndex = genreIndex;
		this.artistIndex = artistIndex;
		this.titleIndex = titleIndex;
		this.listingView = listingView;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
