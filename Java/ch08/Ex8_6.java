
public class Ex8_6 {
	public static void main(String[] args) {
		// 예외 발생시키기
		
		try {
			// 1. 예외클래스 객체만들기
			RuntimeException e = new RuntimeException("에러 발생!");
			
			// 2. throw로 예외 발생시키기
			throw e;
			
//			throw new Exception("에러 발생!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(1);
	
	}

}
