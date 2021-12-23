import java.io.File;
import java.io.IOException;

public class Ex15_15 {
	public static void main(String[] args) throws IOException {
		File f = new File("C:\\BIBLE JAVA2\\CH15\\src\\Ex15_15.java");
		String fileName = f.getName();
		int pos = fileName.lastIndexOf('.');
		
		System.out.println(f.getName());				// ���� �̸�
		System.out.println(fileName.substring(0,pos));	// Ȯ���� �� �����̸�
		System.out.println(fileName.substring(pos+1));	// Ȯ����
		
		System.out.println(f.getPath());				// ���
		System.out.println(f.getAbsolutePath());		// ������
		System.out.println(f.getCanonicalPath());		// ���԰��
		System.out.println(f.getParent());				// ������ �����ִ� ���丮
		System.out.println(File.pathSeparator);			// ��α�����
		System.out.println(File.pathSeparatorChar);		// ��α�����
		System.out.println(File.separator);				// �̸�������
		System.out.println(File.separatorChar);			// �̸�������`
		System.out.println(System.getProperty("user.dir"));
		
		
	}
}
