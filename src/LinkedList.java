import java.util.NoSuchElementException;

/**
 * Note: Die Implementierung einer verketteten Liste.
 * 
 * @author Peter Pilgerstorfer
 * 
 * @param <C>
 *            Der Typ der in der Liste gespeicherten Elemente.
 */
public class LinkedList<C> implements Iterable<C> {
	private Node first; // Note: der Anfangsknoten, oder null (bei leerer Liste)

	/**
	 * Note: Liefert einen neuen ListIterator ueber den Elemente abgefragt,
	 * eingefuegt oder geloescht werden koennen.
	 */
	@Override
	public ListIterator<C> iterator() {
		return new ListIterator<C>() {
			// Invariante: prev, cur und next zeigen auf ein Element der Liste
			// oder auf null

			// Note: Zeigt auf das Element vor dem zuletzt ausgelesenen.
			// Note: Ausnahme: Nach dem Entfernen eines Elements gilt (prev ==
			// cur)
			private Node prev = null;

			// Note: Zeigt auf das zuletzt ausgelesene Element.
			// Invariante: Wenn cur != null ist, gilt cur.next == next.
			// Invariante: Anderenfalls ist next das erste Element.
			private Node cur = null;

			// Note: zeigt auf das naechste Element dass ausgelesen wird (oder
			// null am Listenende).
			private Node next = first;

			/**
			 * @returns liefert true, wenn der Iterator weitere Elemente hat
			 */
			@Override
			public boolean hasNext() {
				return next != null;
			}

			/**
			 * Note: Liefert das naechste Element der Liste.
			 * 
			 * @throws NoSuchElementException
			 *             wenn keine weiteren Elemente verfuegbar sind
			 */
			@Override
			public C next() {
				if (next == null) {
					throw new NoSuchElementException();
				}

				prev = cur;
				cur = next;
				next = next.next;

				return cur.value;
			}

			/**
			 * Note: Entfernt das Element das zuletzt mit next() ausgelesen
			 * wurde. Wenn remove() nach add() aufgerufen wird, wird das
			 * hinzugefuegte Element entfernt. remove() kann nur einmal nach
			 * einem Aufruf von next() oder add() aufgerufen werden.
			 * 
			 * @throws IllegalStateException
			 *             Es wurden weder next() noch add() vorher aufgerufen,
			 *             oder removed wurde mehr als einmal nach dem letzten
			 *             Aufruf von next() oder add() aufgerufen.
			 */
			// Nachbedingung: Nach dem Entfernen zeigen prev und cur auf das
			// Element vor next.
			// Nachbedingung: next bleibt unveraendert.
			@Override
			public void remove() {
				// Zusicherung: falls das naechste Element das erste ist, gilt:
				// cur, prev == null
				if (cur == prev) {
					throw new IllegalStateException();
				}

				if (prev == null) {
					// Note: das erste Element wird entfernt
					first = next;
				} else {
					prev.next = next;
				}

				cur = prev;
			}

			/**
			 * Fuegt das angegebene Element in die Liste ein. Das Element wird
			 * unmittelbar vor dem naechsten Element, das von next()
			 * zurueckgegeben wird, eingefuegt. Wenn es kein naechstes Element
			 * gibt, wird an das Ende der Liste angehaengt.
			 */
			@Override
			public void add(C value) {
				Node newNode = new Node(value);

				newNode.next = next;

				if (cur == null) {
					first = newNode;
				} else {
					cur.next = newNode;
				}

				prev = cur;
				cur = newNode;
			}
		};
	}

	/**
	 * Note: Ein Knoten der Liste
	 * 
	 * @author Peter Pilgerstorfer
	 * 
	 */
	private class Node {
		private C value;
		private Node next;

		private Node(C value) {
			this.value = value;
		}
	}
}
