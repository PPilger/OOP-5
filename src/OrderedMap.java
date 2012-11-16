import java.util.Iterator;

public class OrderedMap<K extends Shorter<K>, O> extends OrderedSet<K>
		implements ListIterable<K> {
	private ListIterable<Map<K, O>> iterable;

	public OrderedMap() {
		this(new LinkedList<Map<K, O>>());
	}

	private OrderedMap(final ListIterable<Map<K, O>> iterable) {
		super(new ListIterable<K>() {

			@Override
			public ListIterator<K> iterator() {
				return new MapIterator<K, O>(iterable);
			}
		});

		this.iterable = iterable;
	}

	@Override
	public MapIterator<K, O> iterator() {
		return new MapIterator<K, O>(iterable);
	}

	private static class MapIterator<K, O> implements ListIterator<K>, ListIterable<O> {
		private ListIterator<Map<K, O>> iter;
		private Map<K, O> current = null;
		
		private MapIterator(ListIterable<Map<K, O>> iterable) {
			iter = iterable.iterator();
		}

		@Override
		public boolean hasNext() {
			return iter.hasNext();
		}

		@Override
		public K next() {
			current = iter.next();
			return current.key;
		}

		@Override
		public void remove() {
			iter.remove();
		}

		@Override
		public void insert(K key) {
			iter.insert(new Map<K, O>(key));
		}

		@Override
		public ListIterator<O> iterator() {
			return current.objects.iterator();
		}
	}

	private static class Map<K, O> {
		private K key;
		private LinkedList<O> objects;

		private Map(K key) {
			this.key = key;
			this.objects = new LinkedList<O>();
		}
	}
}
