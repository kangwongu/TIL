package baekjoon;

import java.util.Scanner;

public class Ex10951 {
	public static void main(String[] args) {
		// �Է�
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNextInt()) {
			// �� ���� �Է¹���
			int a = scanner.nextInt();
			int b = scanner.nextInt();
	
			// ���� ����
			System.out.println(a+b);
		}
	}
}
