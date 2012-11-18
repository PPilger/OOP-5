/**
 * Untertyp von Shorter
 * 
 * @author Christian Kletzaner
 *
 */
public class Description implements Shorter<Description> {
	
	private String text;
	
	//Defniert einen Text
	public Description(String text) {
		this.text = text;
	}
	
	/**
	 * NOTE: Vergleicht die Laengen der Texte.
	 * 		 Wenn der uebergebene Text kleiner ist als
	 * 		 der Text vom derzeitigen Objekt, dann wird
	 * 		 TRUE zurueckgegeben.
	 * 
	 * @Override
	 */
	public boolean shorter(Description other) {
		return this.text.length() < other.text.length();
	}

	//Gibt den Text des Objekts zurueck
	public String toString() {
		return this.text;
	}
	
	//Gibt die Anzahl der Zeilen zurueck
	public int lineCount() {
		return this.text.split("\n").length;
	}
	
	
}
