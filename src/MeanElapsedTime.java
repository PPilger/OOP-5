package src;

public class MeanElapsedTime extends ElapsedTime{

	public MeanElapsedTime(){
		
	}
	
	Set<Double> meassurement = new Set<Double>();
	
	//@Override
	public boolean shorter(ElapsedTime other) {
		if(this.getTime() < other.getTime())
			return true;
		return false;
	}

	//@Override
	public int count() {
		int cnt = 0;
		for(Double db: meassurement)
		{
			cnt++;
		}
		return cnt;
	}
	
	public void addMeassurement(Double meassurement)
	{
		this.meassurement.add(meassurement);
	}
	
	public Double maxMeassurement()
	{
		Iterator<Double> iti = meassurement.Iterator();
		Double ret;
		while(iti.hasNext())
		{
			ret = iti.next();
		}
		return ret;
	}

	private Double getTime()
	{
		Double ret = 0.0;
		for(Double db : meassurement)
		{
			ret += db;
		}
		return ret / (double)count();
	}
}
