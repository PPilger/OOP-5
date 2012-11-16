import java.util.Iterator;

public class OrderedMap<P extends Shorter<P>, O> extends Set.OrderedSet<P> {
	private LinkedList<Map> list;

	@Override
	public MapIterator<P, O> iterator() {
		final Iterator<P> iter = super.iterator();
		return new MapIterator<P, O>() {
			private P current = null;
			
			@Override
			public boolean hasNext() {
				return iter.hasNext();
			}

			@Override
			public P next() {
				current = iter.next();
				return current;
			}

			@Override
			public void remove() {
				Iterator<Map> mapIter = list.iterator();
				
				while(mapIter.hasNext()) {
					if(mapIter.next().key == current) {
						mapIter.remove();
						break;
					}
				}
				
				iter.remove();
			}

			@Override
			public ListIterator<O> iterator() {
				LinkedList<O> objects = null;
				
				for(Map map : list) {
					if(map.key == current) {
						objects = map.objects;
						break;
					}
				}
				
				if(objects == null) {
					Map map = new Map(current);
					list.iterator().insert(map);
				}
				
				return objects.iterator();
			}
		};
	}

	private class Map {
		private P key;
		private LinkedList<O> objects;

		private Map(P key) {
			this.key = key;
			this.objects = new LinkedList<O>();
		}
	}
}
