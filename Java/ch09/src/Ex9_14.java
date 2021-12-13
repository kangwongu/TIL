import static java.lang.Math.*;
import static java.lang.System.*;

public class Ex9_14 {
	public static void main(String[] args) {
		Integer i = new Integer(100);
		Integer i2 = new Integer(100);
		
		System.out.println(i==i2);
		System.out.println(i.equals(i2));
		System.out.println(i.compareTo(i2));
		System.out.println(i.toString());
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.SIZE);
		System.out.println(Integer.BYTES);
		System.out.println(Integer.TYPE);
		
		Double d = new Double(10.0);
		Double d2 = new Double(10.0);
		
		System.out.println(d==d2);
		System.out.println(d.equals(d2));
		System.out.println(d.toString());
		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.MIN_VALUE);
		System.out.println(Double.SIZE);
		System.out.println(Double.BYTES);
		System.out.println(Double.TYPE);
				
	}

}

