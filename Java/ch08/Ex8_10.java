import java.io.File;

public class Ex8_10 {
	public static void main(String[] args) {
		// ������ �����ϴ� �޼ҵ带 ���� ������ �����ϰ�, �� �������� ������ ������ ����ó��
		// ���� �����ϴ� �޼ҵ忡���� ���ܸ� ������ ȣ���ϴ� �ʿ��� ���ܸ� ó���ϰԲ� ��
		
		try {
			// ȣ���ϴ� �ʿ��� ����ó��
			File f = createFile("");
			System.out.println("���� ����");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// ������ �����ϴ� �޼ҵ�
	// ��ȯŸ���� File, �Ű������� ���� ���ڿ��� ������ ����
	static File createFile(String fileName) throws Exception {
		// ��ȿ�� �˻�
		if(fileName.equals("") || fileName==null) {
			// ���� �߻���Ŵ
			throw new Exception("�����̸��� ��ȿ���� �ʽ��ϴ�.");
		}
		
		// �����̸��� ��ȿ�ϸ� ���� ����
		File f = new File(fileName);
		f.createNewFile();
		return f;
	}
}
