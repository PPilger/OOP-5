import java.util.Iterator;

public interface ListIterator<T> extends Iterator<T> {
	/**
	 * Inserts the specified element into the list. The element is inserted
	 * immediately before the next element that would be returned by next, if
	 * any.
	 */
	public void add(T value);
}
