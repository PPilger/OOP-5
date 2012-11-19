import java.util.Iterator;

public class MeanElapsedTime extends ElapsedTime {

	Set<Double> meassurement = new Set<Double>();

	// @Override
	public int count() {
		Iterator<Double> iti = meassurement.iterator();
		int cnt = 0;
		while(iti.hasNext()) {
			iti.next();
			cnt++;
		}
		return cnt;
	}

	public void addMeassurement(double meassurement) {
		this.meassurement.insert(meassurement);
	}

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

	protected double getTime() {
		double ret = 0;
		for (Double db : meassurement) {
			ret += db;
		}
		return ret / (double) count();
	}
}
