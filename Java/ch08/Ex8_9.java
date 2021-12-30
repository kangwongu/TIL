
public class Ex8_9 {
	// 메소드에 예외 선언하기
	
	// 메인 메소드, method1 호출
	public static void main(String[] args) throws Exception {
		method1();
	}
	// 메소드 1, method2 호출
	static void method1() throws Exception {
		// method2에서 예외가 발생하고, 메소드에 예외를 선언했기 때문에
		// 호출하는쪽에서 예외처리해야함
		method2();	// 예외 발생하는 메소드라 호출하면 예외처리 해야 함
	}
	// 메소드 2, 예외 발생
	static void method2() throws Exception {
		// checked예외라 무조건 예외처리해야함
		// 여기선 메소드에 예외 선언으로 호출하는 쪽으로 넘김
		throw new Exception("예외 발생!!!");
	}
}
