import java.util.Scanner;

public class Ex4_3 {

	public static void main(String[] args) {
		System.out.print("���ڸ� �ϳ� �Է��ϼ���.>");
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		
		// �Է¹��� ���� 0���� �ƴ���?
		if(input==0) {
			System.out.println("�Է¹��� ���� 0�Դϴ�.");
		} else {
			System.out.println("�Է¹��� ���� 0�� �ƴմϴ�");
		}
	}

}
