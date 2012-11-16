public class OrderedSet<P extends Shorter<P>> extends Set<P> {
	private ListIterable<P> iterable;

	public OrderedSet() {
		this(new LinkedList<P>());
	}

	OrderedSet(ListIterable<P> iterable) {
		super(iterable);

		this.iterable = iterable;
	}

	@Override
	public void insert(P element) {
		if (contains(element)) {
			return;
		}

		ListIterator<P> iter = iterable.iterator();
		while (iter.hasNext() && element.shorter(iter.next())) {
		}
		iter.insert(element);
	}
}
