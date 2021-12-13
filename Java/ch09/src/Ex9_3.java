
public class Ex9_3 {
	public static void main(String[] args) {
		// equals()메소드 오버라이딩 -> hashCode()메소드도 오버라이딩
		
		String str1 = new String("abc");
		String str2 = new String("abc");
		
		String str3 = "abc";
		String str4 = "abc";
		
		
		// String클래스는 재정의 되어있음
		System.out.println(str1==str2);
		System.out.println(str3==str4);
		System.out.println(str1.equals(str2));
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
	}

}

