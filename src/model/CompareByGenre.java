package model;

import java.util.Comparator;

public class CompareByGenre implements Comparator<CD> {

	@Override
	public int compare(CD o1, CD o2) {
		return o1.getGenre().compareTo(o2.getGenre());
	}

}
