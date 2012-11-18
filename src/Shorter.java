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
	/**
	 * NOTE: Vergleicht zwei Objekte miteinander
	 * 
	 * Vorbedingung: other darf nicht NULL sein.
	 * 
	 * @param other
	 * @return
	 * 		TRUE, wenn other kleiner ist als das derzeitige Objekt
	 */
	public boolean shorter(P other);
}
