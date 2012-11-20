import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Note: Eine Menge an Elementen, zu denen wiederum mehrere Objekte gespeichert
 * werden koennen.
 * 
 * @author Peter Pilgerstorfer
 * 
 * @param <P>
 *            Typ der gespeicherten Elemente.
 * @param <O>
 *            Typ der zu jedem Objekt gespeicherten Elemente
 */
public class OrderedMap<P extends Shorter<? super P>, O> extends Set.OrderedSet<P> {
	// Note: list enthaelt zu Eintraegen in der Superklasse eine Liste an
	// Objekten.
	private LinkedList<Mapping> map = new LinkedList<Mapping>();

	@Override
	public MapIterator<P, O> iterator() {
		final Iterator<P> iter = super.iterator();
		return new MapIterator<P, O>() {
			// Note: current zeigt auf das zuletzt gelesene Element oder null.
			private P current = null;

			/**
			 * @returns liefert true, wenn der Iterator weitere Elemente hat
			 */
			@Override
			public boolean hasNext() {
				return iter.hasNext();
			}

			/**
			 * Note: Liefert das naechste Element
			 * 
			 * @throws NoSuchElementException
			 *             wenn keine weiteren Elemente verfuegbar sind
			 */
			@Override
			public P next() {
				current = iter.next();
				return current;
			}

			/**
			 * Note: Entfernt das Element, das zuletzt mit next() ausgelesen
			 * wurde. remove() kann nur einmal nach einem Aufruf von next()
			 * aufgerufen werden.
			 * 
			 * @throws IllegalStateException
			 *             next() wurde noch nie aufgerufen, oder removed wurde
			 *             mehr als einmal nach dem letzten Aufruf von next()
			 *             aufgerufen.
			 */
			@Override
			public void remove() {
				// Note: Entferne den Eintrag aus der Map (sofern er existiert).
				Iterator<Mapping> mapIter = map.iterator();
				while (mapIter.hasNext()) {
					if (mapIter.next().key == current) {
						mapIter.remove();
						break;
					}
				}

				iter.remove();
			}

			/**
			 * @return ein Iterator ueber die Objekte des aktuellen Elements
			 */
			@Override
			public ListIterator<O> iterator() {
				LinkedList<O> objects = null;

				// Note: Wenn es bereits ein mapping gibt, wird dieses verwendet.
				for (Mapping mapping : map) {
					if (mapping.key == current) {
						objects = mapping.objects;
						break;
					}
				}

				// Note: Wenn es noch kein Mapping gibt, wird ein neues erzeugt.
				if (objects == null) {
					Mapping mapping = new Mapping(current);
					map.iterator().add(mapping);
					
					objects = mapping.objects;
				}

				return objects.iterator();
			}
		};
	}

	private class Mapping {
		private P key;
		private LinkedList<O> objects;

		private Mapping(P key) {
			this.key = key;
			this.objects = new LinkedList<O>();
		}
	}
}
