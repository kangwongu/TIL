import java.util.HashMap;
import java.util.Scanner;

public class Ex11_16 {
	public static void main(String[] args) {
		// id, ����� HashMap�� ����, ����� �Է�, ���߸� ������, Ʋ���� ��
		// HashMap����
		HashMap hm = new HashMap();
		
		// HashMap�� id, ��� ����
		hm.put("kwg527", "kjg1202");
		hm.put("kjg1202", "kwg0527");
		hm.put("asdf", "1234");
		
		Scanner scanner = new Scanner(System.in);
		
		// ����� �Է�
		while(true ) {
			System.out.println("id�� password�� �Է��ϼ���.");
			// id�Է�
			System.out.print("id :");
			String id = scanner.nextLine();
			
			// ��� �Է�
			System.out.print("password :");
			String password = scanner.nextLine();
			System.out.println();
			
			// id�� ��ġ���� ������ ���Է�
			if(!hm.containsKey(id)) {
				System.out.println("��ġ���� �ʴ� id�Դϴ�.");
				continue;
			}
			
			// id�� ��ġ, ����� ��ġ���� ������ ���Է�
			if(!(hm.get(id)).equals(password)) {
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			} else {
				System.out.println("�α��� ����!");
				break;
			}
			
			
		}
		
		
	}
}
