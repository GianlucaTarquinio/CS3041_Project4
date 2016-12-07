package model;

public class CD {
	String title, artist, genre;
	int cost; //in cents
	
	public CD(String title, String artist, String genre, int price) {
		this.title = title;
		this.artist = artist;
		this.genre = genre;
		this.cost = price;
	}
	
	public String getGenre() {
		return this.genre;
	}
	
	public String getArtist() {
		return this.artist;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	@Override
	public String toString() {
		return "\"" + title + "\" (" + genre + ") by " + artist + ", " + cost + " cents";
	}
}
