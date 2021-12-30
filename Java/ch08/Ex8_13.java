import java.io.File;

public class Ex8_13 {
	public static void main(String[] args) {
		// 
		try {
			Install();
			System.out.println("���� ����");
		} catch (InstallException e) {
			e.printStackTrace();
		}
	}
	
	// ��ġ �޼ҵ�
	static void Install() throws InstallException {
		// ��ġ���� -> ���Ϻ��� -> �ӽ����ϻ���
		try {
			startInstall();
		} catch (MemoryException2 e) {
			// MemoryException�� InstallException�� ���� ����
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
	
	// ��ġ ���� �޼ҵ�
	static void startInstall() throws MemoryException2, SpaceException2 {
		// ��ġ �������� �� �߻��� �� �ִ� ���� SpaceException, MemoryException
		// �޸𸮰� �����ϸ� ���� �߻�
		if(!enoughMemory())
			// �޼ҵ忡 ���� ������ ȣ���ϴ� �ʿ��� ����ó���ϰ� ó��
			throw new MemoryException2();
		// ������ �����ϸ� ���� �߻�
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

	// ���� ���� �޼ҵ�
	static void copyFiles() {
		
	}
	
	// �ӽ� ���� ���� �޼ҵ�
	static void deleteTempFiles() {
		
	}
}

// ����� ���� ����
class MemoryException2 extends Exception {
	MemoryException2() { super("�޸� ����!"); }
}

class SpaceException2 extends Exception {
	SpaceException2() { super("��ġ�� ���� ����!"); }
}

class InstallException extends Exception {
	InstallException() { super("��ġ ���� ���� �߻�"); }
}

