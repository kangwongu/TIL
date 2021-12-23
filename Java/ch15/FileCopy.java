import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) throws IOException {
		// FileInputStream, FileOutputStream ����
		// args[0]������ �о args[1]�� ����
		FileInputStream fis = new FileInputStream(args[0]);
		FileOutputStream fos = new FileOutputStream(args[1]);
		
		int data = 0;
		// fis�� ������ �о fos�� ����
		while((data=fis.read())!=-1) {
			fos.write(data);
		}
		
		fis.close();
		fos.close();
	}

}
