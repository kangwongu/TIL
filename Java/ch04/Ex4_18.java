import java.util.Scanner;

public class Ex4_18 {

	public static void main(String[] args) {
		
		// �Է����� ��
		Scanner scanner = new Scanner(System.in);
		
		// ���ѷ���,
		while(true) {
			// �޴�
			System.out.println("(1) �߰�");
			System.out.println("(2) ��ȸ");
			System.out.println("(3) ����");
			System.out.println("(0) ����");
			
			// �޴� �Է¹���
			System.out.print("�޴��� �������ּ���(1)~(3) (0)�� ����.>>");
			int menu = scanner.nextInt();
			
			// ��ȿ���˻�
			// �޴��� 0�̸� ����
			if(menu == 0) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
				// �޴��� 1~3�� �ƴϸ� ���Է�
			} else if (!(1 <= menu && menu <= 3)) {
				System.out.println("�ùٸ��� ���� �޴��Դϴ�. ���Է��ϼ���");
				continue;
			}
			
			System.out.println("�����Ͻ� �޴��� "+menu+"�Դϴ�.");
			
			
		}
	}
}