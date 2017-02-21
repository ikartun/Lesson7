package by.epam.tr.lesson7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import by.epam.tr.lesson7.comparator.TitleComparator;
import by.epam.tr.lesson7.comparator.VerseProseGenreComparator;
import by.epam.tr.lesson7.comparator.YearAuthorComparator;

public class CollectedLiteratureWorkSort {

	public static void main(String[] args) {
		List<LiteratureWork> verseProseLiteratureWorks = new ArrayList<>();
		
		verseProseLiteratureWorks.add(new Verse("Евгений Онегин", 1831, "А.С. Пушкин", true, "роман"));
		verseProseLiteratureWorks.add(new Prose("Мастер и Маргарита", 1937, "М.А. Булгаков", false, "роман"));
		verseProseLiteratureWorks.add(new Verse("Мцыри", 1839, "М.Ю. Лермонтов", true, "поэма"));
		verseProseLiteratureWorks.add(new Prose("Ревизор", 1840, "Н.В. Гоголь", false, "комедия"));
		verseProseLiteratureWorks.add(new Verse("Анна Снегина", 1925, "С.А. Есенин", true, "поэма"));
		verseProseLiteratureWorks.add(new Prose("Война и мир", 1840, "Л.Н. Толстой", false, "роман-эпопея"));
		verseProseLiteratureWorks.add(new Verse("Илиада", 562, "Гомер", true, "эпическая поэма"));
		
		CollectedLiteratureWork collectedVersesProses = new CollectedLiteratureWork(verseProseLiteratureWorks, "книга");
		
		sort(collectedVersesProses, new TitleComparator());
		System.out.println("----------------------------");
		sort(collectedVersesProses, new YearAuthorComparator());
		System.out.println("----------------------------");
		sort(collectedVersesProses, new VerseProseGenreComparator());
	}
	
	public static void sort(CollectedLiteratureWork collectedLiteratureWork, Comparator<LiteratureWork> comparator) {
		List<LiteratureWork> verseProseLiteratureWorks = collectedLiteratureWork.getLiteratureWorks();
		boolean isAtypicalComparison = false;
		
		Collections.sort(verseProseLiteratureWorks, comparator);
		
		if (comparator instanceof VerseProseGenreComparator) {
			isAtypicalComparison = true;
		}
		
		if (isAtypicalComparison) {
			Verse verse;
			Prose prose;
			boolean isRhyme;
			String genre;
			
			for (LiteratureWork literatureWork : verseProseLiteratureWorks) {
				if (literatureWork instanceof Verse) {
					verse = (Verse) literatureWork;
					isRhyme = verse.isRhyme();
					genre = verse.getGenre();
				}
				else {
					prose = (Prose) literatureWork;
					isRhyme = prose.isRhyme();
					genre = prose.getGenre();
				}
				System.out.println(collectedLiteratureWork.getForm() + "-сборник: this is " + (isRhyme ? "Verse" : "Prose") + ", Genre is " + genre + ", Title is " + literatureWork.getTitle() + ", Author is " + literatureWork.getAuthor() + ", Year is " + literatureWork.getYearPublished());
			}
		}
		else {
			for (LiteratureWork literatureWork : verseProseLiteratureWorks) {
				System.out.println(collectedLiteratureWork.getForm() + "-сборник: Title is " + literatureWork.getTitle() + ", Author is " + literatureWork.getAuthor() + ", Year is " + literatureWork.getYearPublished());
			}
		}
	}

}
