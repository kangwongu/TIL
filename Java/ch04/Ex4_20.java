import java.util.Scanner;

public class Ex4_20 {

	public static void main(String[] args) {
		// ����
		// �޴��� Ȱ��� ����
		int menu;
		int num;	// ������ ��
		
		Scanner scanner = new Scanner(System.in);
	
		// do-while���� �̸��� ����
		outer :
		do {
			System.out.println("(1) squre");
			System.out.println("(2) squre root");
			System.out.println("(3) log");
			
			// �޴��� �Է¹���
			System.out.print("�޴��� �����ϼ���(1~3). ����(0)>");
			menu = scanner.nextInt();
			
			// �޴��� 0�̸� ����
			if(menu == 0) {
				System.out.println("���α׷��� �����մϴ�");
				break;
			// �޴��� 1~3�� �ƴϸ� ���Է�
			} else if(!(1 <= menu && menu <= 3)) {
				System.out.println("�ٽ� �Է��ϼ���(1~3). ����(0)");
				continue;
			}
			
			System.out.println("�����Ͻ� �޴��� " + menu + "�Դϴ�");
			
			for(;;) {
				System.out.print("����� ���� �Է��ϼ���(0~99) (0:��� ����, 99:��ü ����)>");
				// ������ �� �Է�
				num = scanner.nextInt();
				
				// ���ǰ˻�, 0�̸� ����, 99�� ��ü����
				if(num == 0) {
					System.out.println("�������");
					break;
				} 
				
				if(num == 99) {
					System.out.println("��ü����");
					break outer;
				}
				
				// �޴��� ���� ���� ����
				switch(menu) {
				// ����
				case 1:
					System.out.println("result = " + num*num);
					break;
				// ������
				case 2:
					System.out.println("result = " + Math.sqrt(num));
					break;
				// �α�	
				case 3:
					System.out.println("result = " + Math.log(num));
					break;
				}
				
			}
			
			
		}while(true);
		
		
		
		
		
	}
}