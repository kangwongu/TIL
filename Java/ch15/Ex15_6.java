import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex15_6 {
	public static void main(String[] args) {
		// ���۸� �̿��� 123456789�� ��� 123.txt�� ����
		try {
			// ��ݽ�Ʈ��(������Ʈ��)
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
