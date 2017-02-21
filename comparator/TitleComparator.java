package by.epam.tr.lesson7.comparator;

import java.util.Comparator;

import by.epam.tr.lesson7.LiteratureWork;

public class TitleComparator implements Comparator<LiteratureWork>{

	@Override
	public int compare(LiteratureWork o1, LiteratureWork o2) {
		return o1.getTitle().compareTo(o2.getTitle());
	}

}
