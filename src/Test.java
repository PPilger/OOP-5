
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("Hello Java!");
CompositeTime ct = new  CompositeTime(new Double[] {12.6, 45.245, 16.344, 3.2});
System.out.print(ct.count());

		Shorter<? super CompositeTime> s = new CompositeTime(new Double[] {0.0});
	}

}
