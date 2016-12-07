package model;

import java.util.Comparator;

public class CompareByArtist implements Comparator<CD> {

	@Override
	public int compare(CD o1, CD o2) {
		return o1.getArtist().compareTo(o2.getArtist());
	}

}
