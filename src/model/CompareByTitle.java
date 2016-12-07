package model;

import java.util.Comparator;

public class CompareByTitle implements Comparator<CD> {

	@Override
	public int compare(CD o1, CD o2) {
		return o1.getTitle().compareTo(o2.getTitle());
	}

}
