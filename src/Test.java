import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		test1();
		test2();
	}

	private static void printTestHeader(int num, String description) {
		System.out.println();
		System.out.println();
		System.out.println("Test " + num + ":");
		System.out.println(description);
	}

	private static void printSet(Set<Description> set, String description) {
		int count = 0;

		System.out.println();
		System.out.println(description);
		
		for (Description elem : set) {
			System.out.println(elem.toString());
			count++;
		}
		
		System.out.println("Anzahl der Zeilen: " + count);
	}

	private static void test1() {
		Set.OrderedSet<Description> oset;
		Iterator<Description> iti;
		Description die = new Description("Die");
		Description katz = new Description("Katz");

		printTestHeader(1, "teste OrderedSet<Description>");

		oset = new Set.OrderedSet<Description>();
		oset.insert(new Description("Hoppala!"));
		oset.insert(die);
		oset.insert(katz);
		oset.insert(new Description("ist da!"));
		printSet(oset, "gefuelltes Set:");
		
		oset.insert(new Description("Abcdefg"));
		printSet(oset, "gueltigen Eintrag 'Abcdefg' hinzufuegen:");

		oset.insert(die);
		printSet(oset, "bereits vorhandenen Eintrag 'Die' hinzufuegen (identisch):");

		oset.insert(new Description("Die"));
		printSet(oset, "bereits vorhandenen Eintrag 'Die' hinzufuegen (nicht identisch):");

		iti = oset.iterator();
		while (iti.hasNext()) {
			Description tmp = iti.next();
			if (tmp == katz) {
				iti.remove();
			}
		}

		printSet(oset, "vorhandenen Eintrag 'Katz' loeschen:");
	}

	private static void test2() {
		printTestHeader(2, "teste OrderedMap<MeanElapsedTime, CompositeTime>");

		OrderedMap<MeanElapsedTime, CompositeTime> omap = new OrderedMap<MeanElapsedTime, CompositeTime>();
		MeanElapsedTime meat;
		omap.insert(meat = new MeanElapsedTime());
		meat.addMeassurement(17.3);
		meat.addMeassurement(0.0045);
		meat.addMeassurement(64.8);
		meat.addMeassurement(9.3);
		MapIterator<MeanElapsedTime, CompositeTime> mapIter = omap.iterator();
		CompositeTime ct;
		Iterator<CompositeTime> coIti;
		while (mapIter.hasNext()) {
			mapIter.next();
			coIti = mapIter.iterator();
			while (coIti.hasNext()) {
				ct = coIti.next();
				System.out.println(ct.count() + " gezaehlt, ShortestTime"
						+ ct.shortestTime());
			}
		}
		meat.addMeassurement(57.345);
		mapIter = omap.iterator();
		while (mapIter.hasNext()) {
			mapIter.next();
			coIti = mapIter.iterator();
			while (coIti.hasNext()) {
				ct = coIti.next();
				System.out.println(ct.count() + " gezaehlt, ShortestTime"
						+ ct.shortestTime());
			}
		}
	}
}
