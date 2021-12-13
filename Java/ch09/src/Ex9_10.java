import java.util.StringJoiner;

public class Ex9_10 {
	public static void main(String[] args) {
		// 기본형 -> 문자열, valueOf()사용
		int iVal = 100;
		String strVal = String.valueOf(iVal);
		System.out.println(strVal);
		
		// 기본형 -> 문자열, valueOf()사용
		double dVal = 200.0;
		String strVal2 = String.valueOf(dVal);
		System.out.println(strVal2);
		
		// 기본형 -> 문자열, + "" 사용
		int iVal3 = 150;
		String strVal5 = iVal3 + "";
		System.out.println(strVal5);
		
		// 문자열 -> 기본형, parseXXX()사용
		String strVal3 = "150";
		int iVal2 = Integer.parseInt(strVal3);
		System.out.println(iVal2);
		
		// 문자열 -> 기본형, valueOf()사용
		String strVal4 = "250.0";
		double dVal2 = Double.valueOf(strVal4);
		System.out.println(dVal2);
		
		
		
	}

}

