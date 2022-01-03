package thirdedition.exercise;

public class Exercise9_7 {
	public static boolean contains(String src, String target) {
		return src.indexOf(target)!=-1;
	}
	
	
	public static void main(String[] args) {
		System.out.println(contains("12345", "12"));
		System.out.println(contains("12345", "67"));
	}
}