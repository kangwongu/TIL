import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ex15_20 {
	public static void main(String[] args) {
		try {
			// 저장할 파일 이름
			String fileName = "UserInfo.ser";
			
			// 파일에 저장
			// 기반스트림 FileOutputStream, 보조스트림 BufferedOutputStream, ObjectOutputStream
			FileOutputStream fos = new FileOutputStream(fileName);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			// 직렬화하기위한 오브젝트아웃풋스트림 생성
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			
			// 직렬화할 객체 생성
			UserInfo u1 = new UserInfo("강원구", "kkkdg", 26);
			UserInfo u2 = new UserInfo("박지성", "rhw125", 40);
			
			// 직렬화할 객체를 담을 리스트 생성
			ArrayList<UserInfo> list = new ArrayList<>();
			list.add(u1);
			list.add(u2);
			
			// 객체 직렬화
			oos.writeObject(u1);
			oos.writeObject(u2);
			oos.writeObject(list);
			
			oos.close();
			System.out.println("직렬화 종료");	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
