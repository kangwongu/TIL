package thirdedition;

import java.util.Scanner;

public class ScannerEx {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("�� �ڸ� ������ �ϳ� �Է����ּ���>");
		String input = scanner.nextLine();
		int num = Integer.parseInt(input);
		
		System.out.println(input);
		System.out.println(num);
	}

}
