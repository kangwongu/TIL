import java.util.Scanner;

public class Ex4_15 {

	public static void main(String[] args) {
		// ��, ��ǻ��
		int input=0, com=0;
		
		// ��ǻ�Ϳ� ������ �� ����
		com = (int)(Math.random()*100)+1;
		
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.print("���� �Է��ϼ���.>>");
			input = scanner.nextInt();
			
			if(input > com) {
				System.out.println("Down!!");
			} else if(input < com) {
				System.out.println("Up!!");
			}
		} while(input!=com);
		
		System.out.println("����!");
	}
}