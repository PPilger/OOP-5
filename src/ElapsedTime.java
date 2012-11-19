package src;

public abstract class ElapsedTime implements Shorter<ElapsedTime>{

	public ElapsedTime()
	{
		this();
	}
	public abstract int count();
	protected abstract Double getTime();
}
