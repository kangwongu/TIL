package thirdedition;

import java.text.DecimalFormat;
import java.text.ParseException;

public class DecimalFormatEx2 {
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("#,###.##");
		DecimalFormat df2 = new DecimalFormat("#.###E0");
		DecimalFormat df3 = new DecimalFormat("-#.#");
		
		try {
			// df -> Number
			Number num = df.parse("1,234,567.899");
			System.out.println(num);
			
			// Number -> double
			double d = num.doubleValue();
			System.out.println(d);
			
			// Number -> df2
			System.out.println(df2.format(num));
			
			System.out.println(df3.format(num));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
