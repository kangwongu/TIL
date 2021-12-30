package thirdEdition.exercise;

public class Exercise6_24 {
	public static int abs(int value) {
		return value > 0 ? value : (value==0 ? 0 : -value);
	}
	
	public static void main(String[] args) {
		int value=5;
		System.out.println(abs(value));
		value = -10;
		System.out.println(abs(value));
	}
}


