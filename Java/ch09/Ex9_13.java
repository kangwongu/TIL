import static java.lang.Math.*;
import static java.lang.System.*;

public class Ex9_13 {
	public static void main(String[] args) {
		double val = 90.7552;
		out.println("round("+val+")="+round(val));
		
		val *= 100;
		out.println(round(val));
		System.out.println(round(val)/100);
		System.out.println(round(val)/100.0);
		out.printf("ceil(%3.1f=%3.1f)\n", 1.1, ceil(1.1));
		
		double page = 12.6;
		System.out.println(ceil(page));
		System.out.println(floor(page));
		System.out.println(rint(page));
	}

}

