import java.util.Iterator;

public class Test {
	private static Set.OrderedSet<Description> set;
	private static OrderedMap<MeanElapsedTime, CompositeTime> map;

	public static void main(String[] args) {
		set = new Set.OrderedSet<Description>();
		map = new OrderedMap<MeanElapsedTime, CompositeTime>();
		fillMap();

		test1();
		test2();
		test3();
		test4();
	}

	private static void test1() {
		Iterator<Description> iti;
		Description die = new Description("Die");
		Description katz = new Description("Katz");

		printTestHeader(1, "teste OrderedSet<Description>");

		set.insert(new Description("Hoppala!"));
		set.insert(die);
		set.insert(katz);
		set.insert(new Description("ist da!"));
		
		/**
		 * gefuelltes Set:
		 * Die
		 * Katz
		 * ist da!
		 * Hoppala!
		 * Anzahl der Zeilen: 4
		 */
		printDescription(set, "gefuelltes Set:");

		set.insert(new Description("Abcdefg"));
		
		/**
		 * gueltigen Eintrag 'Abcdefg' hinzufuegen:
		 * Die
		 * Katz
		 * ist da!
		 * Abcdefg
		 * Hoppala!
		 * Anzahl der Zeilen: 5
		 */
		printDescription(set, "gueltigen Eintrag 'Abcdefg' hinzufuegen:");

		set.insert(die);
		
		/**
		 * bereits vorhandenen Eintrag 'Die' hinzufuegen (identisch):
		 * Die
		 * Katz
		 * Abcdefg
		 * ist da!
		 * Hoppala!
		 * Anzahl der Zeilen: 5
		 */
		printDescription(set,
				"bereits vorhandenen Eintrag 'Die' hinzufuegen (identisch):");

		set.insert(new Description("Die"));
		
		/**
		 * bereits vorhandenen Eintrag 'Die' hinzufuegen (nicht identisch):
		 * Die
		 * Die
		 * Katz
		 * ist da!
		 * Abcdefg
		 * Hoppala!
		 * Anzahl der Zeilen: 6
		 */
		printDescription(set,
				"bereits vorhandenen Eintrag 'Die' hinzufuegen (nicht identisch):");

		iti = set.iterator();
		while (iti.hasNext()) {
			Description tmp = iti.next();
			if (tmp == katz) {
				iti.remove();
			}
		}

		/**
		 * vorhandenen Eintrag 'Katz' loeschen:
		 * Die
		 * Die
		 * ist da!
		 * Abcdefg
		 * Hoppala!
		 * Anzahl der Zeilen: 5
		 */
		printDescription(set, "vorhandenen Eintrag 'Katz' loeschen:");
	}

	private static void test2() {
		MapIterator<MeanElapsedTime, CompositeTime> mapIter;
		ListIterator<CompositeTime> objIter;
		MeanElapsedTime meanTime;

		printTestHeader(2, "teste OrderedMap<MeanElapsedTime, CompositeTime>");

		/**
		 * gefuellte Map:
		 * maxMeasurement: 12.0, shortestTimes: [2.4, 5.3]
		 * maxMeasurement: 64.8, shortestTimes: [1.7, 3.4, 1.7, 5.1]
		 * maxMeasurement: 44.4, shortestTimes: [9.3, 0.5]
		 */
		printMap(map, "gefuellte Map:");

		mapIter = map.iterator();
		mapIter.next();
		objIter = mapIter.iterator();

		objIter.add(new CompositeTime(new Double[] { 3., 1., 2., 4. }));
		
		/**
		 * fuege neue CompositeTime zur ersten MeanElapsedTime hinzu (am Anfang):
		 * maxMeasurement: 12.0, shortestTimes: [1.0, 2.4, 5.3]
		 * maxMeasurement: 64.8, shortestTimes: [1.7, 3.4, 1.7, 5.1]
		 * maxMeasurement: 44.4, shortestTimes: [9.3, 0.5]
		 */
		printMap(map,
				"fuege neue CompositeTime zur ersten MeanElapsedTime hinzu (am Anfang):");

		objIter.next();
		objIter.remove();
		
		/**
		 * loesche CompositeTime nach der neu eingefuegten:
		 * maxMeasurement: 12.0, shortestTimes: [1.0, 5.3]
		 * maxMeasurement: 64.8, shortestTimes: [1.7, 3.4, 1.7, 5.1]
		 * maxMeasurement: 44.4, shortestTimes: [9.3, 0.5]
		 */
		printMap(map, "loesche CompositeTime nach der neu eingefuegten:");

		map.insert(meanTime = new MeanElapsedTime());
		
		/**
		 * fuege eine neue, leere MeanElapsedTime zu Map hinzu:
		 * maxMeasurement: 0.0, shortestTimes: []
		 * maxMeasurement: 12.0, shortestTimes: [1.0, 5.3]
		 * maxMeasurement: 64.8, shortestTimes: [1.7, 3.4, 1.7, 5.1]
		 * maxMeasurement: 44.4, shortestTimes: [9.3, 0.5]
		 */
		printMap(map, "fuege eine neue, leere MeanElapsedTime zu Map hinzu:");

		meanTime.addMeassurement(30);
		
		/**
		 * fuege einen Messwert zur neuen MeanElapsedTime hinzu:
		 * maxMeasurement: 12.0, shortestTimes: [1.0, 5.3]
		 * maxMeasurement: 30.0, shortestTimes: []
		 * maxMeasurement: 64.8, shortestTimes: [1.7, 3.4, 1.7, 5.1]
		 * maxMeasurement: 44.4, shortestTimes: [9.3, 0.5]
		 */
		printMap(map, "fuege einen Messwert zur neuen MeanElapsedTime hinzu:");
	}

	private static void test3() {
		MeanElapsedTime meanTime;

		printTestHeader(3, "teste OrderedSet<MeanElapsedTime>");

		/**
		 * OrderedMap:
		 * maxMeasurement: 12.0, shortestTimes: [1.0, 5.3]
		 * maxMeasurement: 30.0, shortestTimes: []
		 * maxMeasurement: 64.8, shortestTimes: [1.7, 3.4, 1.7, 5.1]
		 * maxMeasurement: 44.4, shortestTimes: [9.3, 0.5]
		 */
		printMap(map, "OrderedMap:");

		Set.OrderedSet<MeanElapsedTime> orderedSet = map;

		/**
		 * OrderedMap auf OrderedSet gecastet:
		 * 12.0
		 * 30.0
		 * 64.8
		 * 44.4
		 */
		printMeanElapsedTime(orderedSet, "OrderedMap auf OrderedSet gecastet:");

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

		/**
		 * nach hinzufuegen 3 neuer MeanElapsedTime-Objekte:
		 * 8.8
		 * 8.4
		 * 7.8
		 * 12.0
		 * 30.0
		 * 64.8
		 * 44.4
		 */
		printMeanElapsedTime(orderedSet,
				"nach hinzufuegen 3 neuer MeanElapsedTime-Objekte:");
	}

	private static void test4() {
		printTestHeader(4, "teste OrderedSet<ElapsedTime>");

		Set.OrderedSet<ElapsedTime> set = new Set.OrderedSet<ElapsedTime>();
		MapIterator<MeanElapsedTime, CompositeTime> mapIter;

		mapIter = map.iterator();
		while (mapIter.hasNext()) {
			MeanElapsedTime mtime = mapIter.next();
			Iterator<CompositeTime> objIter;
			
			set.insert(mtime);

			objIter = mapIter.iterator();
			while (objIter.hasNext()) {
				set.insert(objIter.next());
			}
		}

		
		/**
		 * alle ElapsedTime-Objekte aus Testfall 2 und 3:
		 * 4
		 * 3
		 * 3
		 * 1
		 * 3
		 * 1
		 * 4
		 * 3
		 * 3
		 * 2
		 * 2
		 * 4
		 * 1
		 * 3
		 * 3
		 */
		printElapsedTimeSet(set,
				"alle ElapsedTime-Objekte aus Testfall 2 und 3:");

	}

	private static void fillMap() {
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
				compIter.add(new CompositeTime(new Double[] { 8.3, 3.4 }));
				compIter.add(new CompositeTime(new Double[] { 3.9, 1.7, 5.2 }));
				compIter.add(new CompositeTime(new Double[] { 5.1, 9.3 }));
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
				compIter.add(new CompositeTime(new Double[] { 8.5, 2.4 }));
				compIter.add(new CompositeTime(new Double[] { 5.3 }));
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
				compIter.add(new CompositeTime(new Double[] { 9.3 }));
				compIter.add(new CompositeTime(new Double[] { 1.3, 5.8, 7.1,
						0.5 }));
			}
		}

	}

	private static void printTestHeader(int num, String description) {
		System.out.println();
		System.out.println();
		System.out.println("Test " + num + ":");
		System.out.println(description);
	}

	private static void printDescription(Set<Description> set,
			String description) {
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

	private static void printElapsedTimeSet(Set<ElapsedTime> set,
			String description) {
		Iterator<ElapsedTime> iti = set.iterator();

		System.out.println();
		System.out.println(description);

		while (iti.hasNext()) {
			System.out.println(iti.next().count());
		}
	}

	private static void printMeanElapsedTime(Set<MeanElapsedTime> set,
			String description) {
		Iterator<MeanElapsedTime> iti = set.iterator();

		System.out.println();
		System.out.println(description);

		while (iti.hasNext()) {
			System.out.println(iti.next().maxMeassurement());
		}
	}

	private static void printMap(
			OrderedMap<MeanElapsedTime, CompositeTime> map, String description) {
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
}
