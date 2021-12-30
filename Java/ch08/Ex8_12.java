import java.io.File;

public class Ex8_12 {
	public static void main(String[] args) {
		try {
			method1();
		} catch (Exception e) {
			System.out.println("main메소드에서 예외가 처리되었습니다.");
		}
	}
	
	
	static void method1() throws Exception {
		try {
			throw new Exception();
		} catch(Exception e) {
			System.out.println("method1메소드에서 예외가 처리되었습니다.");
			// 예외를 처리하고 다시 던짐
			throw e;
		}
		
	}
}