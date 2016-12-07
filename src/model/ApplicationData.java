package model;

import model.CD;
import java.util.ArrayList;
import java.util.List;

public class ApplicationData {
	ArrayList<CD> cds = new ArrayList<CD>(); //list of all cds, sorted by genre, then by artist, then by title
	ArrayList<Integer> genreMap = new ArrayList<Integer>();
	ArrayList<ArrayList<Integer>> artistMap = new ArrayList<ArrayList<Integer>>();
	
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
	
	public void printCDs() {
		System.out.println("Number of CDs: " + cds.size());
		System.out.println("CDs:");
		for(int i = 0; i < cds.size(); i++) {
			System.out.println(cds.get(i).toString());
		}
	}
}
