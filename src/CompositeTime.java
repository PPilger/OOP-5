public class CompositeTime extends ElapsedTime {

	private Double[] times;

	public CompositeTime(Double[] times) {
		this.times = times;
	}

	@Override
	public int count() {
		return times.length;
	}

	@Override
	protected double getTime() {
		double ret = 0;
		for (Double db : times) {
			ret += db;
		}
		return ret;
	}

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
