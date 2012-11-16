
public class LinkedList<C> implements ListIterable<C> {
	private Node first;

	@Override
	public ListIterator<C> iterator() {
		return new ListIterator<C>() {
			private Node prev = null;
			private Node pos = first;

			@Override
			public boolean hasNext() {
				return pos != null;
			}

			@Override
			public C next() {
				C nextVal = pos.value;
				
				prev = pos;
				pos = pos.next;
				
				return nextVal;
			}

			@Override
			public void remove() {
				prev.next = pos.next;
				pos.next = null;
				
				pos = prev.next;
			}

			public void insert(C value) {
				Node newNode = new Node(value);

				newNode.next = pos;

				if (prev == null) {
					first = newNode;
				} else {
					prev.next = newNode;
				}
				
				prev = newNode;
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
