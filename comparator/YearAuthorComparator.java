package by.epam.tr.lesson7.comparator;

import java.util.Comparator;

import by.epam.tr.lesson7.LiteratureWork;

public class YearAuthorComparator implements Comparator<LiteratureWork>{

	@Override
	public int compare(LiteratureWork o1, LiteratureWork o2) {
		int year1 = o1.getYearPublished();
		int year2 = o2.getYearPublished();
		String author1 = o1.getAuthor();
		String author2 = o2.getAuthor();
		
		if (year1 > year2 ) {
			return 1;
		}
		else if (year1 < year2) {
			return -1;
		}
		else {
			if (author1.compareTo(author2) > 0) {
				return 1;
			}
			else if (author1.compareTo(author2) > 0) {
				return -1;
			}
			else {
				return 0;
			}
		}
	}
}
