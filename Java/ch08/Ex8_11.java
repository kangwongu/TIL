import java.io.File;

public class Ex8_11 {
	public static void main(String[] args) {
		// ��ġ�޼ҵ� ���� ��, ���ܹ߻��ϸ� �޼ҵ忡 ���� �����ؼ� ȣ���ϴ� ���� ����ó���ϰԲ� ó��
		
		// ��ġ ��ƾ
		// ��ġ -> ���Ϻ��� -> �ӽ����� ����
		try {
			startInstall();	// ���� �߻��ϸ� ���� ó���ϰ� ����
			copyFiles();
		} catch (SpaceException e) {
			e.printStackTrace();
		} catch (MemoryException e) {
			e.printStackTrace();
		} finally {
			// ��� ��쿡�� ����Ǿ�� �ϴ� �޼ҵ�� finally�� ����
			deleteTempFiles();	
		}
		
		
	}
	
	private static void deleteTempFiles() {
		
	}

	private static void copyFiles() {
		
	}

	// ��ġ �޼ҵ�
	static void startInstall() throws SpaceException, MemoryException {
		// ��������, �޸𸮺����̸� ���� �߻���Ŵ
		// �߻���Ű�� ���ܵ��� �޼ҵ忡 ������ �޼ҵ� ȣ���ϴ� ���� ����ó���ϰԲ� ó��
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

// ����� ���� ����
class SpaceException extends Exception {
	SpaceException() { super("��ġ ���� ����!"); }
}

class MemoryException extends Exception {
	MemoryException() { super("�޸� ����!"); }
}