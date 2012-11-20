/**
 * Stellt die Moeglichkeit zur verfuegung Messwerte mit doppelter Genauigkeit zu
 * speichern, die nicht Veraenderbar sind.
 * 
 * @author Koegler Alexander
 * 
 */
public class CompositeTime extends ElapsedTime {
	//Invariante: times ist nicht null und enthaelt nur Werte ungleich null
	private Double[] times;

	/**
	 * Erstellt neues Objekt mit den folgenden Messwerten
	 * 
	 * Vorbedingung: Parameter times ist nicht null und enthaelt nur Werte ungleich null
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
	 */
	protected double getTime() {
		double ret = 0;
		for (Double db : times) {
			ret += db;
		}
		return ret;
	}

	/**
	 * Gibt den kleinsten Messwert zurueck oder +Infinity, wenn keine Messwerte
	 * vorhanden sind.
	 * 
	 * @return kleinster Messwert
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
