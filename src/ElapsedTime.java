
public abstract class ElapsedTime implements Shorter<ElapsedTime>{
	public abstract int count();
	
	protected abstract double getTime();
	
	public boolean shorter(ElapsedTime t) {
		return this.getTime() < t.getTime();
	}
}
