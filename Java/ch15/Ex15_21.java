import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Ex15_21 {
	public static void main(String[] args) {
		try {
			// 읽어올 파일의 이름
			String fileName = "UserInfo.ser";
			
			// 파일을 읽어옮
			// 기반 스트림 FileInputStream, 보조스트림 BufferedInputStream, ObjectInputStream
			FileInputStream fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			// 역직렬화하기 위한 ObjectInputStream
			ObjectInputStream ois = new ObjectInputStream(bis);
			
			// 역직렬화, 객체를 읽어옮
			// 객체를 읽어올 때, 출력한 순서와 일치해야함
			UserInfo u1 = (UserInfo) ois.readObject();
			UserInfo u2 = (UserInfo) ois.readObject();
			ArrayList<UserInfo> list = (ArrayList<UserInfo>) ois.readObject();
			
			// 역직렬화한 객체들을 출력
			System.out.println(u1);
			System.out.println(u2);
			System.out.println(list.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
