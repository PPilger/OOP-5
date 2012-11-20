import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}

	private static void printTestHeader(int num, String description) {
		System.out.println();
		System.out.println();
		System.out.println("Test " + num + ":");
		System.out.println(description);
	}

	private static void print(Set<Description> set, String description) {
		Iterator<Description> iter = set.iterator();
		int count = 0;

		System.out.println();
		System.out.println(description);

		while (iter.hasNext()) {
			System.out.println(iter.next().toString());
			count++;
		}

		System.out.println("Anzahl der Zeilen: " + count);
	}

	private static void print(OrderedMap<MeanElapsedTime, CompositeTime> map,
			String description) {
		MapIterator<MeanElapsedTime, CompositeTime> mapIter = map.iterator();

		System.out.println();
		System.out.println(description);

		while (mapIter.hasNext()) {
			MeanElapsedTime meanTime = mapIter.next();
			Iterator<CompositeTime> objIter = mapIter.iterator();

			System.out.print("maxMeasurement: " + meanTime.maxMeassurement()
					+ ", shortestTimes: [");

			if (objIter.hasNext()) {
				CompositeTime compTime = objIter.next();
				System.out.print(compTime.shortestTime());
			}
			while (objIter.hasNext()) {
				CompositeTime compTime = objIter.next();
				System.out.print(", " + compTime.shortestTime());
			}

			System.out.println("]");
		}
	}

	private static void fill(OrderedMap<MeanElapsedTime, CompositeTime> map) {
		MapIterator<MeanElapsedTime, CompositeTime> mapIter;
		MeanElapsedTime meanTime;

		// 1. Eintrag
		meanTime = new MeanElapsedTime();
		meanTime.addMeassurement(17.3);
		meanTime.addMeassurement(64.8);
		meanTime.addMeassurement(19.3);
		map.insert(meanTime);

		mapIter = map.iterator();
		while (mapIter.hasNext()) {
			MeanElapsedTime cur = mapIter.next();
			if (cur == meanTime) {
				ListIterator<CompositeTime> compIter = mapIter.iterator();
				compIter.add(new CompositeTime(new Double[] { 3.2, 5.7, 1.7 }));
				compIter.add(new CompositeTime(new Double[] { 8.3, 3.4, 2.0 }));
				compIter.add(new CompositeTime(new Double[] { 5.1, 9.3, 2.5 }));
			}
		}

		// 2. Eintrag
		meanTime = new MeanElapsedTime();
		meanTime.addMeassurement(8.3);
		meanTime.addMeassurement(6.5);
		meanTime.addMeassurement(12.0);
		map.insert(meanTime);

		mapIter = map.iterator();
		while (mapIter.hasNext()) {
			MeanElapsedTime cur = mapIter.next();
			if (cur == meanTime) {
				ListIterator<CompositeTime> compIter = mapIter.iterator();
				compIter.add(new CompositeTime(new Double[] { 8.5, 2.4, 7.1 }));
				compIter.add(new CompositeTime(new Double[] { 5.3, 3.3, 0.2 }));
				compIter.add(new CompositeTime(new Double[] { 3.9, 1.7, 5.2 }));
			}
		}

		// 3. Eintrag
		meanTime = new MeanElapsedTime();
		meanTime.addMeassurement(44.4);
		meanTime.addMeassurement(23.8);
		meanTime.addMeassurement(44.3);
		map.insert(meanTime);

		mapIter = map.iterator();
		while (mapIter.hasNext()) {
			MeanElapsedTime cur = mapIter.next();
			if (cur == meanTime) {
				ListIterator<CompositeTime> compIter = mapIter.iterator();
				compIter.add(new CompositeTime(new Double[] { 9.3, 4.2, 3.2 }));
				compIter.add(new CompositeTime(new Double[] { 1.3, 5.8, 7.1 }));
				compIter.add(new CompositeTime(new Double[] { 2.7, 3.2, 5.5 }));
			}
		}

	}

	private static void test1() {
		Set.OrderedSet<Description> set;
		Iterator<Description> iti;
		Description die = new Description("Die");
		Description katz = new Description("Katz");

		printTestHeader(1, "teste OrderedSet<Description>");

		set = new Set.OrderedSet<Description>();
		set.insert(new Description("Hoppala!"));
		set.insert(die);
		set.insert(katz);
		set.insert(new Description("ist da!"));
		print(set, "gefuelltes Set:");

		set.insert(new Description("Abcdefg"));
		print(set, "gueltigen Eintrag 'Abcdefg' hinzufuegen:");

		set.insert(die);
		print(set, "bereits vorhandenen Eintrag 'Die' hinzufuegen (identisch):");

		set.insert(new Description("Die"));
		print(set,
				"bereits vorhandenen Eintrag 'Die' hinzufuegen (nicht identisch):");

		iti = set.iterator();
		while (iti.hasNext()) {
			Description tmp = iti.next();
			if (tmp == katz) {
				iti.remove();
			}
		}

		print(set, "vorhandenen Eintrag 'Katz' loeschen:");
	}

	private static void test2() {
		OrderedMap<MeanElapsedTime, CompositeTime> map;
		MapIterator<MeanElapsedTime, CompositeTime> mapIter;
		ListIterator<CompositeTime> objIter;
		MeanElapsedTime meanTime;

		printTestHeader(2, "teste OrderedMap<MeanElapsedTime, CompositeTime>");

		map = new OrderedMap<MeanElapsedTime, CompositeTime>();
		fill(map);
		print(map, "gefuellte Map:");

		mapIter = map.iterator();
		mapIter.next();
		objIter = mapIter.iterator();

		objIter.add(new CompositeTime(new Double[] { 3., 1., 2., 4. }));
		print(map,
				"fuege neue CompositeTime zur ersten MeanElapsedTime hinzu (am Anfang):");

		objIter.next();
		objIter.remove();
		print(map, "loesche CompositeTime nach der neu eingefuegten:");

		map.insert(meanTime = new MeanElapsedTime());
		print(map, "fuege eine neue, leere MeanElapsedTime zu Map hinzu:");
		
		meanTime.addMeassurement(30);
		print(map, "fuege einen Messwert zur neuen MeanElapsedTime hinzu:");
	}
	
	private static void test3() {
		OrderedMap<MeanElapsedTime, CompositeTime> map;
		MapIterator<MeanElapsedTime, CompositeTime> mapIter;
		ListIterator<CompositeTime> objIter;
		MeanElapsedTime meanTime;

		printTestHeader(3, "teste OrderedSet<MeanElapsedTime>");

		map = new OrderedMap<MeanElapsedTime, CompositeTime>();
		fill(map);
		print(map, "gefuellte Map:");
		
		Set.OrderedSet<MeanElapsedTime> orderedSet = map;
		Iterator<MeanElapsedTime> setIter = orderedSet.iterator();
		
		meanTime = new MeanElapsedTime();
		meanTime.addMeassurement(4.2);
		meanTime.addMeassurement(2.1);
		meanTime.addMeassurement(8.4);
		
		orderedSet.insert(meanTime);
		
		meanTime = new MeanElapsedTime();
		meanTime.addMeassurement(1.1);
		meanTime.addMeassurement(2.2);
		meanTime.addMeassurement(4.4);
		meanTime.addMeassurement(8.8);
		
		orderedSet.insert(meanTime);
		
		meanTime = new MeanElapsedTime();
		meanTime.addMeassurement(2.4);
		meanTime.addMeassurement(4.7);
		meanTime.addMeassurement(7.8);
		
		orderedSet.insert(meanTime);
		
	private static void test4() {
		
		Set.OrderedSet<ElapsedTime> ose4 = new Set.OrderedSet<ElapsedTime>();
		OrderedMap<MeanElapsedTime, CompositeTime> mt4 = new OrderedMap<MeanElapsedTime, CompositeTime>();
		fill(mt4);
		MapIterator<MeanElapsedTime, CompositeTime> meat = mt4.iterator();
		while(meat.hasNext())
		{
			MeanElapsedTime et = meat.next();
			ose4.insert(et);
			Iterator<CompositeTime> citi = meat.iterator();
			while(citi.hasNext())
			{
				ose4.insert(citi.next());
			}
		}
		printTestHeader(4, "Koeglers Test");
		print(ose4);
		
		
		
		
	}
	
	private static void print(Set.OrderedSet<ElapsedTime> orset)
	{
		Iterator<ElapsedTime> iti = orset.iterator();
		
		while(iti.hasNext())
		{
			System.out.println(iti.next().count());
		}
	}
}
