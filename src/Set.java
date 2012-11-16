import java.util.Iterator;

public class Set<P> implements Iterable<P> {
	private ListIterable<P> iterable;

	public Set() {
		this(new LinkedList<P>());
	}

	Set(ListIterable<P> iterable) {
		this.iterable = iterable;
	}

	public void insert(P element) {
		if(contains(element)) {
			return;
		}

		iterable.iterator().insert(element);
	}
	
	public boolean contains(P element) {
		for (P c : iterable) {
			if (c == element) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<P> iterator() {
		return iterable.iterator();
	}
}
