import java.io.File;

public class Ex8_12 {
	public static void main(String[] args) {
		try {
			method1();
		} catch (Exception e) {
			System.out.println("main�޼ҵ忡�� ���ܰ� ó���Ǿ����ϴ�.");
		}
	}
	
	
	static void method1() throws Exception {
		try {
			throw new Exception();
		} catch(Exception e) {
			System.out.println("method1�޼ҵ忡�� ���ܰ� ó���Ǿ����ϴ�.");
			// ���ܸ� ó���ϰ� �ٽ� ����
			throw e;
		}
		
	}
}