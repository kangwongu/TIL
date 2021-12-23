import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Ex15_21 {
	public static void main(String[] args) {
		try {
			// �о�� ������ �̸�
			String fileName = "UserInfo.ser";
			
			// ������ �о��
			// ��� ��Ʈ�� FileInputStream, ������Ʈ�� BufferedInputStream, ObjectInputStream
			FileInputStream fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			// ������ȭ�ϱ� ���� ObjectInputStream
			ObjectInputStream ois = new ObjectInputStream(bis);
			
			// ������ȭ, ��ü�� �о��
			// ��ü�� �о�� ��, ����� ������ ��ġ�ؾ���
			UserInfo u1 = (UserInfo) ois.readObject();
			UserInfo u2 = (UserInfo) ois.readObject();
			ArrayList<UserInfo> list = (ArrayList<UserInfo>) ois.readObject();
			
			// ������ȭ�� ��ü���� ���
			System.out.println(u1);
			System.out.println(u2);
			System.out.println(list.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
