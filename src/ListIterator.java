import java.util.Iterator;

/**
 * Stellt einen Iterator ueber eine Liste dar. Es koennen Elemente ausgelesen,
 * eingefuegt und entfernt werden.
 * 
 * @author Peter Pilgerstorfer
 * 
 * @param <T>
 */
public interface ListIterator<T> extends Iterator<T> {
	/**
	 * Note: Fuegt das angegebene Element in die Liste ein. Das Element wird
	 * unmittelbar vor dem naechsten Element, das von next() zurueckgegeben
	 * wird, eingefuegt. Wenn es kein naechstes Element gibt, wird an das Ende
	 * der Liste angehaengt.
	 */
	public void add(T value);
}
