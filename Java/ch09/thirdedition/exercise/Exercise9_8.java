package thirdedition.exercise;

public class Exercise9_8 {
	public static double round(double d, int n) {
		// d를 소수 n째 자리만큼 반올림
		return Math.round(d * Math.pow(10, n)) / Math.pow(10, n);
	}
	
	
	public static void main(String[] args) {
		System.out.println(round(3.1415, 1));
		System.out.println(round(3.1415, 2));
		System.out.println(round(3.1415, 3));
		System.out.println(round(3.1415, 4));
		System.out.println(round(3.1415, 5));
	}
}