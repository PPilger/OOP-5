/**
 * Stellt die Moeglichkeit zur verfuegung Messwerte mit doppelter Genauigkeit zu
 * speichern, die nicht Veraenderbar sind.
 * 
 * @author Koegler Alexander
 * 
 */
public class CompositeTime extends ElapsedTime {

	private Double[] times;

	/**
	 * Erstellt neues Objekt mit den folgenden Messwerten
	 * 
	 * @param times
	 *            Messwerte
	 */
	public CompositeTime(Double[] times) {
		this.times = times;
	}

	/**
	 * Zaehtl die Anzahl der Messwerte
	 * 
	 * @return Anzahl der Messwerte
	 */
	@Override
	public int count() {
		return times.length;
	}

	@Override
	/**
	 * Gibt die Zeit fuer diesen Typ zurueck, der die Summe aller Messwerte ist.
	 * Nachbedingung: Wert groeszer gleich 0 wird zurueckgegeben, 0 sofern keine Messwerte vorhanden sind.
	 */
	protected double getTime() {
		double ret = 0;
		for (Double db : times) {
			ret += db;
		}
		return ret;
	}

	/**
	 * Gibt den kleinsten Messwert zurueck
	 * 
	 * @return kleinster Messwert Nachbedingung: gibt den kleinsten Messwert
	 *         zurueck, Positive_Infinity sofern keine Messwerte vorhanden sind
	 */
	public Double shortestTime() {
		Double ret = Double.POSITIVE_INFINITY;
		for (Double db : times) {
			if (db < ret) {
				ret = db;
			}
		}
		return ret;
	}

}
