import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) throws IOException {
		// FileInputStream, FileOutputStream 생성
		// args[0]파일을 읽어서 args[1]에 저장
		FileInputStream fis = new FileInputStream(args[0]);
		FileOutputStream fos = new FileOutputStream(args[1]);
		
		int data = 0;
		// fis의 내용을 읽어서 fos로 저장
		while((data=fis.read())!=-1) {
			fos.write(data);
		}
		
		fis.close();
		fos.close();
	}

}
