import java.util.Iterator;

public interface MapIterator<P, O> extends Iterator<P> {
	 public ListIterator<O> iterator();
}
