
public class Description implements Shorter<Description> {
	
	private String text;
	
	public Description(String text) {
		this.text = text;
	}
	
	/**
	 * NOTE: Vergleicht die Laengen der Texte.
	 * 
	 * @Override
	 */
	public boolean shorter(Description other) {
		return this.text.length() < other.text.length();
	}

	public String toString() {
		return this.text;
	}
	
	public int lineCount() {
		return this.text.split("\n").length;
	}
	
	
}
