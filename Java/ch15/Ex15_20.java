import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ex15_20 {
	public static void main(String[] args) {
		try {
			// ������ ���� �̸�
			String fileName = "UserInfo.ser";
			
			// ���Ͽ� ����
			// ��ݽ�Ʈ�� FileOutputStream, ������Ʈ�� BufferedOutputStream, ObjectOutputStream
			FileOutputStream fos = new FileOutputStream(fileName);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			// ����ȭ�ϱ����� ������Ʈ�ƿ�ǲ��Ʈ�� ����
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			
			// ����ȭ�� ��ü ����
			UserInfo u1 = new UserInfo("������", "kkkdg", 26);
			UserInfo u2 = new UserInfo("������", "rhw125", 40);
			
			// ����ȭ�� ��ü�� ���� ����Ʈ ����
			ArrayList<UserInfo> list = new ArrayList<>();
			list.add(u1);
			list.add(u2);
			
			// ��ü ����ȭ
			oos.writeObject(u1);
			oos.writeObject(u2);
			oos.writeObject(list);
			
			oos.close();
			System.out.println("����ȭ ����");	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
