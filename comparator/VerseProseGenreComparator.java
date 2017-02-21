package by.epam.tr.lesson7.comparator;

import java.util.Comparator;

import by.epam.tr.lesson7.LiteratureWork;
import by.epam.tr.lesson7.Prose;
import by.epam.tr.lesson7.Verse;


/*
 * Atypical comparator to compare different types - verses before and proses after, by genre if two verses or two proses
 */
public class VerseProseGenreComparator implements Comparator<LiteratureWork>{

	@Override
	public int compare(LiteratureWork o1, LiteratureWork o2) {		
		if (o1 instanceof Verse && o2 instanceof Prose) {
			return -1;
		}
		else if (o1 instanceof Verse && o2 instanceof Verse) {
			return ((Verse) o1).getGenre().compareTo(((Verse) o2).getGenre());
		}
		else if (o1 instanceof Prose && o2 instanceof Prose) {
			return ((Prose) o1).getGenre().compareTo(((Prose) o2).getGenre());
		}
		else if (o1 instanceof Prose && o2 instanceof Verse) {
			return 1;
		}
		
		return 0;
	}
}