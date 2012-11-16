import java.util.Iterator;

public class Set<P> implements Iterable<P> {
	private LinkedList<P> list = new LinkedList<P>();

	public boolean insert(P element) {
		if (contains(element)) {
			return false;
		}

		list.iterator().insert(element);
		return true;
	}

	public boolean contains(P element) {
		for (P c : list) {
			if (c == element) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<P> iterator() {
		return list.iterator();
	}

	public static class OrderedSet<P extends Shorter<P>> extends Set<P> {

		@Override
		public boolean insert(P element) {
			if (contains(element)) {
				return false;
			}

			ListIterator<P> iter = super.list.iterator();
			while (iter.hasNext() && element.shorter(iter.next())) {
			}
			iter.insert(element);
			return true;
		}
	}
}
