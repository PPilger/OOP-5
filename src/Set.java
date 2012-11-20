import java.util.Comparator;
import java.util.Iterator;

/**
 * Note: Eine Menge von Elementen.
 * 
 * @author Peter Pilgerstorfer
 * 
 * @param <P>
 *            Typ der gespeicherten Elemente.
 */
public class Set<P> implements Iterable<P> {
	// Invariante: list enthaelt keine Elemente gleich null
	private LinkedList<P> list = new LinkedList<P>();

	/**
	 * Note: Ueberprueft, ob ein Element in die Menge eingefuegt werden kann.
	 * Note: null kann nicht eingefuegt werden. Ein Element das bereits
	 * vorhanden ist kann ebensowenig eingefuegt werden.
	 * 
	 * @return true, wenn das Element eingefuegt werden kann, false
	 *         anderenfalls.
	 */
	private boolean canInsert(P element) {
		if (element == null) {
			return false;
		}

		for (P c : list) {
			if (c == element) {
				return false;
			}
		}

		return true;
	}

	/**
	 * @return true, wenn das Element eingefuegt wurde, false anderenfalls.
	 */
	public boolean insert(P element) {
		if (!canInsert(element)) {
			return false;
		}

		list.iterator().add(element);

		return true;
	}

	@Override
	public Iterator<P> iterator() {
		return list.iterator();
	}

	/**
	 * Note: Eine sortierte Menge an Elementen vom Typ P. Die Sortierung erfolgt
	 * nach der Laenge.
	 * 
	 * @author Peter Pilgerstorfer
	 */
	public static class OrderedSet<P extends Shorter<? super P>> extends Set<P> {

		/**
		 * Note: gibt einen Iterator zurueck, der ueber die sortierten Elemente
		 * iteriert.
		 */
		// Nachbedingung: list ist sortiert
		@Override
		public Iterator<P> iterator() {
			super.list.sort(new Comparator<P>() {

				@Override
				public int compare(P o1, P o2) {
					if (o1.shorter(o2)) {
						return -1;
					} else if (o2.shorter(o1)) {
						return 1;
					} else {
						return 0;
					}
				}
			});
			return super.iterator();
		}
	}
}
