import java.util.NoSuchElementException;

public class LinkedList<C> implements Iterable<C> {
	private Node first;

	public ListIterator<C> iterator() {
		return new ListIterator<C>() {
			private Node prev = null;
			private Node cur = null;
			private Node next = first;

			/**
			 * Returns true if this list iterator has more elements.
			 */
			@Override
			public boolean hasNext() {
				return next != null;
			}

			/**
			 * Returns the next element in the list.
			 * 
			 * @throws NoSuchElementException
			 *             if no more elements are available
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
			 * Removes from the list the last element that was returned by next.
			 * If remove is called after add, the inserted value will be
			 * removed. This call can only be made once per call to next or add.
			 * 
			 * @throws IllegalStateException
			 *             next has not been called
			 */
			@Override
			public void remove() {
				if (cur == null) {
					throw new IllegalStateException();
				}

				prev.next = next;
				cur = prev;
			}

			/**
			 * Inserts the specified element into the list. The element is
			 * inserted immediately before the next element that would be
			 * returned by next, if any.
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

	private class Node {
		private C value;
		private Node next;

		private Node(C value) {
			this.value = value;
		}
	}
}
