import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex15_6 {
	public static void main(String[] args) {
		// 버퍼를 이용해 123456789가 담긴 123.txt를 생성
		try {
			// 기반스트림(보조스트림)
			FileOutputStream fos = new FileOutputStream("100.txt");
			BufferedOutputStream bos = new BufferedOutputStream(fos,5);
			
			for(int i='1'; i<'9'; i++) {
				bos.write(i);
			}
			
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
