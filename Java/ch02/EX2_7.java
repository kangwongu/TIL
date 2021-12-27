
public class EX2_7 {

	public static void main(String[] args) {
		// 어떤 타입의 변수도 문자열과 덧셈연산을 수행하면 '문자열'이 됨!
		
		String name = "Ja" + "va";	// 문자열 + 문자열
		String str = name + 8.0;	// 문자열 + 실수형
		
		System.out.println(name);
		System.out.println(str);
		System.out.println(7 +" ");
		System.out.println(" " + 7);
		System.out.println(7 + "");
		System.out.println("" + 7);
		System.out.println(7 + 7 + "");
		System.out.println("" + 7 + 7);
		
	}

}
