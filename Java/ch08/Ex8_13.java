import java.io.File;

public class Ex8_13 {
	public static void main(String[] args) {
		// 
		try {
			Install();
			System.out.println("정상 종료");
		} catch (InstallException e) {
			e.printStackTrace();
		}
	}
	
	// 설치 메소드
	static void Install() throws InstallException {
		// 설치시작 -> 파일복사 -> 임시파일삭제
		try {
			startInstall();
		} catch (MemoryException2 e) {
			// MemoryException은 InstallException의 원인 예외
			InstallException ie = new InstallException();
			ie.initCause(e);
			throw ie;
		} catch (SpaceException2 e) {
			InstallException ie = new InstallException();
			ie.initCause(e);
			throw ie;
		}
		copyFiles();
		deleteTempFiles();
	}
	
	// 설치 시작 메소드
	static void startInstall() throws MemoryException2, SpaceException2 {
		// 설치 시작했을 때 발생할 수 있는 예외 SpaceException, MemoryException
		// 메모리가 부족하면 예외 발생
		if(!enoughMemory())
			// 메소드에 예외 선언해 호출하는 쪽에서 예외처리하게 처리
			throw new MemoryException2();
		// 공간이 부족하면 예외 발생
		if(!enoughSpace()) {
			throw new SpaceException2();
		}
	}
	
	private static boolean enoughSpace() {
		return true;
	}

	private static boolean enoughMemory() {
		return false;
	}

	// 파일 복사 메소드
	static void copyFiles() {
		
	}
	
	// 임시 파일 삭제 메소드
	static void deleteTempFiles() {
		
	}
}

// 사용자 정의 예외
class MemoryException2 extends Exception {
	MemoryException2() { super("메모리 부족!"); }
}

class SpaceException2 extends Exception {
	SpaceException2() { super("설치할 공간 부족!"); }
}

class InstallException extends Exception {
	InstallException() { super("설치 도중 오류 발생"); }
}

