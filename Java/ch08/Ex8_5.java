
public class Ex8_5 {
	public static void main(String[] args) {
		// 예외를 발생시킨 후, catch블럭에서 printStackTrace, getMessage사용해보기
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0);
			System.out.println(4);
		} catch(ArithmeticException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(5);
		}
		System.out.println(6);
	}

}
