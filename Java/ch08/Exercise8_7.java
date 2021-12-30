import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise8_7 {
	public static void main(String[] args) {
		// ������ ���� �Է¹ް� �� ���� ���ߴ� ����
		
		// ������ �� ����
		int answer = (int)(Math.random()*100)+1;
		int input = 0;	// ����� �Է��� ������ ����
		int count = 0;	// �õ�Ƚ���� ������ ����
		
		do {
			count++;
			System.out.print("1~100������ ���� �Է��ϼ���.>>");
			
			// ����� �Է�
			try {
				input = new Scanner(System.in).nextInt();
			} catch (InputMismatchException e) {
				System.out.println("��ȿ���� ���� ���Դϴ�. �ٽ� �Է��ϼ���.");
				continue;
			}
			
			if(answer > input) {
				System.out.println("Up!");
			} else if(answer < input) {
				System.out.println("Down!");
			} else {
				System.out.println("����!");
				System.out.println("�õ�Ƚ���� "+count+"���Դϴ�.");
				break;
			}
		} while(true);
	}
}
