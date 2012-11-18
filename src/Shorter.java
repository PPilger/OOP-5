/**
 * NOTE: Die Methode shorter beschreibt nur, ob ein Objekt P kleiner ist
 * 		 als das derzeitige Objekt und gibt ein TRUE zurueck, sobald das Vergleichsobjekt
 * 		 kleiner ist als das derzeitige.
 * 
 * @author Christian Kletzander
 *
 * @param <P>
 * 		Beschreibt ein beliebiges Objekt - generischer Typ
 */
public interface Shorter<P> {
	public boolean shorter(P other);
}
