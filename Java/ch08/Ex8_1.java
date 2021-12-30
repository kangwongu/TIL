
public class Ex8_1 {
	public static void main(String[] args) {
		// 예외 처리할 문장이 없는 정상적인 문장
		//
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(4);
			System.out.println(5);
		} catch (Exception e) {
			System.out.println(6);
			System.out.println(7);
		}
		System.out.println(8);
		
	}

}
