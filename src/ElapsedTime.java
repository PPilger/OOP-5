/**
 * @author Koegler Alexander
 * Bietet die Moeglichkeit Messwerte abzuspeichern, die mitienander verglichen werden koennen
 *
 */
public abstract class ElapsedTime implements Shorter<ElapsedTime>{
	/**
	 * Zaehlt Anzahl der Messwerte
	 * @return Anzahl
	 * Nachbedingung: Zahl groeszer gleich 0
	 */
	public abstract int count();
	
	/**
	 * Dient zur ermittlung der fuer shorter relevanten Messwerte
	 * @return
	 */
	protected abstract double getTime();
	
	/**
	 * Gibt zurueck ob das Objekt kuerzere Messwerte liefert als das uebergebene
	 * @return true wenn dieses Objekt kuerzere Messwerte aufweist, andernfalls false
	 */
	public boolean shorter(ElapsedTime t) {
		return this.getTime() < t.getTime();
	}
}
