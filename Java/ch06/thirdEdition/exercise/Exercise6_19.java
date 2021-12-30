package thirdEdition.exercise;

public class Exercise6_19 {
	public static void main(String[] args) {
		String str = "ABC123";
		System.out.println(str);
		change(str);
		// 매개변수로 넘겨준 str은 변경되어서 새로운 주소 참조
		// 기존의 str은 같은 값을 참조
		System.out.println("After change : "+str);
	}
	
	public static void change(String str) {
		// 문자열 연산을 하면서 새로운 문자열이 생성됨 "ABC123456" -> 주소변경
		str += "456";
	}
}


