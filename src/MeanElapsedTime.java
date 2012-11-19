import java.util.Iterator;
/**
 * Stellt die Moeglichkeit zur Verfuegung Messwerte mit doppelter Genauigkeit abzuspeichern.  
 * @author Koegler Alexander
 *
 */
public class MeanElapsedTime extends ElapsedTime {

	Set<Double> meassurement = new Set<Double>();

	// @Override
	/**
	 * Zaehlt die enthaltenen Messwerte
	 * Nachbedingung: gibt Zahl groeszer gleich 0 zurueck
	 */
	public int count() {
		Iterator<Double> iti = meassurement.iterator();
		int cnt = 0;
		while(iti.hasNext()) {
			iti.next();
			cnt++;
		}
		return cnt;
	}

	/**
	 * Fuegt ein Objekt zu den Messwerten hinzu, sofern es nicht bereits eingefuegt wurde.
	 * @param meassurement Das hinzuzufuegende Objekt
	 */
	public void addMeassurement(double meassurement) {
		this.meassurement.insert(meassurement);
	}

	/**
	 * Gibt den hoechsten Messwert aus
	 * @return Peak
	 * Nachbedingung: gibt Zahl groeszer 0 zurueck, gibt 0 zurueck falls keine Messwerte vorhanden sind.
	 */
	public double maxMeassurement() {
		Iterator<Double> iti = meassurement.iterator();
		double ret = 0;

		while (iti.hasNext()) {
			Double cur = iti.next();
			if (ret < cur) {
				ret = cur;
			}
		}

		return ret;
	}

	/**
	 * DIe Zeit ist fuer diesen Typ der Durchschnittswert aller gespeicherten Messwerte
	 * Nachbedingung: gibt Zahl groeszer gleich 0 zurueck
	 */
	protected double getTime() {
		double ret = 0;
		for (Double db : meassurement) {
			ret += db;
		}
		return ret / (double) count();
	}
}
