import java.util.Scanner;

public class Ex4_5 {

	public static void main(String[] args) {
		// ����
		int score = 0;		// ����
		char grade = ' ';	// ����
		char opt = '0';		// ���� ����
		
		// ���� �Է�
		System.out.print("������ �Է��ϼ���.>");
		Scanner scanner = new Scanner(System.in);
		score = scanner.nextInt();
		
		// ������ ���� grade �ο�
		// grade �ο� ��, ������ ���� opt�� �ο�
		if(score >= 90) {
			grade = 'A';
			if(score >= 98) {
				opt = '+';
			} else if(score <= 94) {
				opt = '-';
			}
		} else if(score >= 80) {
			grade = 'B';
			if(score >= 88) {
				opt = '+';
			} else if(score <= 84) {
				opt = '-';
			}
		} else if(score >= 70) {
			grade = 'C';
			if(score >= 78) {
				opt = '+';
			} else if(score >= 74) {
				opt = '-';
			}
		} else {
			grade = 'D';
		}
		
		System.out.printf("����� ������ %c%c�Դϴ�.", grade, opt);
	}

}
