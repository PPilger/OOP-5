package src;

public class CompositeTime extends ElapsedTime{

	private Double[] times;
	
	public CompositeTime(Double[] times)
	{
		this.times = times;
	}
	
	@Override
	public boolean shorter(ElapsedTime other) {
		if(this.getTime() < other.getTime())
			return true;
		return false;
	}

	@Override
	public int count() {
		return times.length;
	}
	
	public Double getTime()
	{
		Double ret = 0.0;
		for(Double db : times)
		{
			ret += db;
		}
		return ret;
	}
	
	public Double shortestTime()
	{
		Double ret = Double.infinity;
		for(Double db : times)
		{
			if(db < ret)
				ret = db;
		}
		return ret;
	}

}
