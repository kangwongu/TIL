
public class EX2_8 {

	public static void main(String[] args) {
		// �� ���� int�� ���� ����
		int x = 15, y = 5;
		
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		
		// �� ���� �� ��ȯ
		// tmp��� ���� Ȱ��
		int tmp = x;
		x = y;
		y = tmp;
		
		
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		
	
	}

}
