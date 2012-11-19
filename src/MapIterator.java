import java.util.Iterator;

/**
 * Note: Stellt einen Iterator ueber eine Map dar.
 * 
 * @author Peter Pilgerstorfer
 * 
 * @param <P>
 *            der Typ des Iterators
 * @param <O>
 *            der Typ der fuer jedes Element gespeicherten Objekte
 */
public interface MapIterator<P, O> extends Iterator<P> {
	/**
	 * @return ein Iterator ueber die Objekte des aktuellen Elements
	 */
	public ListIterator<O> iterator();
}
