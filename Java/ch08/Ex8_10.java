import java.io.File;

public class Ex8_10 {
	public static void main(String[] args) {
		// 파일을 생성하는 메소드를 만들어서 파일을 생성하고, 그 과정에서 문제가 있으면 예외처리
		// 파일 생성하는 메소드에서는 예외를 선언해 호출하는 쪽에서 예외를 처리하게끔 함
		
		try {
			// 호출하는 쪽에서 예외처리
			File f = createFile("");
			System.out.println("정상 종료");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// 파일을 생성하는 메소드
	// 반환타입이 File, 매개변수로 받은 문자열로 파일을 생성
	static File createFile(String fileName) throws Exception {
		// 유효성 검사
		if(fileName.equals("") || fileName==null) {
			// 예외 발생시킴
			throw new Exception("파일이름이 유효하지 않습니다.");
		}
		
		// 파일이름이 유효하면 정상 실행
		File f = new File(fileName);
		f.createNewFile();
		return f;
	}
}
