import java.util.Iterator;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Java!");
		CompositeTime ct2 = new CompositeTime(new Double[] { 12.6, 45.245,
				16.344, 3.2 });
		System.out.print(ct2.count());

		Shorter<? super CompositeTime> s = new CompositeTime(
				new Double[] { 0.0 });

		// Offizielle TEsts
		// OrderedSet
		Set.OrderedSet<Description> oset = new Set.OrderedSet<Description>();
		oset.insert(new Description("Hoppala!"));
		oset.insert(new Description("Die"));
		oset.insert(new Description("Katz"));
		oset.insert(new Description("ist da!"));
		Iterator<Description> iti = oset.iterator();
		while (iti.hasNext()) {
			System.out.println(iti.next().toString());
		}
		System.out.println("Anzahl der Zeilen ?");
		oset.insert(new Description("Abcdefg"));
		
		iti = oset.iterator();
		while (iti.hasNext()) {
			Description tmp = iti.next();
			if (tmp.equals("Katz")) {
				iti.remove();
			} else {
				System.out.println(tmp.toString());
			}
		}
		System.out.println("Anzahl der Zeilen ?");

		// OrderedMAp
		OrderedMap<MeanElapsedTime, CompositeTime> omap = new OrderedMap<MeanElapsedTime, CompositeTime>();
		MeanElapsedTime meat;
		omap.insert(meat = new MeanElapsedTime());
		meat.addMeassurement(17.3);
		meat.addMeassurement(0.0045);
		meat.addMeassurement(64.8);
		meat.addMeassurement(9.3);
		MapIterator<MeanElapsedTime, CompositeTime> mapIter = omap.iterator();
		CompositeTime ct;Iterator<CompositeTime> coIti;
		while(mapIter.hasNext())
		{
			coIti = mapIter.iterator();
			while(coIti.hasNext())
			{
				ct = coIti.next();
				System.out.println(ct.count() + " gezaehlt, ShortestTime" + ct.shortestTime());
			}
		}
		meat.addMeassurement(57.345);
		mapIter = omap.iterator();
		while(mapIter.hasNext())
		{
			coIti = mapIter.iterator();
			while(coIti.hasNext())
			{
				ct = coIti.next();
				System.out.println(ct.count() + " gezaehlt, ShortestTime" + ct.shortestTime());
			}
		}
		

	}

}
