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
	//Invariante: list enthaelt keine Elemente gleich null
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
	public static class OrderedSet<P extends Shorter<P>> extends Set<P> {
		// Invariante: super.list ist sortiert

		/**
		 * Note: Fuegt das Element in die Menge ein, sodass die Sortierung
		 * erhalten bleibt.
		 * 
		 * @return true, wenn das Element eingefuegt werden kann, false
		 *         anderenfalls.
		 */
		@Override
		public boolean insert(P element) {
			ListIterator<P> iter;
			int index;

			if (!super.canInsert(element)) {
				return false;
			}

			// Note: Einfuegeindex bestimmen
			iter = super.list.iterator();
			index = 0;
			while (iter.hasNext() && iter.next().shorter(element)) {
				index++;
			}

			// Note: Zur Einfuegestelle navigieren
			iter = super.list.iterator();
			for (int i = 0; i < index; i++) {
				iter.next();
			}

			iter.add(element);

			return true;
		}
	}
}
