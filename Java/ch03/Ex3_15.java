import java.util.Scanner;

public class Ex3_15 {

	public static void main(String[] args) {
		// ���ڿ��� �Է¹���
		Scanner scanner = new Scanner(System.in);
		
		String input = scanner.nextLine();
		// ���ڿ��� 1��°�� �̾ƿ� (������)
		char ch = input.charAt(0);
		
		
		// ch�� ���� 0~9�������� üũ
		if('0' <= ch && ch <= '9')
			System.out.println(ch+"�� �����Դϴ�.");
		
		// ch�� a~z�̰ų� A~Z���� üũ
		if('a' <= ch && ch <= 'z' || 'A' <= ch && ch <= 'Z')
			System.out.println(ch+"�� �������Դϴ�.");
	}

}
