package model;

import model.CD;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class ApplicationData {
	ArrayList<CD> cds = new ArrayList<CD>(); //list of all cds, sorted by genre, then by artist, then by title
	ArrayList<Integer> genreMap = new ArrayList<Integer>(); //first index of each genre
	ArrayList<ArrayList<Integer>> artistMap = new ArrayList<ArrayList<Integer>>(); //first index of each artist in each genre
	HashMap<String, User> users = new HashMap<String, User>();
	
	public ApplicationData() {
		
	}
	
	public void setCDs(ArrayList<CD> cds) {		
		cds.sort(new CompareByGenre()); //organize by genre first
		
		String lastGenre = null, genre = null;
		for(int i = 0; i < cds.size(); i++) { //record indices in the sorted ArrayList where the genre changes
			genre = cds.get(i).getGenre();
			if(!genre.equals(lastGenre)) {
				genreMap.add(i);
				lastGenre = genre;
			}
		}
		
		//next, organize by artist
		List<CD> sublist;
		int toIndex;
		for(int i = 0; i < genreMap.size(); i++) {
			artistMap.add(new ArrayList<Integer>());
			if(i + 1 < genreMap.size()) {
				toIndex = genreMap.get(i + 1);
			} else {
				toIndex = cds.size();
			}
			sublist = cds.subList(genreMap.get(i), toIndex);
			sublist.sort(new CompareByArtist());
			
			String lastArtist = null, artist = null;
			int fromIndex = 0;
			for(int j = 0; j < sublist.size(); j++) { //record indices where the artist changes in the sublists for each genre
				artist = sublist.get(j).getArtist();
				if(!artist.equals(lastArtist)) {
					sublist.subList(fromIndex, j).sort(new CompareByTitle()); //sort by name within the artist sublists
					fromIndex = j;
					artistMap.get(i).add(j);
					lastArtist = artist;
				}
			}
		}
		
		this.cds = cds;
	}
	
	/** Returns 0 on success, 1 if username is taken, 2 if email is taken, and 3 if both are taken
	 */
	public short addUser(User user) {
		short retval = 0;
		if(users.containsKey(user.getUsername())) {
			retval |= 1;
		}
		Collection<User> userList = users.values();
		for(User u : userList) {
			if(u.getEmail().equals(user.getEmail())) {
				retval |= 2;
				break;
			}
		}
		if(retval == 0) {
			users.put(user.getUsername(), user);
		}
		return retval;
	}
	
	public User getUser(String username) {
		return users.get(username);
	}
	
	public boolean isValidUser(String username, String password) {
		User user = getUser(username);
		if(user != null && user.verifyPassword(password)) {
			return true;
		}
		return false;
	}
	
	public ArrayList<String> getGenres() {
		ArrayList<String> genres = new ArrayList<String>();
		for(int i = 0; i < genreMap.size(); i++) {
			genres.add(cds.get(genreMap.get(i)).getGenre());
		}
		return genres;
	}
	
	public ArrayList<String> getArtistsInGenre(int genreIndex) {
		ArrayList<String> artists = new ArrayList<String>();
		int baseIndex = genreMap.get(genreIndex);
		ArrayList<Integer> localArtistMap = artistMap.get(genreIndex);
		for(int i = 0; i < localArtistMap.size(); i++) {
			artists.add(cds.get(baseIndex + localArtistMap.get(i)).getArtist());
		}
		return artists;
	}
	
	public ArrayList<String> getTitlesInArtistInGenre(int genreIndex, int artistIndex) {
		ArrayList<String> titles = new ArrayList<String>();
		int baseIndex = genreMap.get(genreIndex);
		ArrayList<Integer> localArtistMap = artistMap.get(genreIndex);
		int startIndex = baseIndex + localArtistMap.get(artistIndex);
		int endIndex;
		if(artistIndex + 1 < localArtistMap.size()) {
			endIndex = baseIndex + localArtistMap.get(artistIndex + 1);
		} else {
			if(genreIndex + 1 < genreMap.size()) {
				endIndex = genreMap.get(genreIndex + 1);
			} else {
				endIndex = cds.size();
			}
		}
		for(int i = startIndex; i < endIndex; i++) {
			titles.add(cds.get(i).getTitle());
		}
		return titles;
	}
	
	public void printCDs() {
		System.out.println("Number of CDs: " + cds.size());
		System.out.println("CDs:");
		for(int i = 0; i < cds.size(); i++) {
			System.out.println(cds.get(i).toString());
		}
	}
}
