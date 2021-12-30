import java.io.File;

public class Ex8_11 {
	public static void main(String[] args) {
		// 설치메소드 실행 시, 예외발생하면 메소드에 예외 선언해서 호출하는 쪽이 예외처리하게끔 처리
		
		// 설치 루틴
		// 설치 -> 파일복사 -> 임시파일 삭제
		try {
			startInstall();	// 예외 발생하면 예외 처리하고 종료
			copyFiles();
		} catch (SpaceException e) {
			e.printStackTrace();
		} catch (MemoryException e) {
			e.printStackTrace();
		} finally {
			// 어떠한 경우에도 실행되어야 하는 메소드는 finally에 선언
			deleteTempFiles();	
		}
		
		
	}
	
	private static void deleteTempFiles() {
		
	}

	private static void copyFiles() {
		
	}

	// 설치 메소드
	static void startInstall() throws SpaceException, MemoryException {
		// 공간부족, 메모리부족이면 예외 발생시킴
		// 발생시키는 예외들은 메소드에 선언해 메소드 호출하는 쪽이 예외처리하게끔 처리
		if(!enoughSpace()) {
			throw new SpaceException();
		}
		if(!enoughMemory()) {
			throw new MemoryException();
		}
			
	}

	private static boolean enoughMemory() {
		return false;
	}

	private static boolean enoughSpace() {
		return true;
	}
}

// 사용자 정의 예외
class SpaceException extends Exception {
	SpaceException() { super("설치 공간 부족!"); }
}

class MemoryException extends Exception {
	MemoryException() { super("메모리 부족!"); }
}