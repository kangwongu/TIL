
public class Ex8_2 {
	public static void main(String[] args) {
		// 숫자를 0으로 나누면 발생하는 예외를 발생시킴
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(0/0);	// 예외 발생! catch블럭으로 이동
			System.out.println(3);		// 이 문장은 실행되지 않음, 
		} catch(Exception e) {
			System.out.println(4);
			System.out.println(5);
		}
		System.out.println(6);
		
	}

}
